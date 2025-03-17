package com.yedam.api;

class Member {
	String name;
	int age;

	Member() {
	}

	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return age;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member target = (Member) obj;
			return this.name.equals(target.name) && this.age == target.age;
		}
		return false;
	}
}

public class ObjectExe1 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		// 비교
		System.out.println(obj1 == obj2);
		// 논리적 비교
		System.out.println(obj1.equals(obj2));

		Member m1 = new Member();
		Member m2 = new Member();

		m1.name = "홍열림";
		m1.age = 20;

		m2.name = "홍열림";
		m2.age = 20;
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2)); // Member 클래스는 Object 클래스를 상속받으 자식 클래스라서~ equals도 쓸 수 있는 거임
	}
}
