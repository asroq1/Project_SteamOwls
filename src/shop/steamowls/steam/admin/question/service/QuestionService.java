package shop.steamowls.steam.admin.question.service;

import java.sql.Connection;
import java.util.ArrayList;

import shop.steamowls.steam.admin.admin.dao.AdminDao;
import shop.steamowls.steam.admin.admin.vo.AdminVo;
import shop.steamowls.steam.admin.question.dao.QuestionDao;
import shop.steamowls.steam.booking.vo.BookingVo;
import shop.steamowls.steam.mypage.dao.MypageDao;
import shop.steamowls.steam.mypage.vo.BoardVo;

import static shop.steamowls.common.JdbcUtil.*;

public class QuestionService {

	public BoardVo qDetail(String board_sq) {
		QuestionDao questionDao = QuestionDao.getInstance();
		Connection con = getConnection();
		questionDao.setConnection(con);
		BoardVo vo = new BoardVo();
		vo = questionDao.qDetail(board_sq);

		close(con);
		return vo;
	}


	
	public BoardVo qAnswer(String board_sq) {
		QuestionDao questionDao = QuestionDao.getInstance();
		Connection con = getConnection();
		questionDao.setConnection(con);
		BoardVo vo = new BoardVo();
		vo = questionDao.qAnswer(board_sq);

		close(con);
		return vo;
	}

}
