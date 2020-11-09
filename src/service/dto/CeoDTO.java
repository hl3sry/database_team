package service.dto;

public class CeoDTO {
	private String ceoId;			//사장 아이디
	private String ceoName;			//사장 이름
	private String ceoPasswd;		//사장 비밀번호
	private String ceoPhone;		//사장 핸드폰번호
	private String registrationNum;	//사업자등록번호
	
	public String getCeoId() {
		return ceoId;
	}
	public void setCeoId(String ceoId) {
		this.ceoId = ceoId;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public String getCeoPasswd() {
		return ceoPasswd;
	}
	public void setCeoPasswd(String ceoPasswd) {
		this.ceoPasswd = ceoPasswd;
	}
	public String getCeoPhone() {
		return ceoPhone;
	}
	public void setCeoPhone(String ceoPhone) {
		this.ceoPhone = ceoPhone;
	}
	public String getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}
	
	
}
