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
	
	public int bList(BookingVo bookingVo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int people_count = 0;

		try {
			pstmt = con.prepareStatement("select count(*) from (owls_booking_tb a, owls_product_tb b) where booking_date = ? and booking_start = ? and b.product_sq = ?");
			pstmt.setString(1, bookingVo.getBooking_date());
			pstmt.setString(2, bookingVo.getBooking_start());
			pstmt.setInt(3, bookingVo.getProduct_sq());
			
			people_count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return people_count;
	}
	
	public BookingVo bListFindProduct(int product_sq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookingVo vo = null;
		
		try {
			pstmt = con.prepareStatement("select * from owls_product_tb where product_sq = ? and product_del_fl = 0");
			pstmt.setInt(1, product_sq);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BookingVo();
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_detail(rs.getString("product_detail"));
				vo.setProduct_people(rs.getInt("product_people"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_imagePath(rs.getString("product_imagePath"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}
		public int pInfo(BookingVo bookingVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(
					"insert into owls_booking_tb (member_sq, product_sq, booking_fl, booking_date, booking_start, booking_people) VALUES(?, ?, true, ?, ?, ?)");
			pstmt.setInt(1, bookingVo.getMember_sq());
			pstmt.setInt(2, bookingVo.getProduct_sq());
			pstmt.setString(3, bookingVo.getBooking_date());
			pstmt.setString(4, bookingVo.getBooking_start());
			pstmt.setInt(5, bookingVo.getBooking_people());

			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	public ArrayList<BookingVo> bDetail(String sq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookingVo> list = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement("select * from owls_booking_tb where member_sq = ?");
			pstmt.setInt(1, Integer.parseInt(sq));

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookingVo vo = new BookingVo();
				vo = new BookingVo();
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_detail(rs.getString("product_detail"));
				vo.setProduct_people(rs.getInt("product_people"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_imagePath(rs.getString("product_imagePath"));
				vo.setBooking_date(rs.getString("getBooking_date"));
				vo.setBooking_start(rs.getString("getBooking_start"));
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
	public int bCancel(String booking_sq) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement("Update owls_product_tb set booking_fl = 1 where booking_sq = ? and product_del_fl = 0");
			pstmt.setInt(1, Integer.parseInt("booking_sq"));

			count = pstmt.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}

}
