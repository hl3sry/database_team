package persistence.dao;

import java.util.List;

import service.dto.ClientDTO;

public interface ClientDAO {

	// ��ü �������� ClientDTO�� list�� ��ȯ�ϴ� �޼ҵ�
		public List<ClientDTO> getClientList();

		public int insertClient(ClientDTO client);

		public int updateClient(ClientDTO client);

		public int deleteClient(String clientId);

		public ClientDTO getClientByName(String name);
}
