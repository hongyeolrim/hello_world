package com.yedam.classes;

public class MethodExe3 {
	String str = "";

	String gugudan(int num, int toNum) {
		for (int j = num; j <= toNum; j++) {
			int dan = j;
			for (int i = 1; i < 10; i++) {
				str += dan + " x " + i + " = " + (dan * i) + "\n";
			}
		}
		return str;
	}

	void printStar(int cnt, String str) {
		for (int i = 1; i <= cnt; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(str);
			}
			System.out.println();
		}
	}

	void printCard() {
		int[] intAry = new int[16];

		for (int i = 0; i < intAry.length; i++) {

			int num;
			boolean isOverLap;

			do {
				num = (int) (Math.random() * 16) + 1;
				isOverLap = false;

				for (int j = 0; j < i; j++) {
					if (intAry[j] == num) {
						isOverLap = true;
						break;
					}
				}

			} while (isOverLap);
			intAry[i] = num;

		}
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("%3d", intAry[i]);
			if (i % 4 == 3) {
				System.out.println();
			}
		}
	}
}
