package Board;

import java.util.Scanner;

public class ProjectMain {

	public static void main(String[] args) {
		Board b = new Board();
		Scanner scan = new Scanner(System.in);
		int count = 0;

		try {
			while (true) {
				b.showMenu();

				int num = scan.nextInt();

				if (num == 0) {
					System.out.println("�����մϴ�.");
					break;
				} else if (num == 1) {
					if (count <= 0) {
						System.out.println("��ϵ� ���� �����ϴ�.");
					} else {
						b.showList();
					}
				} else if (num == 2) {
					scan.nextLine();
					System.out.print("���� >> ");
					String title = scan.nextLine();
					System.out.print("�ۼ��� >> ");
					String author = scan.nextLine();
					System.out.print("���� >> ");
					String contents = scan.nextLine();
					b.addList(title, author, contents);
					count++;
				} else if (num == 3) {
					if (count <= 0) {
						System.out.println("��ϵ� ���� �����ϴ�.");
					} else {
						System.out.print("������ �� �� ��ȣ >> ");
						int searchNum = scan.nextInt();
						b.searchList(searchNum);
					}
				} else if (num == 4) {
					if (count <= 0) {
						System.out.println("��ϵ� ���� �����ϴ�.");
					} else {
						System.out.print("������ �� ��ȣ >> ");
						int delNum = scan.nextInt();
						b.delList(delNum);
						count--;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}