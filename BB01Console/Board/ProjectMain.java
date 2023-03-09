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
					System.out.println("종료합니다.");
					break;
				} else if (num == 1) {
					if (count <= 0) {
						System.out.println("등록된 글이 없습니다.");
					} else {
						b.showList();
					}
				} else if (num == 2) {
					scan.nextLine();
					System.out.print("제목 >> ");
					String title = scan.nextLine();
					System.out.print("작성자 >> ");
					String author = scan.nextLine();
					System.out.print("내용 >> ");
					String contents = scan.nextLine();
					b.addList(title, author, contents);
					count++;
				} else if (num == 3) {
					if (count <= 0) {
						System.out.println("등록된 글이 없습니다.");
					} else {
						System.out.print("내용을 볼 글 번호 >> ");
						int searchNum = scan.nextInt();
						b.searchList(searchNum);
					}
				} else if (num == 4) {
					if (count <= 0) {
						System.out.println("등록된 글이 없습니다.");
					} else {
						System.out.print("삭제할 글 번호 >> ");
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