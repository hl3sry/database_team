package order;
public class orderDto {
	private int orderCode;		//주문코드(3001-4000), sequence로 자동생성
	private String orderDate;	//주문일(월, 일, 시, 분)
	private int orderCheck;		//주문 처리 여부 0, 1
	private String pickDate;		//픽업 날짜(월, 일, 시, 분)
	private String clientId;		//고객 아이디(fk)

	public orderDto() {}
	public orderDto( String od, int oc, String pd ) {
		orderDate = od;
		orderCheck = oc;
		pickDate = pd;
	}
	public int getOrderCode() { return orderCode; }
	public String getOrderDate() { return orderDate; }
	public int getOrderCheck() { return orderCheck; }
	public String getPickDate() { return pickDate; }
	public String getClientId() { return clientId; }

	public void setOrderCode(int c) { orderCode = c; }
	public void setOrderDate(String od) { orderDate = od; }
	public void setOrderCheck(int oc) { orderCheck = oc; }
	public void setPickDate(String pd) { pickDate = pd; }
	public void setClientId(String id) { clientId = id; }
}