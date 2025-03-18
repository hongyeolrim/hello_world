package com.yedam.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yedam.variable.Member;

//<<Set의 특징>>
//중복된 요소를 허용하지 않음 (add() 시 중복이면 무시됨)
//저장된 순서를 보장하지 않음 (출력 순서가 다를 수 있음)
//null을 하나만 저장할 수 있음
//List와 다르게 get(index)로 요소에 접근할 수 없음

//Set의 주요 구현 클래스
//Set은 인터페이스라서 바로 사용할 수 없고, 이를 구현한 클래스를 사용해야 함

//HashSet → 가장 많이 사용됨, 순서 보장 안됨, 빠름
//LinkedHashSet → 입력한 순서를 유지
//TreeSet → 정렬된 상태로 저장 (오름차순 정렬)

//📌 배열 vs. Set의 내부 구조
//배열은 값을 넣으면,
//[1, 2, 3, 4] 이렇게 한 줄로 쭉 줄 세워서 넣어요.
//그래서 순서가 중요하고 중복된 값도 넣을 수 있어요.
//내부 구조는 메모리에 연속적으로 값이 나열된 형태예요.
//**Set(특히 HashSet)**은 값을 넣으면,

//해시(Hash) 라는 규칙으로 값을 내부적으로 계산해서 저장해요.
//예를 들어 숫자 10을 넣으면, 그 숫자에서 특별한 해시값을 얻고,
//이 값을 내부에서 인덱스로 삼아서 저장 위치를 정합니다.
//같은 값이 또 들어오면 똑같은 해시값이 나오니까, 중복 저장을 막는 거예요.
//즉, Set의 내부는
//해시(Hash)를 이용한 특별한 공간으로 값을 저장한다고 보면 됩니다.

//[내부 공간 (버킷 Bucket)]
//	     ┌───────┐
//	     │       │
//	  0  │  20   │ → 값 20 (해시로 얻은 위치)
//	     │       │
//	     ├───────┤
//	     │       │
//	  1  │  10   │ → 값 10
//	     │       │
//	     ├───────┤
//	     │       │
//	  2  │  30   │ → 값 30
//	     │       │
//	     ├───────┤
//	     │       │
//	  3  │ (빈칸) │
//	     │       │
//	     └───────┘
//여기서 같은 값 10을 또 넣으려고 하면 이미 같은 위치에 값이 있으니 추가하지 않아요.
//이게 바로 Set이 중복을 허용하지 않는 이유입니다.

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>(); // Set<String> 타입의 변수를 만들고, HashSet<String> 객체를 넣음
		set.add("Hello");
		set.add("World");
//		set.add(100);  // 에러 발생! (타입 불일치)
		set.add("Hello"); // 중복된 값

		Iterator<String> iter = set.iterator(); // set에 Iterator 얻기
		while (iter.hasNext()) {
			String result = iter.next();
			System.out.println(result);
		}

		// Set<Member>
		Set<Member> members = new HashSet<>();
		members.add(new Member("홍열림", 100));
		members.add(new Member("고사리", 80));
		members.add(new Member("홍열림", 100));

		Iterator<Member> miter = members.iterator();

		while (miter.hasNext()) {
			Member result = miter.next();
			System.out.println(result.toString());
		}

		// int => Integer
		// int 배열에서 중복된 값을 제거한 후에 결과를 List에 추가
		// List 반복문 활용
		int[] intAry = { 10, 20, 30, 40, 20, 10 };

		// 1. 중복 제거를 위해 Set을 만듦
		Set<Integer> iset = new HashSet<>();

		// 2. 확장 for문으로 intAry에 있는 숫자를 하나씩 꺼내서 num에 넣고 그 num을 또 하나씩 iset에 넣음, 중복은 자동 제거!
		for (int num : intAry) {
			iset.add(num);
		}

		// 3. 중복이 제거된 iset을 List로 변환
		List<Integer> ilist = new ArrayList<>(iset); // Set을 List로 감싸면 리스트가 됨

		// 확장 for문으로 리스트 출력
		System.out.println("=== 확장 for문으로 ilist 출력 ===");
		for (int num : ilist) {
			System.out.print(num + " "); // 한 줄에 출력
		}
		System.out.println("\n"); // 줄 바꿈

		// 다른 방법1 ----- Set 바로 출력 (확장 for문으로 출력하면 굳이 List로 변환할 필요없어서 그냥 Set을 바로 출력함
		System.out.println("=== set 바로 출력 ===");
		for (int num : iset) {
			System.out.print(num + " ");
		}
		System.out.println("\n");

		// 다른 방법2 ----- Iterator 반복자로 출력
		System.out.println("=== Iterator 반복자로 출력 ===");
		Iterator<Integer> iterator = iset.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println("\n");

		// 다른 방법3 ----- forEach로 출력
		System.out.println("=== forEach로 출력 ===");
		ilist.forEach(num -> System.out.print(num + " "));
		System.out.println();
	}
}

//<Iterator 인터페이스> => 반복자
//it.hasNext() → 다음 데이터가 있는지 물어보는 메서드(있으면 true, 없으면 false)
//it.next() → 다음 데이터를 하나 꺼내는 메서드
//컬렉션(List, Set, 등)은 Iterator를 제공해 주기 때문에 따로 구현하지 않고 사용할 수 있음

//✅ 쉽게 비유하면?
//📦 Iterator는 택배 기사님이야!

//set.iterator() 하면 Set이 택배 기사님(Iterator 객체)을 불러와!
//hasNext()는 "남은 택배 있어요?" 라고 물어보는 거야.
//next()는 "다음 택배 주세요!" 하고 받는 거야.
//즉, 우리가 Iterator를 직접 만들지 않아도
//Set, List 같은 애들이 알아서 기사님(Iterator)을 준비해 줘!

//public class Main {
//    public static void main(String[] args) {
//        Set<String> fruits = new HashSet<>();
//        fruits.add("Apple");
//        fruits.add("Banana");
//        fruits.add("Cherry");
//
//        Iterator<String> it = fruits.iterator(); // Iterator 생성
//
//        while (it.hasNext()) {  // 요소가 남아 있는 동안 반복
//            String fruit = it.next();  // 다음 요소 가져오기
//            System.out.println(fruit); // 출력
//        }
//    }
//}

//✅ 인터페이스 → 클래스 → 객체 실행 흐름 정리
//✔ **인터페이스(Interface)**는 클래스를 통해서만 실행 가능
//✔ **클래스(Class)**는 객체를 통해서 실행 가능
//✔ **객체(Object)**가 실제로 동작하는 존재
//즉, 인터페이스 → 클래스 → 객체 순서로 실행됨

//✅ 인터페이스, 클래스, 객체 차이 정리
//인터페이스(Interface)

//메서드의 이름과 규칙만 정해둔 것.
//구현이 없고, 명령서 같은 존재.
//예: Iterator 인터페이스는 hasNext(), next() 같은 메서드가 있어야 한다고 정해둠.
//클래스(Class)

//인터페이스에서 정한 메서드를 진짜로 구현한 것.
//실행 가능한 코드가 들어감.
//예: HashSet 내부에 Iterator를 구현한 메서드를 가지고 있음.
//객체(Object)

//클래스를 기반으로 실제로 메모리에 만들어진 것.
//동작하는 상태.
//예: Iterator<String> it = set.iterator(); 하면, HashSet이 Iterator 객체를 만들어서 반환함.

//✅ 반복자(Iterator)와 / 확장 for문(for-each) 차이점
//Iterator	                                                                              확장 for문 (for-each)
//코드 길이	길고 복잡함                                                                         	코드 길이 짧고 간단함
//remove()로 요소 삭제 가능	                                                                      요소 삭제 불가능
//안전하게 요소 삭제 가능	                                                          수정 시 ConcurrentModificationException 발생 가능
//사용 대상은	List, Set, Map 등 모든 컬렉션	                                           List, Set에서 사용 가능 (Map에 직접 사용 불가)
//hasNext(), next()로 요소를 하나씩 직접 가져옴	                                              자동으로 순회, 내부 동작을 제어할 수 없음