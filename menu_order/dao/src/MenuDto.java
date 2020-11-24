public class MenuDto {
	private int menuCode;	//메뉴 코드(2001-3000), sequence로 자동생성
	private String menu;	//메뉴이름
	private int price;	//가격
	private String menuImage;	//메뉴 사진
	private String menuDescription; //메뉴 설명
	private int cafeCode;		//카페코드(fk)
	private String cafeName; //카페이름 from cafe table
	
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