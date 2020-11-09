package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.CeoDAO;
import service.dto.CeoDTO;

public class CeoDAOImpl implements CeoDAO {

	private JDBCUtil jdbcUtil = null;	// JDBCUtil ��ü�� �����ϱ� ���� ����
	
	// �⺻ ������ �����ϴ� query ��
	private static String query = "SELECT CEO.CEOID AS CEO_ID, " +
										"CEO.CEONAME AS CEO_NAME, " + 
										"CEO.CEOPASSWD AS CEO_PASSWD, " + 
										"CEO.CEOPHONE AS CEO_PHONE, " + 
										"CEO.REGISTRATIONNUM AS CEO_REGINUM ";
					
	
	//������
	public CeoDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	//���� ������ list�� ��ȯ�ϴ� �޼ҵ�
	@Override	
	public List<CeoDTO> getCeoList() {
		
		//�߰� query ��
		String allQuery = query + "FROM CEO ORDER BY CEO.CEO_ID ASC ";	
		
		jdbcUtil.setSql(allQuery);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		//query�� ����
			
			List<CeoDTO> list = new ArrayList<CeoDTO>();
			while (rs.next()) {
				CeoDTO dto = new CeoDTO();
				dto.setCeoId(rs.getString("CEO_ID"));
				dto.setCeoName(rs.getString("CEO_NAME"));
				dto.setCeoPasswd(rs.getString("CEO_PASSWD"));
				dto.setCeoPhone(rs.getString("CEO_PHONE"));
				dto.setRegistrationNum(rs.getString("CEO_REGINUM"));
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
	public int insertCeo(CeoDTO ceo) {
		
		int result = 0;
		String insertQuery = "INSERT INTO CEO (CEO_ID, CEO_NAME, CEO_PASSWD, CEO_PHONE, CEO_REGINUM) " +
							"VALUES (?, ?, ?, ?, ?) ";
		
		Object[] param = new Object[] {ceo.getCeoId(), ceo.getCeoName(),
							ceo.getCeoPasswd(), ceo.getCeoPhone(), ceo.getRegistrationNum()};
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		try {
			result = jdbcUtil.executeUpdate();
			System.out.println(ceo.getCeoId() + " id�� ���������� ���ԵǾ����ϴ�.");
			
		} catch (SQLException e) {
			System.out.println("�Է¿��� �߻�!!!");
			if (e.getErrorCode() == 1)
				System.out.println("������ ���������� �̹� �����մϴ�.");
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
	public int updateCeo(CeoDTO ceo) {
		
		String updateQuery = "UPDATE CEO SET ";
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if (ceo.getCeoName() != null) {	//�̸��� �����Ǿ� �ִ� ���
			updateQuery += "CEO_NAME = ?, ";
			tempParam[index++] = ceo.getCeoName();
		}
		if (ceo.getCeoPasswd() != null) {	//��й�ȣ�� �����Ǿ� �ִ� ���
			updateQuery += "CEO_PASSWD = ?, ";
			tempParam[index++] = ceo.getCeoPasswd();
		}
		if (ceo.getCeoPhone() != null) {	//�ڵ�����ȣ�� �����Ǿ� �ִ� ���
			updateQuery += "CEO_PHONE = ?, ";
			tempParam[index++] = ceo.getCeoPhone();
		}
		if (ceo.getRegistrationNum() != null) {	//����ڵ�Ϲ�ȣ�� �����Ǿ� �ִ� ���
			updateQuery += "CEO_REGINUM = ?, ";
			tempParam[index++] = ceo.getRegistrationNum();
		}
		updateQuery += "WHERE CEO_ID = ? ";
		updateQuery = updateQuery.replace(", WHERE", " WHERE");
		
		tempParam[index++] = ceo.getCeoId();
		
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
	public int deleteCeo(String ceoId) {
		
		String deleteQuery = "DELETE FROM CEO WHERE CEO_ID = ?";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {ceoId};
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

	//�̸����� CeoDTO ��ü ��ȯ �޼ҵ� (�ٸ� ������ ��������)
	@Override
	public CeoDTO getCeoByName(String name) {
		String searchQuery = query;
		
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] {name};
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			CeoDTO ceo = null;
			if (rs.next()) {
				ceo = new CeoDTO();
				ceo.setCeoId(rs.getString("CEO_ID"));
				ceo.setCeoName(rs.getString("CEO_NAME"));
				ceo.setCeoPhone(rs.getString("CEO_PASSWD"));
				ceo.setCeoPasswd(rs.getString("CEO_PHONE"));
				ceo.setRegistrationNum(rs.getString("CEO_REGINUM"));
			}
			return ceo;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
		return null;
	}
	
}
