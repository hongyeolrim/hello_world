package yeol.model;

import java.util.Date;
import java.util.regex.Pattern;

public class StudentDto {
	private String studentCode;
	private String loginId;
	private String loginPw;
	private String studentName;
	private String studentTel;
	private Date joinDate;

	public StudentDto() {
	}

	public StudentDto(String studentCode, String loginId, String loginPw, String studentName, String studentTel,
			Date joinDate) {
		this.studentCode = studentCode;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.studentName = studentName;
		this.studentTel = studentTel;
		this.joinDate = joinDate;
	}

	// 아이디 형식에 제약을 걸기 위해 regular expression 사용
	// 4글자 이상 10글자 이하, 영문 대소문자 그리고 숫자만 허용
	// 글자수 제한하는 코드 사이에 공백 들어가면 안 됨! 주의!
	public static boolean checkLoginId(String loginId) {
		String regex = "^[a-zA-Z0-9]{4,10}$";
		return Pattern.matches(regex, loginId);
	}

	public static boolean checkLoginPw(String loginPw) {
		String regex = "^[a-zA-Z0-9]{4,12}$";
		return Pattern.matches(regex, loginPw);
	}

	public String getStudentCode() {
		return studentCode;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentTel() {
		return studentTel;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public void setLoginId(String loginId) {
		if (checkLoginId(loginId)) {
			this.loginId = loginId;
		} else {
			System.out.println("아이디는 4~10자 영문 대소문자와 숫자만 허용됩니다.");
		}
	}

	public void setLoginPw(String loginPw) {
		if (checkLoginPw(loginPw)) {
			this.loginPw = loginPw;
		} else {
			System.out.println("비밀번호는 4~12자 영문 대소문자와 숫자만 허용됩니다.");
		}
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
