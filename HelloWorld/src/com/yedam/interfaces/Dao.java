package com.yedam.interfaces;

// DAO = Data Access Object
// 인터페이스 내의 메소드는 따로 선언을 안 해도 이미 추상 메소드
// 인터페이스는 규칙
public interface Dao {
	void insert();

	void update();

	void delete();
}
