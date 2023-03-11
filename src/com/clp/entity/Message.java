package com.clp.entity;

public class Message extends BaseEntity{
	private User user;
	private String userName;
	private String content;
	private boolean status;
	private String receiver;
	public Message(String userName, String content, String receiver) {
		super();
		this.userName = userName;
		this.content = content;
		this.receiver = receiver;
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
