package service.dto;

public class ClientDTO {
	private String clientId;		//고객 아이디
	private String clientName;		//고객 이름
	private String clientPhone;		//고객 핸드폰번호
	private String clientPasswd;	//고객 비밀번호
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public String getClientPasswd() {
		return clientPasswd;
	}
	public void setClientPasswd(String clientPasswd) {
		this.clientPasswd = clientPasswd;
	}
	
	
}
