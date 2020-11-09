package persistence.dao;

import java.util.List;

import service.dto.CafeSpecificsDTO;

public interface CafeSpecificsDAO {
	
	// 전체 카페특이사항 정보를 CafeSpecificsDTO의 list로 반환하는 메소드
	public List<CafeSpecificsDTO> getCafeSpecificsList();

	public Integer insertCafeSpecifics(CafeSpecificsDTO spec);

	public Integer updateCafeSpecifics(CafeSpecificsDTO spec);

	public Integer deleteCafeSpecifics(String cafeCode);

	public CafeSpecificsDTO getSpecByName(String name);
	
}
