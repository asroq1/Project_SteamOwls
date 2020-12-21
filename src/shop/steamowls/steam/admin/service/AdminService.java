package shop.steamowls.steam.admin.service;

import java.sql.Connection;

import shop.steamowls.steam.admin.dao.AdminDao;
import shop.steamowls.steam.admin.vo.AdminVo;
import static shop.steamowls.common.JdbcUtil.*;

public class AdminService {
	
	
	public AdminVo adminLogIn(AdminVo adminVo) {
		AdminDao adminDao = AdminDao.getInstance();
		Connection con = getConnection();
		adminDao.setConnection(con);

		AdminVo vo = adminDao.adminLogIn(adminVo);

		close(con);
		return vo;
	}
	
	public boolean pDelete(AdminVo adminVo) {
		AdminDao adminDao = AdminDao.getInstance();
		Connection con = getConnection();
		adminDao.setConnection(con);

		int count = adminDao.pDelete(adminVo);
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
