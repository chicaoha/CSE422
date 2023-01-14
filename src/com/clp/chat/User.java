package com.clp.chat;

import java.util.Date;

public class User {
	private String lastName;
	private String firstName;
	private String fullName;
	private String userName;
	private String hashPassword;
	private String gender;
	private Date dateOfBirth;
	private int id;

	public User(String lastName, String firstName, String fullName, String userName, String hashPassword, String gender,
			Date dateOfBirth, int id) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.fullName = fullName;
		this.userName = userName;
		this.hashPassword = hashPassword;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.id = id;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

}
