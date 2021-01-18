package shop.steamowls.steam.admin.review.vo;

public class ReviewVo {
	private int sq;
	private String id;
	private int review_sq;
	private boolean review_del_fl;
	private String review_subject;
	private String review_content;
	private String review_dttm;
	private double review_star;

	public ReviewVo() {

	}

	public int getSq() {
		return sq;
	}

	public void setSq(int sq) {
		this.sq = sq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getReview_sq() {
		return review_sq;
	}

	public void setReview_sq(int review_sq) {
		this.review_sq = review_sq;
	}

	public boolean isReview_del_fl() {
		return review_del_fl;
	}

	public void setReview_del_fl(boolean review_del_fl) {
		this.review_del_fl = review_del_fl;
	}

	public String getReview_subject() {
		return review_subject;
	}

	public void setReview_subject(String review_subject) {
		this.review_subject = review_subject;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_dttm() {
		return review_dttm;
	}

	public void setReview_dttm(String review_dttm) {
		this.review_dttm = review_dttm;
	}

	public double getReview_star() {
		return review_star;
	}

	public void setReview_star(double review_star) {
		this.review_star = review_star;
	}
	
	
}
