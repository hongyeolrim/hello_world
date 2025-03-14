package com.yedam.classes;

import java.util.Scanner;

public class MethodMain {
	public static void main(String[] args) {
		officeApp();
	}

	static void officeApp() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		MethodExe2 m2 = new MethodExe2();

		while (run) {
			System.out.println("1.상품 등록  2.상품 수정  3삭제  4. 목록  5.종료");
			System.out.print("메뉴 선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("등록할 상품코드를 입력하세요>> ");
				String code = scn.nextLine();
				System.out.println("등록할 상품명을 입력하세요>> ");
				String name = scn.nextLine();
				System.out.println("등록할 상품가격을 입력하세요>> ");
				int price = Integer.parseInt(scn.nextLine());
				m2.add(new Product(code, name, price));
				break;
			case 2:
				System.out.println("수정할 상품코드를 입력하세요>> ");
				code = scn.nextLine();
				System.out.println("수정할 상품명을 입력하세요>> ");
				name = scn.nextLine();
				System.out.println("수정할 상품가격을 입력하세요>> ");
				price = Integer.parseInt(scn.nextLine());
				m2.modify(new Product(code, name, price));
				break;
			case 3:
				System.out.println("삭제할 상품의 코드를 입력하세요>> ");
				code = scn.nextLine();
				m2.remove(code);
				break;
			case 4:
				System.out.println("어떤 상품의 목록을 출력하시겠습니까?");
				name = scn.nextLine();
				Product search = new Product();
				search.setProductName(name);
				Product[] list = m2.productList(search);
				for (int i = 0; i < list.length; i++) {
					if (list[i] != null) {
						System.out.println(list[i].showList());
					}
				}
				break;
			case 5:
				run = false;
			}

		}
		System.out.println("end of prog.");
		scn.close();
	}
}

//	void method1234() {
//		MethodExe2 m2 = new MethodExe2();
//
//		Product prod = new Product("A001", "지우개", 0);
//
//		if (m2.modify(prod)) {
//			System.out.println("수정 완료");
//		}
//
//		if (m2.remove("C001")) {
//			System.out.println("삭제 완료");
//		}
//
//		if (m2.add(new Product("A001", "만년필", 100))) {
//			System.out.println("등록 완료");
//		}
//
//		Product search = new Product();
//		search.setProductName("ALL");
//		search.setPrice(700);
//
//		Product[] list = m2.productList(search);
//		for (int i = 0; i < list.length; i++) {
//			if (list[i] != null) {
//				System.out.println(list[i].showList());
//			}
//		}
//	}
//}

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