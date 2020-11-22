package model;

public class Ceo {
	private String userId;
	private String password;
	private String email;
	private String phone;
	private String ceoNum;

	public Ceo() {
	} // 기본 생성자

	public Ceo(String userId, String password, String email, String phone, String ceoNum) {
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.ceoNum = ceoNum;
	}

	public void update(Ceo updateCeo) {
		this.password = updateCeo.password;
		this.email = updateCeo.email;
		this.phone = updateCeo.phone;
		this.ceoNum = updateCeo.ceoNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isSameUser(String userid) {
		return this.userId.equals(userid);
	}

	@Override
	public String toString() {
		return "Ceo [userId=" + userId + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", ceoNum=" + ceoNum + "]";
	}
}
