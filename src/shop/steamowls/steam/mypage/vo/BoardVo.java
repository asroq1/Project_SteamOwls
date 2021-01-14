package shop.steamowls.steam.mypage.vo;

public class BoardVo {

	private int board_sq;
	private String board_subject;
	private String board_content;
	private String board_address;
	private String board_dttm;
	private boolean board_del_fl;
	

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


	
}
