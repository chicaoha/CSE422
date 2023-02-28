package com.clp.data;

import com.clp.entity.Group;
import com.clp.entity.User;
import com.clp.repository.Repository;

public abstract class DataStorage {
	protected Repository<User> users;
	protected Repository<Group> groups;

	public Repository<User> getUsers() {
		return users;
	}
	public Repository<Group> getGroups() {
		return groups;
	}
}
