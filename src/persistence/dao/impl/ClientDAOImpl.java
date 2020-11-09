package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.ClientDAO;
import service.dto.ClientDTO;

public class ClientDAOImpl implements ClientDAO{

	private JDBCUtil jdbcUtil = null;

	private static String query = "SELECT CLIENT.CLIENTID AS CLIENT_ID, " + 
			"CLIENT.CLIENTNAME AS CLIENT_NAME, " + 
			"CLIENT.CLIENTPHONE AS CLIENT_PHONE, " +
			"CLIENT.CLIENTPASSWD AS CLIENT_PASSWD, ";

	public ClientDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	@Override
	public List<ClientDTO> getClientList() {

		String allQuery = query + "FROM CLIENT ORDER BY CLIENT.CLIENT_ID ASC ";	
		
		jdbcUtil.setSql(allQuery);

		try {
			ResultSet rs = jdbcUtil.executeQuery();		

			List<ClientDTO> list = new ArrayList<ClientDTO>();
			while (rs.next()) {
				ClientDTO dto = new ClientDTO();
				dto.setClientId(rs.getString("CLIENT_ID"));
				dto.setClientName(rs.getString("CLIENT_NAME"));
				dto.setClientPhone(rs.getString("CLIENT_PHONE"));
				dto.setClientPasswd(rs.getString("CLIENT_PASSWD"));
				list.add(dto);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return null;
	}

	@Override
	public int insertClient(ClientDTO client) {

		int result = 0;
		String insertQuery = "INSERT INTO CLIENT (CLIENT_ID, CLIENT_NAME, CLIENT_PHONE, CLIENT_PASSWD) " +
				"VALUES (?, ?, ?, ?) ";

		Object[] param = new Object[] {client.getClientId(), client.getClientName(),
				client.getClientPhone(), client.getClientPasswd()};
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);

		try {
			result = jdbcUtil.executeUpdate();
			System.out.println(client.getClientId() + " ");

		} catch (SQLException e) {
			System.out.println("입력오류 발생");
			if (e.getErrorCode() == 1)
				System.out.println("동일한 고객정보가 이미 존재합니다. ");
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return result;
	}

	@Override
	public int updateClient(ClientDTO client) {
		
		String updateQuery = "UPDATE CLIENT SET ";
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if (client.getClientName() != null) {	//이름이 설정되어 있는 경우
			updateQuery += "CLIENT_NAME = ?, ";
			tempParam[index++] = client.getClientName();
		}		
		if (client.getClientPhone() != null) {	//핸드폰번호가 설정되어 있는 경우
			updateQuery += "CLIENT_PHONE = ?, ";
			tempParam[index++] = client.getClientPhone();
		}
		if (client.getClientPasswd() != null) {	//비밀번호가 설정되어 있는 경우
			updateQuery += "CLIENT_PASSWD = ?, ";
			tempParam[index++] = client.getClientPasswd();
		}
		
		updateQuery += "WHERE CLIENT_ID = ? ";
		updateQuery = updateQuery.replace(", WHERE", " WHERE");
		
		tempParam[index++] = client.getClientId();
		
		Object[] newParam = new Object[index];
		for (int i = 0; i < newParam.length; i++)
			newParam[i] = tempParam[i];
		
		jdbcUtil.setSql(updateQuery);
		jdbcUtil.setParameters(newParam);
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
			
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
			
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;
		
	}

	@Override
	public int deleteClient(String clientId) {
		// TODO Auto-generated method stub
		
		String deleteQuery = "DELETE FROM CLIENT WHERE CLIENT_ID = ?";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {clientId};
		jdbcUtil.setParameters(param);
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;
	}

	@Override
	public ClientDTO getClientByName(String name) {
		
		String searchQuery = query;
		
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] {name};
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			ClientDTO client = null;
			if (rs.next()) {
				client = new ClientDTO();
				client.setClientId(rs.getString("CLIENT_ID"));
				client.setClientName(rs.getString("CLIENT_NAME"));
				client.setClientPhone(rs.getString("CLIENT_PASSWD"));
				client.setClientPasswd(rs.getString("CLIENT_PHONE"));
			}
			return client;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
		return null;
	}

}
