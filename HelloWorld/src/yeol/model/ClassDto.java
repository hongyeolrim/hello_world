package yeol.model;

import java.util.Date;

public class ClassDto {
	private String classCode;
	private String className;
	private String profName;
	private Date startDate;
	private Date endDate;
	private double tuitionFee;

	public ClassDto() {
	}

	public ClassDto(String classCode, String className, String profName, Date startDate, Date endDate,
			double tuitionFee) {
		this.classCode = classCode;
		this.className = className;
		this.profName = profName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tuitionFee = tuitionFee;
	}

	public String getClassCode() {
		return classCode;
	}

	public String getClassName() {
		return className;
	}

	public String getProfName() {
		return profName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public double getTuitionFee() {
		return tuitionFee;
	}

}
