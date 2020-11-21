package persistence.dao;

import java.util.List;

import service.dto.CafeSpecificsDTO;

public interface CafeSpecificsDAO {
	
	// ��ü ī��Ư�̻��� ������ CafeSpecificsDTO�� list�� ��ȯ�ϴ� �޼ҵ�
	public List<CafeSpecificsDTO> getCafeSpecificsList();

	public int insertCafeSpecifics(CafeSpecificsDTO spec);

	public int updateCafeSpecifics(CafeSpecificsDTO spec);

	public int deleteCafeSpecifics(String cafeCode);

	public CafeSpecificsDTO getSpecByName(String name);
	
}
