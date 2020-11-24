import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.*;

public class MenuImpl implements MenuDao {
	private JDBCUtil jdbcUtil = null;
	
	//MENU�� �⺻���� ����
	private static String query="SELECT MENU.MENUCODE AS MENU_CODE, " + 
	"MENU.MENU AS MENU_NAME, "+"MENU.PRICE AS MENU_PRICE, "+"MENU.MENUIMAGE AS MENU_IMAGE, "+
			"MENU.MENUDESCRIPTION AS MENU_DESCRIPTION ";
	
	public MenuImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<MenuDto> getMenuList() {
		String allQuery = query+", "+"MENU.CAFECODE AS MENU_CAFECODE "+"FROM MENU ORDER BY MENU.MENUCODE ASC";
		jdbcUtil.setSqlAndParameters(allQuery, null);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MenuDto> list=new ArrayList<MenuDto>();
			while (rs.next()) {
				MenuDto dto = new MenuDto();
				dto.setMenuCode(rs.getInt("MENU_CODE"));
				dto.setMenu(rs.getString("MENU_NAME"));
				dto.setPrice(rs.getInt("MENU_PRICE"));
				dto.setMenuImage(rs.getString("MENU_IMAGE"));
				dto.setMenuDescription(rs.getString("MENU_DESCRIPTION"));
				mto.setCafeCode(rs.getInt("MENU_CAFECODE"));
				list.add(dto);
			}
			return list;
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
	public MenuDto getMenuByNo(int m) {
		String searchQuery = query+", "+"CAFE.CAFENAME AS CAFE_NAME "+"FROM MENU, CAFE "+"WHERE MENU.CAFECODE=CAFE.CAFECODE";
		Object[] param=new Object[] {m};
		jdbcUtil.setSqlAndParameters(searchQuery, param);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			MenuDto mto = null;
			if (rs.next()) {
				mto = new MenuDto();
				mto.setMenuCode(rs.getInt("MENU_CODE"));
				mto.setMenu(rs.getString("MENU_NAME"));
				mto.setPrice(rs.getInt("MENU_PRICE"));
				mto.setMenuImage(rs.getString("MENU_IMAGE"));
				mto.setMenuDescription(rs.getString("MENU_DESCRIPTION"));
				mto.setCafeCode(rs.getInt("MENU_CAFECODE"));
				mto.setCafeName(rs.getString("CAFE_NAME"));
			}
			return mto;
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
	}
	
	public List<MenuDto> getMenuByName(String m) {
		String searchQuery = query + ", " + "CAFE.CAFENAME AS CAFE_NAME " +
			  "FROM MENU, CAFE " +
			  "WHERE MENU.MENU = ? AND " +
			        "MENU.CAFECODE = CAFE.CAFECODE";	 
		jdbcUtil.setSql(searchQuery);				// JDBCUtil �� query �� ����
		Object[] param = new Object[] { m };		// �л��� ã�� ���� �������� �̸��� ����
		jdbcUtil.setParameters(param);				// JDBCUtil �� query ���� �Ű����� ������ ����� �Ű����� ����

		try {
				ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
				MenuDto men = null;
				if (rs.next()) {
						men = new MenuDto();
						men.setMenuCode(rs.getInt("MENU_CODE"));
						men.setMenu(rs.getString("MENU_NAME"));
						men.setPrice(rs.getInt("MENU_PRICE"));
						men.setMenuImage(rs.getString("MENU_IMAGE"));
						men.setMenuDescription(rs.getString("MENU_DESCRIPTION"));
						men.setCafeName(rs.getString("CAFE_NAME"));
				}
				return men;
		} catch (Exception ex) {
				ex.printStackTrace();
		} finally {
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return null;
	}
	
	public int insertMenu(MenuDto m) {
		int result = 0;
		String insertQuery = "INSERT INTO MENU (MENUCODE, MENU, PRICE, MENUIMAGE, MENUDESCRIPTION, CAFECODE) " +
							 "VALUES (?, ?, ?, ?, ?, ?) ";

		CafeDao cafeDAO = new CafeDao();		// ī�� DAO ȹ��
		CafeDto cafeDto = new CafeDao.getCafeByName(m.getCafeName());
		
		String cCode = cafeDto.getCafeCode();		// �����ڵ带 ����
		if (cCode == null) {
			System.out.println("�ش� ī�䰡 �����ϴ�." + m.getCafeName());
			return 0;
		}
		
		// query ���� ����� �Ű����� ���� ���� �Ű����� �迭 ����
		Object[] param = new Object[] {m.getMenuCode(), m.getMenu(), 
							m.getPrice(), m.getMenuImage(), m.getMenuDescription(), cCode};		
		jdbcUtil.setSql(insertQuery);			// JDBCUtil �� insert �� ����
		jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert �� ����
			System.out.println(m.getMenuCode() + " �ڵ��� �޴������� ���ԵǾ����ϴ�.");
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return result;
	}
	
	public int updateMenu(MenuDto m) {
		String updateQuery = "UPDATE MENU SET ";
		int index = 0;
		Object[] tempParam = new Object[10];		// update ���� ����� �Ű������� ������ �� �ִ� �ӽ� �迭
		
		if (m.getMenu() != null) {		// �̸��� �����Ǿ� ���� ���
			updateQuery += "MENU = ?, ";		// update ���� �̸� ���� �κ� �߰�
			tempParam[index++] = m.getMenu();		// �Ű������� ������ �̸� �߰�
		}
		if (m.getPrice() != 0) {
			updateQuery += "PRICE = ?, ";	
			tempParam[index++] = m.getPrice();	
		}
		if (m.getMenuImage() != null) {
			updateQuery += "MENUIMAGE = ?, ";	
			tempParam[index++] = m.getMenuImage();
		}
		if (m.getMenuDescription() != null) {		
			updateQuery += "MENUDESCRIPTION = ?, ";	
			tempParam[index++] =m.getMenuDescription();
		}
		if (m.getCafeCode() != 0) {	
			updateQuery += "CAFECODE = ?, ";		
			tempParam[index++] = m.getCafeCode();
		}
		updateQuery += "WHERE MENUCODE = ? ";		// update ���� ���� ����
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update ���� where �� �տ� ���� �� �ִ� , ����
		
		tempParam[index++] = m.getMenuCode();		// ã�� ���ǿ� �ش��ϴ� �й��� ���� �Ű����� �߰�
		
		Object[] newParam = new Object[index];
		for (int i=0; i < newParam.length; i++)		// �Ű������� ������ŭ�� ũ�⸦ ���� �迭�� �����ϰ� �Ű����� �� ����
			newParam[i] = tempParam[i];
		
		jdbcUtil.setSql(updateQuery);			// JDBCUtil�� update �� ����
		jdbcUtil.setParameters(newParam);		// JDBCUtil �� �Ű����� ����
		
		try {
			int result = jdbcUtil.executeUpdate();		// update �� ����
			return result;			// update �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return 0;
	}
	
	public int deleteMenu(int m) {
		String deleteQuery = "DELETE FROM STUDENT WHERE MENUCODE = ?";
		
		jdbcUtil.setSql(deleteQuery);			// JDBCUtil �� query �� ����
		Object[] param = new Object[] {m};
		jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return 0;
	}
}