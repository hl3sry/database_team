package service.dto;

public class ClientDTO {
	private String clientId;		//�� ���̵�
	private String clientName;		//�� �̸�
	private String clientPhone;		//�� �ڵ�����ȣ
	private String clientPasswd;	//�� ��й�ȣ
	private String addrGu;			//�� �ּ�_��
	private String addrDong;		//�� �ּ�_��
	
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
