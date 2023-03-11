package com.clp.entity;

import java.util.Date;
import java.util.List;

public class Message extends BaseEntity{
	private String sender;
	private String content;
//	private boolean status;
	private String receiver;
	private List<FileAttach> attachment;
	public Message(String userName, String content, String receiver,List<FileAttach> attachment) {
		super();
		this.sender = userName;
		this.content = content;
		this.receiver = receiver;
		this.attachment = attachment;
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
