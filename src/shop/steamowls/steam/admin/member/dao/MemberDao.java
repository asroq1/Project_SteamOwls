package shop.steamowls.steam.admin.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.steamowls.common.Pagenation;
import shop.steamowls.steam.admin.admin.vo.AdminVo;
import shop.steamowls.steam.admin.member.vo.MemberVo;
import shop.steamowls.steam.admin.review.vo.ReviewVo;
import shop.steamowls.steam.mypage.vo.BoardVo;

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

	
	public ArrayList<MemberVo> mManage(Pagenation pagenation) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVo> list = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(
					"select sq, id, name, tel, gender"
					+ " from owls_mber_tb"
					+ " where del_fl = 0");
			pstmt.setInt(1, pagenation.getStartArticleNumber());
			pstmt.setInt(2, pagenation.getARTICLE_COUNT_PER_PAGE());
			
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVo vo = new MemberVo();
				vo = new MemberVo();
				vo.setSq(rs.getInt("sq"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setGender(rs.getString("gender"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public ArrayList<BoardVo> getMemberList(Pagenation pagenation) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVo> list = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(
					"select obt.board_sq, obt.board_subject, obt.board_content, obt.board_address, obt.member_sq, date_format(obt.board_dttm, '%Y-%m-%d %H:%i') as board_dttm,"
							+ " omt.id from owls_board_tb obt INNER JOIN owls_mber_tb omt on obt.member_sq=omt.sq where obt.board_del_fl = false order by obt.board_sq desc limit ?,?");
			pstmt.setInt(1, pagenation.getStartArticleNumber());
			pstmt.setInt(2, pagenation.getARTICLE_COUNT_PER_PAGE());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVo vo = new BoardVo();
				vo = new BoardVo();
				vo.setBoard_sq(rs.getInt("board_sq"));
				vo.setMember_id(rs.getString("id"));
				vo.setBoard_subject(rs.getString("board_subject"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_address(rs.getString("board_address"));
				vo.setBoard_dttm(rs.getString("board_dttm"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public int getMemberCount() {
		PreparedStatement pstmt = null; // 쿼리문 작성할 메소드
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement("select count(obt.board_sq)"
					+ " from owls_board_tb obt INNER JOIN owls_mber_tb omt"
					+ " on obt.member_sq=omt.sq"
					+ " where obt.board_del_fl = false"
					+ " order by obt.board_sq desc");

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

}
