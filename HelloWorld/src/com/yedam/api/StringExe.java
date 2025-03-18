package com.yedam.api;

//Charset.defaultCharset()을 실행하면 현재 기본 인코딩을 확인할 수 있음!

//new String(매개값) 요약 정리
//📌 "문자열 객체를 생성"할 때, 아래처럼 매개값을 넣을 수 있어!
//✔ new String(String str) → 기존 문자열을 새롭게 복사
//✔ new String(char[] charArray) → 문자 배열을 문자열로 변환
//✔ new String(byte[] byteArray) → 바이트 배열을 문자열로 변환
//✔ new String(byte[] byteArray, Charset charset) → 특정 인코딩 적용 가능
//예시 ----> byte[] bstr = { 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100 };
//String msg = new String(bstr); 인코딩 디폴트값은 대부분 UTF-8

//📌 하지만! int, boolean 같은 숫자나 논리값은 new String(int)로 변환할 수 없음!

//int, boolean 등을 문자열로 변환하려면?
//int num = 123;
//boolean flag = true;

//방법1. String.valueOf(값)
//String str1 = String.valueOf(num);
//String str3 = String.valueOf(flag);

//방법2. "값" + ""을 사용하면 됨!
//String str2 = num + "";
//String str4 = flag + ""; 

//charAt()은 String 클래스 안에 있는 메서드야!
//이 메서드는 문자열에서 특정 위치(index)에 있는 **한 글자(문자, char 타입)**를 가져오는 기능을 해

//substring(start, end) : start(포함)부터 end(포함 X)까지 잘라낸 문자열 반환

public class StringExe {
	public static void main(String[] args) {

		String str = "Hello, World";
		str = new String("Hello, World");
		byte[] bAry = str.getBytes();
		for (int i = 0; i < bAry.length; i++) {
			System.out.println(bAry[i]);
		}
		byte[] bstr = { 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100 };
		String msg = new String(bstr);
		System.out.println(msg);
		char result = msg.charAt(0);
		System.out.println((int) result);
		// String: "" // char: ''
		// char(문자)는 내부적으로 숫자(유니코드 값)로 저장되기 때문에, (int) result를 하면 해당 문자의 숫자 값을 확인할 수 있음

		if (result == 'W') {
			int idx = msg.indexOf("o");
			if (idx != -1) {

			}
			// msg.indexOf("o")는 msg 문자열에서 "o"가 처음 등장하는 인덱스(위치)를 찾는 메서드야
			// "o"는 "Hello, World"에서 4번째(인덱스 4)와 8번째(인덱스 8)에 등장.
			// 하지만 indexOf("o")는 **처음 등장하는 위치(4)**를 반환.
			// idx = 4
			// 만약 "o"가 문자열에 없다면 indexOf()는 -1을 반환

			String[] names = { "홍길동", "홍길승", "김민규" };
			int cnt = 0;
			for (int i = 0; i < names.length; i++) {
				if (names[i].indexOf("길") != -1) { // indexOf("길"): names[i] 문자열에서 "길"이 처음 등장하는 위치(인덱스)를 반환
					cnt++;
				}
			}
//			"길"이 포함되어 있으면 위치(인덱스) 값(0 이상의 숫자)을 반환
//			"길"이 없으면 -1을 반환
//          "길"이 포함된 문자열은 "홍길동", "홍길승" 두 개이므로 cnt = 2가 됨
			System.out.println("\"길\"을 포함하는 이름의 갯수: " + cnt);

			System.out.println("Hello, Word".substring(3, 7)); // "Hello, Word"에서 3번 인덱스부터 7번 인덱스 "전"까지의 부분 문자열을 가져옴
																// 3부터 7 이전까지(6까지) 자름
		}

	} // end of main
}
