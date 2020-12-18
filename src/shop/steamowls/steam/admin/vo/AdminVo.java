package shop.steamowls.steam.admin.vo;

public class AdminVo {

	private int sq;
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private boolean sms_fl;
	private boolean info_fl;
	private String dttm;
	private boolean del_fl;
	private boolean admin_fl;

	public AdminVo() {

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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isSms_fl() {
		return sms_fl;
	}

	public void setSms_fl(boolean sms_fl) {
		this.sms_fl = sms_fl;
	}

	public boolean isInfo_fl() {
		return info_fl;
	}

	public void setInfo_fl(boolean info_fl) {
		this.info_fl = info_fl;
	}

	public String getDttm() {
		return dttm;
	}

	public void setDttm(String dttm) {
		this.dttm = dttm;
	}

	public boolean isDel_fl() {
		return del_fl;
	}

	public void setDel_fl(boolean del_fl) {
		this.del_fl = del_fl;
	}

	public boolean isAdmin_fl() {
		return admin_fl;
	}

	public void setAdmin_fl(boolean admin_fl) {
		this.admin_fl = admin_fl;
	}

}
