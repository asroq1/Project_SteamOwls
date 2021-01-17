package shop.steamowls.steam.admin.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import shop.steamowls.steam.admin.member.dao.MemberDao;
import shop.steamowls.steam.admin.member.vo.MemberVo;

import static shop.steamowls.common.JdbcUtil.*;

public class MemberService {

	public ArrayList<MemberVo> mManage() {
		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);
		
		ArrayList<MemberVo> list = memberDao.mManage();
		close(con);
		return list;
	}

}
