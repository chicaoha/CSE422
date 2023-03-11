package com.clp.services;

import com.clp.data.DataStorage;
import com.clp.entity.Group;
import com.clp.data.InMemoryDataStorage;
import com.clp.entity.User;
import com.clp.repository.Repository;

public class UserService {
	private final DataStorage storage;
	public User curUser;
	public UserService(DataStorage storage) {
		super();
		this.storage = storage;
	}
	public User getUser(String userName) {
		return storage.getUsers().find(user -> user.getUserName().equals(userName));
	}
	public boolean login(String username, String password) {
		Repository<User> userRepository = storage.getUsers();
		User attemptedUser = userRepository.getFirst(user -> user.getUserName().equals(username));
		if (attemptedUser == null) {
			return false;
		}
		return attemptedUser.login(password);
	}

	public boolean addUser(String username, String password) {
		Repository<User> userRespository = storage.getUsers();
		User existing = userRespository.getFirst(user -> user.getUserName().equals(username));
		if (existing != null) {
			return false;
		}
		User newUser = new User(username, password);
		storage.getUsers().insert(newUser);
		return true;
	}
}
