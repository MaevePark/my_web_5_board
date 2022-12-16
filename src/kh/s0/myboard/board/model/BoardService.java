package kh.s0.myboard.board.model;

import java.sql.Connection;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class BoardService {
	private BoardDao dao = new BoardDao();
	
// 최소 5개 CRUD
//	insert
	public int insert(BoardVo vo) {
		System.out.println(">>BoardService Param :"+ vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		
		result = dao.insert(conn, vo);
		
		JdbcTemplate.close(conn);
		System.out.println(">>BoardService Return:"+ result);
		return result;
	}
//	update
	public int update(BoardVo vo, int bno/*주로 PK*/) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();

		result = dao.update(conn, vo, bno);
		
		JdbcTemplate.close(conn);
		return result;
	}
//	delete
	public int delete(int bno/*주로 PK*/) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();

		result = dao.delete(conn, bno);
		
		JdbcTemplate.close(conn);
		return result;
	}
//		selectList
	public List<BoardVo> selectList(){
		List<BoardVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();

		volist = dao.selectList(conn);
		
		JdbcTemplate.close(conn);
		return volist;
	}
//		selectOne
	public BoardVo selectOne(int bno/*주로 PK*/){
		BoardVo vo = null;
		Connection conn = JdbcTemplate.getConnection();

		vo = dao.selectOne(conn, bno);
		
		JdbcTemplate.close(conn);
		return vo;
	}

}


