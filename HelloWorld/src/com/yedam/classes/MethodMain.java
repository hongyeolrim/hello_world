package com.yedam.classes;

public class MethodMain {
	public static void main(String[] args) {

		MethodExe2 m2 = new MethodExe2();
		// 상품코드, 상품명, 가격 modify ....

		Product prod = new Product("A001", "지우개", 0);

		if (m2.modify(prod)) {
			System.out.println("수정 완료");
		}

		if (m2.remove("C001")) {
			System.out.println("삭제 완료");
		}

		if (m2.add(new Product("A001", "만년필", 100))) {
			System.out.println("등록 완료");
		}

		Product search = new Product();
		search.setProductName("ALL");
		search.setPrice(700);
		
		Product[] list = m2.productList(search);
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				System.out.println(list[i].showList());
			}
		}

	}
}

//		MethodExe1 m1 = new MethodExe1(); // 힙영역에 객체를 만들고 객체의 주소값을 변수에 반환
//		System.out.println(m1);
//		int n = 5;
//		m1.printString(n, "★");
//
//		double result = m1.sum(n, 10);
//		System.out.println(result);
//		
//		int sumAry = m1.sum(new int[] {10, 20, 30});
//		
//		result = m1.sum(new double[] {10.1, 20.2, 30.3});
//		System.out.println(sumAry);