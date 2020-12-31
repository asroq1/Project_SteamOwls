package shop.steamowls.steam.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.steamowls.steam.booking.vo.BookingVo;
import shop.steamowls.steam.member.vo.MemberVo;

import static shop.steamowls.common.JdbcUtil.close;

public class BookingDao {
	private Connection con;

	private BookingDao() {

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
	
	public ArrayList<BookingVo> getProduct(BookingVo bookingVo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookingVo vo = null;
		ArrayList<BookingVo> list2 = new ArrayList<>();

		try {
			pstmt = con.prepareStatement("select product_sq, sum(booking_people) from owls_booking_tb where booking_date = ? and booking_start = ? group by product_sq");					
			pstmt.setString(1, bookingVo.getBooking_date());
			pstmt.setString(2, bookingVo.getBooking_start());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BookingVo();
				vo.setProduct_sq(rs.getInt("product_sq"));
				vo.setBooked_people(rs.getInt("sum(booking_people)"));
				vo.setLeft_people(4-vo.getBooked_people());
				list2.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return list2;
	}
	
	public ArrayList<BookingVo> findProduct(BookingVo bookingVo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookingVo vo = null;
		ArrayList<BookingVo> list1 = new ArrayList<>();
		

		try {
			pstmt = con.prepareStatement("select * from (owls_booking_tb A, owls_product_tb B) where A.booking_start = ?");
			pstmt.setString(1, bookingVo.getBooking_start());
 
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BookingVo();
				vo.setProduct_sq(rs.getInt("product_sq"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_detail(rs.getString("product_detail"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_people(rs.getInt("product_people"));
				vo.setProduct_time(rs.getString("product_time"));
				vo.setProduct_imagePath(rs.getString("product_imagePath"));
				list1.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list1;
	}

}
