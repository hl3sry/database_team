package dbptp_dao_dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dbptp_dao_dto.CafeDAO;
import dbptp_dao_dto.Cafe;

public class CafeDAOImpl implements CafeDAO {
	private JDBCUtil jdbcUtil = null;

	private static String query = "SELECT CAFE.CAFE_CODE AS CAFE_CODE, " + "       CAFE.CAFE_NAME AS CAFE_NAME "
			+ "       CAFE.LOCATION AS LOCATION, " + "       CAFE.CAFE_PHONE AS CAFE_PHONE, "
			+ "       CAFE.BUSINESSHOURS AS BUSINESSHOURS, " + "       CAFE.NOTICE AS NOTICE, "
			+ "       CAFE.LOGO AS LOGO, " + "       CAFE.CAFE_PHOTO AS CAFE_PHOTO ";

	public CafeDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	// 전체 카페정보를 List 로 반환하는 메소드
	@Override
	public List<Cafe> getCafeList() {
		String allQuery = query + ", " + "CAFE.CEO_ID AS CAFE_CEO_ID, " + "FROM CAFE ORDER BY CAFE.CAFE_CODE ASC ";
		jdbcUtil.setSql(allQuery);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Cafe> list = new ArrayList<Cafe>();
			while (rs.next()) {
				Cafe dto = new Cafe();
				dto.setCafeCode(rs.getInt("CAFE_CODE"));
				dto.setCafeName(rs.getString("CAFE_NAME"));
				dto.setLocation(rs.getString("LOCATION"));
				dto.setCafePhone(rs.getString("CAFE_PHONE"));
				dto.setBusinessHours(rs.getString("BUSINESSHOURS"));
				dto.setNotice(rs.getString("NOTICE"));
				dto.setLogo(rs.getString("LOGO"));
				dto.setCafePhoto(rs.getString("CAFE_PHOTO"));
				dto.setCeoId(rs.getString("CEO_ID"));
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// 카페 이름으로 카페정보를 검색하여 해당카페의 정보를 갖고 있는 Cafe 객체를 반환하는 메소드
	@Override
	public Cafe getCafeByName(String cafeName) {
		String searchQuery = query + ", " + "CEO.CEO_ID AS CEO_ID, " + "FROM CAFE, CEO "
				+ "WHERE CAFE.CAFE_NAME = ? AND " + "CAFE.CEO_ID = CEO.CEO_ID ";
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { cafeName };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			Cafe cafe = null;
			if (rs.next()) {
				cafe = new Cafe();
				cafe.setCafeCode(rs.getInt("CAFE_CODE"));
				cafe.setCafeName(rs.getString("CAFE_NAME"));
				cafe.setLocation(rs.getString("LOCATION"));
				cafe.setCafePhone(rs.getString("CAFE_PHONE"));
				cafe.setBusinessHours(rs.getString("BUSINESSHOURS"));
				cafe.setNotice(rs.getString("NOTICE"));
				cafe.setLogo(rs.getString("LOGO"));
				cafe.setCafePhoto(rs.getString("CAFE_PHOTO"));
				cafe.setCeoId(rs.getString("CEO_ID"));
			}
			return cafe;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// 카페 코드로 카페정보를 검색하여 해당카페의 정보를 갖고 있는 Cafe 객체를 반환하는 메소드
	@Override
	public Cafe getCafeByCode(int cafeCode) {
		String searchQuery = query + ", " + "CEO.CEO_ID AS CEO_ID, " + "FROM CAFE, CEO "
				+ "WHERE CAFE.CAFE_CODE = ? AND " + "CAFE.CEO_ID = CEO.CEO_ID ";
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { cafeCode };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			Cafe cafe = null;
			if (rs.next()) {
				cafe = new Cafe();
				cafe.setCafeCode(rs.getInt("CAFE_CODE"));
				cafe.setCafeName(rs.getString("CAFE_NAME"));
				cafe.setLocation(rs.getString("LOCATION"));
				cafe.setCafePhone(rs.getString("CAFE_PHONE"));
				cafe.setBusinessHours(rs.getString("BUSINESSHOURS"));
				cafe.setNotice(rs.getString("NOTICE"));
				cafe.setLogo(rs.getString("LOGO"));
				cafe.setCafePhoto(rs.getString("CAFE_PHOTO"));
				cafe.setCeoId(rs.getString("CEO_ID"));
			}
			return cafe;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// Cafe 객체에 담겨 있는 카페의 정보를 기반으로 카페정보를 cafe 테이블에 삽입하는 메소드
	@Override
	public int insertCafe(Cafe cafe) {
		int result = 0;
		String insertQuery = "INSERT INTO STUDENT (CAFE_CODE, CAFE_NAME, LOCATION"
				+ ", CAFE_PHONE, BUSINESSHOURS, NOTICE, LOGO" + ", CAFE_PHOTO, CEO_ID) "
				+ "VALUES (cafeCode_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?) ";

		DAOFactory factory = new DAOFactory();

		CeoDAO ceoDAO = factory.getCeoDAO();
		Ceo ceo = ceoDAO.getCeoById(cafe.getCeoId());
		Integer ceoId = ceo.getCeoId();
		if (ceoId == null) {
			System.out.println("해당 ceo가 없습니다.");
			return 0;
		}

		Object[] param = new Object[] { cafe.getCafeCode(), cafe.getCafeName(), cafe.getLocation(), cafe.getCafePhone(),
				cafe.getBusinessHours(), cafe.getNotice(), cafe.getLogo(), cafe.getCafePhoto(), cafe.getCeoId() };
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);

		try {
			result = jdbcUtil.executeUpdate();
			System.out.println(cafe.getCafeCode() + "의 카페 정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 카페 정보가 이미 존재합니다.");
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	// Cafe 객체에 설정되어 있는 정보를 토대로 테이블의 정보를 수정하는 메소드
	@Override
	public int updateCafe(Cafe cafe) {
		String updateQuery = "UPDATE CAFE SET ";
		int index = 0;
		Object[] tempParam = new Object[10];

		if (cafe.getCafeName() != null) {
			updateQuery += "CAFE_NAME = ?, ";
			tempParam[index++] = cafe.getCafeName();
		}
		if (cafe.getLocation() != null) {
			updateQuery += "LOCATION = ?, ";
			tempParam[index++] = cafe.getLocation();
		}
		if (cafe.getCafePhone() != null) {
			updateQuery += "CAFE_PHONE = ?, ";
			tempParam[index++] = cafe.getCafePhone();
		}
		if (cafe.getBusinessHours() != null) {
			updateQuery += "BUSINESSHOURS = ?, ";
			tempParam[index++] = cafe.getBusinessHours();
		}
		if (cafe.getNotice() != null) {
			updateQuery += "NOTICE = ?, ";
			tempParam[index++] = cafe.getNotice();
		}
		if (cafe.getLogo() != null) {
			updateQuery += "LOGO = ?, ";
			tempParam[index++] = cafe.getLogo();
		}
		if (cafe.getCafePhoto() != null) {
			updateQuery += "CAFE_PHOTO = ?, ";
			tempParam[index++] = cafe.getCafePhoto();
		}
		if (cafe.getCeoId() != null) {
			updateQuery += "CEO_ID = ?, ";
			tempParam[index++] = cafe.getCeoId();
		}
		updateQuery += "WHERE CAFE_CODE = ? ";
		updateQuery = updateQuery.replace(", WHERE", " WHERE");

		tempParam[index++] = cafe.getCafeCode();

		Object[] newParam = new Object[index];
		for (int i = 0; i < newParam.length; i++)
			newParam[i] = tempParam[i];

		jdbcUtil.setSql(updateQuery);
		jdbcUtil.setParameters(newParam);

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	// cafeCode를 전달받아 해당 카페의 카페 정보를 삭제하는 메소드
	@Override
	public int deleteCafe(int cafeCode) {
		String deleteQuery = "DELETE FROM CAFE WHERE CAFE_CODE = ?";

		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] { cafeCode };
		jdbcUtil.setParameters(param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

}