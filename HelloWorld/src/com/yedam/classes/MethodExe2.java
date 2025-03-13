package com.yedam.classes;

public class MethodExe2 {
	Product[] store;

	MethodExe2() {
		store = new Product[10];
		store[0] = new Product("A001", "지우개", 500);
		store[1] = new Product("B001", "샤프", 1000);
		store[2] = new Product("C001", "연필", 800);
		store[3] = new Product("D001", "지우개", 1000);
	}

	boolean add(Product prd) {
		for (int i = 0; i < store.length; i++) {
			if (store[i] == null) {
				store[i] = prd;
				return true;
			}
		}
		return false;
	} // end of add
//메소드도 타입을 가질 수 있음..내가 만든 Product라는 라이브러리 클래스를 여기 메소드의 타입으로 지정

	Product[] productList(Product prd) {
		Product[] list = new Product[10];
		int idx = 0;
		for (int i = 0; i < store.length; i++) {
			if (store[i] != null) {
				if (prd.getProductName().equals("ALL") || store[i].getProductName().equals(prd.getProductName())) {
					if (store[i].getPrice() >= prd.getPrice()) {
						list[idx++] = store[i];
					}
				}
			}
		}
		return list;
	} // end of productList

	boolean remove(String code) {
		for (int i = 0; i < store.length; i++) {
			if (store[i] != null) {
				if (store[i].getProductCode().equals(code)) {
					store[i] = null;
					return true;
				}
			}
		}
		return false; // 삭제 => boolean remove (String code)
	} // END OFF REMOVE

	boolean modify(Product prod) {
		for (int i = 0; i < store.length; i++) {
			if (store[i] != null && store[i].getProductCode().equals(prod.getProductCode())) {
				if (prod.getProductName() != null) {
					store[i].setProductName(prod.getProductName());
				}
				if (prod.getPrice() != 0) {
					store[i].setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;// 수정 => boolean modify (Product prod)
	} // end of modify
}
