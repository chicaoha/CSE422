package com.clp.services;
import java.util.List;

import com.clp.data.DataStorage;
import com.clp.entity.Group;
import com.clp.entity.PrivateGroup;
import com.clp.entity.PublicGroup;
import com.clp.entity.User;
import com.clp.repository.Repository;

public class GroupService {
//	private List<Group> groups;
	private final DataStorage storage;
	private boolean isPublic;
	private String groupName;
	private List<PublicGroup> listPublicGroup;
	private List<PrivateGroup> listPrivateGroup;

	public GroupService(DataStorage storage, boolean isPublic, String groupName) {
		super();
		this.storage = storage;
		this.isPublic = isPublic;
		this.groupName = groupName;
	}

	public Group createGroup(User user, boolean isPublic) {
		Repository<Group> groupRepository = storage.getGroup();
		Group group;
		if (isPublic) {
			PublicGroup publicGroup = new PublicGroup();
			String code = publicGroup.getGroupCode();
			listPublicGroup.add(publicGroup);
			group = publicGroup;
		} else {
			PrivateGroup privateGroup = new PrivateGroup(user);
			group = privateGroup;
		}
		storage.getGroup().insert(group);
		return group;
	}

	public boolean RemoveUserFromGroup(int userId) {
		boolean flag = false;
		User foundUser = getUserById(userId);
		if (foundUser != null) {
			users.remove(foundUser);
			flag = true;
		}
		return flag;

		
	}
}
