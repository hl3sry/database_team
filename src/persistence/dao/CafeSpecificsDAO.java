package persistence.dao;

import java.util.List;

import service.dto.CafeSpecificsDTO;

public interface CafeSpecificsDAO {
	
	// 전체 카페특이사항 정보를 CafeSpecificsDTO의 list로 반환하는 메소드
	public List<CafeSpecificsDTO> getCafeSpecificsList();

	public int insertCafeSpecifics(CafeSpecificsDTO spec);

	public int updateCafeSpecifics(CafeSpecificsDTO spec);

	public int deleteCafeSpecifics(String cafeCode);

	public CafeSpecificsDTO getSpecByName(String name);
	
}
