package com.yedam.bookApp;

import java.util.List;
import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Book book = new Book();
		book.setTitle("곰세마리");
		book.setAuthor("판다");
		book.setPublisher("동물원 출판사");
		book.setPrice(20000);

		BookJdbc dao = new BookJdbc();

		if (dao.insert(book)) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}

		Book book2 = new Book();
		book2.setTitle("곰다섯마리");
		book2.setAuthor("불곰");
		book2.setPublisher("동물원 출판사");
		book2.setPrice(22000);
		book2.setBookCode("B1001");

		if (dao.update(book2)) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}

		List<Book> list = dao.list("한빛 출판사");
		for (Book bk : list) {
			System.out.println(bk.showList());
		}

		// 싱글톤 객체 호출
//		BookMain mainApp = BookMain.getInstance();

		// 로그인 과정 추가
//		System.out.println("아이디 입력>> ");
//		String id = scanner.nextLine();
//		System.out.println("비밀번호 입력>> ");
//		String password = scanner.nextLine();

//		if (mainApp.login(id, password)) {
//			mainApp.main(args);
//		} else {
//			System.out.println("사용자 정보가 일치하지 않아 프로그램을 종료합니다.");
//			return;
//		}
		scanner.close();
	}
}
