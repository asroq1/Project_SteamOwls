package shop.steamowls.steam.admin.admin.vo;

public class AdminVo {
	
	private int sq;		//이 세개는 member관련 vo
	private String id;	//
	private String pw;	//
	private int product_sq;				// 이밑의 나머지는 상품관련 vo
	private boolean status_fl;
	private int product_price;
	private int product_sell_count;
	private int product_qna_count;
	private String product_name;
	private String product_detail;
	private String file_path;
	private String thumbnail_path;
	private String admin_id;
	private String admin_pw;

	/**
	 * @return the sq
	 */
	public int getSq() {
		return sq;
	}

	/**
	 * @param sq the sq to set
	 */
	public void setSq(int sq) {
		this.sq = sq;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pw
	 */
	public String getPw() {
		return pw;
	}

	/**
	 * @param pw the pw to set
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}

	/**
	 * @return the product_sq
	 */
	public int getProduct_sq() {
		return product_sq;
	}

	/**
	 * @param product_sq the product_sq to set
	 */
	public void setProduct_sq(int product_sq) {
		this.product_sq = product_sq;
	}

	/**
	 * @return the status_fl
	 */
	public boolean isStatus_fl() {
		return status_fl;
	}

	/**
	 * @param status_fl the status_fl to set
	 */
	public void setStatus_fl(boolean status_fl) {
		this.status_fl = status_fl;
	}

	/**
	 * @return the product_price
	 */
	public int getProduct_price() {
		return product_price;
	}

	/**
	 * @param product_price the product_price to set
	 */
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	/**
	 * @return the product_sell_count
	 */
	public int getProduct_sell_count() {
		return product_sell_count;
	}

	/**
	 * @param product_sell_count the product_sell_count to set
	 */
	public void setProduct_sell_count(int product_sell_count) {
		this.product_sell_count = product_sell_count;
	}

	/**
	 * @return the product_qna_count
	 */
	public int getProduct_qna_count() {
		return product_qna_count;
	}

	/**
	 * @param product_qna_count the product_qna_count to set
	 */
	public void setProduct_qna_count(int product_qna_count) {
		this.product_qna_count = product_qna_count;
	}

	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}

	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	/**
	 * @return the product_detail
	 */
	public String getProduct_detail() {
		return product_detail;
	}

	/**
	 * @param product_detail the product_detail to set
	 */
	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}

	/**
	 * @return the file_path
	 */
	public String getFile_path() {
		return file_path;
	}

	/**
	 * @param file_path the file_path to set
	 */
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	/**
	 * @return the thumbnail_path
	 */
	public String getThumbnail_path() {
		return thumbnail_path;
	}

	/**
	 * @param thumbnail_path the thumbnail_path to set
	 */
	public void setThumbnail_path(String thumbnail_path) {
		this.thumbnail_path = thumbnail_path;
	}

	/**
	 * @return the admin_id
	 */
	public String getAdmin_id() {
		return admin_id;
	}

	/**
	 * @param admin_id the admin_id to set
	 */
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	/**
	 * @return the admin_pw
	 */
	public String getAdmin_pw() {
		return admin_pw;
	}

	/**
	 * @param admin_pw the admin_pw to set
	 */
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	
	

}
