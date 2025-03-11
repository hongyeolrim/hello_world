package com.yedam;

public class HelloExe {
	// main 메소드 => 클래스 안에 속한 함수(기능)를 메소드라고 함
	// main 메소드가 프로그램의 시작점이고 반드시 있어야 함, 내 맘대로 이름 바꿀 수 없음
    public static void main(String[] args) {
    	System.out.println("Hello, World"); //자바스크립트의 console.log랑 비슷한 기능
    	
    	String name;
    	name = "홍열림";
    	
    	System.out.println("내 이름은 " + name);
    	
    	int score = 100;  //변수 설정과 동시에 값 넣음 => 초기값 설정
    	                  //변수 타입과 넣는 값의 타입이 같아야 함
    	
    	System.out.println("점수는 " + score + "점 입니다");
    	
    }
}
