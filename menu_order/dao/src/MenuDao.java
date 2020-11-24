import java.util.List;

public interface MenuDao {
	public List<MenuDto> getMenuList();
	public MenuDto getMenuByNo(int m);
	public List<MenuDto> getMenuByName(String m);
	public int insertMenu(MenuDto m);
	public int updateMenu(MenuDto m);
	public int deleteMenu(int m);
}