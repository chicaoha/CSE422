package com.clp.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Group extends BaseEntity {

	private List<User> users;
	private List<Message> listMessages;

	public Group() {
		users = new ArrayList<>();
		listMessages = new ArrayList<>();
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Message> getListMessages() {
		return listMessages;
	}

	public boolean deleteUser(int id) {
		boolean flag = false;
		User foundUser = getUserById(id);
		if (foundUser != null) {
			users.remove(foundUser);
			flag = true;
		}
		return flag;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public User getUserById(int id) {
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			if (id == users.get(i).getId()) {
				user = users.get(i);
			}
		}
		return user;
	}

	public Message addMessage(Message message) {
		for (int i = 0; i < listMessages.size(); i++) {
			listMessages.add(message);
		}
		return (Message) listMessages;
	}
}
