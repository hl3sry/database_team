package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Ceo;
import model.dao.CeoDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
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
			throw new ExistingUserException(ceo.getUserId() + "는 존재하는 아이디입니다.");
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
			throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
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
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
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
