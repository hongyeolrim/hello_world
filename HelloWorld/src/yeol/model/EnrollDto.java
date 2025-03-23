package yeol.model;

import java.util.Date;

public class EnrollDto {
	private String studentCode;
	private String classCode;
	private Date enrollDate;

	public EnrollDto() {
	}

	public EnrollDto(String studentCode, String classCode, Date enrollDate) {
		this.studentCode = studentCode;
		this.classCode = classCode;
		this.enrollDate = enrollDate;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
}
