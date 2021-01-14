package shop.steamowls.steam.booking.vo;

public class BookingVo {

	private int booking_sq;
	private int member_sq;
	private String booking_date;
	private String booking_start;
	private int booking_people;
	private int product_sq;
	private int product_price;
	private String product_name;
	private String product_time;
	private String product_detail;
	private int product_people;
	private int booked_people;
	private int left_people;
	private String product_imagePath;
<<<<<<< Updated upstream
=======
	private String id;
	private String tel;
	private String name;
	private String gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
>>>>>>> Stashed changes

	public BookingVo() {

	}

	public int getBooking_sq() {
		return booking_sq;
	}

	public void setBooking_sq(int booking_sq) {
		this.booking_sq = booking_sq;
	}

	public int getMember_sq() {
		return member_sq;
	}

	public void setMember_sq(int member_sq) {
		this.member_sq = member_sq;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public String getBooking_start() {
		return booking_start;
	}

	public void setBooking_start(String booking_start) {
		this.booking_start = booking_start;
	}

	public int getBooking_people() {
		return booking_people;
	}

	public void setBooking_people(int booking_people) {
		this.booking_people = booking_people;
	}

	public int getProduct_sq() {
		return product_sq;
	}

	public void setProduct_sq(int product_sq) {
		this.product_sq = product_sq;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_time() {
		return product_time;
	}

	public void setProduct_time(String product_time) {
		this.product_time = product_time;
	}

	public String getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}

	public String getProduct_imagePath() {
		return product_imagePath;
	}

	public void setProduct_imagePath(String product_imagePath) {
		this.product_imagePath = product_imagePath;
	}

	public int getProduct_people() {
		return product_people;
	}

	public void setProduct_people(int product_people) {
		this.product_people = product_people;
	}

	public int getBooked_people() {
		return booked_people;
	}

	public void setBooked_people(int booked_people) {
		this.booked_people = booked_people;
	}

	public int getLeft_people() {
		return left_people;
	}

	public void setLeft_people(int left_people) {
		this.left_people = left_people;
	}

}