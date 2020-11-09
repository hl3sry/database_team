package persistence.dao;

import java.util.List;
import service.dto.CeoDTO;

// �������� DAO : interface �κ�
public interface CeoDAO {
	
	// ��ü ���������� CeoDTO�� list�� ��ȯ�ϴ� �޼ҵ�
	public List<CeoDTO> getCeoList();

	public int insertCeo(CeoDTO ceo);

	public int updateCeo(CeoDTO ceo);

	public int deleteCeo(String ceoId);

	public CeoDTO getCeoByName(String name);
}	