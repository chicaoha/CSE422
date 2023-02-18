package com.clp.data;

import com.clp.entity.User;
import com.clp.repository.Repository;

public abstract class DataStorage {
	protected Repository<User> users;

	public Repository<User> getUsers() {
		return users;
	}
}
