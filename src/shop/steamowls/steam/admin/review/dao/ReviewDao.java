package shop.steamowls.steam.admin.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.steamowls.steam.admin.admin.vo.AdminVo;
import shop.steamowls.steam.admin.review.vo.ReviewVo;
import shop.steamowls.steam.mypage.vo.MypageVo;

import static shop.steamowls.common.JdbcUtil.close;

public class ReviewDao {
	private Connection con;

	public ReviewDao() {

	}

	private static class LazyHolder {
		private static final ReviewDao INSTANCE = new ReviewDao();
	}

	public static ReviewDao getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public ArrayList<ReviewVo> rManage() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReviewVo> list = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(
					"select"
					+ " A.review_sq, A.review_subject, A.review_content, A.review_dttm, A.review_star, B.id, B.sq"
					+ " from (owls_review_tb A, owls_mber_tb B)"
					+ " where A.member_sq = B.sq"
					+ " and A.review_del_fl = 0"
					+ " order by A.review_dttm desc");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewVo vo = new ReviewVo();
				vo = new ReviewVo();
				vo.setSq(rs.getInt("sq"));
				vo.setId(rs.getString("id"));
				vo.setReview_sq(rs.getInt("review_sq"));
				vo.setReview_star(rs.getDouble("review_star"));
				vo.setReview_subject(rs.getString("review_subject"));
				vo.setReview_content(rs.getString("review_content"));
				vo.setReview_dttm(rs.getString("review_dttm"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public ReviewVo rDetail(ReviewVo reviewVo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewVo vo = null;
		
		try {
			pstmt = con
					.prepareStatement("select"
							+ " A.review_sq, A.review_star, A.review_subject, A.review_content, A.review_dttm, B.sq, B.id"
							+ " from (owls_review_tb A, owls_mber_tb B)"
							+ " where A.member_sq = B.sq"
							+ " and review_sq = ?"
							+ " and review_del_fl = 0");
			pstmt.setInt(1, reviewVo.getReview_sq());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new ReviewVo();
				vo.setSq(rs.getInt("sq"));
				vo.setId(rs.getString("id"));
				vo.setReview_sq(rs.getInt("review_sq"));
				vo.setReview_star(rs.getDouble("review_star"));
				vo.setReview_subject(rs.getString("review_subject"));
				vo.setReview_content(rs.getString("review_content"));
				vo.setReview_dttm(rs.getString("review_dttm"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}
	
	public int rDelete(ReviewVo reviewVo) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement("update owls_review_tb"
					+ " set review_del_fl = 1"
					+ " where review_sq = ?"
					+ " and review_del_fl = 0");
			pstmt.setInt(1, reviewVo.getReview_sq());

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	

}
