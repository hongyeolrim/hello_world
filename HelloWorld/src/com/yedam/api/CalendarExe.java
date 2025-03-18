package com.yedam.api;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarExe {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar.getInstance()를 호출하면 현재 날짜와 시간 정보를 가진 Calendar 객체가 생성

		// 날짜를 설정하는 코드
		// ***주의*** 1월이 아니라 2월이 됨 → 이유: MONTH는 0부터 시작
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 10);

		// cal.set(연도, 월, 일)의 형태로 한 번에 날짜를 설정
		// MONTH는 0부터 시작하므로 2는 3월이 됨 ====> 2023년 3월 5일
		cal.set(2023, 2, 5);

//      Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.DAY_OF_WEEK 등은 상수값을 의미
//		Calendar.YEAR → 1  연도 뽑을 수 있는 상수
//		Calendar.MONTH → 2 월 뽑을 수 있는 상수
//		Calendar.DATE → 5  일 뽑을 수 있는 상수
//		Calendar.DAY_OF_WEEK → 7 요일 뽑을 수 있는 상수

//		System.out.println(cal.get(상수));
//		System.out.println(Calendar.YEAR); // Calendar.YEAR 같은 상수를 활용하면 숫자를 기억하지 않아도 된다
//		System.out.println(Calendar.MONTH);
//		System.out.println(Calendar.DATE);
//		System.out.println(Calendar.DAY_OF_WEEK);
//		Calendar.DAY_OF_WEEK 자체는 그냥 **요일을 나타내는 상수(숫자 7)**일 뿐이야.
//		이걸 그대로 출력하면 그냥 "7"이라는 숫자가 나오는 거고,
//		실제로 요일을 가져오려면 cal.get(Calendar.DAY_OF_WEEK)을 써야 해!

//		int yeartest = cal.get(Calendar.YEAR);
//		int monthtest = cal.get(Calendar.MONTH) + 1; // 월은 0부터 시작하므로 +1 필요
//		int datetest = cal.get(Calendar.DATE);
//		int dayOfWeektest = cal.get(Calendar.DAY_OF_WEEK);
//
//		System.out.println("연도: " + yeartest);
//		System.out.println("월: " + monthtest);
//		System.out.println("일: " + datetest);
//		System.out.println("요일: " + dayOfWeektest);

//		년, 월 입력 => n월달의 1일의 요일 반환, 말일을 반환
//		getDay(2025, 7) //7월달의 1일의 요일 반환
//      getLastDate(2025, 7); //7월달의 마지막날 반환

		Scanner scanner = new Scanner(System.in);

		System.out.print("연도 입력>> ");
		int year = scanner.nextInt();

		System.out.print("월 입력>> ");
		int month = scanner.nextInt();

		// 결과 출력
		System.out.println(getDay(year, month));
		System.out.println(getLastDate(year, month));

		scanner.close(); // Scanner 닫기
	}

	static String getDay(int year, int month) {
		Calendar cal = Calendar.getInstance();

		cal.set(year, month - 1, 1);

		// 1일의 요일 구하기
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String[] weekDays = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		// 자바의 Calendar.DAY_OF_WEEK에서는 항상 일요일이 1, 토요일이 7이야
		// 오라클도 일요일이 1이야
		// 자바스크립트, C, Python 만 일요일이 0이야

		String day = weekDays[dayOfWeek - 1]; // 7이 나오면 강제로 0이 됨

		return year + "년 " + month + "월 " + "1일의 요일은 " + day + " 입니다";
	}

	static String getLastDate(int year, int month) {
		Calendar cal = Calendar.getInstance();

		cal.set(year, month - 1, 1);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return year + "년 " + month + "월의 말일은 " + lastDay + "일 입니다";
	}
}

// 한 해의 최대 주(week) 개수 구하기
//Calendar cal = Calendar.getInstance();
//int maxWeeks = cal.getActualMaximum(Calendar.WEEK_OF_YEAR);
//System.out.println("올해의 최대 주(week) 개수: " + maxWeeks);

//한 달의 최대 주 개수 구하기
//Calendar cal = Calendar.getInstance();
//cal.set(2024, Calendar.MARCH, 1); // 2024년 3월 설정
//
//int maxWeeksInMonth = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
//System.out.println("2024년 3월의 최대 주 개수: " + maxWeeksInMonth);