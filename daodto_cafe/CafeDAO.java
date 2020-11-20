package dbptp_dao_dto;

import java.util.List;
import dbptp_dao_dto.Cafe;

//ī�� ������ ó���ϱ� ���� DAO
public interface CafeDAO {
	public List<Cafe> getCafeList();				// ��ü ī�� ������ ȹ��
	public int insertCafe(Cafe cafe);				// ī�������� �߰�
	public int updateCafe(Cafe cafe);				// ī�������� ����
	public int deleteCafe(int cafeCode);			// ī�������� ����
	public Cafe getCafeByName(String cafeName);		// ī�������� ī������� ã��
	public Cafe getCafeByCode(int cafeCode);		// ī�������� ī���ڵ�� ã��
}