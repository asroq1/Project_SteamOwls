package shop.steamowls.steam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import shop.steamowls.steam.member.vo.MemberVo;

import static shop.steamowls.common.JdbcUtil.close;

public class MypageDao {
	private Connection con;

	public MypageDao() {

	}

	private static class LazyHolder {
		private static final MypageDao INSTANCE = new MypageDao();
	}

	public static MypageDao getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int signUp(MemberVo memberVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(
					"insert into owls_mber_tb(id,pw,name,tel,gender,sms_fl) " + "values(?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getPw());
			pstmt.setString(3, memberVo.getName());
			pstmt.setString(4, memberVo.getTel());
			pstmt.setString(5, memberVo.getGender());
			pstmt.setBoolean(6, memberVo.isSms_fl());

			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

	public MemberVo logIn(String id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;
		
		try {
			pstmt = con.prepareStatement("select sq, id, pw from owls_mber_tb where id = ? and del_fl = 0");
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVo();
				vo.setSq(rs.getInt("sq"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}

	public MemberVo forgotId(MemberVo memberVo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;

		try {
			pstmt = con.prepareStatement("select id from owls_mber_tb where name = ? and tel = ? and del_fl = 0");
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getTel());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVo();
				vo.setId(rs.getString("id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberVo;
	}
	
		public MemberVo forgotPw(MemberVo memberVo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;

		try {
			pstmt = con.prepareStatement("select sq, pw  from owls_mber_tb "
					+ "where id = ? and name = ? and tel = ? and del_fl = 0 ");
			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getName());
			pstmt.setString(3, memberVo.getTel());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberVo = new MemberVo();
				
				vo.setSq(rs.getInt("sq"));
				vo.setPw(rs.getString("pw"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return vo;
		
	}
	
	
	public int resetPw(MemberVo memberVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement("update owls_mber_tb set pw = ? where sq = ? and del_fl = 0");
			pstmt.setString(1, memberVo.getPw());
			pstmt.setInt(2, memberVo.getSq());
			
			count = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return count;
	}

}
