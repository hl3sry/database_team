package dbptp_dao_dto;

import java.util.List;
import dbptp_dao_dto.Cafe;

//카페 정보를 처리하기 위한 DAO
public interface CafeDAO {
	public List<Cafe> getCafeList();				// 전체 카페 정보를 획득
	public int insertCafe(Cafe cafe);				// 카페정보를 추가
	public int updateCafe(Cafe cafe);				// 카페정보를 수정
	public int deleteCafe(int cafeCode);			// 카페정보를 삭제
	public Cafe getCafeByName(String cafeName);		// 카페정보를 카페명으로 찾음
	public Cafe getCafeByCode(int cafeCode);		// 카페정보를 카페코드로 찾음
}