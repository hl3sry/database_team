package dbptp_dao_dto;

//카페 정보를 위한 DTO
public class Cafe {
	private Integer cafeCode;					//카페코드 (PK)
	private String ceoId;						//사장ID (FK)
	private String cafeName = null;				//카페이름
	private String location = null;				//카페위치
	private String cafePhone;					//카페전화번호
	private String businessHours = null;		//영업시간
	private String notice = null;				//공지사항
	private String logo = null;					//카페로고
	private String cafePhoto = null;			//카페사진
	
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