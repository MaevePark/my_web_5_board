package kh.s0.myboard.member.model;

import java.sql.Connection;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class BusinessInfoService {
	private BusinessInfoDao dao = new BusinessInfoDao();
//	insert - 등록
	public int insert(BusinessInfoVo vo) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		JdbcTemplate.close(conn);
		return result;
	}
//	update - 수정
	public int update(BusinessInfoVo vo, String busno/*주로 PK*/) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, busno);
		JdbcTemplate.close(conn);
		return result;
	}
//	delete  - 삭제
	public int delete(String busno/*주로 PK*/) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, busno);
		JdbcTemplate.close(conn);	
		return result;
	}
//	selectList  - 목록조회
	public List<BusinessInfoVo> selectList(){
		List<BusinessInfoVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		return volist;
	}
//	selectOne - 상세조회
	public BusinessInfoVo selectOne(String busno/*주로 PK*/){
		BusinessInfoVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, busno);
		JdbcTemplate.close(conn);
		return vo;
	}
}
