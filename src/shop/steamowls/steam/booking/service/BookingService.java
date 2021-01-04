package shop.steamowls.steam.booking.service;

import java.sql.Connection;
import java.util.ArrayList;

import shop.steamowls.steam.admin.product.vo.ProductVo;
import shop.steamowls.steam.booking.dao.BookingDao;
import shop.steamowls.steam.booking.vo.BookingVo;

import static shop.steamowls.common.JdbcUtil.*;

public class BookingService {
	public boolean bBooking(BookingVo bookingVo) {

		BookingDao bookingDao = BookingDao.getInstance();
		Connection con = getConnection();
		bookingDao.setConnection(con);

		int count = bookingDao.bBooking(bookingVo);
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
	
	public BookingVo bBookingCheck(int member_sq) {
		BookingDao bookingDao = BookingDao.getInstance();
		Connection con = getConnection();
		bookingDao.setConnection(con);

		BookingVo vo = bookingDao.bBookingCheck(member_sq);

		close(con);
		return vo;
	}
	
	public ArrayList<BookingVo> findProduct() {
		BookingDao dao = BookingDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		ArrayList<BookingVo> list = dao.findProduct();
		close(con);
		return list;
	}
	
	public int bList(BookingVo bookingVo) {
		BookingDao bookingDao = BookingDao.getInstance();
		Connection con = getConnection();
		bookingDao.setConnection(con);

		int people_count = bookingDao.bList(bookingVo);

		close(con);
		return people_count;
	}
	
	public BookingVo bListFindProduct(int product_sq) {
		BookingDao dao = BookingDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		BookingVo vo = dao.bListFindProduct(product_sq);
		close(con);
		return vo;
	}
	
}
