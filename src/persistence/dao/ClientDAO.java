package persistence.dao;

import java.util.List;

import service.dto.ClientDTO;

public interface ClientDAO {

	// 전체 고객정보를 ClientDTO의 list로 반환하는 메소드
		public List<ClientDTO> getClientList();

		public int insertClient(ClientDTO client);

		public int updateClient(ClientDTO client);

		public int deleteClient(String clientId);

		public ClientDTO getClientByName(String name);
}
