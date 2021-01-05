package shop.steamowls.steam.mypage.service;

import java.sql.Connection;
import java.util.ArrayList;

import shop.steamowls.steam.booking.dao.BookingDao;
import shop.steamowls.steam.booking.vo.BookingVo;
import shop.steamowls.steam.member.dao.MemberDao;
import shop.steamowls.steam.member.vo.MemberVo;
import shop.steamowls.steam.mypage.dao.MypageDao;
import shop.steamowls.steam.mypage.vo.MypageVo;

import static shop.steamowls.common.JdbcUtil.*;

public class MypageService {
	public boolean modify(MypageVo mypageVo) {
		MypageDao mypageDao = MypageDao.getInstance();
		Connection con = getConnection();
		mypageDao.setConnection(con);

		int count = mypageDao.modify(mypageVo);
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
	public boolean withdraw(MypageVo mypageVo) {
		MypageDao mypageDao = MypageDao.getInstance();
		Connection con = getConnection();
		mypageDao.setConnection(con);

		int count = mypageDao.withdraw(mypageVo);
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
	
	public MypageVo mCheckPw(MypageVo mypageVo) {
		MypageDao mypageDao = MypageDao.getInstance();
		Connection con = getConnection();
		mypageDao.setConnection(con);
		MypageVo vo = new MypageVo();
		vo = mypageDao.mCheckPw(mypageVo);

		close(con);
		return vo;
	}
	public ArrayList<BookingVo> bDetail(String sq) {
		MypageDao mypageDao = MypageDao.getInstance();
		Connection con = getConnection();
		mypageDao.setConnection(con);
		ArrayList<BookingVo> list = mypageDao.bDetail(sq);
		close(con);
		return list;
	}
	public boolean bCancel(int booking_sq) {
		MypageDao mypageDao = MypageDao.getInstance();
		Connection con = getConnection();
		mypageDao.setConnection(con);

		int count = mypageDao.bCancel(booking_sq);
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
