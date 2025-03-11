package com.yedam.variable;
import java.util.Scanner;
public class VarExe4 {
    public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
    	int[] scores = new int[3]; //값을 다 넣지 않고 배열의 크기만 정함 => {0, 0, 0}
    	                           //int 타입은 초기값이 0

   	    int sum = 0;
   	    double avg = 0.0;
        for(int i = 0; i < scores.length; i++) {
        	System.out.println("점수를 입력하세요>"); //점수를 입력하세요
        	scores[i] = scn.nextInt(); //값 입력
     	    sum = sum + scores[i];            
     }
     avg = (double)sum / scores.length;
     System.out.println("합은 " + sum + "입니다"); //입력한 값의 합을 출력, "합은 n입니다"
     System.out.println("평균은 " + avg + "입니다");
    }
}
