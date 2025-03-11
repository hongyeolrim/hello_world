package com.yedam.variable;

import java.util.Scanner;

//추가, 수정, 삭제, 목록 출력
public class VarExe7 {
    public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
    	boolean run = true;
    	
    	//Member 값을 저장
    	Member[] storage = new Member[100];
    	storage[0] = new Member("하지원", 80);
    	storage[1] = new Member("감자", 39);
    	storage[2] = new Member("곰돌이", 100);
    	while(run) {
    		System.out.println("1.등록 2.수정 3.삭제 4.목록 출력 5.평균 6.종료");
    		System.out.print("선택>> ");
    		int menu = Integer.parseInt(scn.nextLine()); //엔터키 처리하기 위해서 이렇게 함
    		
    		switch(menu) {
    		case 1: 
    			System.out.println("이름을 입력하세요>> ");
    			String name = scn.nextLine();
    			System.out.println("점수를 입력하세요>> ");
    			int score = Integer.parseInt(scn.nextLine());
    			System.out.println("등록 완료");
    			Member mem = new Member();  //인스턴스 생성
    			mem.setMember(name, score);
    			for(int i = 0; i < storage.length; i++) {
    				if(storage[i] == null) {
    					storage[i] = mem;
    					break; //for반복문 종료
    				}
    			}
    			break; //case1 종료
    		case 2: 
    			System.out.println("이름을 입력하세요>> ");
    			name = scn.nextLine();
    			boolean isExist = false; //존재 여부를 체크
    			for(int i = 0; i < storage.length; i++) {
    				if(storage[i] != null && storage[i].getName().equals(name)) {
    					System.out.println("점수를 입력하세요>> ");
    					int reScore = Integer.parseInt(scn.nextLine());
        				storage[i].setScore(reScore);
        				System.out.println("수정 완료");
        				isExist = true; //체크 확인
        				break;
        			}   
        		}
    			if (!isExist) {
    				System.out.println("찾는 이름이 존재하지 않습니다!");
    			}
    			break;   
    		
    		case 3:
    			System.out.println("이름을 입력하세요>> ");
    			name = scn.nextLine();
    			isExist = false;
    			for(int i = 0; i < storage.length; i++) {
    				if(storage[i] != null && storage[i].getName().equals(name)) {
        				storage[i] = null;
        				System.out.println("삭제 완료");
        				isExist = true;
        				break;
        			}   
        		}
    			if (!isExist) {
    				System.out.println("찾는 이름이 존재하지 않습니다!");
    			}
    			
    			break;         //break 위치는 어디에 있어야 하고, 왜 2번 넣는지?
    		case 4: 
    			for(int i = 0; i < storage.length; i++) {
    				if(storage[i] != null) {
    					System.out.println(storage[i].getName() + " " + storage[i].getScore() + "점");
    				}
    			}
    			break;
    		case 5: 
    			int sum = 0, count = 0;
    			for(int i = 0; i < storage.length; i++) {
    			 if(storage[i] != null) {
    				 count++;
    				 sum += storage[i].getScore();
    			 }
    			}
    			double avg = (double) sum / count;
    			System.out.println("평균 점수는 " + avg + "점 입니다!");  
    			break;
    		case 6:
    			run = false;  			
    		}
    		
    	}
    	
    	System.out.println("end dof prog");
    } //end of main
}
