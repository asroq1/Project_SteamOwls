package shop.steamowls.steam.admin.member.vo;

public class MemberVo {
	
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

	public MemberVo() {

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the sms_fl
	 */
	public boolean isSms_fl() {
		return sms_fl;
	}

	/**
	 * @param sms_fl the sms_fl to set
	 */
	public void setSms_fl(boolean sms_fl) {
		this.sms_fl = sms_fl;
	}

	/**
	 * @return the info_fl
	 */
	public boolean isInfo_fl() {
		return info_fl;
	}

	/**
	 * @param info_fl the info_fl to set
	 */
	public void setInfo_fl(boolean info_fl) {
		this.info_fl = info_fl;
	}

	/**
	 * @return the dttm
	 */
	public String getDttm() {
		return dttm;
	}

	/**
	 * @param dttm the dttm to set
	 */
	public void setDttm(String dttm) {
		this.dttm = dttm;
	}

	/**
	 * @return the del_fl
	 */
	public boolean isDel_fl() {
		return del_fl;
	}

	/**
	 * @param del_fl the del_fl to set
	 */
	public void setDel_fl(boolean del_fl) {
		this.del_fl = del_fl;
	}

	/**
	 * @return the admin_fl
	 */
	public boolean isAdmin_fl() {
		return admin_fl;
	}

	/**
	 * @param admin_fl the admin_fl to set
	 */
	public void setAdmin_fl(boolean admin_fl) {
		this.admin_fl = admin_fl;
	}

}
