package com.yedam.variable;

import java.util.Scanner;

//클래스 안에 메소드 여러개 넣을 수 있음
public class VarExe6 {
//	public static void tset() {
//    	Math.random(); 
    	//임의의 정수 1~50 
    	//Math라는 클래스에 있는 random이라는 함수
        // 0 <= x < 1 (0과 같거나 크고, 1보다는 작음)
    	
//    	for (int i = 1; i <= 5; i++) {
//    		System.out.println((int)(Math.random() * 50) + 1); } //(int)Math.random()하면 정수로 바꿔줌..
    		                                                     //곱하기 해서 원하는 소수로 바꾼 후에 정수로 변환
    		                                                     
    	
//        int[] scores = new int[5]; //정수(int) -> 5개 저장
//        for (int i = 0; i < scores.length; i++) {
//         scores[i] = (int)(Math.random() * 71) + 30;  //학생의 점수를 30~100 사이의 점수로 반환
//         System.out.println(scores[i]);
//         }
        
//        for (int i = 0; i < scores.length; i++) {
//        if (scores[i] % 2 == 1) {
//       	 System.out.println(scores[i]);
//        }
//        }
        
//        for (int i = 0; i < scores.length; i++) {
//            if (scores[i] == 100) {
//           	 System.out.println(i + "번째 값: " + scores[i]); 
//           	 }
//	}
//	}    
    public static void main(String[] args) { //args는 변수, String[]은 타입        
    	
     Scanner scn = new Scanner(System.in);  //컨트롤 + 시프트 + 영어 o = import단축키
     Member m1 = new Member();  //인스턴스 생성
     m1.setName("홍열림");
     Member m2 = new Member();
     m2.setName("최민수");
     Member m3 = new Member();
     m3.setName("다진마늘");
     Member m4 = new Member();
     m4.setName("고양이");
     
     //배열
     Member[] members = {m1, m2, m3, m4};
     
     for(int i = 0; i < members.length; i++) {
    	 members[i].setScore((int)(Math.random() * 31) + 70);    //여기에 = 쓰는 거랑 +=쓰는 거랑 똑같나?
    	 System.out.println("이름: " + members[i].getName() + ", 점수: " + members[i].getScore());
     }
     
     //조회하고 싶은 사람의 입력을 하면 점수출력
     System.out.println("조회할 이름 입력>> ");
     String search = scn.nextLine();
     for(int i = 0; i < members.length; i++) {
    	 if(members[i].getName().equals(search)) {
    		 System.out.print(members[i].getName() + "의 점수는 " + members[i].getScore() + "점");
    	 }
     }
     
     
     
     //점수가 가장 높은 사람의 이름
//     int best = members[0].score;
//     String name = members[0].name;
//     for(int i = 0; i < members.length; i++) {
//    	 if(best < members[i].score) {
//    		 best = members[i].score;
//    		 name = members[i].name;
//    	 }
//     }
//     System.out.println("최고 점수는 " + best + "점을 받은 " + name);
    }
}
