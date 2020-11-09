package persistence;

public class OrderDetailDTO {
	private int menuCode;
	private int orderCode;
	private int cafeCode;
	private String clientId;
	private int OrderPrice = -1;
	private int quantity = -1;
	private int size = 1;
	private int shot = 0;
	private int hot = 1;
	public int getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}
	public int getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	public int getCafeCode() {
		return cafeCode;
	}
	public void setCafeCode(int cafeCode) {
		this.cafeCode = cafeCode;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public int getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(int OrderPrice) {
		this.OrderPrice = OrderPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getShot() {
		return shot;
	}
	public void setShot(int shot) {
		this.shot = shot;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	
	
	
	
	
	
	
}
