package com.clp.entity;

import java.util.List;

public class Message extends BaseEntity{
	private User user;
	private String userName;
	private String content;
	private boolean status;
	private String receiver;
	private List<File> attachment;
	public Message(String userName, String content, String receiver,List<File> attachment) {
		super();
		this.userName = userName;
		this.content = content;
		this.receiver = receiver;
		this.attachment = attachment;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<File> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<File> attachment) {
		this.attachment = attachment;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	
}
