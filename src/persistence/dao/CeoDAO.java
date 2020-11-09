package persistence.dao;

import java.util.List;
import service.dto.CeoDTO;

// 사장정보 DAO : interface 부분
public interface CeoDAO {
	
	// 전체 사장정보를 CeoDTO의 list로 반환하는 메소드
	public List<CeoDTO> getCeoList();

	public int insertCeo(CeoDTO ceo);

	public int updateCeo(CeoDTO ceo);

	public int deleteCeo(String ceoId);

	public CeoDTO getCeoByName(String name);
}	