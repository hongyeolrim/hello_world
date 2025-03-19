package com.yedam.bookApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookJdbc {

	// ✅ Connection 객체 생성 메서드 (try-with-resources를 위해 public으로 변경 가능)
	private Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";

		try {
			return DriverManager.getConnection(url, userId, userPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ✅ 책 추가 (INSERT)
	public boolean insert(Book book) {
		String sql = "INSERT INTO tbl_book (book_code, title, author, publisher, price) "
				+ "VALUES (book_seq.nextval, ?, ?, ?, ?)";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getPublisher());
			stmt.setInt(4, book.getPrice());

			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ✅ 책 삭제 (DELETE)
	public boolean delete(String bookCode) {
		String sql = "DELETE FROM tbl_book WHERE book_code = ?";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, bookCode);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ✅ 책 수정 (UPDATE)
	public boolean update(Book book) {
		String sql = "UPDATE tbl_book SET title = ?, price = ?, author = ? WHERE book_code = ?";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, book.getTitle());
			stmt.setInt(2, book.getPrice());
			stmt.setString(3, book.getAuthor());
			stmt.setString(4, book.getBookCode());

			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ✅ 책 목록 조회 (출판사별 필터 가능)
	public List<Book> list(String publisher) {
		List<Book> list = new ArrayList<>();
		String sql = "SELECT book_code, title, author, publisher, price FROM tbl_book "
				+ "WHERE (? IS NULL OR publisher = ?) " + "ORDER BY book_code";

		try (Connection conn = getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {

			psmt.setString(1, publisher);
			psmt.setString(2, publisher);

			try (ResultSet rs = psmt.executeQuery()) {
				while (rs.next()) {
					list.add(new Book(rs.getString("book_code"), rs.getString("title"), rs.getString("author"),
							rs.getString("publisher"), rs.getInt("price")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// ✅ 단건 조회 (책 코드로 검색)
	public Book searchByCode(String bookCode) {
		String sql = "SELECT book_code, title, author, publisher, price FROM tbl_book WHERE book_code = ?";
		Book book = null;

		try (Connection conn = getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {

			psmt.setString(1, bookCode);

			try (ResultSet rs = psmt.executeQuery()) {
				if (rs.next()) { // ✅ bookCode에 해당하는 책이 있으면
					book = new Book(rs.getString("book_code"), rs.getString("title"), rs.getString("author"),
							rs.getString("publisher"), rs.getInt("price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book; // ✅ 찾은 책 객체를 반환 (없으면 null)
	}
}
