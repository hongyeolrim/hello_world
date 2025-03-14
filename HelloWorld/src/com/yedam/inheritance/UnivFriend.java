package com.yedam.inheritance;

/*
 * Friend 클래스를 상속받는 클래스
 */
public class UnivFriend extends Friend {
	private String univName;
	private String major;

	public UnivFriend() {
		super();
	}

	public UnivFriend(String name, String tel, String univName, String major) {
		super(name, tel);
		this.univName = univName;
		this.major = major;
	}

	// 부모의 메소드를 자식이 재정의 = overriding
//	@Override
//    public void setNmae(String name) {
//    	부모 final 메소드는 overriding 안 됨
//    }
	@Override
	public String toString() {
		return super.toString() + ", 학교는 " + univName + ", 학과는 " + major;
	}

	@Override
	public String getName() {
		return super.getName();
	}

	public String getUnivName() {
		return univName;
	}

	public String getMajor() {
		return major;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
