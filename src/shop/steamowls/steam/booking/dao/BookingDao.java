package shop.steamowls.steam.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.steamowls.steam.mypage.vo.MypageVo;

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


}
