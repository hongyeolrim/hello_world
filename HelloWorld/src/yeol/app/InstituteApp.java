package yeol.app;

import java.util.List;
import java.util.Scanner;

import yeol.dao.InstituteDao;
import yeol.model.BoardDto;
import yeol.model.ClassDto;
import yeol.model.CommentDto;
import yeol.model.StudentDto;

public class InstituteApp {
	private InstituteDao dao = new InstituteDao();
	private Scanner sc = new Scanner(System.in);
	private StudentDto currentUser;

	// 가운데 정렬 함수
	public static String center(String text, int width) {
		int padding = width - text.length();
		int left = padding / 2;
		int right = padding - left;
		return " ".repeat(left) + text + " ".repeat(right);
	}

	// 라인 출력 메서드1
	private void printLine() {
		System.out.println("----------------------------------------------------------------------------");
	}

	// 라인 출력 메서드2
	private void printLine2() {
		System.out.println("============================================================================");
	}

	// 프로그램 이름 출력 메서드
	private void printWelcome() {
		printLine2();
		System.out.println("🎓 외국어 학원 수강 신청 ver 1.0");
		printLine2();
	}

	// 메인 메뉴 출력 메서드
	private void printMainMenu() {
		printLine();
		System.out.println("[1.로그인🆔] [2.회원 가입➕] [3.강의 목록📚] [4.수강 신청📝] [5.Q&A 게시판💭] [6.내 정보👤] [7.나가기👋]");
		printLine();
	}

	// null과 공백 확인 메서드
	private boolean isNullOrEmpty(String s) {
		return s == null || s.trim().isEmpty();
	}

	// 로그인 여부 확인 메서드(특정 메뉴들은 로그인 안 하면 접근할 수 없음, 경고)
	private void isLoggedIn() {
		if (currentUser == null) {
			System.out.println("🔒로그인 후 이용 가능한 메뉴입니다.");
			return;
		}
	}

	// 로그인 메서드
	public StudentDto loginProcess(String loginId, String loginPw) {

		StudentDto student = dao.login(loginId, loginPw);
		if (student != null) {
			System.out.println("🎉로그인 성공! " + student.getStudentName() + "님, 반갑습니다!😊");
			return student;
		} else {
			System.out.println("❌로그인 실패! 아이디 또는 비밀번호가 잘못되었습니다.😢");
			return null;
		}
	} // end of 로그인 메서드

	// 로그인 메서드_최종
	private void login() {
		System.out.println("아이디를 입력하세요>> ");
		String loginId = sc.nextLine();
		System.out.println("비밀번호를 입력하세요>> ");
		String loginPw = sc.nextLine();
		currentUser = loginProcess(loginId, loginPw);
	} // end of 로그인 메서드_최종

	// 회원 가입 메서드
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
	} // end of 회원 가입 메서드

	// 회원 가입 메서드_최종
	private void join() {
		System.out.println("아이디 생성(4~10자/영문 대소문자 또는 숫자)>> ");
		String createId = sc.nextLine();
		System.out.println("비밀번호 생성(4~12자/영문 대소문자 또는 숫자)>> ");
		String createPw = sc.nextLine();
		System.out.println("이름>> ");
		String studentName = sc.nextLine();
		System.out.println("연락처(예:01011112222)>> ");
		String studentTel = sc.nextLine();
		currentUser = joinProcess(createId, createPw, studentName, studentTel);
	} // end of 회원 가입 메서드_최종

	// 강의 목록 출력 메서드
	public void showClassListProcess() {
		List<ClassDto> classList = dao.classList();
		for (ClassDto cls : classList) {
			System.out.println(cls);
		}
	} // end of 강의 목록 출력 메서드

	// 강의 목록 출력 메서드_최종
	private void showClassList() {
		printLine2();
		System.out.println("전체 강의 목록📋");
		printLine2();
		showClassListProcess();
		printLine();
		System.out.println("이전 메뉴: b");
		String back = sc.nextLine();

		// equalsIgnoreCase() 대소문자 구분 X
		if (back.equalsIgnoreCase("b")) {
			return;
		} else {
			System.out.println("❗잘못된 입력입니다. 메인 메뉴로 돌아가려면 'b'를 입력하세요.");
		}
	}

	// 수강 신청 메서드
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
	} // end of 수강 신청 메서드

	// 수강 신청 메서드_최종
	private void enrollment() {
		isLoggedIn();
		enrollProcess();
	}

	// 게시판 출력 메서드(관리자용)
	public void showBoardList() {
		List<BoardDto> blist = dao.boardList();

		printLine2();
		System.out.println(center("[글번호]", 8) + center("[제목]", 30) + center("[작성자]", 15) + center("[작성일자]", 15)
				+ center("[조회수]", 7));
		printLine();
		for (BoardDto board : blist) {
			String title = board.getTitle();
			if (title.length() > 27) {
				title = title.substring(0, 26) + "...";
			}
			System.out.println(center(String.valueOf(board.getPostCode()), 8) + center(title, 30)
					+ center(board.getLoginId(), 15) + center(String.valueOf(board.getWriteDate()), 15)
					+ center(String.valueOf(board.getViews()), 7));
		}
		printLine2();
	} // end of 게시글 출력 메서드

	// 게시판 출력 메서드 - 한 페이지에 5개씩 출력 적용
	private void showBoardByPage(int page) {
		List<BoardDto> list = dao.boardList(); // 전체 게시글 리스트 가져오기
		int pageSize = 5; // 한 페이지에 보여줄 게시글 수
		int total = list.size(); // 전체 게시글 수(리스트의 사이즈)

		// 총 페이지 수(전체 게시글 수 / 5 -> 소수점도 나오게 형변환 -> Math.ceil로 올림)
		int totalPages = (int) Math.ceil((double) total / pageSize);

		// 잘못된 페이지 번호 방지
		if (page < 1 || page > totalPages) {
			System.out.println("❗페이지가 존재하지 않습니다.");
			return;
		}

		int start = (page - 1) * pageSize; // 리스트 시작 인덱스 = 0, 5, 10...
		int end = Math.min(start + pageSize, total); // 리스트 끝 인덱스(총 개수 넘지 않게)

		printLine2();
		System.out.println(center("[글번호]", 8) + center("[제목]", 30) + center("[작성자]", 15) + center("[작성일자]", 15)
				+ center("[조회수]", 7));
		printLine();
		// 5개씩만 출력
		for (int i = start; i < end; i++) {
			BoardDto board = list.get(i);
			String title = board.getTitle();
			if (title.length() > 27)
				title = title.substring(0, 26) + "..."; // 제목 너무 길면 자름
			System.out.println(center(String.valueOf(board.getPostCode()), 8) + center(title, 30)
					+ center(board.getLoginId(), 15) + center(String.valueOf(board.getWriteDate()), 15)
					+ center(String.valueOf(board.getViews()), 7));
		}
		printLine2();
		System.out.println("📜현재 페이지: " + page + " / " + totalPages); // 현재 페이지 안내
	} // end of 게시판 출력 메서드 - 한 페이지에 5개씩 출력 적용

	// 게시판 출력_최종(사용자용) 메서드 - 페이징&사용자 입력 처리
	public void boardWithPagination() {
		int currentPage = 1; // 처음은 1페이지부터 시작

		while (true) {
			showBoardByPage(currentPage); // 게시판 글 목록(현재 페이지) 출력
			System.out.println("게시글 읽기>> 글번호 입력 | 이전: p | 다음: n | 이전 메뉴: b");
			String input = sc.nextLine();

			if (input.equalsIgnoreCase("p")) {
				currentPage--;
			} else if (input.equalsIgnoreCase("n")) {
				currentPage++;
			} else if (input.equalsIgnoreCase("b")) {
				System.out.println("📁게시판 메뉴로 돌아갑니다.");
				return;
			} else {
				try {
					int postCode = Integer.parseInt(input);
					readPost(postCode);
				} catch (NumberFormatException e) {
					System.out.println("❗숫자(글번호) 또는 p/n/b 중 하나를 입력해 주세요.");
				}
			}
		}
	}

	// 게시글 번호와 일치하는 게시물 출력 메서드
	private void printPost(BoardDto post) {
		printLine2();
		System.out.println("📄 " + post.getTitle());
		System.out
				.println("작성자: " + post.getLoginId() + " | 작성일: " + post.getWriteDate() + " | 조회수: " + post.getViews());
		printLine2();
		System.out.println(post.getContent());
	} // end of 게시글 번호와 일치하는 게시물 출력 메서드

	// 게시글 읽기 메서드
	public void readPost(int postCode) {
		dao.incrementViews(postCode); // 조회수 증가는 딱 1번만

		while (true) {
			BoardDto post = dao.getPostByCode(postCode);

			if (post == null) {
				System.out.println("❌해당 글이 존재하지 않습니다!");
				return;
			}

			// 게시글 출력
			printPost(post);
			// 댓글 출력
			printCommentList(postCode);
			// 사용자 입력 받기
			printLine();
			System.out.println("📌댓글 읽기>> 댓글번호 입력 | 댓글 쓰기: w | 댓글 삭제: d | 뒤로 가기: b");
			System.out.println("◀️ 이전 글: p | 다음 글: n ▶️");
			String input = sc.nextLine();

			// 입력 처리
			if (input.equalsIgnoreCase("w")) {
				writeComment(postCode);
			} else if (input.equalsIgnoreCase("d")) {
				deleteComment();
			} else if (input.equalsIgnoreCase("b")) {
				break; // 게시글 목록으로 돌아가기
			} else if (input.equalsIgnoreCase("p")) {
				Integer prev = dao.getPrevPostCode(postCode);
				if (prev == null) {
					System.out.println("❗이전 글이 없습니다.");
				} else {
					postCode = prev;
					dao.incrementViews(postCode); // 새 글로 이동하면 조회수 증가
				}
			} else if (input.equalsIgnoreCase("n")) {
				Integer next = dao.getNextPostCode(postCode);
				if (next == null) {
					System.out.println("❗다음 글이 없습니다.");
				} else {
					postCode = next;
					dao.incrementViews(postCode); // 새 글로 이동하면 조회수 증가
				}
			} else {
				// 숫자면 댓글번호로 간주
				try {
					int commentCode = Integer.parseInt(input);
					readComment(commentCode);
				} catch (NumberFormatException e) {
					System.out.println("❗잘못된 입력입니다.");
				}
			}
		}
	}

	// 게시글 등록 메서드
	public void writePostProcess(String title, String content) {

		if (isNullOrEmpty(title)) {
			System.out.println("제목은 반드시 입력해 주세요!✍️");
			return;
		}
		dao.posting(currentUser.getLoginId(), title, content);
		System.out.println("게시글 등록이 완료되었습니다!👍");
	} // end of 게시글 등록 메서드

	// 게시글 등록 메서드_최종
	private void writePost() {
		isLoggedIn();
		System.out.println("제목 입력>> ");
		String title = sc.nextLine();
		System.out.println("내용 입력>> ");
		String content = sc.nextLine();
		writePostProcess(title, content);
	} // end of 게시글 등록 메서드_최종

	// 게시글 삭제 메서드
	public void deletePostProcess(int postCode) {
		BoardDto post = dao.getPostByCode(postCode);

		if (post == null) {
			System.out.println("해당 게시글이 존재하지 않습니다.🔍");
			return;
		}
		if (!currentUser.getLoginId().equals(post.getLoginId())) {
			System.out.println("다른 사용자의 글은 삭제할 수 없습니다.👀");
			return;
		}
		System.out.println("정말로 삭제하시겠습니까? Y/n>> ");
		String answer = sc.nextLine();

		if (answer.equalsIgnoreCase("y")) {
			dao.deletePost(postCode);
			System.out.println("게시글 삭제가 완료되었습니다!🗑️");
		} else if (answer.equalsIgnoreCase("n")) {
			System.out.println("게시글 삭제를 취소했습니다");
		} else {
			System.out.println("게시글 삭제에 실패했습니다.😲");
		}
	} // end of 게시글 삭제 메서드

	// 게시글 삭제 메서드_최종
	private void deletePost() {
		try {
			System.out.print("삭제할 게시글의 글번호 입력>> ");
			int postCode = Integer.parseInt(sc.nextLine());
			deletePostProcess(postCode);
		} catch (NumberFormatException e) {
			System.out.println("❗숫자만 입력해 주세요.");
		}
	} // end of 게시글 삭제 메서드_최종

	// 댓글 출력 메서드
	private void printCommentList(int postCode) {
		List<CommentDto> comments = dao.commentList(postCode);

		System.out.println("💬 댓글 목록 💬");
		printLine();

		System.out.printf("%-10s %-30s %-15s %-20s\n", "댓글번호", "내용", "작성자", "작성일자");
		printLine();

		if (comments.isEmpty()) {
			System.out.println("등록된 댓글이 없습니다.😳");
		} else {
			for (CommentDto c : comments) {
				String content = c.getContent();
				if (content.length() > 25) {
					content = content.substring(0, 24) + "...";
				}
				System.out.printf("%-10d %-30s %-15s %-20s\n", c.getCommentCode(), content, c.getLoginId(),
						c.getWriteDate());
			}
		}
	} // end of 댓글 출력 메서드

	// 댓글 상세 읽기 메서드
	private void readComment(int commentCode) {
		CommentDto comment = dao.getComment(commentCode);

		if (comment == null) {
			System.out.println("❌입력하신 번호에 해당하는 댓글은 존재하지 않습니다.");
		} else {
			System.out.println("\n🔍댓글 상세 보기");
			printLine();
			System.out.println("작성자: " + comment.getLoginId());
			System.out.println("작성일: " + comment.getWriteDate());
			System.out.println("내용:\n" + comment.getContent());
			printLine();
		}
	} // end of 댓글 상세 읽기 메서드

	// 댓글 등록 메서드
	public void writeComment(int postCode) {
		isLoggedIn();

		System.out.println("댓글 내용 작성>> ");
		String content = sc.nextLine();

		if (isNullOrEmpty(content)) {
			System.out.println("❗댓글 내용은 비워둘 수 없습니다.");
			return;
		}

		boolean result = dao.commenting(postCode, currentUser.getLoginId(), content);
		if (result) {
			System.out.println("✅댓글이 등록되었습니다!");
			printCommentList(postCode); // 댓글만 다시 출력(댓글 쓰자마자 확인 가능)
			return;
		} else {
			System.out.println("❌댓글 등록에 실패했습니다.");
		}
	} // end of 댓글 등록 메서드

	// 댓글 삭제 메서드
	public void deleteComment() {
		System.out.println("삭제할 댓글 번호 입력>> ");
		int commentCode = Integer.parseInt(sc.nextLine());
		CommentDto comment = dao.getComment(commentCode);

		// 댓글이 존재하는지 null값 체크
		if (comment == null) {
			System.out.println("❌해당 댓글이 존재하지 않습니다.");
			return;
		}

		// 로그인 여부 체크
		isLoggedIn();

		// 본인이 쓴 댓글인지 확인
		if (!comment.getLoginId().equals(currentUser.getLoginId())) {
			System.out.println("❗다른 사람이 쓴 댓글은 삭제할 수 없습니다.");
			return;
		}

		// 삭제 의사 확인
		System.out.println("정말로 삭제하시겠습니까? Y/n>> ");
		String answer = sc.nextLine();

		if (answer.equalsIgnoreCase("y")) {
			dao.deleteComment(commentCode);
			System.out.println("댓글 삭제가 완료되었습니다!🗑️");
		} else if (answer.equalsIgnoreCase("n")) {
			System.out.println("댓글 삭제를 취소했습니다.");
		} else {
			System.out.println("댓글 삭제에 실패했습니다.😲");
		}
	} // end of 댓글 삭제 메서드

	// 내 정보 출력 메서드
	public void myInfo() {
		isLoggedIn();
		printLine2();
		System.out.println("😎내 정보");
		printLine();
		System.out.println("아이디: " + currentUser.getLoginId());
		System.out.println("이름: " + currentUser.getStudentName());
		System.out.println("연락처: " + currentUser.getStudentTel());
		System.out.println("가입일: " + currentUser.getJoinDate());
		printLine();
		System.out.println("내가 수강 신청한 수업!👉👈");
		ClassDto ec = dao.getEnrolledClass(currentUser.getStudentCode());
		if (ec != null) {
			System.out.println(dao.getEnrolledClass(currentUser.getStudentCode()));
		} else {
			System.out.println("❗아직 수강 신청한 수업이 없습니다.");
		}
	} // end of 내 정보 출력 메서드

	private void boardMenu() {
		while (true) {
			System.out.println("[1.게시글 목록] [2.게시글 등록] [3.게시글 삭제] [4.메인으로 돌아가기]");
			System.out.println("메뉴 선택>> ");
			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				boardWithPagination();
				break;
			case "2":
				writePost();
				break;
			case "3":
				deletePost();
				break;
			case "4":
				System.out.println("📁메인 메뉴로 돌아갑니다.");
				break;
			}
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
				login();
				break;
			case "2":
				join();
				break;
			case "3":
				showClassList();
				break;
			case "4":
				enrollment();
				break;
			case "5":
				boardMenu();
				break;
			case "6":
				myInfo();
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
