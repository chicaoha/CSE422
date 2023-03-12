package com.clp.entity;

public class FileAttach {
	String fileName;
	String Id;
	String path;

	public FileAttach(String fileName, String id, String path) {
		super();
		this.fileName = fileName;
		Id = id;
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
