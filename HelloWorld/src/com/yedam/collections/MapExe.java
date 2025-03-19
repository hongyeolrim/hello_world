package com.yedam.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.bookApp.Book;

//맵이 뭐야? 맵(Map)은 **"키(key) - 값(value) 쌍"**으로 데이터를 저장하는 특별한 구조야
//키는 중복될 수 없어 (예: 학번, 도서 코드, 사원 번호 등)
//값은 중복될 수 있어 (예: 같은 이름을 가진 학생, 같은 저자가 쓴 책, 같은 직무 등)
//키를 이용해서 빠르게 값을 찾을 수 있어!

//맵 종류
//Map<String, Integer> hashMap = new HashMap<>(); // 순서 없음 (빠름)
//Map<String, Integer> linkedHashMap = new LinkedHashMap<>(); // 입력한 순서 유지
//Map<String, Integer> treeMap = new TreeMap<>(); // 키 기준으로 자동 정렬

//map.entrySet()
//맵에 저장된 모든 "키-값 쌍"을 하나씩 꺼내오는 기능
//Set<Entry<키, 값>> 변수명 = 맵변수명.entrySet();   ===> Entry는 한 쌍의 항목(키-값 쌍)

public class MapExe {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>(); // 이 코드에서 키는 정수, 값은 문자열
		map.put(100, "홍길동"); // 맵변수명.put(키, 값) =====> 맵에 데이터 넣기
		map.put(101, "김민수");
		map.put(102, "김혁수");
		Set<Entry<Integer, String>> eset = map.entrySet();
		for (Entry<Integer, String> entry : eset) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}

		Map<String, Book> books = new HashMap<String, Book>();
		books.put("B001", new Book("이것이 자바다", "신용권", "한빛출", 20000));
		books.put("B002", new Book("자바스크립트", "김자바", "한빛출", 25000));
		books.put("B003", new Book("HTML,CSS", "김자바", "한빛출", 28000));

		// 검색
		Book result = books.get("B001");

		// 키 set 반환
		Set<String> keyset = books.keySet();
		for (String key : keyset) {
			System.out.println("key: " + key + ", val: " + books.get(key).showList());
		}

		// 키:값 (Entry) 반환
		Set<Entry<String, Book>> entryset = books.entrySet();
		for (Entry<String, Book> entry : entryset) {
			System.out.println("key: " + entry.getKey() + ", val: " + entry.getValue().showList());
		}

		// {키: 값}
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); // 자바객체 -> 문자열
		String json = gson.toJson(books);
		System.out.println(json); // 객체 출력

		System.out.println("등록된 값은: " + map.get(100)); // 맵변수명.get(키)를 통해서 등록된 값 가져오기
		System.out.println(map.containsKey(100)); // 맵변수명.containsKey(키) - 키가 있는지 확인!

		map.remove(100); // 맵변수명.remove(키) - 키에 해당하는 값 삭제!
	}
}
