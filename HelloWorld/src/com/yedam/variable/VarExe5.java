package com.yedam.variable;
//예금, 출금, 잔고확인 기능이 있는 프로그램
//잔고 최대액수 10만원, 출금 금액이 잔고보다 크면 안 됨
import java.util.Scanner;

public class VarExe5 {
    public static void main(String[] args) {
    	boolean run = true;
    	int balance = 0; //예금액을 저장하는 변수
    	int amt = 0; //최대금액과 최소금액을 넘어서지 않도록
    	Scanner scn = new Scanner(System.in);
    	while(run) {
    		System.out.println("1.예금 2.출금 3.잔고 4.종료");
    		int menu = scn.nextInt();
    		switch(menu) {
    		case 1: 
    			System.out.print("예금액을 입력>>");
    			amt = scn.nextInt();    
    		    if(balance + amt > 100000) {
    		    	   System.out.println("10만원을 초과합니다");
    		    	} else {
    		    	balance = balance + amt; 
    		    	}
    			break; //case1 종료
    		case 2:
    			System.out.print("출금액을 입력>>");
    			amt = scn.nextInt();    
    			   if(balance < amt) {
    		    	   System.out.println("잔액을 초과하는 금액을 출금할 수 없습니다");
    		    	} else {
    		    	balance = balance - amt; 
    		    	}
    			break; //case2 종료
    		case 3:
    			System.out.println("잔고는 " + balance + "원 입니다");
    			break; //case3 종료
    		case 4: run = false;
    		}
    	}
    	 System.out.println("end of prog"); //end of main
    }  
}
 