package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class Test {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		BoardVO board = new BoardVO();
		board.setTitle("매퍼 테스트44");
		board.setContent("매퍼를 활용한 입력 테스트");
		board.setWriter("newbie");
		board.setBoardNo(5);

		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

			int r = mapper.insertBoard(board);

//					sqlSession.delete("com.yedam.mapper.BoardMapper.deleteBoard", board.getBoardNo());
			if (r == 1) {
				System.out.println("등록성공!");
				sqlSession.commit();
			} else {
				System.out.println("등록실패ㅠㅠ");
			}
			List<BoardVO> list = mapper.selectBoard();
//			List<BoardVO> list = sqlSession.selectList("com.yedam.mapper.BoardMapper.selectBoard");
			for (BoardVO brd : list) {
				System.out.println(brd.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
