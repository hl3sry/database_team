package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.CafeSpecificsDAO;
import service.dto.CafeSpecificsDTO;

public class CafeSpecificsDAOImpl implements CafeSpecificsDAO{

	private JDBCUtil jdbcUtil = null;	// JDBCUtil ��ü�� �����ϱ� ���� ����

	// �⺻ ������ �����ϴ� query ��
	private static String query = "SELECT CAFESPECIFICS.CAFECODE AS CAFE_CODE, " + 
			"CAFESPECIFICS.PARKING AS PARKING, " + 
			"CAFESPECIFICS.DRIVETHRU AS DRIVETHRU, " + 
			"CAFESPECIFICS.NOKIDSZONE AS NOKIDSZONE, " + 
			"CAFESPECIFICS.WITHDOG AS WITHDOG ";

	public CafeSpecificsDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	@Override
	public List<CafeSpecificsDTO> getCafeSpecificsList() {

		String allQuery = query + "FROM CAFESPECIFICS ORDER BY CAFESPECIFICS.CAFE_CODE ASC ";	

		jdbcUtil.setSql(allQuery);


		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
			List<CafeSpecificsDTO> list = new ArrayList<CafeSpecificsDTO>();		
			while (rs.next()) {	
				CafeSpecificsDTO dto = new CafeSpecificsDTO();		
				dto.setParking(rs.getInt("PARKING"));
				dto.setDrivethru(rs.getInt("DRIVETHRU"));
				dto.setNoKidsZone(rs.getInt("NOKIDSZONE"));
				dto.setWithDog(rs.getInt("WITHDOG"));
				list.add(dto);		
			}
			return list;		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		

		return null;	
	}

	@Override
	public int insertCafeSpecifics(CafeSpecificsDTO spec) {

		int result = 0;
		String insertQuery = "INSERT INTO CAFESPECIFICS (CAFE_CODE, PARKING, DRIVETHRU, NOKIDSZONE, WITHDOG) " +
				"VALUES (?, ?, ?, ?, ?) ";

		Object[] param = new Object[] {spec.getCafeCode(), spec.getParking(),
				spec.getDrivethru(), spec.getNoKidsZone(), spec.getWithDog()};
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);

		try {
			result = jdbcUtil.executeUpdate();
			System.out.println(spec.getCafeCode() + " �ڵ��� Ư�̻��� ������ ���ԵǾ����ϴ�.");

		} catch (SQLException e) {
			System.out.println("�Է¿��� �߻�!!!");
			if (e.getErrorCode() == 1)
				System.out.println("������ Ư�̻��� ������ �̹� �����մϴ�.");
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
	public int updateCafeSpecifics(CafeSpecificsDTO spec) {
		
		String updateQuery = "UPDATE CAFESPECIFICS SET ";
		int index = 0;
		Object[] tempParam = new Object[10];		// update ���� ����� �Ű������� ������ �� �ִ� �ӽ� �迭
		
		updateQuery += "PARKING = ?, ";		
		tempParam[index++] = spec.getParking();
		
		updateQuery += "DRIVETHRU = ?, ";		
		tempParam[index++] = spec.getDrivethru();
		
		updateQuery += "NOKIDSZONE = ?, ";		
		tempParam[index++] = spec.getNoKidsZone();
		
		updateQuery += "WITHDOG = ?, ";		
		tempParam[index++] = spec.getWithDog();
		
		updateQuery += "WHERE CAFE_CODE = ? ";		// update ���� ���� ����
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update ���� where �� �տ� ���� �� �ִ� , ����
		
		tempParam[index++] = spec.getCafeCode();		
		
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

	@Override
	public int deleteCafeSpecifics(String cafeCode) {
		
		String deleteQuery = "DELETE FROM CAFESPECIFICS WHERE CAFE_CODE = ?";
		
		jdbcUtil.setSql(deleteQuery);			// JDBCUtil �� query �� ����
		Object[] param = new Object[] {cafeCode};
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

	@Override
	public CafeSpecificsDTO getSpecByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
