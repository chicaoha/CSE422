package com.clp.services;

import java.util.ArrayList;
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

	public GroupService(DataStorage storage) {
		super();
		this.storage = storage;
		listPrivateGroup = new ArrayList<PrivateGroup>();
		listPublicGroup = new ArrayList<>();
	}
	
	public Group findGroupById(Group anyGroup) {
		Repository<Group> groupRepository = storage.getGroup();
		Group foundGroup = groupRepository.getFirst(group -> group.getId() == group.getId());
		return foundGroup;
	}

	public Group createGroup(User user, boolean isPublic) {
		Repository<Group> groupRepository = storage.getGroup();
		Group group = new Group() {
		};
		if (isPublic) {
			PublicGroup publicGroup = new PublicGroup();
			String code = publicGroup.getGroupCode();
			group = publicGroup;
			listPublicGroup.add(publicGroup);
		} else {
			System.out.println("test");
			PrivateGroup privateGroup = new PrivateGroup(user);
			group = privateGroup;
			System.out.println(group);
		}
		System.out.println(groupRepository);
		groupRepository.insert(group);
		return group;
	}


	public boolean isAdmin(Group group, User user) {
		for (PrivateGroup privateGroup : listPrivateGroup) {
			if (privateGroup.getId() == group.getId()) {
				List<User> admins = privateGroup.getAdmins();
				for (User admin : admins) {
					if (admin.getId() == user.getId()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean RemoveUserFromGroup(int userId, int groupId) {
		Repository<Group> groupRepository = storage.getGroup();
		Group foundGroup = groupRepository.getFirst(group -> group.getId() == groupId);
		if (foundGroup != null) {
			Repository<User> userRepository = storage.getUsers();
			User existing = userRepository.getFirst(user -> user.getId() == (userId));
			if (existing != null) {
				if (!isAdmin(foundGroup, existing)) {
					foundGroup.deleteUser(userId);
					return true;
				}
			}
		}
		return false;
	}
}
