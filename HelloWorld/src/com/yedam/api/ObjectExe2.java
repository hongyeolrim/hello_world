package com.yedam.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectExe2 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		System.out.println(obj1);

		Date obj2 = new Date();
		System.out.println(obj2.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초"); // 왜 월만 대문자? 아~ minute 때문에
																					// 소문자hh 12시간 대문자HH 24시간
		System.out.println(sdf.format(obj2));
	}
}
