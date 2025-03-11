package com.yedam.variable;

import java.util.Scanner;

// 사용자의 입력값을 읽어들이는 방식
// 스캐너라는 클래스가 처리함 (우리가 만드는 클래스가 아니라 이미 라이브러리에 있는 클래스)
public class VarExe3 {
    public static void main(String[] args) {
    	 Scanner scn = new Scanner(System.in);       
    	 //자바 유틸 패키지에 있는 스캐너, 클래스는 원래 풀네임을 써줘야 함
    	 //근데 import 해와서 넣을 수도 있음
    	 //스캐너는 ()안에 바로 값을 넣어줘야 함
    	 //System.in은 기본 입력 장치 = 키보드
    	 
    	 System.out.print("이름을 입력하세요>");  //System.out은 기본 출력 장치 = 모니터
    	 String name = scn.nextLine(); //스캐너가 가지고 있는 메소드(함수)
    	 
    	 System.out.print("점수를 입력하세요>");
    	 int score = scn.nextInt();
    	 
    	 System.out.print("키를 입력하세요>");
    	 double height = scn.nextDouble();
    	 
    	 System.out.print("입력한 값: " + name + ", 점수: " + score + ", 키: " + height);
    }
}
