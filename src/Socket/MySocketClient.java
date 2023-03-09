package Socket;

import java.io.IOException;
import java.net.Socket;

public class MySocketClient {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 2400); // ���� ������ ���� 
			// arp -a �ؼ� ã�ƺ� �ڸ� �ּ�, �ȵǸ� localhost �־ Ȯ��
			System.out.println("������ �����մϴ�"); // ���� Ȯ�ο�
			
			ListeningThread t1 = new ListeningThread(socket); // �������� ���� �޼��� �д� Thread
			WritingThread t2 = new WritingThread(socket); // ������ �޼��� ������ Thread

			t1.start(); // ListeningThread Start
			t2.start(); // WritingThread Start
            
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
}

