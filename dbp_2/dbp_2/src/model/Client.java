package model;

public class Client {
	private String userId;
	private String password;
	private String email;
	private String phone;

	public Client() { } // 기본 생성자

	public Client(String userId, String password, String email, String phone) {
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public void update(Client updateClient) {
		this.password = updateClient.password;
		this.email = updateClient.email;
		this.phone = updateClient.phone;
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
		return "Client [userId=" + userId + ", password=" + password + ", email=" + email + ", phone="
				+ phone + "]";
	}
}
