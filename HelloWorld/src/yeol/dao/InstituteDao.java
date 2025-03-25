package yeol.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import yeol.model.BoardDto;
import yeol.model.ClassDto;
import yeol.model.CommentDto;
import yeol.model.StudentDto;

public class InstituteDao {

	// DB 연결 메서드
	public Connection openConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";

		try {
			return DriverManager.getConnection(url, userId, userPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end of DB 연결 메서드

	// null값 & 빈 문자열 확인 메서드
	public boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	// 클래스 코드 매핑 메서드
	private String getClassCodeFromChoice(int choice) {
		switch (choice) {
		case 1:
			return "A001"; // 아랍어
		case 2:
			return "B001"; // 베트남어
		case 3:
			return "C001"; // 프랑스어
		case 4:
			return "D001"; // 인도네시아어
		default:
			return null;
		}
	}

	// 로그인 처리 메서드
	public StudentDto login(String loginId, String loginPw) {
		String sql = "SELECT student_code, student_name, student_tel, join_date FROM students WHERE login_id = ? AND login_pw = ?";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, loginId);
			stmt.setString(2, loginPw);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String studentCode = rs.getString("student_code");
				String studentName = rs.getString("student_name");
				String studentTel = rs.getString("student_tel");
				Date joinDate = rs.getDate("join_date");
				return new StudentDto(studentCode, loginId, loginPw, studentName, studentTel, joinDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end of 로그인 처리 메서드

	// 회원가입 처리 메서드
	// LPAD(값, 총길이, '채울문자')
	public StudentDto join(String loginId, String loginPw, String studentName, String studentTel) {
		String joinSql = "INSERT INTO students(student_code, login_id, login_pw, student_name, student_tel, join_date) "
				+ "VALUES ('S' || LPAD(student_seq.NEXTVAL, 3, '0'), ?, ?, ?, ?, SYSDATE)";
		String selectSql = "SELECT student_code, join_date FROM students WHERE login_id = ?";

		if (isNullOrEmpty(loginId) || isNullOrEmpty(loginPw) || isNullOrEmpty(studentName)
				|| isNullOrEmpty(studentTel)) {
			return null;
		}

		studentTel = studentTel.replaceAll("[^0-9]", ""); // 전화번호에서 숫자만 남기기

		try (Connection conn = openConnection();
				PreparedStatement joinStmt = conn.prepareStatement(joinSql);
				PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {

			joinStmt.setString(1, loginId);
			joinStmt.setString(2, loginPw);
			joinStmt.setString(3, studentName);
			joinStmt.setString(4, studentTel);

			int result = joinStmt.executeUpdate();
			if (result > 0) {
				selectStmt.setString(1, loginId);
				ResultSet rs = selectStmt.executeQuery();
				if (rs.next()) {
					String studentCode = rs.getString("student_code");
					Date joinDate = rs.getDate("join_date");
					return new StudentDto(studentCode, loginId, loginPw, studentName, studentTel, joinDate);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end of 회원가입 처리 메서드

	// 강의 목록 출력 메서드
	public List<ClassDto> classList() {
		List<ClassDto> classList = new ArrayList<>();
		String sql = "SELECT class_code, class_name, prof_name, start_date, end_date, tuition_fee FROM classes ORDER BY class_code";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				classList.add(
						new ClassDto(rs.getString("class_code"), rs.getString("class_name"), rs.getString("prof_name"),
								rs.getDate("start_date"), rs.getDate("end_date"), rs.getDouble("tuition_fee")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>(); // 예외 발생 시 빈 리스트 반환
		}
		return classList;
	} // end of 강의 목록 출력 메서드

	// 수강 신청 처리 메서드
	// 성공: 1, 이미 신청했을 때: -1, 기타 실패: 0
	public int enroll(String studentCode, int choice) {
		String classCode = getClassCodeFromChoice(choice);

		// 1. 이미 신청했는지 먼저 체크
		if (isAlreadyEnrolled(studentCode, classCode)) {
			return -1; // 중복 신청이면 -1 반환
		}

		// 2. 신청 처리 (INSERT)
		String sql = "INSERT INTO enrollment(student_code, class_code, enroll_date) VALUES (?, ?, SYSDATE)";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, studentCode);
			stmt.setString(2, classCode);

			int result = stmt.executeUpdate(); // 성공한 행 수

			return result > 0 ? 1 : 0; // 성공한 행 수가 0보다 크면 1 반환, 그게 아니면(실패했으면) 0을 반환

		} catch (SQLException e) {
			e.printStackTrace();
			return 0; // 예외 발생도 실패로 처리
		}
	}
	// end of 수강 신청 처리 메서드

	// 수강 신청 중복 확인 메서드
	private boolean isAlreadyEnrolled(String studentCode, String classCode) {
		String sql = "SELECT COUNT(*) FROM enrollment WHERE student_code = ? AND class_code = ?";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, studentCode);
			stmt.setString(2, classCode);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0; // 수강한 적 있으면 true
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	} // end of 수강 신청 중복 확인 메서드

	// 특정 학생이 수강 신청한 수업 가져오기 메서드
	public ClassDto getEnrolledClass(String studentCode) {
		String sql = "SELECT c.class_code, c.class_name, c.prof_name, c.start_date, c.end_date, c.tuition_fee "
				+ "FROM classes c JOIN enrollment e ON c.class_code = e.class_code " + "WHERE e.student_code = ?";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, studentCode);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new ClassDto(rs.getString("class_code"), rs.getString("class_name"), rs.getString("prof_name"),
						rs.getDate("start_date"), rs.getDate("end_date"), rs.getDouble("tuition_fee"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end of 특정 학생이 수강 신청한 수업 가져오기 메서드

	// 조회수 증가 메서드
	public boolean incrementViews(int postCode) {
		String sql = "UPDATE qna_board SET views = views + 1 WHERE post_code = ?";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, postCode);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} // end of 조회수 증가 메서드

	// 게시글 목록 처리 메서드
	public List<BoardDto> boardList() {
		List<BoardDto> boardList = new ArrayList<>();
		String sql = "SELECT post_code, title, content, login_id, write_date, views FROM qna_board ORDER BY post_code DESC";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				boardList.add(new BoardDto(rs.getInt("post_code"), rs.getString("title"), rs.getString("content"),
						rs.getString("login_id"), rs.getDate("write_date"), rs.getInt("views")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>(); // 예외 발생 시 빈 리스트 반환
		}
		return boardList;
	} // end of 게시글 목록 처리 메서드

	// 게시글 출력 처리 메서드
	public BoardDto getBoard(int postCode) {
		String sql = "SELECT post_code, title, content, login_id, write_date, views FROM qna_board WHERE post_code = ?";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, postCode);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new BoardDto(rs.getInt("post_code"), rs.getString("title"), rs.getString("content"),
						rs.getString("login_id"), rs.getDate("write_date"), rs.getInt("views"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end of 게시글 출력 처리 메서드

	// 게시글 등록 처리 메서드
	public boolean posting(String loginId, String title, String content) {
		if (title == null) {
			return false;
		}

		String sql = "INSERT INTO qna_board(post_code, title, content, login_id, write_date, views)\r\n"
				+ "VALUES (post_code_seq.NEXTVAL, ?, ?, ?, SYSDATE)";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setString(3, loginId);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} // end of 게시글 등록 처리 메서드

	// 게시글 삭제 메서드
	public boolean deletePost(int postCode) {
		String deleteCommentsSql = "DELETE FROM qna_comments WHERE post_code = ?"; // 게시글 삭제되면 댓글도 같이 삭제
		String deletePostSql = "DELETE FROM qna_board WHERE post_code = ?";

		try (Connection conn = openConnection();
				PreparedStatement deleteCommentsStmt = conn.prepareStatement(deleteCommentsSql);
				PreparedStatement deletePostStmt = conn.prepareStatement(deletePostSql)) {

			deleteCommentsStmt.setInt(1, postCode); // 댓글 삭제
			deleteCommentsStmt.executeUpdate(); // 댓글이 없어도 그냥 시도하고 넘어감

			deletePostStmt.setInt(1, postCode);

			return deletePostStmt.executeUpdate() > 0; // 게시글 삭제만 성공하면 true
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} // end of 게시글 삭제 메서드

	// 글번호로 게시글 조회하는 메서드
	public BoardDto getPostByCode(int postCode) {
		String sql = "SELECT post_code, title, content, login_id, write_date, views FROM qna_board WHERE post_code = ?";
		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, postCode);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setPostCode(rs.getInt("post_code"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setWriteDate(rs.getDate("write_date"));
				dto.setViews(rs.getInt("views"));
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	} // end of 글번호로 게시글 조회하는 메서드

	// 이전 게시물의 글번호 가져오는 메서드
	// 반환 타입을 int가 아니라 Integer로 하는 이유 : null 값도 받아야 해서
	public Integer getPrevPostCode(int postCode) {
		String sql = "SELECT post_code FROM qna_board WHERE post_code < ? ORDER BY post_code DESC FETCH FIRST 1 ROWS ONLY";
		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, postCode);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("post_code");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// end of 이전 게시물의 글번호 가져오는 메서드

	// 다음 게시물의 글번호 가져오는 메서드
	public Integer getNextPostCode(int postCode) {
		String sql = "SELECT post_code FROM qna_board WHERE post_code > ? ORDER BY post_code FETCH FIRST 1 ROWS ONLY";
		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, postCode);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("post_code");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end of 다음 게시물의 글번호 가져오는 메서드

	// 게시글(n)의 전체 댓글 출력 메서드
	public List<CommentDto> commentList(int postCode) {
		List<CommentDto> commentList = new ArrayList<>();
		String sql = "SELECT comment_code, post_code, content, login_id, write_date FROM qna_comments WHERE post_code = ? ORDER BY comment_code DESC";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, postCode);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				commentList.add(new CommentDto(rs.getInt("comment_code"), rs.getInt("post_code"),
						rs.getString("content"), rs.getString("login_id"), rs.getDate("write_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	} // end of 게시글(n)의 전체 댓글 출력 메서드

	// 댓글 번호로 댓글 조회하는 메서드 - 상세보기
	public CommentDto getComment(int commentCode) {
		String sql = "SELECT comment_code, post_code, content, login_id, write_date FROM qna_comments WHERE comment_code = ?";
		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, commentCode);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new CommentDto(rs.getInt("comment_code"), rs.getInt("post_code"), rs.getString("content"),
						rs.getString("login_id"), rs.getDate("write_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 조회 실패 시 null 반환
	} // end of 댓글 번호로 댓글 조회하는 메서드 - 상세보기

	// 댓글 등록 처리 메서드
	public boolean commenting(int postCode, String loginId, String content) {
		if (content == null || content.trim().isEmpty()) {
			return false;
		}

		String sql = "INSERT INTO qna_comments(comment_code, post_code, content, login_id, write_date)\r\n"
				+ "VALUES (comment_code_seq.NEXTVAL, ?, ?, ?, SYSDATE)";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, postCode);
			stmt.setString(2, content);
			stmt.setString(3, loginId);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} // end of 댓글 등록 처리 메서드

	// 댓글 삭제 메서드
	public boolean deleteComment(int commentCode) {
		String sql = "DELETE FROM qna_comments WHERE comment_code = ?";

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, commentCode);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} // end of 댓글 삭제 메서드
}