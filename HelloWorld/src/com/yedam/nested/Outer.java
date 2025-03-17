package com.yedam.nested;

public class Outer {
	class Inner {
		String name;

		void innerMethod() {
			System.out.println("메소드 호출");
		}
	}

	void method1() {
		Inner inner = new Inner();
		inner.name = "홍열림";
		System.out.println(inner.name);
	}

}
