package com.yedam.inheritance;

/*
 * 친구1: 이름, 연락처
 */

// 출생의 비밀이 숨겨져 있습니다! Friend 클래스는 사실 모든 클래스의 조상급인 Object 클래스의 자식이었던 겁니다
public class Friend extends Object {
	// 필드
	private String name;
	private String tel;

	// 생성자
	public Friend() {
	}

	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "이름은 " + getName() + ", 연락처는 " + getTel();
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
