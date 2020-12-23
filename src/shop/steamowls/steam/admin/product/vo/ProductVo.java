package shop.steamowls.steam.admin.product.vo;

public class ProductVo {

	private int sq; // 이 세개는 member관련 vo
	private String id; //
	private String pw; //
	private int product_sq; // 이밑의 나머지는 상품관련 vo
	private boolean status_fl;
	private int product_price;
	private int product_sell_count;
	private int product_qna_count;
	private int product_people;
	private String product_name;
	private String product_detail;
	private String product_image;
	private String product_originalImage;
	private String product_imagePath;

	/**
	 * @return the file
	 */
	public String getProduct_image() {
		return product_image;
	}

	/**
	 * @param file the file to set
	 */
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	/**
	 * @return the originalFile
	 */
	public String getProduct_originalImage() {
		return product_originalImage;
	}

	/**
	 * @param originalFile the originalFile to set
	 */
	public void setProduct_originalImage(String product_originalImage) {
		this.product_originalImage = product_originalImage;
	}

	/**
	 * @return the path
	 */
	public String getProduct_imagePath() {
		return product_imagePath;
	}

	/**
	 * @param path the path to set
	 */
	public void setProduct_imagePath(String product_imagePath) {
		this.product_imagePath = product_imagePath;
	}

	/**
	 * @return the product_people
	 */
	public int getProduct_people() {
		return product_people;
	}

	/**
	 * @param product_people the product_people to set
	 */
	public void setProduct_people(int product_people) {
		this.product_people = product_people;
	}

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

}
