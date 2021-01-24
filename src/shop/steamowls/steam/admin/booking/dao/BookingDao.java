package shop.steamowls.steam.admin.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.steamowls.steam.admin.admin.vo.AdminVo;
import shop.steamowls.steam.booking.vo.BookingVo;

import static shop.steamowls.common.JdbcUtil.close;

public class BookingDao {
	private Connection con;

	public BookingDao() {

	}

	private static class LazyHolder {
		private static final BookingDao INSTANCE = new BookingDao();
	}

	public static BookingDao getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public ArrayList<BookingVo> Bmanage() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookingVo> list = new ArrayList<>();
		try {
			pstmt = con
					.prepareStatement("select * from owls_booking_tb a"
							+ " left join owls_mber_tb b"
							+ " on a.member_sq = b.sq"
							+ " left join owls_product_tb c"
							+ " on a.product_sq = c.product_sq"
							+ " where a.booking_fl =1 and b.del_fl = 0 order by a.booking_date, a.booking_start asc");
					

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookingVo vo = new BookingVo();
				vo.setBooking_sq(rs.getInt("booking_sq"));
				vo.setMember_sq(rs.getInt("member_sq"));
				vo.setProduct_sq(rs.getInt("product_sq"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setGender(rs.getString("gender"));
				vo.setBooking_date(rs.getString("booking_date"));
				vo.setBooking_people(rs.getInt("booking_people"));
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

	public ArrayList<BookingVo> BmanageProc(BookingVo bookingVo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookingVo> list = new ArrayList<>();

		try {
			pstmt = con.prepareStatement("select * from owls_booking_tb a"
					+ " INNER JOIN owls_mber_tb b"
					+ " on a.member_sq = b.sq"
					+ " INNER  join owls_product_tb c"
					+ " on a.product_sq = c.product_sq"
					+ " where b.del_fl = 0 and booking_date = ?"
					+ " order by a.booking_start asc");
			pstmt.setString(1, bookingVo.getBooking_date());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookingVo vo = new BookingVo();
				vo.setBooking_sq(rs.getInt("booking_sq"));
				vo.setMember_sq(rs.getInt("member_sq"));
				vo.setProduct_sq(rs.getInt("product_sq"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setGender(rs.getString("gender"));
				vo.setBooking_date(rs.getString("booking_date"));
				vo.setBooking_people(rs.getInt("booking_people"));
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

	public int Bcancel(BookingVo bookingVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement("Update owls_booking_tb set booking_fl = 0 where booking_sq = ?");
			pstmt.setInt(1, bookingVo.getBooking_sq());

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

}
