public class MenuDto {
	private int menuCode;	//�޴� �ڵ�(2001-3000), sequence�� �ڵ�����
	private String menu;	//�޴��̸�
	private int price;	//����
	private String menuImage;	//�޴� ����
	private String menuDescription; //�޴� ����
	private int cafeCode;		//ī���ڵ�(fk)
	private String cafeName; //ī���̸� from cafe table
	
	public int getMenuCode() { return menuCode; }
	public String getMenu() { return menu; }
	public int getPrice() { return price; }
	public int getCafeCode() { return cafeCode; }
	public String getMenuImage() { return menuImage; }
	public String getMenuDescription() {return menuDescription; }
	public String getCafeName() {return cafeName;}
	
	public void setMenuCode(int c) { menuCode = c; }
	public void setMenu(String m) { menu = m; }
	public void setPrice(int p) { price = p; }
	public void setCafeCode(int cc) { cafeCode = cc; }
	public void setMenuImage(String i) { menuImage = i; }
	public void setMenuDescription(String d) {menuDescription=d;}
	public void setCafeName(String n) {cafeName = n;}
}