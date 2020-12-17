package shop.steamowls.steam.admin.service;

import java.sql.Connection;

import shop.steamowls.steam.member.dao.MemberDao;
import shop.steamowls.steam.member.vo.MemberVo;
import static shop.steamowls.common.JdbcUtil.*;

public class AdminService {
	
	
	public MemberVo adminLogIn(MemberVo memberVo) {
		MemberDao memberDao = MemberDao.getInstance();
		Connection con = getConnection();
		memberDao.setConnection(con);

		MemberVo vo = memberDao.adminLogIn(memberVo);

		close(con);
		return vo;
	}

	
}
