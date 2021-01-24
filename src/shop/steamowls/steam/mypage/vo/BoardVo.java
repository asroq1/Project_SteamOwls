package shop.steamowls.steam.mypage.vo;

public class BoardVo {

	private int board_sq;
	private int member_sq;
	private String member_id;
	private String board_subject;
	private String board_content;
	private String board_address;
	private String board_dttm;
	private boolean board_del_fl;
	private int answer_sq;
	private boolean answer_fl;
	private String answer_content;
	private String answer_dttm;
	

	public BoardVo() {

	}


	public int getBoard_sq() {
		return board_sq;
	}


	public void setBoard_sq(int board_sq) {
		this.board_sq = board_sq;
	}


	public String getBoard_subject() {
		return board_subject;
	}


	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}


	public String getBoard_content() {
		return board_content;
	}


	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}


	public String getBoard_address() {
		return board_address;
	}


	public void setBoard_address(String board_address) {
		this.board_address = board_address;
	}



	public String getBoard_dttm() {
		return board_dttm;
	}


	public void setBoard_dttm(String board_dttm) {
		this.board_dttm = board_dttm;
	}


	public boolean isBoard_del_fl() {
		return board_del_fl;
	}


	public void setBoard_del_fl(boolean board_del_fl) {
		this.board_del_fl = board_del_fl;
	}


	public int getMember_sq() {
		return member_sq;
	}


	public void setMember_sq(int member_sq) {
		this.member_sq = member_sq;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public int getAnswer_sq() {
		return answer_sq;
	}


	public void setAnswer_sq(int answer_sq) {
		this.answer_sq = answer_sq;
	}


	public boolean isAnswer_fl() {
		return answer_fl;
	}


	public void setAnswer_fl(boolean answer_fl) {
		this.answer_fl = answer_fl;
	}


	public String getAnswer_content() {
		return answer_content;
	}


	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}


	public String getAnswer_dttm() {
		return answer_dttm;
	}


	public void setAnswer_dttm(String answer_dttm) {
		this.answer_dttm = answer_dttm;
	}



	
}
