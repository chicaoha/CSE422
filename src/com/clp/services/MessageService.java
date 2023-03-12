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
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
}
