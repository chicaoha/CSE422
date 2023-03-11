package com.clp.services;

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

	public MessageService(DataStorage storage, UserService userService, GroupService groupService,
			List<Message> listMessages) {
		super();
		this.storage = storage;
		this.userService = userService;
		this.groupService = groupService;
		this.listMessages = listMessages;
	}

	public Message sendMessage(User sender, String text, Object receiver) {
		if (sender == null) {
			throw new IllegalArgumentException("Sender cannot be null");
		}

		User tempSende = userService.getUser(sender.getUserName());
		if (receiver == null) {
			throw new IllegalArgumentException("Receiver cannot be null");
		}
		String receiverName = null;
		Message message = null;

		// if receiver is a user
		if (receiver instanceof User) {
			User receiverUser = (User) receiver;

			// make sure receiver is not the same as sender
			if (sender.getUserName().equals(receiverUser.getUserName())) {
				throw new IllegalArgumentException("Sender and receiver cannot be the same");
			}
			User tempReceiver = userService.getUser(receiverUser.getUserName());
			// create message object and add to receiver's message list
			message = new Message(sender.getUserName(), text, receiverUser.getUserName());
		} else if (receiver instanceof Group) {
			Group receiverGroup = (Group) receiver;

			if (!receiverGroup.getUsers().contains(sender)) {
				throw new IllegalArgumentException("Sender is not a member of the group");
			}
			
			message= new Message(receiverName, text, receiverName);
		}
		return message;
	}

}
