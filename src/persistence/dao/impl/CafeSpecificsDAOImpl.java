package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.CafeSpecificsDAO;
import service.dto.CafeSpecificsDTO;

public class CafeSpecificsDAOImpl implements CafeSpecificsDAO{

	private JDBCUtil jdbcUtil = null;	// JDBCUtil 객체를 지정하기 위한 변수

	// 기본 정보를 포함하는 query 문
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
			ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행			
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
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
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
			System.out.println(spec.getCafeCode() + " 코드의 특이사항 정보가 삽입되었습니다.");

		} catch (SQLException e) {
			System.out.println("입력오류 발생!!!");
			if (e.getErrorCode() == 1)
				System.out.println("동일한 특이사항 정보가 이미 존재합니다.");
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
		Object[] tempParam = new Object[10];		// update 문에 사용할 매개변수를 저장할 수 있는 임시 배열
		
		updateQuery += "PARKING = ?, ";		
		tempParam[index++] = spec.getParking();
		
		updateQuery += "DRIVETHRU = ?, ";		
		tempParam[index++] = spec.getDrivethru();
		
		updateQuery += "NOKIDSZONE = ?, ";		
		tempParam[index++] = spec.getNoKidsZone();
		
		updateQuery += "WITHDOG = ?, ";		
		tempParam[index++] = spec.getWithDog();
		
		updateQuery += "WHERE CAFE_CODE = ? ";		// update 문에 조건 지정
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update 문의 where 절 앞에 있을 수 있는 , 제거
		
		tempParam[index++] = spec.getCafeCode();		
		
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

	@Override
	public int deleteCafeSpecifics(String cafeCode) {
		
		String deleteQuery = "DELETE FROM CAFESPECIFICS WHERE CAFE_CODE = ?";
		
		jdbcUtil.setSql(deleteQuery);			// JDBCUtil 에 query 문 설정
		Object[] param = new Object[] {cafeCode};
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

	@Override
	public CafeSpecificsDTO getSpecByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
