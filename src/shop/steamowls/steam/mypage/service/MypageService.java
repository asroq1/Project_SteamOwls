package shop.steamowls.steam.mypage.service;

import java.sql.Connection;

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
}
