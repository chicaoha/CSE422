package com.clp.chat;

import com.clp.entity.Group;
import com.clp.entity.User;

public class PublicGroup extends Group {
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
