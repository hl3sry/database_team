package menu;

public class MenuDto {
	private int menuCode;	//메뉴 코드(2001-3000), sequence로 자동생성
	private String menu;	//메뉴이름
	private int price;	//가격
	private int visible;	//노출 여부 0, 1
	private int famous;	//인기메뉴 여부 0, 1
	private int menuImage;	메뉴 사진
	private int cafeCode;		//카페코드(fk)
	//private int categoryCode;	//카테고리코드(fk)

	public MenuDto() {}
	public MenuDto(String m, int p, int v, int f, String i) {
		menu = m;
		price = p;
		visible = v;
		famous = f;
		menuImage = i;
	}
	public int getMenuCode() { return menuCode; }
	public String getMenu() { return menu; }
	public int getPrice() { return price; }
	public int getVisible() { return visible; }
	public int getFamous() { return famous; }
	public int getCafeCode() { return cafeCode; }
	public String getMenuImage() { return menuImage; }

	public void setMenuCode(int c) { menuCode = c; }
	public void setMenu(String m) { menu = m; }
	public void setPrice(int p) { price = p; }
	public void setVisible(int v) { visible = v; }
	public void setFamous(int f) { famous = f; }
	public void setCafeCode(int cc) { cafeCode = cc; }
	public void setMenuImage(String i) { menuImage = i; }
}