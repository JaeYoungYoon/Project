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
		System.out.println("1 목록 보기 2 글 등록 3 내용 보기 4 글 삭제 0 종료 >> ");
	}

	public void showList() {
		System.out.println("=================================");
		System.out.println("번호" + "\t" + "제목" + "\t" + "작성자" + "\t" + "작성일");

		for (Post p : list) {
			System.out.println((list.indexOf(p) + 1) + "\t" + p.getTitle() + "\t" + p.getAuthor() + "\t" + p.getDate());
		}

	} // end of showList (1번 목록 보기)

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
		System.out.println("글이 추가되었습니다.");

	} // end of addList (2번 글 등록하기)

	public void searchList(int num) {
		if (num <= 0 || num > list.size()) {
			System.out.println("해당하는 번호에 대한 글이 없습니다.");
			return;
		}

		Post search = list.get(num - 1);
		System.out.println("=================================");
		System.out.println(num + "\t" + search.getTitle() + "\t" + search.getAuthor() + "\t" + search.getDate());
		System.out.println("---------------------------------");
		System.out.println(search.getParagraph());

	} // end of searchList (3번 내용 보기)

	public void delList(int num) {
		if (num <= 0 || num > list.size()) {
			System.out.println("해당하는 번호에 대한 글이 없습니다.");
			return;
		}
		Post del = list.get(num - 1);
		list.remove(list.indexOf(del));
		System.out.println(num + "번 글이 삭제되었습니다.");

	} // end of delList (4번 글 삭제하기)

}