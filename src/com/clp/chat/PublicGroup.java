package com.clp.chat;

import java.util.List;

import com.clp.entity.Group;
import com.clp.entity.User;

public class PublicGroup extends Group {
	private String joinCode;

	public PublicGroup(List<User> users, String groupName, int groupId) {
		super(users, groupName, groupId);
	}
	public PublicGroup(List<User> users, String groupName, int groupId, String joinCode) {
		super(users, groupName, groupId);
	}
	
	private String generateJoinCode() {
        String alphanumeric = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(alphanumeric.length());
            sb.append(alphanumeric.charAt(index));
        }
        return sb.toString();
    }
	public Group createPublicGroup() {
		
		 joinCode = generateJoinCode();
		 PublicGroup newGroup = new PublicGroup(getUsers(), joinCode, getId(), joinCode);
		return newGroup;
	}
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
