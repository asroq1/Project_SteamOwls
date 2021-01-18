package shop.steamowls.steam.admin.booking.service;

import java.sql.Connection;
import java.util.ArrayList;

import shop.steamowls.steam.admin.admin.dao.AdminDao;
import shop.steamowls.steam.admin.admin.vo.AdminVo;
import shop.steamowls.steam.admin.booking.dao.BookingDao;
import shop.steamowls.steam.booking.vo.BookingVo;


import static shop.steamowls.common.JdbcUtil.*;

public class BookingService {
	public ArrayList<BookingVo> Bmanage() {
		BookingDao bookingDao = BookingDao.getInstance();
		Connection con = getConnection();
		bookingDao.setConnection(con);

		ArrayList<BookingVo> list = bookingDao.Bmanage();
		close(con);
		return list;
	}
	
	public ArrayList<BookingVo> BmanageProc(BookingVo bookingVo) {
		BookingDao bookingDao = BookingDao.getInstance();
		Connection con = getConnection();
		bookingDao.setConnection(con);

		ArrayList<BookingVo> list = bookingDao.BmanageProc(bookingVo);
		close(con);
		return list;
	}

	public boolean Bcancel(BookingVo bookingVo) {
		BookingDao bookingDao = BookingDao.getInstance();
		Connection con = getConnection();
		bookingDao.setConnection(con);

		int count = bookingDao.Bcancel(bookingVo);
		boolean isSuccess = false;
		if (count > 0) {
			commit(con);
			isSuccess = true;
		} else {
			rollback(con);
			isSuccess = false;
		}
		close(con);
		return isSuccess;
	}

}
