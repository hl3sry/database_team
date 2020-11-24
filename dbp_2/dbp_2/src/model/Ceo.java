package model;

public class Ceo {
	private String ceoId;
	private String name;
	private String password;
	private String phone;
	private String ceoNum;

	public Ceo() {
	} // 기본 생성자

	public Ceo(String ceoId, String name, String phone, String ceoNum, String password) {
		this.ceoId = ceoId;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.ceoNum = ceoNum;
	}

	public void update(Ceo updateCeo) {
		this.name = updateCeo.name;
		this.password = updateCeo.password;
		this.phone = updateCeo.phone;
		this.ceoNum = updateCeo.ceoNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCeoId() {
		return ceoId;
	}

	public void setCeoId(String ceoId) {
		this.ceoId = ceoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCeoNum() {
		return ceoNum;
	}

	public void setCeoNum(String ceoNum) {
		this.ceoNum = ceoNum;
	}

	/* 비밀번호 검사 */
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}

	public boolean isSameUser(String ceoId) {
		return this.ceoId.equals(ceoId);
	}

	@Override
	public String toString() {
		return "Ceo [ceoId=" + ceoId + ", name=" + name + ", phone=" + phone + ", ceoNum=" + ceoNum + ", password="
				+ password + "]";
	}
}
