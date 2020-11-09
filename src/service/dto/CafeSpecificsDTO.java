package service.dto;

public class CafeSpecificsDTO {
	private int cafeCode;		//카페코드
	private int parking;		//주차
	private int drivethru;		//드라이브
	private int noKidsZone;		//노키즈존
	private int withDog;		//애견동반
	
	public int getCafeCode() {
		return cafeCode;
	}
	public void setCafeCode(int cafeCode) {
		this.cafeCode = cafeCode;
	}
	public int getParking() {
		return parking;
	}
	public void setParking(int parking) {
		this.parking = parking;
	}
	public int getDrivethru() {
		return drivethru;
	}
	public void setDrivethru(int drivethru) {
		this.drivethru = drivethru;
	}
	public int getNoKidsZone() {
		return noKidsZone;
	}
	public void setNoKidsZone(int noKidsZone) {
		this.noKidsZone = noKidsZone;
	}
	public int getWithDog() {
		return withDog;
	}
	public void setWithDog(int withDog) {
		this.withDog = withDog;
	}
	
	
}
