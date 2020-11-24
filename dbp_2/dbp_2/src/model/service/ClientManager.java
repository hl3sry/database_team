package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Client;
import model.dao.ClientDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
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
			throw new ExistingUserException(client.getClientId() + "�� �����ϴ� ���̵��Դϴ�.");
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
			throw new UserNotFoundException(userId + "�� �������� �ʴ� ���̵��Դϴ�.");
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
			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
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
