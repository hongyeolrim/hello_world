package com.yedam.ref;
//2025년 기준으로 월 정보 => 1일의 위치를 반환
public class ArrayExe3Calendar {
public static final String blue = "\u001B[34m" ;
public static final String red  = "\u001B[31m" ;
public static int getFirstDay(int month) {
	switch(month) {
	case 1:
		return 3;
	case 2:
		return 6;
	case 3:
		return 6;
	case 4:
		return 2;
	default:
		return 1;
	}
}
//2025년 기준으로 월의 마지막날 반환
public static int getLastDate(int month) {
	switch(month) {
	case 1:
		return 31;
	case 2:
		return 28;
	case 3:
		return 31;
	case 4:
		return 30;
	default:
		return 31;
	}
}
//1 ~ 31 출력 (print or println)
//Integer.paseInt()는 문자열을 정수 타입으로 바꿔주는 메소드
	public static void main(String[] args) {
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		for(String day : days) {
			System.out.print(" " + day);
		}
		System.out.println(); //줄바꿈
		int month = 3;
		int space = getFirstDay(month); //1일의 위치값
		int lastDate = getLastDate(month); //마지막날
		for(int s = 0; s < space; s++) {
			System.out.print("    ");
		}
		for(int i = 1; i <= lastDate; i++) {
			if(String.valueOf(i).length() == 1) {
				System.out.print("   " + i);
				//int를 문자열로 바꾸는 메소드, length()는 문자 길이를 알려주는 메소드
			}else if(String.valueOf(i).length() == 2) {
				if(i == 21) {
					System.out.print(" " + "평가");		
				} else { 
					System.out.print("  " + i);
				}
			}
			if((space + i) % 7 == 0) {
				System.out.println();
			}
		}
		
		
	}

}
