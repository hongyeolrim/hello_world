package com.yedam.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListExe {
	public static void main(String[] args) {
// 배열 : int[], String[], Member[] => intAry[n]
// 컬렉션 : List<Integer>, List<String>, List<Member> => intList.get(n), intList.add(n)
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(100);
		intList.add(150);
		intList.add(200);
		intList.add(100);

		for (int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		// Set컬렉션 - 저장 순서 유지 안 됨, 중복된 값 저장할 수 없음
		Set<Integer> intSet = new HashSet<Integer>();
		intSet.add(100);
		intSet.add(150);
		intSet.add(200);
		intSet.add(100);
		System.out.println("----------------");
		for (Integer numbers : intSet) {
			System.out.println(numbers);
		}
		// Set<Member>
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("이순신", 22));
		members.add(new Member("궁예", 25));
		members.add(new Member("홍길동", 20));
		System.out.println("================"); // hashcode, equals 전부 같아야 동등객체
		for (Member mbrs : members) {
			System.out.println(mbrs.toString());
		}
	}
}
