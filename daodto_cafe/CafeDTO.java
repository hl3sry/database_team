package dbptp_dao_dto;

//ī�� ������ ���� DTO
public class Cafe {
	private Integer cafeCode;					//ī���ڵ� (PK)
	private String ceoId;						//����ID (FK)
	private String cafeName = null;				//ī���̸�
	private String location = null;				//ī����ġ
	private String cafePhone;					//ī����ȭ��ȣ
	private String businessHours = null;		//�����ð�
	private String notice = null;				//��������
	private String logo = null;					//ī��ΰ�
	private String cafePhoto = null;			//ī�����
	
	public Integer getCafeCode() {
		return cafeCode;
	}
	public void setCafeCode(int cafeCode) {
		this.cafeCode = cafeCode;
	}
	
	public String getCeoId() {
		return ceoId;
	}
	public void setCeoId(String ceoId) {
		this.ceoId = ceoId;
	}
	
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCafePhone() {
		return cafePhone;
	}
	public void setCafePhone(String cafePhone) {
		this.cafePhone = cafePhone;
	}
	
	public String getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}
	
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getCafePhoto() {
		return cafePhoto;
	}
	public void setCafePhoto(String cafePhoto) {
		this.cafePhoto = cafePhoto;
	}
}