package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Client;
import model.dao.ClientDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class ClientManager {
	private static ClientManager userMan = new ClientManager();
	private ClientDAO clientDAO;
	private ClientAnalysis clientAnalysis;

	private ClientManager() {
		try {
			clientDAO = new ClientDAO();
			clientAnalysis = new ClientAnalysis(clientDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static ClientManager getInstance() {
		return userMan;
	}
	
	public int create(Client client) throws SQLException, ExistingUserException {
		if (clientDAO.existingUser(client.getClientId()) == true) {
			throw new ExistingUserException(client.getClientId() + "는 존재하는 아이디입니다.");
		}
		return clientDAO.create(client);
	}

	public int update(Client client) throws SQLException {
		return clientDAO.update(client);
	}	

	public int remove(String userId) throws SQLException {
		return clientDAO.remove(userId);
	}

	public Client findUser(String userId)
		throws SQLException, UserNotFoundException {
		Client client = clientDAO.findUser(userId);
		
		if (client == null) {
			throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
		}		
		return client;
	}

	public List<Client> findUserList() throws SQLException {
			return clientDAO.findUserList();
	}
	
	public List<Client> findUserList(int currentPage, int countPerPage)
		throws SQLException {
		return clientDAO.findUserList(currentPage, countPerPage);
	}

	public boolean login(String userId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		Client client = findUser(userId);

		if (!client.matchPassword(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}

	public List<Client> makeFriends(String userId) throws Exception {
		return clientAnalysis.recommendFriends(userId);
	}
	
	public ClientDAO getClientDAO() {
		return this.clientDAO;
	}
}
