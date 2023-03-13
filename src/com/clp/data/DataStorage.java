package com.clp.data;

import com.clp.entity.Alias;
import com.clp.entity.Group;
import com.clp.entity.Message;
import com.clp.entity.User;
import com.clp.repository.Repository;

public abstract class DataStorage {
	protected Repository<User> users;

	protected Repository<Group> group;

	protected Repository<Message> message;

	protected Repository<Alias> alias;

	public Repository<User> getUsers() {
		return users;
	}

	public Repository<Group> getGroup() {
		return group;
	}

	public Repository<Message> getMessage() {
		return message;
	}

	public Repository<Alias> getAlias() {
		return alias;
	}

}
