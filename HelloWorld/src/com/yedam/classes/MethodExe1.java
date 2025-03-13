package com.yedam.classes;

public class MethodExe1 {
	// 리턴타입 메소드이름 (매개변수...) {
	// }
	// public 선언 안 하면 디폴트값으로
	public void printString(int times, String str) {
		for (int i = 1; i <= times; i++) {
			System.out.println(str);
		}
	}

	int sum(int n1, int n2) {
		int result = 0;
		result = n1 + n2;
		return result;
	}

	int sum(double n1, double n2) {
		return (int) (n1 + n2);
	}

	int sum(int[] ary) {
		int result = 0;
		for (int i = 0; i < ary.length; i++) {
			result += ary[i];
		}
		return result;
	}

	// 배열의 합 (double[]을 매개값, 반환도 double로)
	double sum(double[] ary) {
		double result = 0;
		for (int i = 0; i < ary.length; i++) {
			result += ary[i];
		}
		return result;
	}
}
