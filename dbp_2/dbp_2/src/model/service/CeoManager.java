package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Ceo;
import model.dao.CeoDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */
public class CeoManager {
	private static CeoManager userMan = new CeoManager();
	private CeoDAO ceoDAO;
	private CeoAnalysis ceoAanlysis;

	private CeoManager() {
		try {
			ceoDAO = new CeoDAO();
			ceoAanlysis = new CeoAnalysis(ceoDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static CeoManager getInstance() {
		return userMan;
	}
	
	public int create(Ceo ceo) throws SQLException, ExistingUserException {
		if (ceoDAO.existingUser(ceo.getUserId()) == true) {
			throw new ExistingUserException(ceo.getUserId() + "�� �����ϴ� ���̵��Դϴ�.");
		}
		return ceoDAO.create(ceo);
	}

	public int update(Ceo ceo) throws SQLException {
		return ceoDAO.update(ceo);
	}	

	public int remove(String userId) throws SQLException {
		return ceoDAO.remove(userId);
	}

	public Ceo findUser(String userId)
		throws SQLException, UserNotFoundException {
		Ceo ceo = ceoDAO.findUser(userId);
		
		if (ceo == null) {
			throw new UserNotFoundException(userId + "�� �������� �ʴ� ���̵��Դϴ�.");
		}		
		return ceo;
	}

	public List<Ceo> findUserList() throws SQLException {
			return ceoDAO.findUserList();
	}
	
	public List<Ceo> findUserList(int currentPage, int countPerPage)
		throws SQLException {
		return ceoDAO.findUserList(currentPage, countPerPage);
	}

	public boolean login(String userId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		Ceo ceo = findUser(userId);

		if (!ceo.matchPassword(password)) {
			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		return true;
	}

	public List<Ceo> makeFriends(String userId) throws Exception {
		return ceoAanlysis.recommendFriends(userId);
	}
	
	public CeoDAO getCeoDAO() {
		return this.ceoDAO;
	}
}
