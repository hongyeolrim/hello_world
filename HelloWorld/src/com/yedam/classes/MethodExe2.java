package com.yedam.classes;

import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	private List<Product> store;

	MethodExe2() {
		store = new ArrayList<Product>();
		store.add(new Product("A001", "지우개", 500));
		store.add(new Product("B001", "샤프", 1000));
		store.add(new Product("C001", "연필", 800));
		store.add(new Product("D001", "지우개2", 1000));
	}

	boolean add(Product prd) {
		boolean result = store.add(prd);
		return result;
	} // end of add
//메소드도 타입을 가질 수 있음..내가 만든 Product라는 라이브러리 클래스를 여기 메소드의 타입으로 지정

	boolean modify(Product prod) {
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i) != null && store.get(i).getProductCode().equals(prod.getProductCode())) {
				if (prod.getProductName() != null) {
					store.get(i).setProductName(prod.getProductName());
				}
				if (prod.getPrice() != 0) {
					store.get(i).setPrice(prod.getPrice());

				}
				System.out.println("수정 완료");
				return true;
			}
		}
		return false;// 수정 => boolean modify (Product prod)
	} // end of modify

	boolean remove(String code) {
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i).getProductCode().equals(code)) {
				store.remove(i);
				return true;
			}
		}
		return false; // 삭제 => boolean remove (String code)

	} // END OFF REMOVE

	List<Product> productList(Product prd) {
		List<Product> list = new ArrayList<>();
		int idx = 0;
		for (int i = 0; i < store.size(); i++) {
			if (prd.getProductName().equals("ALL") || store.get(i).getProductName().equals(prd.getProductName())) {
				if (store.get(i).getPrice() >= prd.getPrice()) {
					list.add(store.get(i));
				}
			}
		}
		return list;
	} // end of productList

}
