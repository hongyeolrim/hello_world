package com.yedam.ref;

import com.yedam.variable.Member;

public class ArrayExe2 {
	public static void main(String[] args) {
//		String[] strAry = {"Hello", "World", "20", "23.4"};
//		//확장 for문
//		for (String str : strAry) {
//			System.out.println(str);
//		}
//		//크기 지정
//		strAry = new String[10]; //이건 초기값이 0이 아니라 null임
//		strAry[0] = new String("Nice");
//		for (String str : strAry) {
//			System.out.println(str);
//	   }
		//Member 클래스 import
		Member[] memAry = new Member[10]; //컨트롤 + 클래스명 클릭 = 빠른 이동
		memAry[0] = new Member();
		memAry[0].setMember("홍열림", 100);
		memAry[0].setScore(90);
		memAry[0].showInfo();
//		
		memAry[1] = new Member();
		memAry[1].setMember("계란말이", 90);
		memAry[1].setScore(70);
		memAry[1].showInfo();

		memAry[2] = new Member("청국장", 99);
		memAry[2].showInfo();
		for(int i = 0; i < memAry.length; i++) {
			if(memAry[i] != null) {
//			memAry[i].showInfo(); 
			}
	}
		}
}
