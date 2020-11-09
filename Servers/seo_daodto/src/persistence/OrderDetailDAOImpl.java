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
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
			}		
			return null;	
	 }
		public int insertOrderDetail(OrderDetailDTO OrderDetail) {
			
			int result = 0;
			String insertQuery = "INSERT INTO OrderDetail (ORDERCODE, MENUCODE, CAFECODE, CLIENTID,QUANTITIY,ORDERPRICE, SIZE, SHOT, HOT) " +
								 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			Object[] param = new Object[] {OrderDetail.getOrderCode(), OrderDetail.getMenuCode(),OrderDetail.getCafeCode(),
					OrderDetail.getClientId(),OrderDetail.getQuantity(),OrderDetail.getOrderPrice(),OrderDetail.getSize(),OrderDetail.getShot(),OrderDetail.getHot()};
			jdbcUtil.setSql(insertQuery);			// JDBCUtil 에 insert 문 설정
			jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
					
			try {				
				result = jdbcUtil.executeUpdate();		// insert 문 실행
				System.out.println("주문상세가 삽입되었습니다.");
			} catch (SQLException ex) {
				System.out.println("입력오류 발생!!!");
				if (ex.getErrorCode() == 1)
					System.out.println("동일한 주문상세가 이미 존재합니다."); 
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {		
				jdbcUtil.commit();
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
			}		
			return result;		// insert 에 의해 반영된 레코드 수 반환	
			
			
		}
//		public int updateOrderDetail(OrderDetailDTO OrderDetail) {
//			String updateQuery = "UPDATE ORDERDETAIL SET ";
//			int index = 0;
//			Object[] tempParam = new Object[10];		// update 문에 사용할 매개변수를 저장할 수 있는 임시 배열
//			
//			if (OrderDetail.getOrderPrice() != -1) {		// 이름이 설정되어 있을 경우
//				updateQuery += "PRICE = ?, ";		// update 문에 이름 수정 부분 추가
//				tempParam[index++] = OrderDetail.getOrderPrice();		// 매개변수에 수정할 이름 추가
//			}
//			if (OrderDetail.getQuantity() != -1) {		// 이름이 설정되어 있을 경우
//				updateQuery += "QUANTITY = ?, ";		// update 문에 이름 수정 부분 추가
//				tempParam[index++] = OrderDetail.getQuantity();		// 매개변수에 수정할 이름 추가
//			}
//			updateQuery += "WHERE ORDERCODE = ? AND CAFECODE = ? ";		// update 문에 조건 지정
//			updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update 문의 where 절 앞에 있을 수 있는 , 제거
//			
//			tempParam[index++] = OrderDetail.getOrderCode();		// 찾을 조건에 해당하는 학번에 대한 매개변수 추가
//			tempParam[index++] = OrderDetail.getCafeCode();
//			
//			Object[] newParam = new Object[index];
//			for (int i=0; i < newParam.length; i++)		// 매개변수의 개수만큼의 크기를 갖는 배열을 생성하고 매개변수 값 복사
//				newParam[i] = tempParam[i];
//			
//			jdbcUtil.setSql(updateQuery);			// JDBCUtil에 update 문 설정
//			jdbcUtil.setParameters(newParam);		// JDBCUtil 에 매개변수 설정
//			
//			try {
//				int result = jdbcUtil.executeUpdate();		// update 문 실행
//				return result;			// update 에 의해 반영된 레코드 수 반환
//			} catch (Exception ex) {
//				jdbcUtil.rollback();
//				ex.printStackTrace();
//			}
//			finally {
//				jdbcUtil.commit();
//				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
//			}		
//			return 0;
//		}
		public int deleteOrderDetail(int orderCode,int cafeCode) {
			String deleteQuery = "DELETE FROM ORDERDETAIL WHERE ORDERCODE = ? AND CAFECODE = ? ";
			
			jdbcUtil.setSql(deleteQuery);			// JDBCUtil 에 query 문 설정
			Object[] param = new Object[] {orderCode, cafeCode};
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
		
		public OrderDetailDTO getOrderDetailByOrderCodeAndCafeCodeForCeo(int orderCode, int cafeCode) {
			String searchQuery = query + 
					  " WHERE ORDERCODE = ? AND CAFECODE = ? ";
				jdbcUtil.setSql(searchQuery);				// JDBCUtil 에 query 문 설정
				Object[] param = new Object[] { orderCode, cafeCode };		// 학생을 찾기 위한 조건으로 이름을 설정
				jdbcUtil.setParameters(param);				// JDBCUtil 에 query 문의 매개변수 값으로 사용할 매개변수 설정
				try {
					ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행
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
