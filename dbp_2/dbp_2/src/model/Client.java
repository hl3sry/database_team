package model;

public class Client {
	private String clientId;
	private String name;
	private String phone;
	private String password;
	private String addrgu;
	private String addrdong;

	public Client() {
	} // 기본 생성자

	public Client(String clientId, String name, String phone, String password, String addrgu, String addrdong) {
		this.clientId = clientId;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.addrgu = addrgu;
		this.addrdong = addrdong;
	}

	public void update(Client updateClient) {
		this.password = updateClient.password;
		this.name = updateClient.name;
		this.phone = updateClient.phone;
		this.addrgu = updateClient.addrgu;
		this.addrdong = updateClient.addrdong;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddrgu() {
		return addrgu;
	}

	public void setAddrgu(String addrgu) {
		this.addrgu = addrgu;
	}

	public String getAddrdong() {
		return addrdong;
	}

	public void setAddrdong(String addrdong) {
		this.addrdong = addrdong;
	}

	/* 비밀번호 검사 */
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}

	public boolean isSameUser(String clientId) {
		return this.clientId.equals(clientId);
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", phone=" + phone + ", password=" + password
				+ ", addrgu=" + addrgu + ", addrdong=" + addrdong + "]";
	}
}
