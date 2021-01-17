package shop.steamowls.steam.admin.review.service;

import static shop.steamowls.common.JdbcUtil.close;
import static shop.steamowls.common.JdbcUtil.commit;
import static shop.steamowls.common.JdbcUtil.getConnection;
import static shop.steamowls.common.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import shop.steamowls.steam.admin.review.dao.ReviewDao;
import shop.steamowls.steam.admin.review.vo.ReviewVo;
import shop.steamowls.steam.mypage.dao.MypageDao;
import shop.steamowls.steam.mypage.vo.MypageVo;

public class ReviewService {

	public ArrayList<ReviewVo> rManage() {
		ReviewDao reviewDao = ReviewDao.getInstance();
		Connection con = getConnection();
		reviewDao.setConnection(con);
		
		ArrayList<ReviewVo> list = reviewDao.rManage();
		close(con);
		return list;
	}
	
	public ReviewVo rDetail(ReviewVo reviewVo) {
		ReviewDao reviewDao = ReviewDao.getInstance();
		Connection con = getConnection();
		reviewDao.setConnection(con);
		
		ReviewVo vo = reviewDao.rDetail(reviewVo);
		close(con);
		return vo;
	}
	
	public boolean rDelete(ReviewVo reviewVo) {
		ReviewDao reviewDao = ReviewDao.getInstance();
		Connection con = getConnection();
		reviewDao.setConnection(con);

		int count = reviewDao.rDelete(reviewVo);
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
