package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO{
	private JDBCUtil jdbcUtil = null;
	private static String query = "SELECT CATEGORYCODE, CATEGORYNAME, CATEGORYDESCRIPTION FROM CATEGORY ";
	
	 CategoryDAOImpl(){
		 jdbcUtil = new JDBCUtil();
	 }
	 public List<CategoryDTO> getCategoryList(){
		 
		 jdbcUtil.setSql(query);
		 try { 
				ResultSet rs = jdbcUtil.executeQuery();				
				List<CategoryDTO> list = new ArrayList<CategoryDTO>();		
					CategoryDTO dto = new CategoryDTO();		
					dto.setCategoryCode(rs.getInt("CATEGORYCODE"));
					dto.setCategoryName(rs.getString("CATEGORYNAME"));
					dto.setCategoryDescription(rs.getString("CATEGORYDESCRIPTION"));
					
					list.add(dto);		
				return list;		
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
			}		
			return null;	
		 
	 }	// 전체 학과 정보를 획득
		public int insertCategory(CategoryDTO Category) {
			int result = 0;
			String insertQuery = "INSERT INTO CATEGORY (CATEGORYCODE, CATEGORYNAME, CATEGORYDESCRIPTION) " +
								 "VALUES (CATEGORYCODE_SEQ.NEXTVAL, ?, ? ) ";
			
			Object[] param = new Object[] {Category.getCategoryName(),Category.getCategoryDescription()};
			jdbcUtil.setSql(insertQuery);			// JDBCUtil 에 insert 문 설정
			jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
					
			try {				
				result = jdbcUtil.executeUpdate();		// insert 문 실행
				System.out.println(Category.getCategoryName() + " 카테고리가 삽입되었습니다.");
			} catch (SQLException ex) {
				System.out.println("입력오류 발생!!!");
				if (ex.getErrorCode() == 1)
					System.out.println("동일한 카테고리가 이미 존재합니다."); 
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {		
				jdbcUtil.commit();
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
			}		
			return result;		// insert 에 의해 반영된 레코드 수 반환	
			
			
		}
		public int updateCategory(CategoryDTO Category) {
			String updateQuery = "UPDATE CATEGORY SET ";
			int index = 0;
			Object[] tempParam = new Object[10];		// update 문에 사용할 매개변수를 저장할 수 있는 임시 배열
			
			if (Category.getCategoryName() != null) {		// 이름이 설정되어 있을 경우
				updateQuery += "CATEGORYNAME = ?, ";		// update 문에 이름 수정 부분 추가
				tempParam[index++] = Category.getCategoryName();		// 매개변수에 수정할 이름 추가
			}
			if (Category.getCategoryDescription() != null) {		// 이름이 설정되어 있을 경우
				updateQuery += "CATEGORYDESCRIPTION = ?, ";		// update 문에 이름 수정 부분 추가
				tempParam[index++] = Category.getCategoryDescription();		// 매개변수에 수정할 이름 추가
			}
			
			updateQuery += "WHERE CATEGORYCODE = ? ";		// update 문에 조건 지정
			updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update 문의 where 절 앞에 있을 수 있는 , 제거
			
			tempParam[index++] = Category.getCategoryCode();		// 찾을 조건에 해당하는 학번에 대한 매개변수 추가
			
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
		public int deleteCategory(int categoryCode) {
			String deleteQuery = "DELETE FROM CATEOGRY WHERE CATEGORYCODE = ?";
			
			jdbcUtil.setSql(deleteQuery);			// JDBCUtil 에 query 문 설정
			Object[] param = new Object[] {categoryCode};
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
		public CategoryDTO getCategoryByName(String categoryName) {
			String searchQuery = query + 
				  " WHERE CATEGORYNAME = ?";
			jdbcUtil.setSql(searchQuery);				// JDBCUtil 에 query 문 설정
			Object[] param = new Object[] { categoryName };		// 학생을 찾기 위한 조건으로 이름을 설정
			jdbcUtil.setParameters(param);				// JDBCUtil 에 query 문의 매개변수 값으로 사용할 매개변수 설정
			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행
				CategoryDTO stu = null;
				if (rs.next()) {						
					stu = new CategoryDTO();
					stu.setCategoryCode(rs.getInt("CATEGORYCODE"));
					stu.setCategoryName(rs.getString("CATEGORYNAME"));
					stu.setCategoryDescription(rs.getString("CATEGORYDESCRIPTION"));
					
				}
				return stu;				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		
			}
			return null;
		}
		public CategoryDTO getCategoryByCode(String categoryCode) {
			String searchQuery = query + " WHERE CATEGORYCODE = ?";
			jdbcUtil.setSql(searchQuery); // JDBCUtil 에 query 문 설정
			Object[] param = new Object[] { categoryCode }; // 학생을 찾기 위한 조건으로 이름을 설정
			jdbcUtil.setParameters(param); // JDBCUtil 에 query 문의 매개변수 값으로 사용할 매개변수 설정
			try {
				ResultSet rs = jdbcUtil.executeQuery(); // query 문 실행
				CategoryDTO stu = null;
				if (rs.next()) {
					stu = new CategoryDTO();
					stu.setCategoryCode(rs.getInt("CATEGORYCODE"));
					stu.setCategoryName(rs.getString("CATEGORYNAME"));
					stu.setCategoryDescription(rs.getString("CATEGORYDESCRIPTION"));
				}
				return stu;
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();
			}
			return null;

		}
	
}
			
