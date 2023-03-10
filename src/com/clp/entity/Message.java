package com.clp.entity;

public class Message extends BaseEntity{
	private User user;
	private String content;
	private boolean status;
	public Message(User user, String content, boolean status) {
		super();
		this.user = user;
		this.content = content;
		this.status = status;
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
	
	
}
