package com.clp.entity;

import java.util.ArrayList;
import java.util.List;

import com.clp.services.TextService;

public class PrivateGroup extends Group {
	private String groupName;
	private List<User> admins;

	public PrivateGroup(User user) {
		super();
		admins = new ArrayList<>();
	}

	public boolean joinByInvitation(User user) {
		int id = user.getId();
		if (getUserById(id) == null) {
			addUser(user);
			return true;
		}
		return false;
	}

	public List<User> getAdmins() {
		return admins;
	}

	public void setAdmins(List<User> admins) {
		this.admins = admins;
	}

}
