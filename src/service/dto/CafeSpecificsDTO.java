package service.dto;

public class CafeSpecificsDTO {
	private int cafeCode;		//ī���ڵ�
	private int parking;		//����
	private int drivethru;		//����̺�
	private int noKidsZone;		//��Ű����
	private int withDog;		//�ְߵ���
	
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
