package com.yedam;

import com.yedam.ref.Person;

public class HelloExe {
	public static void main(String[] args) {
		// 1. 변수 선언 및 값 할당 : 32000
		int num1 = 32000;

		// 2. 34, 32, 88, 23
		int[] numbers = { 34, 32, 88, 23 };

		// 3. 문자 32
		String num2 = "32";

		// 4. 정수 변수에 저장
		int cnt = Integer.parseInt(num2);

		// 5. Hello, Nice, Good
		String[] words = { "Hello", "Nice", "Good" };

		// 6. 60~100사이 임의의 숫자(정수) 5개 저장
		int[] randomNum = { (int) (Math.random() * 41) + 60 };

		// 7. 이름, 연락처, 나이 선언
		Person person1 = new Person("홍열림", "010-1111-1111", 34);

		// 8. 이름 전화번호, 나이 3개 집어넣기
//		Person person1 = new Person("홍열림", "010-1111-1111", 34);
//		Person person2 = new Person("김삿갓", "010-2222-2222", 102);
//		Person person3 = new Person("고양이", "010-3333-3333", 2);
//		Person[] people = { person1, person2, person3 };
		Person[] people = new Person[3];
		people[0] = person1;
		people[1] = new Person("김삿갓", "010-2222-2222", 102);
		people[2] = new Person("고양이", "010-3333-3333", 2);

		// 9. 나이가 제일 많은 사람
		int page = 0;
		String pname = "";
		for (int i = 0; i < people.length; i++) {
			if (people[i].getAge() > page) {
				page = people[i].getAge();
				pname = people[i].getName();
			}
		}
		System.out.println(pname);
		
//		Person oldest = people[0];  //첫 번째 사람을 가장 나이 많은 사람으로 가정
//
//		for (int i = 1; i < people.length; i++) {  //첫 번째 사람과 나머지를 비교
//		    if (people[i].getAge() > oldest.getAge()) {
//		        oldest = people[i];  //더 나이 많은 사람이 있으면 업데이트
//		    }
//		}
//
//		System.out.println("가장 나이 많은 사람: " + oldest);
	}
}