package com.yedam.bookApp;

import java.util.List;
import java.util.Scanner;

public class BookMain {

	private static BookMain instance = new BookMain();
	private User[] users = new User[100];
	private BookJdbc dao = new BookJdbc(); // ✅ 데이터베이스 연동 객체 추가

	private BookMain() {
		users[0] = new User("hong", "p1111", "홍길동");
		users[1] = new User("lee", "p2222", "이순신");
		users[2] = new User("park", "p3333", "박혁거세");
	}

	public static BookMain getInstance() {
		return instance;
	}

	Scanner scn = new Scanner(System.in);
	Book[] bookStore = new Book[100];

	public User login(String id, String pw) {
		MemberJdbc dao = new MemberJdbc();
		return dao.login(id, pw);
	}

	public int getSequenceNo() {
		int max = 0;
		for (Book book : bookStore) {
			if (book != null && book.getOrderNo() > max) {
				max = book.getOrderNo();
			}
		}
		return max + 1;
	}

	public void add() {
		System.out.println("도서명을 입력하세요>> ");
		String title = scn.nextLine();

		System.out.println("저자를 입력하세요>> ");
		String author = scn.nextLine();
		System.out.println("출판사를 입력하세요>> ");
		String publisher = scn.nextLine();
		System.out.println("가격을 입력하세요>> ");
		int price = Integer.parseInt(scn.nextLine());

		// ✅ 데이터베이스에만 저장 (bookStore[] 사용 X)
		Book book = new Book(title, author, publisher, price);
		if (dao.insert(book)) {
			System.out.println("책이 성공적으로 추가되었습니다.");
		} else {
			System.out.println("책 추가에 실패했습니다.");
		}
	}

	public void edit() {
		System.out.println("도서 코드를 입력하세요>> ");
		String bookCode = scn.nextLine();
		boolean isExist = false;

		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getBookCode().equals(bookCode)) {
				System.out.println("저자를 입력하세요>> ");
				String fixAuthor = scn.nextLine();
				System.out.println("도서명을 입력하세요>> ");
				String fixTitle = scn.nextLine();
				System.out.println("가격을 입력하세요>> ");
				int fixPrice = Integer.parseInt(scn.nextLine());

				bookStore[i].setTitle(fixTitle);
				bookStore[i].setAuthor(fixAuthor);
				bookStore[i].setPrice(fixPrice);

				dao.update(bookStore[i]); // ✅ 데이터베이스 업데이트
				System.out.println("수정 완료");
				isExist = true;
				break;
			}
		}

		if (!isExist) {
			System.out.println("찾는 도서명이 존재하지 않습니다!");
		}
	}

	public void delete() {
		System.out.println("도서명을 입력하세요>> ");
		String title = scn.nextLine();
		boolean isExist = false;
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				dao.delete(bookStore[i].getBookCode()); // ✅ 데이터베이스에서도 삭제
				bookStore[i] = null;
				System.out.println("삭제 완료");
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			System.out.println("찾는 도서명이 존재하지 않습니다!");
		}
	}

	public void list() {
		// ✅ 기존 bookStore 배열 대신 DB에서 목록을 가져옴
		List<Book> books = dao.list(null);

		if (books.isEmpty()) {
			System.out.println("등록된 책이 없습니다.");
		} else {
			for (Book book : books) {
				System.out.println(book.showList()); // ✅ DB에서 가져온 목록 출력
			}
		}
	}

	public void searchByPublisher() {
		System.out.println("출판사 이름을 입력하세요>> ");
		String publisher = scn.nextLine();
		boolean found = false;

		for (Book book : bookStore) {
			if (book != null && book.getPublisher().equals(publisher)) {
				System.out.println(book.showList());
				found = true;
			}
		}

		if (!found) {
			System.out.println("해당 출판사의 책이 없습니다.");
		}
	}

	public void searchByCode() {
		System.out.println("도서 코드를 입력하세요>> ");
		String bookCode = scn.nextLine(); // 사용자가 입력한 도서 코드

		boolean found = false;
		for (Book book : bookStore) {
			if (book != null && book.getBookCode().equals(bookCode)) {
				System.out.println("검색 결과: " + book.showList()); // 검색된 책 정보 출력
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("해당 도서 코드를 가진 책이 없습니다.");
		}
	}

	public static void main(String[] args) {
		BookMain app = BookMain.getInstance();
		app.init();
		boolean run = true;

		while (run) {
			System.out.println("아이디와 비밀번호를 입력하세요");
			System.out.println("아이디>> ");
			String id = app.scn.nextLine();
			System.out.println("비밀번호>> ");
			String pw = app.scn.nextLine();
			app.login(id, pw);

			User loggedInUser = app.login(id, pw);

			// ✅ 로그인 실패한 경우
			if (loggedInUser.getId().equals("Unknown")) {
				System.out.println("로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
				continue; // 다시 로그인 요청
			}

			System.out.println("[1.도서등록] [2.수정] [3.삭제] [4.목록] [5.출판사 검색] [6. 도서 코드 검색] [9.종료]");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(app.scn.nextLine());

			switch (menu) {
			case 1:
				app.add();
				break;
			case 2:
				app.edit();
				break;
			case 3:
				app.delete();
				break;
			case 4:
				app.list();
				break;
			case 5:
				app.searchByPublisher();
				break;
			case 6:
				app.searchByCode();
				break;
			case 9:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요!");
			}
		}

		System.out.println("end of prog.");
	}

	void init() {
		bookStore[0] = new Book("구구구", "비둘기", "한빛 출판사", 1800, 1);
		bookStore[1] = new Book("짹짹짹", "참새", "우리 출판사", 3000, 2);
		bookStore[2] = new Book("부자되는방법", "김거지", "가람 출판사", 120000, 3);
		bookStore[3] = new Book("오늘은 내가 요리사", "짜파게티", "한빛 출판사", 17000, 4);
		bookStore[4] = new Book("연어초밥이란 무엇인가", "미스터초밥왕", "가람 출판사", 30000, 5);
		bookStore[5] = new Book("슈퍼샤이", "뉴진스", "희진 출판사", 22000, 6);
	}
}
