package com.clp.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

import com.clp.data.DataStorage;
import com.clp.entity.FileAttach;
import com.clp.entity.Group;
import com.clp.entity.Message;
import com.clp.entity.User;
import com.clp.repository.Repository;

public class MessageService {
	private final DataStorage storage;
	UserService userService;
	GroupService groupService;
	List<Message> listMessages = new ArrayList<>();
	public static final int DEFAULT_BUFFER_SIZE = 8192;

	public MessageService(DataStorage storage) {
		super();
		this.storage = storage;
		this.userService = new UserService(storage);
		this.groupService = new GroupService(storage);
		this.listMessages = listMessages;
	}


	public void sendFile(File fileName, InputStream stream, String UserNane, String receiverName) throws IOException {
		saveFile(stream, fileName);
		FileAttach fileAtt = createFile(fileName);
	}



	public FileAttach createFile(File file) {
		String id = UUID.randomUUID().toString();
		String name = "Phat" + id;
		String path = "Dir" + id;
		FileAttach fileAttach = new FileAttach(name, id, path);
		return fileAttach;
	}

	private static void saveFile(InputStream inputStream, File file) throws IOException {
		try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
			int read;
			byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		}
	}

	public Boolean sendMessage(String sender, String content, String receiver, List<FileAttach> attachment) {
		Message message = new Message(sender, content, receiver, attachment);
		listMessages.add((Message) message.sortMessageByTime);
		storage.getMessage().insert(message);
		return true;
	}

	public void deleteMessage(Message message) {
		storage.getMessage().delete(message);
	}

	public List<Message> getAllMessage() {
		this.listMessages = storage.getMessage().getAll();
		return listMessages;
	}


//	public List<FileAttach> getAllFiles(Group group){
//		if(checkMember(user, group)) {
//		Repository<Message> messagesContainFiles = storage.getMessage();
//		FileAttach file = messagesContainFiles.get(message -> message.getAttachment() != null, message )
//		}
//	}
	public List<Message> GetTopLatestMessages(int numOfLastesMessages, int notIncludeMessages) {
		List<Message> latestMessages = new ArrayList<>();
		if (numOfLastesMessages >= notIncludeMessages && listMessages != null) {
			for (int i = notIncludeMessages; i < numOfLastesMessages; i++) {
				latestMessages.add(listMessages.get(i));
			}
		}
		return latestMessages;
	}

	public List<Message> findMessageByKeyWord(String keyword) {
		List<Message> messagesFindByKeyword = new ArrayList<>();
		List<Message> messages = storage.getMessage().getAll();
		for (Message mess : messages) {
			if (mess.getContent().contains(keyword)) {
				messagesFindByKeyword.add(mess);
			}
		}
		return messagesFindByKeyword;
	}

	public boolean checkMember(User user, Group group) {
		List<User> users = group.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				return true;
			}
		}
		return false;
	}

	public List<Group> getGroupsOfUser(User user) {
		List<Group> groupsOfUser = new ArrayList<>();
		List<Group> groups = storage.getGroup().getAll();
		for (int i = 0; i < groups.size(); i++) {
			Group group = groups.get(i);
			if (checkMember(user, group)) {
				groupsOfUser.add(group);
			}
		}
		return groupsOfUser;
	}
	
	public List<List<Message>> GetConversations(User user){
		List<List<Message>> conversations = new ArrayList<>();
		List<Group> groups = getGroupsOfUser(user);
		for (Group group : groups) {
			List<Message> messages = group.getListMessages();
			conversations.add(messages);
		}
		return conversations;
	}
	
	public HashMap<Integer, List<Message>>  getConversations (User user){
		HashMap<Integer, List<Message>> conversations = new HashMap<>();
		List<Group> groups = getGroupsOfUser(user);
		for (Group group : groups) {
			List<Message> messages = group.getListMessages();
			int groupId = group.getId();
			conversations.put(groupId, messages);
		}
		return conversations;
	}
	
//	public List<Message> getConversations

}
