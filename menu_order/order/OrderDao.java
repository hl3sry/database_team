package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class OrderDao {
	//고객 기준의 주문
	private DataSource ds;
	
	public OrderDao() throws Exception {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");		//팀 db주소 넣기
	}	
	
	public int create(OrderDto order) throws SQLException {	//주문 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT INTO ORDER (orderCode, orderDate, orderCheck, pickDate, clientId) VALUES ");
			insertQuery.append("(orderCode_seq.nextVal, ?, ?, ?, ?)");	//고객 아이디는 고객이 직접 입력
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setInt(1, order.getOrderCode());
			pstmt.setString(2, order.getOrderDate());
			pstmt.setInt(3, order.getOrderCheck());
			pstmt.setString(4, order.getPickDate());
			pstmt.setString(5, order.getClientId());

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

	public int update(OrderDto order) throws SQLException {	//주문 수정
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer updateQuery = new StringBuffer();
			updateQuery.append("UPDATE ORDER SET ");
			updateQuery.append("orderDate=?, orderCheck=?, pickDate=? ");
			updateQuery.append("WHERE orderCode=? and clientId=?");		
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, order.getorderDate());
			pstmt.setInt(2, order.getOrderCheck());
			pstmt.setString(3, order.getPickDate());
			pstmt.setInt(4, order.getOrderCode());
			pstmt.setString(5, order.getClientId());
		
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

	public int remove(int orderCode, String clientId) throws SQLException {	//주문 삭제
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer removeQuery = new StringBuffer();
			removeQuery.append("DELETE FROM ORDER ");
			removeQuery.append("WHERE orderCode=? and clientId=?");
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(removeQuery.toString());
			pstmt.setInt(1, orderCode);
			pstmt.setString(2, clientId);
	
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

	public OrderDto findOrder(int orderCode, String clientId) throws SQLException {
	//주문 정보를 찾아 반환
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT orderDate, orderCheck, pickDate ");
			findQuery.append("FROM ORDER ");
			findQuery.append("WHERE orderCode=? and clientId=?");
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setInt(1, orderCode);
			pstmt.setInt(2, clientId);	
			rs = pstmt.executeQuery();
			
			OrderDto order = null;
			if ( rs.next() ){
				order = new OrderDto();
				order.setOrderCode(orderCode);
				order.setCilentId(clientId);
				order.setOrderDate(rs.getString("orderDate"));
				order.setOrderCheck(rs.getInt("orderCheck"));
				order.setPickDate(rs.getString("pickDate"));
			}
			return order;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}

	public List<OrderDto> findOrderList(int currentPage, int countPerPage)
	//전체 주문 리스트 만들어 반환
		throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT orderCode, orderDate, orderCheck, pickDate ");
			findQuery.append("FROM ORDER ");
			findQuery.append("ORDER BY clientId");	//고객별로 주문들 정렬
	
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );		
			rs = pstmt.executeQuery();

			int start = ((currentPage-1) * countPerPage) + 1;
			
			List<OrderDto> orderList = null;
			if ( (start >= 0) && rs.absolute(start) ) {
				orderList = new ArrayList<OrderDto>();				
				do {
					OrderDto order = new OrderDto();
					order.setOrderCode(rs.getInt("orderCode"));
					order.setClientId(rs.getString("clientId"));
					order.setOrderDate(rs.getString("orderDate"));
					order.setOrderCheck(rs.getInt("orderCheck"));
					order.setPickDate(rs.getInt("pickDate"));
					orderList.add(order);					
				} while ( (rs.next()) && (--countPerPage > 0));	
			}
			return orderList;
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