package com.yedam.classes;

public class MethodExe5 {
	public static void main(String[] args) {
		int num1 = 10;
		num1 = 20;
		final int num2 = 20;
		// num2 = 30; 변경불가

		final Product p1 = new Product();
		p1.setProductCode("A001");
		p1.setProductCode("B001");
		
//		p1 = new Product();
	}
}
