package com.clp.services;

import java.util.ArrayList;
import java.util.List;

import com.clp.chat.PublicGroup;
import com.clp.entity.Group;
import com.clp.entity.PrivateGroup;
import com.clp.entity.User;

public class GroupService {
	List<Group> listGroups = new ArrayList<Group>();
	
	public List<Group> createGroup(User user, PublicGroup publicGroup, PrivateGroup privateGroup, String groupType) {
		int userId = user.getId();
		if (groupType.equalsIgnoreCase("public")) {
			listGroups.add(publicGroup);
		} else {
			listGroups.add(privateGroup);
		}
		return listGroups;
	}
	public void inviteUser(String user) {
		if(listGroups.contains(user)) {
			System.out.println(user + " is already a member of this group.");
		}
		
	}
}
