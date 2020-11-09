package persistence;

import java.util.List;

public interface OrderDetailDAO {
		
		public List<OrderDetailDTO> getOrderDetailList();		
		public int insertOrderDetail(OrderDetailDTO OrderDetail);	
		//public int updateOrderDetail(OrderDetailDTO OrderDetail);	
		public int deleteOrderDetail(int orderCode,int cafeCode);			
		public OrderDetailDTO getOrderDetailByOrderCodeAndCafeCodeForCeo(int orderCode, int cafeCode);	
		
}
