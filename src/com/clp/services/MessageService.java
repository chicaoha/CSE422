package com.clp.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.clp.data.DataStorage;
import com.clp.entity.Group;
import com.clp.entity.Message;
import com.clp.entity.User;

public class MessageService {
	private final DataStorage storage;
	UserService userService;
	GroupService groupService;
	List<Message> listMessages = new ArrayList<>();
	public static final int DEFAULT_BUFFER_SIZE = 8192;

	public MessageService(DataStorage storage, UserService userService, GroupService groupService,
			List<Message> listMessages) {
		super();
		this.storage = storage;
		this.userService = userService;
		this.groupService = groupService;
		this.listMessages = listMessages;
	}

//	public Message sendMessage(User sender, String text, Object receiver) {
//		if (sender == null) {
//			throw new IllegalArgumentException("Sender cannot be null");
//		}
//
//		User tempSender= userService.getUser(sender.getUserName());
//		if (receiver == null) {
//			throw new IllegalArgumentException("Receiver cannot be null");
//		}
//		String receiverName = null;
//		Message message = null;
//
//		// if receiver is a user
//		if (receiver instanceof User) {
//			User receiverUser = (User) receiver;
//
//			// make sure receiver is not the same as sender
//			if (sender.getUserName().equals(receiverUser.getUserName())) {
//				throw new IllegalArgumentException("Sender and receiver cannot be the same");
//			}
//			User tempReceiver = userService.getUser(receiverUser.getUserName());
//			// create message object and add to receiver's message list
//			message = new Message(sender.getUserName(), text, receiverUser.getUserName(), null);
//		} else if (receiver instanceof Group) {
//			Group receiverGroup = (Group) receiver;
//
//			if (!receiverGroup.getUsers().contains(sender)) {
//				throw new IllegalArgumentException("Sender is not a member of the group");
//			}
//
//			message = new Message(receiverName, text, receiverName, null);
//		}
//		return message;
//	}
	public void sendFile(File fileName, InputStream stream, String UserNane, String receiverName) throws IOException {
		saveFile(stream, fileName);
	}
	public File createFile (File file) {
		File file = new File();
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
}
