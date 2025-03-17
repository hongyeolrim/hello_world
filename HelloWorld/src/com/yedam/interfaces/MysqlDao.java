package com.yedam.interfaces;

// 1차 프로젝트
// 등록(insert), 수정 (modify), 삭제(remove)

//Dao라는 인터페이스의 기능을 따라서 메소드명을 똑같이 만들어줘야 함
public class MysqlDao implements Dao {
	@Override
	public void insert() {
		System.out.println("mysql용 등록");
	}

	@Override
	public void update() {
		System.out.println("mysql용 수정");
	}

	@Override
	public void delete() {
		System.out.println("mysql용 삭제");
	}
}
