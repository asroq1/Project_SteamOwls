package shop.steamowls.steam.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.steamowls.steam.admin.product.vo.ProductVo;
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

	public int bBooking(BookingVo bookingVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(
					"insert into owls_booking_tb (member_sq, booking_date, booking_start, booking_people) values(?, ?, ?, ?)");
			pstmt.setInt(1, bookingVo.getMember_sq());
			pstmt.setString(2, bookingVo.getBooking_date());
			pstmt.setString(3, bookingVo.getBooking_start());
			pstmt.setInt(4, bookingVo.getBooking_people());

			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	

	public BookingVo bBookingCheck(int member_sq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookingVo vo = null;

		try {
			pstmt = con.prepareStatement("select * from owls_booking_tb where member_sq = ?");
			pstmt.setInt(1, member_sq);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new BookingVo();
				vo.setBooking_date(rs.getString("booking_date"));
				vo.setBooking_start(rs.getString("booking_start"));
				vo.setBooking_people(rs.getInt("booking_people"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}
	
	public ArrayList<BookingVo> findProduct() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookingVo> list = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement("select * from owls_product_tb where product_del_fl = 0");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookingVo vo = new BookingVo();
				vo.setProduct_sq(rs.getInt("product_sq"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_detail(rs.getString("product_detail"));
				vo.setProduct_people(rs.getInt("product_people"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_imagePath(rs.getString("product_imagePath"));
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

}
