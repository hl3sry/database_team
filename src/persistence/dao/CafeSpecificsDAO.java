package persistence.dao;

import java.util.List;

import service.dto.CafeSpecificsDTO;

public interface CafeSpecificsDAO {
	
	// ��ü ī��Ư�̻��� ������ CafeSpecificsDTO�� list�� ��ȯ�ϴ� �޼ҵ�
	public List<CafeSpecificsDTO> getCafeSpecificsList();

	public Integer insertCafeSpecifics(CafeSpecificsDTO spec);

	public Integer updateCafeSpecifics(CafeSpecificsDTO spec);

	public Integer deleteCafeSpecifics(String cafeCode);

	public CafeSpecificsDTO getSpecByName(String name);
	
}
