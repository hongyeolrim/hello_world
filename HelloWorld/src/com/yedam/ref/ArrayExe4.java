package com.yedam.ref;
//컨트롤 시프트 f = 정렬
public class ArrayExe4 {
	public static void main(String[] args) {
		int[] intAry = { 8, 7, 6, 5, 4 };
		int temp = intAry[0];
		intAry[0] = intAry[1];
		intAry[1] = temp;
		for (int i = 0; i < intAry.length - 1; i++) {
			for (int j = 0; j < intAry.length - 1; j++) {
				if (intAry[j] > intAry[j + 1]) {
					temp = intAry[j];
					intAry[j] = intAry[j + 1];
					intAry[j + 1] = temp;
				}

			}
		}
		for (int numbers : intAry) {
			System.out.println(numbers);
		}
	}
}
