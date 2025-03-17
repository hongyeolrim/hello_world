package com.yedam.bookApp;

import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 싱글톤 객체 호출
		BookMain mainApp = BookMain.getInstance();

		// 로그인 과정 추가
		System.out.println("아이디 입력>> ");
		String id = scanner.nextLine();
		System.out.println("비밀번호 입력>> ");
		String password = scanner.nextLine();

		if (mainApp.login(id, password)) {
			mainApp.main(args);
		} else {
			System.out.println("사용자 정보가 일치하지 않아 프로그램을 종료합니다.");
			return;
		}
		scanner.close();
	}
}

// 회원 로그인 기능을 만들고, 로그인 성공한 사람만 BookMain을 실행할 수 있도록 만들기!
// BookMain 클래스에서 singleton 패턴을 유지하면서, main()을 통해서만 실행 가능하게 하기
// 회원(User) 데이터를 저장하고 로그인 검증하는 기능을 추가하기

// 숙제:
// 1번) BookMain의 main메소드를 통해서만 기능활용하도록 하세요.
// User 클래스를 생성하고
// BookMain에 User[]을 선언해서 회원을 3명 등록하기.
// BookMain에 login메소드를 선언하고 매개값으로 아이디와 비밀번호를 입력받도록 한다.
// login메소드는 User[]에 등록된 회원중에서 입력받은 아이디와 비밀번호가 있으면 로그인성공 아니면 실패.
// login성공 했을 경우에만 1번) main메소드를 실행하도록 한다
