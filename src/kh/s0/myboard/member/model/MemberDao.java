package kh.s0.myboard.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import common.jdbc.JdbcTemplate;


// Member / BusinessInfo  
public class MemberDao {
//	insert
//	update
//	delete
//	selectList
//	selectOne
	// 최소 5개 
//	insert - 등록
	public int insert(Connection conn, MemberVo vo) {
		int result = 0;
		return result;
	}
//	update - 수정
	public int update(Connection conn, MemberVo vo, String mid/*주로 PK*/) {
		int result = 0;
		return result;
	}
//	delete  - 삭제
	public int delete(Connection conn, String mid/*주로 PK*/) {
		int result = 0;
		return result;
	}
//	selectList  - 목록조회
	public List<MemberVo> selectList(Connection conn){
		List<MemberVo> volist = null;

		return volist;
	}
//	selectOne - 상세조회
	public MemberVo selectOne(Connection conn, String mid/*주로 PK*/){
		MemberVo vo = null;
		return vo;
	}
//	selectOne - login - 상세조회
	public MemberVo login(Connection conn, String mid, String mpwd){
		MemberVo vo = null;
		//PK로 where했으므로 단일행 결과물
		// * 속도 저하의 원인. 필요한 컬럼명을 나열함.
		String query = "select mid,mname,mauthcode,busno,mtype from member where mid=? and mpwd=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//PK로 where했으므로 단일행 결과물로 while문 작성하지 않음
				vo = new MemberVo();
				vo.setMid(rs.getString("mid"));
				vo.setMname(rs.getString("mname"));
				vo.setMauthcode(rs.getString("mauthcode"));
				vo.setMtype(rs.getInt("mtype"));
				vo.setBusno(rs.getString("busno"));
//				vo.setMid(rs.getString(1));
//				vo.setMname(rs.getString(2));
//				vo.setMauthcode(rs.getString(3));
//				vo.setMtype(rs.getInt(5));
//				vo.setBusno(rs.getString(4));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		
		return vo;
	}
	
	
	
	
	
}
