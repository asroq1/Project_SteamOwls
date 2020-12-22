package shop.steamowls.steam.admin.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.steamowls.steam.admin.admin.vo.AdminVo;

import static shop.steamowls.common.JdbcUtil.close;

public class QuestionDao {
	private Connection con;

	public QuestionDao() {

	}

	private static class LazyHolder {
		private static final QuestionDao INSTANCE = new QuestionDao();
	}

	public static QuestionDao getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	
	

	

}
