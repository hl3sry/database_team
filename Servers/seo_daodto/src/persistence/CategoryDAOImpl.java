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
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
			}		
			return null;	
		 
	 }	// ��ü �а� ������ ȹ��
		public int insertCategory(CategoryDTO Category) {
			int result = 0;
			String insertQuery = "INSERT INTO CATEGORY (CATEGORYCODE, CATEGORYNAME, CATEGORYDESCRIPTION) " +
								 "VALUES (CATEGORYCODE_SEQ.NEXTVAL, ?, ? ) ";
			
			Object[] param = new Object[] {Category.getCategoryName(),Category.getCategoryDescription()};
			jdbcUtil.setSql(insertQuery);			// JDBCUtil �� insert �� ����
			jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
					
			try {				
				result = jdbcUtil.executeUpdate();		// insert �� ����
				System.out.println(Category.getCategoryName() + " ī�װ��� ���ԵǾ����ϴ�.");
			} catch (SQLException ex) {
				System.out.println("�Է¿��� �߻�!!!");
				if (ex.getErrorCode() == 1)
					System.out.println("������ ī�װ��� �̹� �����մϴ�."); 
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {		
				jdbcUtil.commit();
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
			}		
			return result;		// insert �� ���� �ݿ��� ���ڵ� �� ��ȯ	
			
			
		}
		public int updateCategory(CategoryDTO Category) {
			String updateQuery = "UPDATE CATEGORY SET ";
			int index = 0;
			Object[] tempParam = new Object[10];		// update ���� ����� �Ű������� ������ �� �ִ� �ӽ� �迭
			
			if (Category.getCategoryName() != null) {		// �̸��� �����Ǿ� ���� ���
				updateQuery += "CATEGORYNAME = ?, ";		// update ���� �̸� ���� �κ� �߰�
				tempParam[index++] = Category.getCategoryName();		// �Ű������� ������ �̸� �߰�
			}
			if (Category.getCategoryDescription() != null) {		// �̸��� �����Ǿ� ���� ���
				updateQuery += "CATEGORYDESCRIPTION = ?, ";		// update ���� �̸� ���� �κ� �߰�
				tempParam[index++] = Category.getCategoryDescription();		// �Ű������� ������ �̸� �߰�
			}
			
			updateQuery += "WHERE CATEGORYCODE = ? ";		// update ���� ���� ����
			updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update ���� where �� �տ� ���� �� �ִ� , ����
			
			tempParam[index++] = Category.getCategoryCode();		// ã�� ���ǿ� �ش��ϴ� �й��� ���� �Ű����� �߰�
			
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
		public int deleteCategory(int categoryCode) {
			String deleteQuery = "DELETE FROM CATEOGRY WHERE CATEGORYCODE = ?";
			
			jdbcUtil.setSql(deleteQuery);			// JDBCUtil �� query �� ����
			Object[] param = new Object[] {categoryCode};
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
		public CategoryDTO getCategoryByName(String categoryName) {
			String searchQuery = query + 
				  " WHERE CATEGORYNAME = ?";
			jdbcUtil.setSql(searchQuery);				// JDBCUtil �� query �� ����
			Object[] param = new Object[] { categoryName };		// �л��� ã�� ���� �������� �̸��� ����
			jdbcUtil.setParameters(param);				// JDBCUtil �� query ���� �Ű����� ������ ����� �Ű����� ����
			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
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
			jdbcUtil.setSql(searchQuery); // JDBCUtil �� query �� ����
			Object[] param = new Object[] { categoryCode }; // �л��� ã�� ���� �������� �̸��� ����
			jdbcUtil.setParameters(param); // JDBCUtil �� query ���� �Ű����� ������ ����� �Ű����� ����
			try {
				ResultSet rs = jdbcUtil.executeQuery(); // query �� ����
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
			
