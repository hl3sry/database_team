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
	public List<Ceo> recommendFriends(String ceoId) throws Exception {
		Ceo thisuser = dao.findUser(ceoId);
		if (thisuser == null) {
			throw new Exception("invalid ceo ID!");
		}
		int m1 = ceoId.indexOf('@');
		if (m1 == -1) return null;
		String mserver1 = thisuser.getCeoId().substring(m1);
		
		List<Ceo> friends = new ArrayList<Ceo>();
		
		List<Ceo> ceoList = dao.findUserList(1, 10000);
		Iterator<Ceo> ceoIter = ceoList.iterator();		
		while (ceoIter.hasNext()) {
			Ceo ceo = (Ceo)ceoIter.next();
			
			if (ceo.getCeoId().equals(ceoId)) continue;
			int m2 = ceo.getCeoId().indexOf('@');
			if (m2 == -1) continue;
			String mserver2 = ceo.getCeoId().substring(m2);

			if (mserver1.equals(mserver2)) 
				friends.add(ceo);		
		}
		return friends;
	}

}
