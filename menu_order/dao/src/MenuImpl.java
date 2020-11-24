import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.*;

public class MenuImpl implements MenuDao {
	private JDBCUtil jdbcUtil = null;
	
	//MENU의 기본정보 포함
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
		jdbcUtil.setSql(searchQuery);				// JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { m };		// 학생을 찾기 위한 조건으로 이름을 설정
		jdbcUtil.setParameters(param);				// JDBCUtil 에 query 문의 매개변수 값으로 사용할 매개변수 설정

		try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행
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
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return null;
	}
	
	public int insertMenu(MenuDto m) {
		int result = 0;
		String insertQuery = "INSERT INTO MENU (MENUCODE, MENU, PRICE, MENUIMAGE, MENUDESCRIPTION, CAFECODE) " +
							 "VALUES (?, ?, ?, ?, ?, ?) ";

		CafeDao cafeDAO = new CafeDao();		// 카페 DAO 획득
		CafeDto cafeDto = new CafeDao.getCafeByName(m.getCafeName());
		
		String cCode = cafeDto.getCafeCode();		// 교수코드를 설정
		if (cCode == null) {
			System.out.println("해당 카페가 없습니다." + m.getCafeName());
			return 0;
		}
		
		// query 문에 사용할 매개변수 값을 갖는 매개변수 배열 생성
		Object[] param = new Object[] {m.getMenuCode(), m.getMenu(), 
							m.getPrice(), m.getMenuImage(), m.getMenuDescription(), cCode};		
		jdbcUtil.setSql(insertQuery);			// JDBCUtil 에 insert 문 설정
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(m.getMenuCode() + " 코드의 메뉴정보가 삽입되었습니다.");
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;
	}
	
	public int updateMenu(MenuDto m) {
		String updateQuery = "UPDATE MENU SET ";
		int index = 0;
		Object[] tempParam = new Object[10];		// update 문에 사용할 매개변수를 저장할 수 있는 임시 배열
		
		if (m.getMenu() != null) {		// 이름이 설정되어 있을 경우
			updateQuery += "MENU = ?, ";		// update 문에 이름 수정 부분 추가
			tempParam[index++] = m.getMenu();		// 매개변수에 수정할 이름 추가
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
		updateQuery += "WHERE MENUCODE = ? ";		// update 문에 조건 지정
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update 문의 where 절 앞에 있을 수 있는 , 제거
		
		tempParam[index++] = m.getMenuCode();		// 찾을 조건에 해당하는 학번에 대한 매개변수 추가
		
		Object[] newParam = new Object[index];
		for (int i=0; i < newParam.length; i++)		// 매개변수의 개수만큼의 크기를 갖는 배열을 생성하고 매개변수 값 복사
			newParam[i] = tempParam[i];
		
		jdbcUtil.setSql(updateQuery);			// JDBCUtil에 update 문 설정
		jdbcUtil.setParameters(newParam);		// JDBCUtil 에 매개변수 설정
		
		try {
			int result = jdbcUtil.executeUpdate();		// update 문 실행
			return result;			// update 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return 0;
	}
	
	public int deleteMenu(int m) {
		String deleteQuery = "DELETE FROM STUDENT WHERE MENUCODE = ?";
		
		jdbcUtil.setSql(deleteQuery);			// JDBCUtil 에 query 문 설정
		Object[] param = new Object[] {m};
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete 문 실행
			return result;						// delete 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}
}