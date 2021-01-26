package shop.steamowls.steam.admin.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import shop.steamowls.common.Pagenation;
import shop.steamowls.steam.admin.member.dao.MemberDao;
import shop.steamowls.steam.admin.member.vo.MemberVo;
import shop.steamowls.steam.mypage.dao.MypageDao;
import shop.steamowls.steam.mypage.vo.BoardVo;

import static shop.steamowls.common.JdbcUtil.*;

public class MemberService {

	public ArrayList<MemberVo> mManage(Pagenation pagenation) {
		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);
		
		ArrayList<MemberVo> list = memberDao.mManage(pagenation);
		close(con);
		return list;
	}
	

	public int getMemberCount() {
		MemberDao dao = MemberDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.getMemberCount();
		close(con);
		return count;
	}
	
	public MemberVo mDetail(MemberVo memberVo) {
		MemberDao dao = MemberDao.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MemberVo vo = dao.mDetail(memberVo);
		close(con);
		return vo;
	}

}
