package service.dto;

public class ClientDTO {
	private String clientId;		//고객 아이디
	private String clientName;		//고객 이름
	private String clientPhone;		//고객 핸드폰번호
	private String clientPasswd;	//고객 비밀번호
	private String addrGu;			//고객 주소_구
	private String addrDong;		//고객 주소_동
	
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
	public String getAddrGu() {
		return addrGu;
	}
	public void setAddrGu(String addrGu) {
		this.addrGu = addrGu;
	}
	public String getAddrDong() {
		return addrDong;
	}
	public void setAddrDong(String addrDong) {
		this.addrDong = addrDong;
	}
		
}
