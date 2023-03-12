package com.clp.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Group extends BaseEntity {
	private List<User> users = new ArrayList<>();
	private List<String> listMessages = new ArrayList<>();

	public List<User> getUsers() {
		return users;
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

	protected void addUser(User user) {
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
//	public Group getGroupById(int id) {
//		Group group = null;
//		for (int i = 0; i < users.size(); i++) {
//			if (id == users.get(i).getId()) {
//				user = users.get(i);
//			}
//		}
//		return user;
//	}
//	public Message addMessage(Message message) {
//		Group group= null;
//		for ( int i=0; i< listMessages.size(); i++) {
//			listMessages.add(message);
//		}
//		return  (Message) listMessages;
//	}

}
