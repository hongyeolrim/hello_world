package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//1. ojdbc 데이터베이스 연결, 쿼리, 실행결과
//2. Connection 객체(db session)
//3. StATEMENT(PreparedStatement) 쿼리실행
//4. ResultSet(조회), int(입력, 수정, 삭제)

//int result = stmt.executeUpdate("쿼리문");
//몇 개의 행이 수정됐는지 숫자로 알려줌.
//INSERT, UPDATE, DELETE는 executeUpdate()를 써서 **영향받은 행 개수(int)**를 받아야 해요.

public class DaoExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		String sql = "select empno,\r\n" + "       ename,\r\n" + "       job,\r\n" + "       mgr,\r\n"
				+ "       hiredate,\r\n" + "       sal\r\n" + "from   emp order by empno desc";
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			conn.setAutoCommit(false); // 자동 커밋 안 하겠다는 설정
			System.out.println("연결 성공");
			Statement stmt = conn.createStatement();

			int r = stmt.executeUpdate("DELETE FROM emp\r\n" + "WHERE  empno = 9999");
			if (r > 0) {
				System.out.println("삭제 성공");
				conn.commit(); // 커밋 메소드
			}

			ResultSet rs = stmt.executeQuery(sql); // 쿼리 작성 -> 쿼리 실행
			while (rs.next()) {
				System.out.println(rs.getInt("empno") + ", " + rs.getString("ename") + ", " + rs.getString("job"));
			} // getInt 컬럼에 해당하는 값을 정수 타입으로 반환
			System.out.println("-- end of data --");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

//📌코드에서 쓰는
//단어 쉽게 알기!

//데이터베이스(Database)
//데이터를 저장하는 창고 -> 택배 물류 창고

//JDBC(Java Database Connectivity)
//자바(Java)와 데이터베이스가 서로 소통할 수 있게 도와주는 기술

//ojdbc(Oracle JDBC)
//JDBC를 사용하려면 데이터베이스에 맞는 드라이버가 필요해!
//자바와 오라클(Oracle) 데이터베이스를 연결시켜주는 드라이버 -> 배달 트럭 운전자

//Connection 객체(db session)
//데이터베이스와 연결하는 "연결 통로" -> DB와 연결되는 전용 도로
//DriverManager.getConnection()
//드라이버와 함께 데이터베이스로 연결되는 통로로 입장 -> 전용 도로 진입
//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user", "password");

//Statement
//데이터베이스에 SQL(에스큐엘)을 전달해주는 사람 -> 택배기사 (매번 배달할 때마다 주소, 물건을 일일이 확인하고 포장해서 배송하는 일반 택배 기사)
//Statement stmt = conn.createStatement(); //Statement Statement 객체를 담을 변수 = Connection 객체가 담긴 변수.createStatement();

//PreparedStatement -> 자주 배송하는 물건은 미리 포장하고, 배송할 주소까지 미리 알고 있어서 빠르게 배송하는 단골 전문 택배 기사
//PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customers WHERE id = ?");
//pstmt.setInt(1, 10);  //(1번째 물음표에 10을 넣음)
//ResultSet rs = pstmt.executeQuery();

//executeQuery()
//SQL 실행 & 조회 결과 출력 -> 배송 주문을 받아서 택배 창고의 물건들을 가져옴
//ResultSet -> 가져올 물건들을 담아오는 상자
//ResultSet rs = stmt.executeQuery("SELECT * FROM customers");

//executeUpdate()
//데이터를 추가하거나, 바꾸거나, 지울 때 쓰는 명령 (INSERT, UPDATE, DELETE 때 사용!) -> 택배 창고에 있는 물건들 정리

//conn.setAutoCommit(false)
//데이터를 실수로 잘못 삭제하거나 추가하는 걸 방지하기 위해서 "꼭 허락해줘야만 실제 데이터가 바뀌도록 설정하는 것" -> 택배 창고에 있는 물건들 정리하려면 관리자한테 허락 맡아야 함

//conn.commit()
//실제로 변경사항을 데이터베이스에 확실하게 저장할 때 쓰는 명령 -> 관리자가 허락하고 나서 "최종 확정된 업무 보고서"에 변경 사항을 기록 (이후 변경 불가)

//rs.close();, stmt.close();, conn.close(); -> 그날 하루의 업무가 다 끝나면 전용 통로 닫고 퇴근