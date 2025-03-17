package com.yedam.interfaces;

// 메인 메소드를 담고 있는 실행 클래스
public class ServiceApp {
	public static void main(String[] args) {
//		MysqlDao dao = new MysqlDao();
//		OracleDao dao = new OracleDao();
		Dao dao1 = new MysqlDao();
		dao1.insert();
		dao1.update();
		dao1.delete();

		Dao dao2 = new OracleDao();
		dao2.insert();
		dao2.update();
		dao2.delete();

		// 등록
//		dao.insert();
//		dao.add();
		// 수정
//		dao.modify();
		// 삭제
//		dao.remove();
//		dao.delete();
//인터페이스를 활용 안 하면 저렇게 일일이 다 바꿔야 함

	}
}
