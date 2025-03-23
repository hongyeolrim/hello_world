package yeol.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
	public boolean join(String loginId, String loginPw, String studentName, String studentTel) {
		String sql = "INSERT INTO students(student_code, login_id, login_pw, student_name, student_tel, join_date) "
				+ "VALUES ('S' || LPAD(student_seq.NEXTVAL, 3, '0'), ?, ?, ?, ?, SYSDATE)";

		if (isNullOrEmpty(loginId) || isNullOrEmpty(loginPw) || isNullOrEmpty(studentName)
				|| isNullOrEmpty(studentTel)) {

			return false;
		}

		// 전화번호에서 숫자만 남기기
		// replaceAll("바꾸고 싶은 문자의 패턴(regex)", "대체할 문자")
		studentTel = studentTel.replaceAll("[^0-9]", "");

		try (Connection conn = openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, loginId);
			stmt.setString(2, loginPw);
			stmt.setString(3, studentName);
			stmt.setString(4, studentTel);

			return stmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	} // end of 회원가입 처리 메서드

}