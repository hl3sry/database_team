package menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class MenuDao {
	private DataSource ds;
	
	public MenuDao() throws Exception {
		Context init = new InitialContext();
		ds =(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			//팀 db주소 넣기
	}	
	
	public int create(MenuDto menu) throws SQLException {	//메뉴 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT INTO MENU (menuCode, menu, price, visible, famous, menuImage, cafeCode) VALUES ");
			insertQuery.append("(menuCode_seq.nextVal, ?, ?, ?, ?, ?, ?)");	//카페코드는 카페테이블에서 생성된 번호를 사장이 직접 입력
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setInt(1, menu.getMenuCode());
			pstmt.setString(2, menu.getMenu());
			pstmt.setInt(3, menu.getPrice());
			pstmt.setInt(4, menu.getVisible());
			pstmt.setInt(5, menu.getFamous());
			pstmt.setString(6, menu.getMenuImage());
			pstmt.setInt(7, menu.getCafeCode());

			int result = pstmt.executeUpdate();
			return result;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}
			if ( con != null ){
				con.close();
			}
		}
	}

	public int update(MenuDto menu) throws SQLException {	//메뉴 수정
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer updateQuery = new StringBuffer();
			updateQuery.append("UPDATE MENU SET ");
			updateQuery.append("menu=?, price=?, visible=?, famous=?, menuImage=? ");
			updateQuery.append("WHERE menuCode=? and cafeCode=?");
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, menu.getMenu());
			pstmt.setInt(2, menu.getPrice());
			pstmt.setInt(3, menu.getVisible());
			pstmt.setInt(4, menu.getFamous());
			pstmt.setString(5, menu.getMenuImage());
			pstmt.setInt(6, menu.getMenuCode());
			pstmt.setInt(7, menu.getCafeCode());

			int result = pstmt.executeUpdate();
			return result;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}
			if ( con != null ){
				con.close();
			}
		}
	}

	public int remove(int menuCode, int cafeCode) throws SQLException {	//메뉴 삭제
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer removeQuery = new StringBuffer();
			removeQuery.append("DELETE FROM MENU ");
			removeQuery.append("WHERE menuCode=? and cafeCode=?");		
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(removeQuery.toString());
			pstmt.setInt(1, menuCode);
			pstmt.setInt(2, cafeCode);
	
			int result = pstmt.executeUpdate();			
			return result;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}
			if ( con != null ){
				con.close();
			}
		}
	}

	public MenuDto findMenu(int menuCode, int cafeCode) throws SQLException {
	//메뉴 정보를 찾아 반환
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT menu, price, visible, famous, menuImage ");
			findQuery.append("FROM MENU");
			findQuery.append("WHERE menuCode=? and cafeCode=?");		
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setInt(1, menuCode);
			pstmt.setInt(2, cafeCode);
	
			rs = pstmt.executeQuery();
			
			MenuDto menu = null;
			if ( rs.next() ){
				menu = new MenuDto();
				menu.setMenuCode(menuCode);
				menu.setCafeCode(cafeCode);
				menu.setMenu(rs.getString("menu"));
				menu.setPrice(rs.getInt("price"));
				menu.setVisible(rs.getInt("visible"));
				menu.setFamous(rs.getInt("famous"));
				menu.setMenuImage(rs.getString("menuImage"));
			}
			return menu;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}

	public List<MenuDto> findMenuList(int currentPage, int countPerPage) throws SQLException {	//전체 메뉴 리스트 만들어 반환
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT menuCode, cafeCode, menu, price, visible, famous, menuImage ");
			findQuery.append("FROM MENU ");
			findQuery.append("ORDER BY cafeCode");	//한 카페의 메뉴들만 보이게
	
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );		
			rs = pstmt.executeQuery();

			int start = ((currentPage-1) * countPerPage) + 1;
			
			List<MenuDto> MenuList = null;
			if ( (start >= 0) && rs.absolute(start) ) {
				MenuList = new ArrayList<MenuDto>();				
				do {
					MenuDto menu = new MenuDto();
					menu.setMenuCode(rs.getInt("menuCode"));
					menu.setCafeCode(rs.getInt("cafeCode"));
					menu.setMenu(rs.getString("menu"));
					menu.setPrice(rs.getInt("price"));
					menu.setVisible(rs.getInt("visible"));
					menu.setFamous(rs.getInt("famous"));
					menu.setMenuImage(rs.getString("menuImage"));	
					MenuList.add(menu);
				} while ( (rs.next()) && (--countPerPage > 0));	
			}
			return MenuList;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
}