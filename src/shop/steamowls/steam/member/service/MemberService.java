package shop.steamowls.steam.member.service;

import java.sql.Connection;

import shop.steamowls.steam.member.dao.MemberDao;
import shop.steamowls.steam.member.vo.MemberVo;
import shop.steamowls.steam.mypage.vo.MypageVo;

import static shop.steamowls.common.JdbcUtil.*;

public class MemberService {
	public boolean signUp(MemberVo memberVo) {

		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);

		int count = memberDao.signUp(memberVo);
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
	
	public boolean checkId(String id) {

		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);

		int count = memberDao.checkId(id);
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

	public MemberVo logIn(MemberVo memberVo) {
		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);

		MemberVo vo = memberDao.logIn(memberVo);

		close(con);
		return vo;
	}
	
	public MemberVo adminLogIn(MemberVo memberVo) {
		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);

		MemberVo vo = memberDao.adminLogIn(memberVo);

		close(con);
		return vo;
	}

	public MemberVo forgotId(MemberVo memberVo) {
		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);
		
		MemberVo vo = memberDao.forgotId(memberVo);
		
		close(con);
		return vo;
	}
	
	public MemberVo forgotPw(MemberVo memberVo) {
		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);
		
		MemberVo vo = memberDao.forgotPw(memberVo);

		close(con);
		return vo;
	}
	
	public boolean resetPw(MemberVo memberVo) {
		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);

		int count = memberDao.resetPw(memberVo);
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
	public MemberVo mCheckPw(MemberVo memberVo) {
		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);
		MemberVo vo = new MemberVo();
		vo = memberDao.mCheckPw(memberVo);
		
		close(con);
		return vo;
	}

	public boolean withdraw(MypageVo mypageVo) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
