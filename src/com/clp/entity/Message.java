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
	
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Message extends BaseEntity {
	private String sender;
	private String content;
	private String receiver;
	private List<FileAttach> attachment;
	private LocalDateTime sentAt;

	public Message(String userName, String content, String receiver, List<FileAttach> attachmentt) {
		super();
		this.sender = userName;
		this.content = content;
		this.receiver = receiver;
		this.attachment = attachment;
		this.sentAt = LocalDateTime.now();
	}

	public static Comparator sortMessageByTime;
	static {
		sortMessageByTime = (m1, m2) -> ((Message) m2).getSentAt().compareTo(((Message) m1).getSentAt());
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public String getUserName() {
		return sender;
	}

	public void setUserName(String userName) {
		this.sender = userName;
	}

	public List<FileAttach> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<FileAttach> attachment) {
		this.attachment = attachment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

}
