package com.clp.entity;

public class File extends BaseEntity {
	String fileName;
	String Id;
	String path;

	public File(String fileName, String id, String path) {
		super();
		this.fileName = fileName;
		Id = id;
		this.path = path;
	}
}
