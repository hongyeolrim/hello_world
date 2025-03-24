package yeol.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import yeol.dao.InstituteDao;
import yeol.model.BoardDto;
import yeol.model.ClassDto;
import yeol.model.StudentDto;

public class InstituteApp {
	private InstituteDao dao = new InstituteDao();
	private Scanner sc = new Scanner(System.in);
	private StudentDto currentUser;

	private void printLine() {
		System.out.println("----------------------------------------------------------------------------");
	}

	private void printLine2() {
		System.out.println("============================================================================");
	}

	private boolean isNullOrEmpty(String s) {
		return s == null || s.trim().isEmpty();
	}

	private void printWelcome() {
		printLine2();
		System.out.println("🎓 외국어 학원 수강 신청 ver 1.0");
		printLine2();
	}

	private void printMainMenu() {
		printLine();
		System.out.println("[1.로그인🆔] [2.회원 가입👤] [3.강의 목록📚] [4.수강 신청📝] [5.Q&A 게시판💭] [6.내 정보] [7.나가기👋]");
		printLine();
	}

	public StudentDto loginProcess(String loginId, String loginPw) {

		StudentDto student = dao.login(loginId, loginPw);
		if (student != null) {
			System.out.println("🎉로그인 성공! " + student.getStudentName() + "님, 반갑습니다!😊");
			return student;
		} else {
			System.out.println("❌로그인 실패! 아이디 또는 비밀번호가 잘못되었습니다.😢");
			return null;
		}
	}

	public StudentDto joinProcess(String loginId, String loginPw, String studentName, String studentTel) {

		if (StudentDto.checkLoginId(loginId) && StudentDto.checkLoginPw(loginPw)) {
			StudentDto newUser = dao.join(loginId, loginPw, studentName, studentTel);
			if (newUser != null) {
				System.out.println("✨회원 가입이 완료됐습니다!🥳");
				System.out.println("자동으로 로그인 되었습니다. 환영합니다, " + newUser.getStudentName() + "님!");
			}
			return newUser;
		} else {
			System.out.println("⚠가입 정보를 올바른 형식으로 다시 입력해 주세요.");
			return null;
		}
	}

	public void showClassList() {
		List<ClassDto> classList = dao.classList();
		for (ClassDto cls : classList) {
			System.out.println(cls);
		}
	}

	public boolean enrollProcess() {
		List<ClassDto> classList = dao.classList();
		for (int i = 0; i < classList.size(); i++) {
			System.out.print(" [" + (i + 1) + "." + classList.get(i).getClassName());
		}
		System.out.println("메뉴 선택>> ");
		int choice;

		try {
			choice = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("❗숫자만 입력해 주세요.");
			return false;
		}

		if (choice < 1 || choice > classList.size()) {
			System.out.println("❗잘못된 번호입니다.");
			return false;
		}

		ClassDto selectedClass = classList.get(choice - 1); // 배열은 0부터 시작하니까
		System.out.println(selectedClass.getClassName() + "수업을 수강 신청 하시겠습니까? (Y/n)>> ");
		String answer = sc.nextLine();

		if (answer.equalsIgnoreCase("y")) {
			int result = dao.enroll(currentUser.getStudentCode(), choice);
			if (result == 1) {
				System.out.println("✅수강 신청 완료!");
				return true;
			} else if (result == -1) {
				System.out.println("❌수강 신청 실패! 이미 신청한 수업이 있는지 확인하세요.");
			} else {
				System.out.println("😅수강 신청이 취소되었습니다.");
			}
		}
		return false;
	}

	public void showBoardList() {
		for (BoardDto board : dao.boardList()) {
			System.out.println(board);
		}
	}

	public void run() {
		printWelcome();

		while (true) {
			printMainMenu();

			System.out.print("메뉴 선택>> ");
			String input = sc.nextLine();

			switch (input) {
			case "1":
				System.out.println("아이디를 입력하세요>> ");
				String loginId = sc.nextLine();
				System.out.println("비밀번호를 입력하세요>> ");
				String loginPw = sc.nextLine();
				currentUser = loginProcess(loginId, loginPw);
				break;
			case "2":
				System.out.println("아이디 생성(4~10자/영문 대소문자 또는 숫자)>> ");
				String createId = sc.nextLine();
				System.out.println("비밀번호 생성(4~12자/영문 대소문자 또는 숫자)>> ");
				String createPw = sc.nextLine();
				System.out.println("이름>> ");
				String studentName = sc.nextLine();
				System.out.println("연락처(예:01011112222)>> ");
				String studentTel = sc.nextLine();
				currentUser = joinProcess(createId, createPw, studentName, studentTel);
				break;
			case "3":
				printLine2();
				System.out.println("전체 강의 목록📋");
				printLine2();
				showClassList();
				printLine();
				System.out.println("이전 메뉴>b");
				String back = sc.nextLine();

				// equalsIgnoreCase() 대소문자 구분 X
				if (back.equalsIgnoreCase("b")) {
					break;
				} else {
					System.out.println("❗잘못된 입력입니다. 메인 메뉴로 돌아가려면 'b'를 입력하세요.");
				}
				break;
			case "4":
				if (currentUser == null) {
					System.out.println("🔒수강 신청을 하려면 먼저 로그인 해 주세요!");
					break;
				}
				enrollProcess();
				break;
			case "5":
				System.out.println("[1.게시글 목록] [2.게시글 등록] [3.게시글 삭제] [4.메인으로 돌아가기]");
				System.out.println("메뉴 선택>> ");
				String menu = sc.nextLine();
				switch (menu) {
				case "1":
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				}
				break;
			case "6":
				break;
			case "7":
				System.out.println("🚪프로그램을 종료합니다. 다음에 또 만나요~!💕");
				sc.close();
				return;
			default:
				System.out.println("❗올바른 메뉴 번호를 입력하세요.");
			}
		}
	}

}
