package shop.steamowls.steam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.steamowls.steam.admin.product.vo.ProductVo;
import shop.steamowls.steam.booking.vo.BookingVo;
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

			pstmt = con.prepareStatement("update owls_mber_tb set del_fl = 1 where sq = ? and pw = ? and del_fl = 0");
			pstmt.setInt(1, mypageVo.getSq());
			pstmt.setString(2, mypageVo.getPw());

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

	public int Bcancel(BookingVo bookingVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(
					"Update owls_booking_tb set booking_f1 = 1 where member_sq = ? and product_del_fl = 0");
			pstmt.setInt(1, bookingVo.getBooking_sq());

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

	public ArrayList<BookingVo> Bhistory(int sq) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookingVo> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(
					"select a.booking_sq, a.member_sq, a.product_sq, c.product_imagePath, c.product_name, c.product_detail, c.product_price, a.booking_date, a.booking_people, a.booking_start"
					+ "	from owls_booking_tb a"
					+ "	inner join owls_mber_tb b"
					+ "	on a.member_sq = b.sq"
					+ "	inner join owls_product_tb c"
					+ "	on a.product_sq = c.product_sq"
					+ "	where a.member_sq = ?");
			pstmt.setInt(1, sq);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookingVo vo = new BookingVo();
				vo.setBooking_sq(rs.getInt("booking_sq"));
				vo.setMember_sq(rs.getInt("member_sq"));
				vo.setProduct_sq(rs.getInt("product_sq"));
				vo.setProduct_imagePath(rs.getString("product_imagePath"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_detail(rs.getString("product_detail"));
				vo.setBooking_people(rs.getInt("booking_people"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setBooking_date(rs.getString("booking_date"));
				vo.setBooking_start(rs.getString("booking_start"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return list;
	}

}
