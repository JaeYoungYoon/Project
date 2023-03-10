package Socket;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Board.Post;
import Board.Board;

public class MySocketServer extends Thread {
	static Socket socket = null;
	static List<Socket> clients = new ArrayList<>();
	boolean idcheck = false;

	public MySocketServer(Socket socket) {
		this.socket = socket; // ���� socket�� �Ҵ�
		clients.add(socket);
	}

	public void run() { // Thread ���� start() �޼ҵ� ��� �� �ڵ����� �ش� �޼ҵ� ���� (Thread���� ������ ����)
		try {
			System.out.println("���� : " + socket.getInetAddress() + " IP�� Ŭ���̾�Ʈ�� ����Ǿ����ϴ�"); // ���� Ȯ�ο�

			// InputStream - Ŭ���̾�Ʈ���� ���� �޼��� �б�
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			// OutputStream - �������� Ŭ���̾�Ʈ�� �޼��� ������
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out, true);
			
			String readValue; // Client���� ���� �� ����
			Board board = new Board(out);
			int count = 0;
			
			String author = socket.getInetAddress().toString();

			writer.println("[[�Խ��� ���α׷�]]");
			board.showMenu();
			
			while ((readValue = reader.readLine()) != null) { // Ŭ���̾�Ʈ�� �޼��� �Է½ø��� ����

				out = socket.getOutputStream();
				writer = new PrintWriter(out, true);

				if (readValue.equals("0")) {
					writer.println("�����մϴ�.");
					System.exit(0);
				} else if (readValue.equals("1")) {
					if (count <= 0) {
						writer.println("��ϵ� ���� �����ϴ�.");
						board.showMenu();
					} else {
						board.showList();
					}
				} else if (readValue.equals("2")) {

					writer.println("���� >> ");
					String title = reader.readLine();

					if (!idcheck) {
						writer.println("�ۼ��� >> ");
						String str = reader.readLine();
						author = str;
						idcheck = true;
					} else {
						writer.print("�ۼ��� >> ");
						writer.println(author);
					}

					writer.println("���� >> ");
					String contents = reader.readLine();

					board.addList(title, author, contents);
					count++;
					board.showListInServer();
				} else if (readValue.equals("3")) {
					if (count <= 0) {
						writer.println("��ϵ� ���� �����ϴ�.");
						board.showMenu();
					} else {
						writer.println("������ �� �� ��ȣ >> ");
						String str = reader.readLine();
						int searchNum = Integer.parseInt(str);
						board.searchList(searchNum);
					}
				} else if (readValue.equals("4")) {
					if (count <= 0) {
						writer.println("��ϵ� ���� �����ϴ�.");
						board.showMenu();
					} else {
						writer.println("������ �� ��ȣ >> ");
						String str = reader.readLine();
						int delNum = Integer.parseInt(str);
						board.delList(delNum);
						count--;
						board.showListInServer();
					}
				} else {
					writer.println("������ ��ȣ�� �Խ��� ����� �����ϴ�.");
				}
				
			} // end of while
			


		} catch (Exception e) {
			e.printStackTrace(); // ����ó��
		} finally {
			clients.remove(socket);
			System.out.println("���� : " + socket.getInetAddress() + " IP�� Ŭ���̾�Ʈ�� ���� ����");
		}
	} // end of run()

	public static void main(String[] args) {
		
		int socketPort = 2400; // ���� ��Ʈ ������
		List<Socket> clients = new ArrayList<>();
		try {
			ServerSocket serverSocket = new ServerSocket(socketPort); // ���� ���� �����
			System.out.println("socket : " + socketPort); // ���� ���� Ȯ�ο�

			// ���� ������ ����� ������ ���ѷ���
			while (true) {
				Socket socketUser = serverSocket.accept(); // ������ Ŭ���̾�Ʈ ���� ��
				clients.add(socketUser);
				Thread thd = new MySocketServer(socketUser); // Thread �ȿ� Ŭ���̾�Ʈ ������ �����
				thd.start(); // Thread ����
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
