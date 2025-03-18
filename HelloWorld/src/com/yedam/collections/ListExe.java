package com.yedam.collections;
import java.util.ArrayList;
import java.util.List;

//배열[] vs. List 차이
//배열 : 고정됨(처음에 크기 정해야 함), 고정된 크기 & 빠른 연산할 때 사용!
//리스트 : 동적 크기 (자동으로 늘어남), add, set, remove 사용 가능

public class ListExe {

	public static void main(String[] args) {
		int[] intAry = { 10, 20 };
		int[] intAry2 = new int[5];
		for (int i = 0; i < intAry.length; i++) {
			intAry2[i] = intAry[i];
		}
		intAry[2] = 30;

		List<Integer> list = new ArrayList<Integer>();
		// List 인터페이스를 사용해서 ArrayList를 만들었음
		// Integer 타입 요소만 저장 가능
		// 오른쪽에도 Integer를 명시했지만, Java 7 이상에서는 생략 가능
		// List = "어떤 리스트든 만들어서 사용할 수 있는 틀"
		// ArrayList, LinkedList = "실제 사용하는 리스트 종류"

		list.add(10);
		list.add(14);
		list.add(17);
		list.add(20); // 추가

		Integer it1 = list.get(0); // 조회

		list.remove(0); // 삭제

		list.set(0, 30); // 수정, 값1 = 인덱스 / 값2 = 변경값

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

//컬렉션 프레임워크의 기본 구조
//컬렉션 프레임워크에는 크게 3가지가 있어:

//(1) List - 순서가 있는 데이터 모음
//👉 줄 세운 것처럼 차곡차곡 저장하는 곳

//✅ 특징:
//중복 데이터 O (똑같은 값 여러 개 가능)
//저장된 순서 유지 O

//List는 제일 큰 범위(인터페이스) → 다양한 리스트들이 있음!
//ArrayList와 LinkedList는 List의 자식 클래스(구현체)
//각각 특징이 다르기 때문에 필요에 따라 변경 가능! 🚀

//ArrayList → 배열을 사용해서 데이터를 저장!
//내부 구조 : 
//index:   0     1     2
//         A     B     C

//LinkedList → 
//✔ LinkedList 안에 있는 값들은 모두 객체야!
//✔ LinkedList는 데이터를 "노드(Node)" 라는 객체에 저장해!
//✔ 이 노드들은 서로 연결(Linked) 되어 있음!
//내부 구조 : [A] → [B] → [C]

//✔ 처음엔 ArrayList로 시작 → 필요하면 LinkedList로 변경 가능! 🚀

//ArrayList vs. LinkedList 차이
//ArrayList : 내부에서 배열 사용, 조회(검색)할 일이 많을 때!
//LinkedList : 내부에서 노드(객체) 연결, 자주 추가/삭제할 때!

//<List 쓰는 여러가지 형식>

//✅ List<String> list = new ArrayList<>(); → 가장 안전함! 🚀
//앞쪽 제네릭엔 반!드!시! 타입 적어야함
//뒤쪽 제네릭엔 타입 추론이 있으니까 타입 생략 가능!
//뒤쪽에 타입은 생략하더라도 어떤 List를 쓸지는 써야 함

//List<?> list = new ArrayList<타입>();
//List<?> 는 이미 만들어져서 데이터가 담겨있는 리스트를 가져와서 읽기만 할 때 주로 씀
//즉, 다른 곳에서 이미 데이터를 넣어놨고, 지금 이 시점에선 읽기만 하겠다는 의미

