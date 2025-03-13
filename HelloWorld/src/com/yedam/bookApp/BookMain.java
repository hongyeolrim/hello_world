package com.yedam.bookApp;

import java.util.Scanner;

public class BookMain {
	static Scanner scn = new Scanner(System.in); // 사용자에게서 값을 입력받는 스캐너 실행, 기본 입력 장치로부터 값을 받을 거임(System.in)
	static Book[] bookStore = new Book[100]; // 100개의 값을 넣을 수 있는 배열 인스턴스 생성, Book클래스를 사용, 형식은 그냥 외우기(배열 형식이라 [] 넣어줬다고
												// 생각하면 편함)

	// 순번 생성
	public static int getSequenceNo() {
		int max = 0;
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getOrderNo() > max) {
				max = bookStore[i].getOrderNo();
			}
		}
		return max + 1; // 현재 마지막번호 + 1 = 이렇게 하는 이유는 이미 등록된 책의 다음 번호로 새 책을 등록해야 하니까(아마도)
	}

	// 등록
	public static void add() {
		System.out.println("도서명을 입력하세요>> ");
		String title = scn.nextLine(); // 사용자에게서 문자열 입력받음
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				System.out.println("중복된 이름입니다!");
				return;
			}
		}
		System.out.println("저자를 입력하세요>> ");
		String author = scn.nextLine();
		System.out.println("출판사를 입력하세요>> ");
		String publisher = scn.nextLine();
		System.out.println("가격을 입력하세요>> ");
		int price = Integer.parseInt(scn.nextLine());
		System.out.println("등록 완료");
		Book book = new Book(title, author, publisher, price, getSequenceNo()); // 이거는 내가 두번재로 만든 생성자 호출
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] == null) {
				bookStore[i] = book;
				break;
			}
		}
	} // END OF ADD

	public static void edit() {
		System.out.println("도서명을 입력하세요>> ");
		String title = scn.nextLine();
		boolean isExist = false;

		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				System.out.println("저자를 입력하세요>> ");
				String fixAuthor = scn.nextLine();
				if (fixAuthor.length() != 0) {
					bookStore[i].setAuthor(fixAuthor);
				}
				System.out.println("출판사를 입력하세요>> ");
				String fixPublisher = scn.nextLine();
				if (fixPublisher.length() != 0) {
					bookStore[i].setPublisher(fixPublisher);
				}
				System.out.println("가격을 입력하세요>> ");
				String fixPrice = scn.nextLine();
				if (!fixPrice.isBlank()) { // .isBlank()
					bookStore[i].setPrice(Integer.parseInt(fixPrice));
				}
				System.out.println("수정 완료");
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			System.out.println("찾는 도서명이 존재하지 않습니다!");
		}
	} // END OF EDIT

	public static void delete() {
		System.out.println("도서명을 입력하세요>> ");
		String title = scn.nextLine();
		boolean isExist = false;
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				bookStore[i] = null;
				System.out.println("삭제 완료");
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			System.out.println("찾는 도서명이 존재하지 않습니다!");
		}
	} // END OF DELETE

	public static void list() {
		for (int i = 0; i < bookStore.length - 1; i++) {
			for (int j = 0; j < bookStore.length - 1; j++) {
				if (bookStore[j] == null && bookStore[j + 1] != null) {
					Book temp = bookStore[j];
					bookStore[j] = bookStore[j + 1];
					bookStore[j + 1] = temp;
				} else if (bookStore[j] != null && bookStore[j + 1] != null
						&& bookStore[j].getOrderNo() > bookStore[j + 1].getOrderNo()) {
					Book temp = bookStore[j];
					bookStore[j] = bookStore[j + 1];
					bookStore[j + 1] = temp;
				}
			}
		}
		int seqNo = 1;
		for (Book books : bookStore) {
			if (books != null) {
				System.out.println("[" + seqNo++ + "] " + books.showList());
			}
		}
	}

	public static void searchByPublisher() {
		System.out.println("출판사 이름을 입력하세요>> ");
		String publisher = scn.nextLine(); // 사용자에게 출판사 입력받음
		boolean found = false; // 책을 찾았는지 여부를 저장하는 변수

		for (Book book : bookStore) { // 모든 책을 반복하면서 확인
			if (book != null && book.getPublisher().equals(publisher)) {
				System.out.println(book.showList()); // 해당 출판사 책 정보 출력
				found = true; // 책을 찾았으므로 true로 변경
			}
		}

		if (!found) { // found가 false라면 (즉, 책을 못 찾았다면)
			System.out.println("해당 출판사의 책이 없습니다.");
		}
	}

	public static void main(String[] args) {
//	    	Book book = new Book();   //인스턴스 생성을 반드시 먼저하고 값을 넣어야 오류가 안 남
// 	    	book.setTitle("어린왕자");
//	    	book.setAuthor("생택쥐페리");
//	    	book.setPublisher("한빛 출판사");         //이게 setter (아마도)
//	        book.setPrice(18000);
//	        System.out.println("책 제목: " + book.getTitle() + ", 저자: " + book.getAuthor());
//	        //이것들은 내가 기본 생성자를 이용해서 만든 거

//	        Book book = new Book("어린왕자", "생택쥐페리", "한빛 출판사", 18000);
//	        System.out.println(book.showBookInfo());  //내가 만들어둔 리턴 메소드 사용
//	        //이건 내가 만든 생성자를 사용한 거, 매번 값을 넣지 않고 이렇게 한줄로 완성
		init();
		boolean run = true; // 불리언 변수 선언?(아마도)

		while (run) {
			System.out.println("1.도서등록 2.수정 3.삭제 4.목록 5.출판사 검색 9.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine()); // 숫자인데 문자열로 받고 다시 정수로 바꿔주는 이유는 : n하고 엔터까지 동시에 처리하기 위해서(아마도)
															// 스위치 문에는 조건에 값이 정수로 들어가야 매칭 확인 가능하니까

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				delete();
				break;
			case 4: // 목록 - 제목, 저자, 가격만 보여주고 싶음
				list();
				break;
			case 5:
				searchByPublisher();
				break;
			case 9: // 종료
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요!");
				break;
			}
		}
		System.out.println("end of prog.");
	} // END OF MAIN

	static void init() {
		bookStore[0] = new Book("구구구", "비둘기", "한빛출", 1800, 1);
		bookStore[1] = new Book("짹짹짹", "참새", "우리출", 3000, 2);
		bookStore[2] = new Book("부자되는방법", "김거지", "가람출", 120000, 3);
		bookStore[3] = new Book("오늘은 내가 요리사", "백종원", "한빛출", 17000, 4);
		bookStore[4] = new Book("연어초밥이란 무엇인가", "미스터초밥왕", "가람출", 30000, 5);
		bookStore[5] = new Book("슈퍼샤이", "뉴진스", "가람출", 22000, 6);
	}
}
