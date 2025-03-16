package com.yeolrim;

import java.time.LocalTime;

public class Task {
	private Day day;
	private LocalTime time; // 자바에 만들어져 있는 클래스 LocalTime 사용
	private String task;
	private boolean completed;

	public Task() {
	}

	public Task(Day day, LocalTime time, String task) {
		this.day = day;
		this.time = time;
		this.task = task;
		this.completed = false; // 처음엔 미완료로 설정
	}

	public Day getDay() {
		return day;
	}

	public LocalTime getTime() {
		return time;
	}

	public String getTask() {
		return task;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public void markCompleted() {
		this.completed = true; // 완료 처리 기능
	}

	// 삼항 연산자(if-else를 한 줄로 표현한 거)
	// (조건식) ? ture일 때 값 : false일 때 값;
	// 삼항 연산자 우선 순위 보장을 위해서 () 씌워줌
	public String toString() {
		return ((completed) ? "[완료] " : "[미완료] ") + task + " - " + day.getKoreanDay() + " " + time;
	}

}

enum Day {
	// Day 생성자에 들어갈 매개값("요일")
	MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"), THURSDAY("목요일"), FRIDAY("금요일"), SATURDAY("토요일"), SUNDAY("일요일");

	private final String koreanDay; // 한글 요일을 저장하는 필드

	// 내가 필드랑 생성자를 직접 따로 만들었으니까 추가된 필드랑 생성자가 자동으로 호출되면서 객체가 생성될거야
	// (Java가 클래스랑 객체를 자동으로 만들어줌)
	// 내가 만든 enum Day 클래스의 부모 클래스를 Java가 직접 만들어줘서 내 클래스가 그 부모클래스의 모든 걸 상속받아

	// 클래스명<타입>
	// => 이 클래스가 다룰 타입(데이터의 종류)을 정한다
	// => 부모가 어떤 자식을 가질지 정한다
	// 클래스명<T>
	// => T라는 타입을 나중에 정한다(객체를 생성할 때 T의 실제 타입을 결정한다)

	// 생성자
	Day(String koreanDay) {
		this.koreanDay = koreanDay;
	}

	public String getKoreanDay() {
		return koreanDay;
	}
}
