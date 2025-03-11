package com.yedam.variable;

public class VarExe8 {
    public static void main(String[] args) {
    	int n1 = 10;
    	byte b1 = 20;
//    	byte result = b1 + 30; //-128 ~ 127을 담을 수 있는데도 오류가 뜨는 이유
    	                       //b1이랑 30의 데이터 타입을 기본 int로 인식하기 때문에 큰 데이터를 작은 값에 넣을 수 없음
    	                       //int는 4바이트, byte는 1바이트
    	byte result = (byte)(b1 + 130); //이렇게 형변환(casting)을 해줘야 함, 크기의 범위를 벗어나면 제일 작은 값으로 다시 돌아가서 나머지를 계산함
    	System.out.println("더한 결과: " + result);
    	n1 = b1; //작은 값을 큰 값에 넣는 거라서 잘 됩니다 형변환을 안 해도...자동형변환(promotion)이 되거든요
    	System.out.println(n1);
    	for(int i = 1; i < 150; i++) {
    		System.out.println(b1++);
    		
    		n1 = 200;
    		b1 = (byte)n1;
    		System.out.println(b1);  //값 손실?
    	}
    }
}
