package kh.s0.myboard.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.jdbc.JdbcTemplate;
import kh.s0.myboard.board.model.BoardVo;


public class BusinessInfoDao {
	// 최소 5개 
//		insert - 등록
		public int insert(Connection conn, BusinessInfoVo vo) {
			int result = 0;
			return result;
		}
//		update - 수정
		public int update(Connection conn, BusinessInfoVo vo, String busno/*주로 PK*/) {
			int result = 0;
			return result;
		}
//		delete  - 삭제
		public int delete(Connection conn, String busno/*주로 PK*/) {
			int result = 0;
			return result;
		}
//		selectList  - 목록조회
		public List<BusinessInfoVo> selectList(Connection conn){
			List<BusinessInfoVo> volist = null;

			return volist;
		}
//		selectOne - 상세조회
		public BusinessInfoVo selectOne(Connection conn, String busno/*주로 PK*/){
			BusinessInfoVo result = null;
			
			String sql = "select * from business_info where busno=?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, busno);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = new BusinessInfoVo();
					result.setBusceoname(rs.getString("busceoname"));
					result.setBuscertification(rs.getString("buscertification"));
					result.setBusname(rs.getString("busname"));
					result.setBusno(rs.getString("busno"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(pstmt);
			}
			return result;
			
		}
}
