package shop.steamowls.steam.booking.service;

import java.sql.Connection;
import java.util.ArrayList;

import shop.steamowls.steam.booking.dao.BookingDao;
import shop.steamowls.steam.booking.vo.BookingVo;
import shop.steamowls.steam.member.dao.MemberDao;
import shop.steamowls.steam.member.vo.MemberVo;

import static shop.steamowls.common.JdbcUtil.*;

public class BookingService {
	
	public ArrayList<BookingVo> getProduct(BookingVo bookingVo) {

		BookingDao bookingDao = BookingDao.getInstance();
		Connection con = getConnection();
		bookingDao.setConnection(con);

		ArrayList<BookingVo> list2 = bookingDao.getProduct(bookingVo);
		
		close(con);
		return list2;
	}
	
	public ArrayList<BookingVo> findProduct(BookingVo bookingVo) {

		BookingDao bookingDao = BookingDao.getInstance();
		Connection con = getConnection();
		bookingDao.setConnection(con);

		ArrayList<BookingVo> list1 = bookingDao.findProduct(bookingVo);

		close(con);
		return list1;
	}
	
	

	/*
	 * public BookingVo findBookingSq(BookingVo bookingVo) {
	 * 
	 * BookingDao bookingDao = BookingDao.getInstance(); Connection con =
	 * getConnection(); bookingDao.setConnection(con);
	 * 
	 * BookingVo vo = bookingDao.findBookingSq(bookingVo);
	 * 
	 * close(con); return vo; }
	 */

	
}
