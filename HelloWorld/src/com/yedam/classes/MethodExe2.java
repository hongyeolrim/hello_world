package com.yedam.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	private List<Product> store;

	MethodExe2() {
		init();
	}

	void init() {
		store = new ArrayList<Product>();
		File file = new File("c:/temp/object.dat");

		if (!file.exists()) {
			save(); // 빈 리스트를 저장해서 파일 생성
		}

		try (FileInputStream fis = new FileInputStream("c:/temp/object.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			store = (List<Product>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			Scanner scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
//			while (true) {
//				String msg = scn.nextLine();
//				String[] msgAry = msg.split(" ");
//				store.add(new Product(msgAry[0], msgAry[1], Integer.parseInt(msgAry[2])));
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchElementException e) {
//
//		}
	}

	void save() {
		try (FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(store);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	boolean add(Product prd) {
		boolean result = store.add(prd);
		System.out.println("상품 등록 성공!");
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
