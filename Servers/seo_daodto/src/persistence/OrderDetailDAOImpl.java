package persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class OrderDetailDAOImpl implements OrderDetailDAO{
	private JDBCUtil jdbcUtil = null;
	private static String query = "SELECT ORDERCODE, MENUCODE, CAFECODE, CLIENTID, QUANTITIY, ORDERPRICE, SIZE, SHOT, HOT FROM ORDERDETAIL ";
	
	OrderDetailDAOImpl(){
		 jdbcUtil = new JDBCUtil();
	 }
	 public List<OrderDetailDTO> getOrderDetailList(){
		 jdbcUtil.setSql(query);
		 try { 
				ResultSet rs = jdbcUtil.executeQuery();				
				List<OrderDetailDTO> list = new ArrayList<OrderDetailDTO>();		
				OrderDetailDTO dto = new OrderDetailDTO();		
					dto.setOrderCode(rs.getInt("ORDERCODE"));
					dto.setCafeCode(rs.getInt("CAFECODE"));
					dto.setMenuCode(rs.getInt("MENUCODE"));
					dto.setClientId(rs.getString("CLIENTID"));
					dto.setOrderPrice(rs.getInt("ORDERPRICE"));
					dto.setQuantity(rs.getInt("QUANTITY"));
					dto.setSize(rs.getInt("SIZE"));
					dto.setShot(rs.getInt("SHOT"));
					dto.setHot(rs.getInt("HOT"));
					
					list.add(dto);		
				return list;		
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
			}		
			return null;	
	 }
		public int insertOrderDetail(OrderDetailDTO OrderDetail) {
			
			int result = 0;
			String insertQuery = "INSERT INTO OrderDetail (ORDERCODE, MENUCODE, CAFECODE, CLIENTID,QUANTITIY,ORDERPRICE, SIZE, SHOT, HOT) " +
								 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			Object[] param = new Object[] {OrderDetail.getOrderCode(), OrderDetail.getMenuCode(),OrderDetail.getCafeCode(),
					OrderDetail.getClientId(),OrderDetail.getQuantity(),OrderDetail.getOrderPrice(),OrderDetail.getSize(),OrderDetail.getShot(),OrderDetail.getHot()};
			jdbcUtil.setSql(insertQuery);			// JDBCUtil �� insert �� ����
			jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
					
			try {				
				result = jdbcUtil.executeUpdate();		// insert �� ����
				System.out.println("�ֹ��󼼰� ���ԵǾ����ϴ�.");
			} catch (SQLException ex) {
				System.out.println("�Է¿��� �߻�!!!");
				if (ex.getErrorCode() == 1)
					System.out.println("������ �ֹ��󼼰� �̹� �����մϴ�."); 
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {		
				jdbcUtil.commit();
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
			}		
			return result;		// insert �� ���� �ݿ��� ���ڵ� �� ��ȯ	
			
			
		}
//		public int updateOrderDetail(OrderDetailDTO OrderDetail) {
//			String updateQuery = "UPDATE ORDERDETAIL SET ";
//			int index = 0;
//			Object[] tempParam = new Object[10];		// update ���� ����� �Ű������� ������ �� �ִ� �ӽ� �迭
//			
//			if (OrderDetail.getOrderPrice() != -1) {		// �̸��� �����Ǿ� ���� ���
//				updateQuery += "PRICE = ?, ";		// update ���� �̸� ���� �κ� �߰�
//				tempParam[index++] = OrderDetail.getOrderPrice();		// �Ű������� ������ �̸� �߰�
//			}
//			if (OrderDetail.getQuantity() != -1) {		// �̸��� �����Ǿ� ���� ���
//				updateQuery += "QUANTITY = ?, ";		// update ���� �̸� ���� �κ� �߰�
//				tempParam[index++] = OrderDetail.getQuantity();		// �Ű������� ������ �̸� �߰�
//			}
//			updateQuery += "WHERE ORDERCODE = ? AND CAFECODE = ? ";		// update ���� ���� ����
//			updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update ���� where �� �տ� ���� �� �ִ� , ����
//			
//			tempParam[index++] = OrderDetail.getOrderCode();		// ã�� ���ǿ� �ش��ϴ� �й��� ���� �Ű����� �߰�
//			tempParam[index++] = OrderDetail.getCafeCode();
//			
//			Object[] newParam = new Object[index];
//			for (int i=0; i < newParam.length; i++)		// �Ű������� ������ŭ�� ũ�⸦ ���� �迭�� �����ϰ� �Ű����� �� ����
//				newParam[i] = tempParam[i];
//			
//			jdbcUtil.setSql(updateQuery);			// JDBCUtil�� update �� ����
//			jdbcUtil.setParameters(newParam);		// JDBCUtil �� �Ű����� ����
//			
//			try {
//				int result = jdbcUtil.executeUpdate();		// update �� ����
//				return result;			// update �� ���� �ݿ��� ���ڵ� �� ��ȯ
//			} catch (Exception ex) {
//				jdbcUtil.rollback();
//				ex.printStackTrace();
//			}
//			finally {
//				jdbcUtil.commit();
//				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
//			}		
//			return 0;
//		}
		public int deleteOrderDetail(int orderCode,int cafeCode) {
			String deleteQuery = "DELETE FROM ORDERDETAIL WHERE ORDERCODE = ? AND CAFECODE = ? ";
			
			jdbcUtil.setSql(deleteQuery);			// JDBCUtil �� query �� ����
			Object[] param = new Object[] {orderCode, cafeCode};
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
		
		public OrderDetailDTO getOrderDetailByOrderCodeAndCafeCodeForCeo(int orderCode, int cafeCode) {
			String searchQuery = query + 
					  " WHERE ORDERCODE = ? AND CAFECODE = ? ";
				jdbcUtil.setSql(searchQuery);				// JDBCUtil �� query �� ����
				Object[] param = new Object[] { orderCode, cafeCode };		// �л��� ã�� ���� �������� �̸��� ����
				jdbcUtil.setParameters(param);				// JDBCUtil �� query ���� �Ű����� ������ ����� �Ű����� ����
				try {
					ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
					OrderDetailDTO orderDetail = null;
					if (rs.next()) {						
						orderDetail = new OrderDetailDTO();
						orderDetail.setOrderCode(rs.getInt("ORDERCODE"));
						orderDetail.setCafeCode(rs.getInt("CAFECODE"));
						orderDetail.setMenuCode(rs.getInt("MENUCODE"));
						orderDetail.setClientId(rs.getString("CLIENTID"));
						orderDetail.setOrderPrice(rs.getInt("ORDERPRICE"));
						orderDetail.setQuantity(rs.getInt("QUANTITY"));
						orderDetail.setSize(rs.getInt("SIZE"));
						orderDetail.setShot(rs.getInt("SHOT"));
						orderDetail.setHot(rs.getInt("HOT"));	
					}
					return orderDetail;				
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					jdbcUtil.close();		
				}
				return null;
			
		}
	 
}
