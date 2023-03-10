package Board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Board {

	Scanner scan = new Scanner(System.in);
	List<Post> list = new ArrayList<>();

	public void showMenu() {
		System.out.println("---------------------------------");
		System.out.println("1 ��� ���� 2 �� ��� 3 ���� ���� 4 �� ���� 0 ���� >> ");
	}

	public void showList() {
		System.out.println("=================================");
		System.out.println("��ȣ" + "\t" + "����" + "\t" + "�ۼ���" + "\t" + "�ۼ���");

		for (Post p : list) {
			System.out.println((list.indexOf(p) + 1) + "\t" + p.getTitle() + "\t" + p.getAuthor() + "\t" + p.getDate());
		}

	} // end of showList (1�� ��� ����)

	public void addList(String title, String author, String contents) {
		Post post = new Post();
		
		post.setIndex(list.indexOf(post));
		post.setTitle(title);
		post.setAuthor(author);
		post.setParagraph(contents);

		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy, hh:mm aaa");
		String date = sdf.format(new Date());
		post.setDate(date);

		list.add(post);
		System.out.println("���� �߰��Ǿ����ϴ�.");

	} // end of addList (2�� �� ����ϱ�)

	public void searchList(int num) {
		if (num <= 0 || num > list.size()) {
			System.out.println("�ش��ϴ� ��ȣ�� ���� ���� �����ϴ�.");
			return;
		}

		Post search = list.get(num - 1);
		System.out.println("=================================");
		System.out.println(num + "\t" + search.getTitle() + "\t" + search.getAuthor() + "\t" + search.getDate());
		System.out.println("---------------------------------");
		System.out.println(search.getParagraph());

	} // end of searchList (3�� ���� ����)

	public void delList(int num) {
		if (num <= 0 || num > list.size()) {
			System.out.println("�ش��ϴ� ��ȣ�� ���� ���� �����ϴ�.");
			return;
		}
		Post del = list.get(num - 1);
		list.remove(list.indexOf(del));
		System.out.println(num + "�� ���� �����Ǿ����ϴ�.");

	} // end of delList (4�� �� �����ϱ�)

}