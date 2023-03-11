package com.clp.chat;

import com.clp.entity.Group;
import com.clp.entity.User;
import com.clp.repository.Repository;

public class PublicGroup extends Group {
	private String groupCode;
	private String groupName;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		super.addUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return super.deleteUser(id);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return super.getUserById(id);
	}
}
