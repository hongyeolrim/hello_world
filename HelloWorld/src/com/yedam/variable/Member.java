package com.yedam.variable;

// public <-> private
// 클래스 이름 앞에 public이 붙으면 다른 클래스에게도 이 클래스에 대한 접근을 허용한다는 것
public class Member {
	// 클래스 : 필드 (값을 저장)
	private String name;
	private int score;

	// 클래스 : 생성자(실체를 생성)
	// 개발자가 생성자 지정을 안 하면 자바 컴파일러가 기본 생성자를 생성함
	// ()는 생성하겠다는 의미(생성자를 불러오겠다는 의미)
	public Member() {
		// 얘는 기본 생성자
	}

	// 생성자 overloading / 생성자는 여러개 만들 수 있음
	// 생성자는 반환할지 안 할지 안 써도 됨
	// 생성자를 정의하면 기본 생성자는 사라짐 그래서 기본생성자를 다른 곳에서 쓰면 에러남, 이럴 땐 기본 생성자도 미리 같이 만들어줘야 함
	public Member(String name, int score) {
		this.name = name;
		this.score = score;
	}

	// Set 컬렉션의 중복된 값으로 지정
	// name, score => hashCode + equals => 동일한 값
	@Override
	public int hashCode() {
		return score;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member target = (Member) obj;
			return this.name.equals(target.name);
		}
		return false;
	}

	// 클래스 : 메소드(기능) = 반환값, 메소드명, 매개값이 있어야 함
	// 반환하지 않더라도 값은 적어줘야 함
//  void - 반환안함
//  showInfo - 메소드명
//  () - 매개값
	public void showInfo() {
		System.out.println("이름은 " + name + ", 점수는 " + score); // 필드에 있는 값을 출력하는 showInfo라는 메소드(함수)를 만든 거임
	}

	public void setMember(String name, int score) {
		this.name = name; // name이라는 필드의 값을 채워주겠습니다, 매개값인지 필드인지 안 헷갈리게 필드에는 this를 붙여줌
		this.score = score;
	}
	// 만들어진 메소드는 이 클래스를 가진 애들만 쓸 수 있음, 아무나 쓸 수 있는 게 아님

	// 만약에 private으로 된 필드값을 사용하고 싶으면 해당 필드의 값을 반환하는 메소드를 만들어줘야 함
	public String getName() {
		return name;
	}

	// score라고 하는 필드의 값을 반환
	public int getScore() {
		return score;
	}

	// score 필드의 값을 지정
	// 매개값을 받아와서 넣어준 거
	public void setScore(int score) {
		if (score < 0 || score > 100) {
			System.out.println("적정값을 입력하세요" + "");
			return;
		}
		this.score = score;
	} // 메소드를 통해 입력되는 값을 제어하도록 하기 위해 private을 쓰는 거임

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 점수: " + score;
	}
}
