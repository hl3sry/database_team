package model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Client;
import model.dao.ClientDAO;

// an example business class
public class ClientAnalysis {
	private ClientDAO dao;
	
	public ClientAnalysis() {}
	
	public ClientAnalysis(ClientDAO dao) {
		super();
		this.dao = dao;
	}

	// an example business method
	public List<Client> recommendFriends(String userId) throws Exception {
		Client thisuser = dao.findUser(userId);
		if (thisuser == null) {
			throw new Exception("invalid user ID!");
		}
		int m1 = userId.indexOf('@');
		if (m1 == -1) return null;
		String mserver1 = thisuser.getName().substring(m1);
		
		List<Client> friends = new ArrayList<Client>();
		
		List<Client> clientList = dao.findUserList(1, 10000);
		Iterator<Client> clientIter = clientList.iterator();		
		while (clientIter.hasNext()) {
			Client client = (Client)clientIter.next();
			
			if (client.getClientId().equals(userId)) continue;
			int m2 = client.getName().indexOf('@');
			if (m2 == -1) continue;
			String mserver2 = client.getName().substring(m2);

			if (mserver1.equals(mserver2)) 
				friends.add(client);		
		}
		return friends;
	}

}
