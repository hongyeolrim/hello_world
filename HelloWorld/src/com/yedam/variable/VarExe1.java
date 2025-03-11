package com.yedam.variable;

//관례 : 클래스의 이름은 항상 대문자로 시작해야 함
public class VarExe1 {
	public static void main(String[] args) {
		int number1 = 70;
		int number2 = 80;
		number1 = 71; //변수 선언을 또 할 수는 없음, 같은 이름으로 2번 선언할 수 없다는 거임
		              //그대신 선언 안 하고 이렇게 값을 덮어씌울 수는 있음
		
		int sum = number1 + number2;
		
		System.out.println("두 점수의 합은 " + sum + "점 입니다");
		
		double avg = (double)sum / 2.0; //둘다 정수면 처리가 안 됨, 둘 다 실수로 바꾸면 처리됨
		                                //(변수 타입)변수 => 변수 타입 변경 형식
		                                //변수에 넣는 연산식에 쓰이는 값들은 타입이 반드시 서로 같아야 함
		System.out.println("두 점수의 평균은 " + avg + "점 입니다");
	}
	
}
