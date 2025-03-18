package com.yedam.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSetExe {
	public static void main(String[] args) {

		Integer[] iAry = { 10, 20, 30 };
		for (int i = 0; i < iAry.length; i++) {
			System.out.println(iAry[i]);
		}

		List<Integer> ilist = new ArrayList<>();
		ilist.add(10);
		ilist.add(20);
		ilist.add(30);

		for (int i = 0; i < ilist.size(); i++) {
			System.out.println(ilist.get(i));
		}

		// 리스트 생성과 동시에 값 추가 (Arrays.asList)
		List<Integer> ilist2 = new ArrayList<>(Arrays.asList(10, 20, 30));

		// 한 번에 여러값 추가 (addAll)
		List<Integer> ilist3 = new ArrayList<>();
		ilist3.addAll(Arrays.asList(10, 20, 30));

	}

}
