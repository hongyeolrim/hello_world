package com.yedam.ref;
//클래스 이름은 무조건 대문자로 시작
//변수는 소문자로 시작
public class ArrayExe1 {
    public static void main(String[] args) {
    	int[] intArray = {10, 20, 30};
//    	int[] intArray2 = new int[100];
    	
    	for (int i = 0; i < intArray.length; i++) {
    		System.out.println(intArray[i]);
    	}
//    	intArray = new int[] {40, 50, 60}; //값을 새로 할당
    	intArray = new int[10]; //int 타입으로 만들 객체 개수 지정
//    	intArray[9] = 90; //해당 인덱스 값 변경
    	//최대 인덱스 번호를 벗어나는 위치에 값을 넣으려고 하면 예외(오류)가 발생함
    	intArray[0] = (int)(Math.random() * 100) + 1;
    	for (int i = 0; i < intArray.length; i++) {
    		if(intArray[i] == 0) {
    			intArray[i] = (int)(Math.random() * 100) + 1;
    		}
    	}
    	
    	//홀수값의 합 구하기
    	//"훌수값의 합은 n입니다"   -이거 집에서 해보기
    	
    	
    	
    	for (int i = 0; i < intArray.length; i++) {
    		System.out.println(intArray[i]);
    	}
    } // end of main
} //end of class ArrayExe1
