package shop.steamowls.steam.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.steamowls.steam.member.vo.MemberVo;

import static shop.steamowls.common.JdbcUtil.close;

public class MemberDao {
	private Connection con;

	public MemberDao() {

	}

	private static class LazyHolder {
		private static final MemberDao INSTANCE = new MemberDao();
	}

	public static MemberDao getInstance() {
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
					"insert into owls_mber_tb(sms_fl, info_fl, id, pw, name, tel, gender) " + "values(?, ?, ?, ?, ?, ?, ?)");
			pstmt.setBoolean(1, memberVo.isSms_fl());
			pstmt.setBoolean(2, memberVo.isInfo_fl());
			pstmt.setString(3, memberVo.getId());
			pstmt.setString(4, memberVo.getPw());
			pstmt.setString(5, memberVo.getName());
			pstmt.setString(6, memberVo.getTel());
			pstmt.setString(7, memberVo.getGender());

			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	public int checkId(String id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			pstmt = con.prepareStatement("select count(*) from owls_mber_tb where id = ? and del_fl = 0");
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public MemberVo logIn(MemberVo memberVo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;

		try {
			pstmt = con.prepareStatement("select sq, id, pw from owls_mber_tb where id = ? and admin_fl = 0");
			pstmt.setString(1, memberVo.getId());

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
	
	public MemberVo adminLogIn(MemberVo memberVo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;

		try {
			pstmt = con.prepareStatement("select sq, id, pw from owls_mber_tb where id = ? and pw = ? and del_fl = 0 and admin_fl = 1");
			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getPw());

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
		return vo;
	}

	public MemberVo forgotPw(MemberVo memberVo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;

		try {
			pstmt = con.prepareStatement(
					"select sq, pw  from owls_mber_tb " + "where id = ? and name = ? and tel = ? and del_fl = 0 ");
			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getName());
			pstmt.setString(3, memberVo.getTel());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVo();

				vo.setSq(rs.getInt("sq"));
				vo.setPw(rs.getString("pw"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

	public MemberVo mCheckPw(MemberVo memberVo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;
		try {
			pstmt = con.prepareStatement("select sq, name, pw, tel from owls_mber_tb " 
						+ "where sq = ? and del_fl = 0 ");
			pstmt.setInt(1, memberVo.getSq());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVo();
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
	
	public int modify(MemberVo memberVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement("update owls_mber_tb set name = ?, pw = ?, tel = ? where sq = ? and del_fl = 0");
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getPw());
			pstmt.setString(3, memberVo.getTel());
			pstmt.setInt(4, memberVo.getSq());

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

}
