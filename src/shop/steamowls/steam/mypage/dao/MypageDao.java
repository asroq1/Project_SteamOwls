package shop.steamowls.steam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.steamowls.steam.booking.vo.BookingVo;
import shop.steamowls.steam.member.vo.MemberVo;
import shop.steamowls.steam.mypage.vo.BoardVo;
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

			pstmt = con.prepareStatement("update owls_mber_tb set del_fl = 1 where sq = ? and del_fl = 0");
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
			pstmt = con
					.prepareStatement("select sq, name, pw, tel from owls_mber_tb " + "where sq = ? and del_fl = 0 ");
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
			close(rs);
		}
		return vo;
	}

	public ArrayList<BookingVo> bDetail(BookingVo bookingVo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookingVo> list = new ArrayList<>();

		try {
			pstmt = con.prepareStatement("select * from (owls_booking_tb A, owls_product_tb B) "
					+ "where A.product_sq = B.product_sq and A.member_sq = ? and A.booking_fl = 1 "
					+ "order by A.booking_date,A.booking_start asc");
			pstmt.setInt(1, bookingVo.getMember_sq());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookingVo vo = new BookingVo();
				vo = new BookingVo();
				vo.setBooking_sq(rs.getInt("booking_sq"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_detail(rs.getString("product_detail"));
				vo.setBooking_people(rs.getInt("booking_people"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_imagePath(rs.getString("product_imagePath"));
				vo.setBooking_date(rs.getString("Booking_date"));
				vo.setBooking_start(rs.getString("Booking_start"));
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

	public int bCancel(int booking_sq) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement("Update owls_booking_tb set booking_fl = 0 where booking_sq = ?");
			pstmt.setInt(1, booking_sq);

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

	public ArrayList<BoardVo> getBoardList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVo> list = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(
					"select obt.*, omt.id from owls_board_tb obt INNER JOIN owls_mber_tb omt on obt.member_sq=omt.sq where obt.board_del_fl = false order by obt.board_sq desc");

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

	public BoardVo qDetail(String board_sq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo vo = null;
		try {
			pstmt = con.prepareStatement("select * from owls_board_tb where board_sq = ?");
			pstmt.setInt(1, Integer.parseInt(board_sq));

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVo();
				vo.setBoard_sq(rs.getInt("board_sq"));
				vo.setMember_sq(rs.getInt("member_sq"));
				vo.setBoard_subject(rs.getString("board_subject"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_address(rs.getString("board_address"));
				vo.setBoard_dttm(rs.getString("board_dttm"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}

	public int qDelete(String board_sq) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {

			pstmt = con.prepareStatement(
					"update owls_board_tb set board_del_fl = 1 where board_sq = ? and board_del_fl = 0");
			pstmt.setInt(1, Integer.parseInt(board_sq));

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

	public int QWriting(BoardVo boardVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(
					"insert into owls_board_tb (member_sq, board_subject, board_content) values(?, ?, ?)");

			pstmt.setInt(1, boardVo.getMember_sq());
			pstmt.setString(2, boardVo.getBoard_subject());
			pstmt.setString(3, boardVo.getBoard_content());

			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

	public BoardVo qModify(BoardVo boardVo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo vo = null;
		try {
			pstmt = con.prepareStatement("select member_sq, board_sq, board_subject, board_content, board_address, board_dttm"
					+ " from owls_board_tb where board_sq = ? and board_del_fl = 0");
//			pstmt.setInt(1, boardVo.getMember_sq());
			pstmt.setInt(1, boardVo.getBoard_sq());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVo();
				vo.setBoard_sq(rs.getInt("member_sq"));
				vo.setBoard_sq(rs.getInt("board_sq"));
				vo.setBoard_subject(rs.getString("board_subject"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_address(rs.getString("board_address"));
				vo.setBoard_dttm(rs.getString("board_dttm"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}
	
	public int qModifyProc(BoardVo boardVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(
					"update owls_board_tb set board_subject = ?, board_content = ? where board_sq = ?");
			pstmt.setString(1, boardVo.getBoard_subject());
			pstmt.setString(2, boardVo.getBoard_content());
			pstmt.setInt(3, boardVo.getBoard_sq());

			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
}
