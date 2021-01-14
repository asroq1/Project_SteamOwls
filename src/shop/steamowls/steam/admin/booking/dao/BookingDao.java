package shop.steamowls.steam.admin.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.steamowls.steam.admin.admin.vo.AdminVo;

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

	
	

<<<<<<< Updated upstream
	
=======
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookingVo> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(
					"select a.booking_sq, a.member_sq, a.product_sq, c.product_name, c.product_price,"
					+ " b.id, b.name, b.tel, b.gender, a.booking_date, a.booking_people, a.booking_start"
					+ "	from owls_booking_tb a"
					+ "	inner join owls_mber_tb b"
					+ "	on a.member_sq = b.sq"
					+ "	inner join owls_product_tb c"
					+ "	on a.product_sq = c.product_sq"
					+ "	where booking_fl = 1 order by a.booking_date, a.booking_start asc");

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
	
	public int Bcancel (BookingVo bookingVo) {
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
>>>>>>> Stashed changes

}
