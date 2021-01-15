package shop.steamowls.steam.admin.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.steamowls.steam.admin.admin.vo.AdminVo;

import static shop.steamowls.common.JdbcUtil.close;

public class SalesDao {
	private Connection con;

	public SalesDao() {

	}

	private static class LazyHolder {
		private static final SalesDao INSTANCE = new SalesDao();
	}

	public static SalesDao getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	
	

	

}
