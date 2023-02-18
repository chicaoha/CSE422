package com.clp.data;

import com.clp.chat.User;
import com.clp.repository.Repository;

public class DataStorage {
	protected Repository<User> users;

	public void setUsers(Repository<User> users) {
		this.users = users;
	}
	
	
}
