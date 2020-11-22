package model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Ceo;
import model.dao.CeoDAO;

// an example business class
public class CeoAnalysis {
	private CeoDAO dao;
	
	public CeoAnalysis() {}
	
	public CeoAnalysis(CeoDAO dao) {
		super();
		this.dao = dao;
	}

	// an example business method
	public List<Ceo> recommendFriends(String userId) throws Exception {
		Ceo thisuser = dao.findUser(userId);
		if (thisuser == null) {
			throw new Exception("invalid ceo ID!");
		}
		int m1 = userId.indexOf('@');
		if (m1 == -1) return null;
		String mserver1 = thisuser.getEmail().substring(m1);
		
		List<Ceo> friends = new ArrayList<Ceo>();
		
		List<Ceo> ceoList = dao.findUserList(1, 10000);
		Iterator<Ceo> ceoIter = ceoList.iterator();		
		while (ceoIter.hasNext()) {
			Ceo ceo = (Ceo)ceoIter.next();
			
			if (ceo.getUserId().equals(userId)) continue;
			int m2 = ceo.getEmail().indexOf('@');
			if (m2 == -1) continue;
			String mserver2 = ceo.getEmail().substring(m2);

			if (mserver1.equals(mserver2)) 
				friends.add(ceo);		
		}
		return friends;
	}

}
