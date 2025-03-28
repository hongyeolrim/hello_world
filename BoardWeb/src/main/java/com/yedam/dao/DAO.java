package com.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url, userId, userPw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
