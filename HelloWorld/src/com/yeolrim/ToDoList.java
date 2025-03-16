package com.yeolrim;

import java.time.LocalTime;
import java.util.ArrayList;

// List 사용법 참고 :
// List<타입> 변수명 = new ArrayList<>(Arrays.asList(값1, 값2, 값3));
// 변수명.add(값4); ---------add 메서드로 배열에 값 추가 가능
public class ToDoList {
	private ArrayList<Task> tasks = new ArrayList<>(); // 할일 목록 저장할 리스트 객체 생성

	public void addTask(Day day, LocalTime time, String task) {
		tasks.add(new Task(day, time, task));
	}

	// 사용자가 입력한 index 번호가 올바른 범위 안이 맞는지 확인
	// index가 0과 같거나 크고, tasks배열 사이즈보단 작음(index는 늘 0부터 시작하니까)
	public void deleteTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.remove(index);
			System.out.println("❌할 일이 삭제되었습니다!");
		} else {
			System.out.println("올바른 번호를 입력해 주세요.");
		}
	}

	// 사용자가 입력한 번호에 해당하는 Task를 완료 상태로 처리
	public void markTaskCompleted(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.get(index).markCompleted();
			System.out.println("🎉할 일이 완료되었습니다!");
		} else {
			System.out.println("올바른 번호를 입력해 주세요.");
		}
	}

	public void showTasks() {
		if (tasks.isEmpty()) {
			System.out.println("📌할 일이 없습니다~");
		} else {
			System.out.println("\n📋 할 일 목록");
			for (int i = 0; i < tasks.size(); i++) {
				System.out.println((i + 1) + ". " + tasks.get(i));
			}
		}
	}
}
