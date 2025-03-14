package com.yedam.classes;

public class GugudanMain {
	public static void main(String[] args) {
		MethodExe3 m3 = new MethodExe3();
		System.out.println(m3.gugudan(2, 5));

		m3.printStar(5, "★");
		m3.printCard();
		MethodExe4 m4 = new MethodExe4();
		m4.main();
	}
}
