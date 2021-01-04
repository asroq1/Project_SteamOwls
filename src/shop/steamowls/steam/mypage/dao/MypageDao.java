package shop.steamowls.steam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.steamowls.steam.member.vo.MemberVo;
import shop.steamowls.steam.mypage.vo.MypageVo;

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

	public int modify(MypageVo mypageVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {

			if (mypageVo.getPw() == null) {
				pstmt = con.prepareStatement("update owls_mber_tb set name = ?, tel = ? where sq = ? and del_fl = 0");
				pstmt.setString(1, mypageVo.getName());
				pstmt.setString(2, mypageVo.getTel());
				pstmt.setInt(3, mypageVo.getSq());

				count = pstmt.executeUpdate();

			} else {
				pstmt = con.prepareStatement(
						"update owls_mber_tb set name = ?, pw = ?, tel = ? where sq = ? and del_fl = 0");
				pstmt.setString(1, mypageVo.getName());
				pstmt.setString(2, mypageVo.getPw());
				pstmt.setString(3, mypageVo.getTel());
				pstmt.setInt(4, mypageVo.getSq());

				count = pstmt.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

	public int withdraw(MypageVo mypageVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {

			pstmt = con
					.prepareStatement("update owls_mber_tb set del_fl = 1 where sq = ? and del_fl = 0");
			pstmt.setInt(1, mypageVo.getSq());

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	public MypageVo mCheckPw(MypageVo mypageVo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MypageVo vo = null;
		try {
			pstmt = con.prepareStatement("select sq, name, pw, tel from owls_mber_tb " 
						+ "where sq = ? and del_fl = 0 ");
			pstmt.setInt(1, mypageVo.getSq());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new MypageVo();
				vo.setSq(rs.getInt("sq"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setTel(rs.getString("tel"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return vo;
	}

}
