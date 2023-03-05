package com.clp.entity;

import java.util.Date;
import com.clp.services.TextService;

public class User extends BaseEntity {
	private String lastName;
	private String firstName;
	private String userName;
	private String hashPassword;
	private String gender;
	private Date dateOfBirth;

	public User(String lastName, String firstName, String userName, String hashPassword, String gender,
			Date dateOfBirth) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.hashPassword = hashPassword;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public User() {
		super();
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.hashPassword = hash(password);
	}

	private String hash(String text) {
		TextService textService = new TextService();
		return textService.hashMD5(text);
	}

	public boolean login(String password) {
		String hashedInputPassword = hash(password);
		return hashedInputPassword.equals(hashedInputPassword);
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
}
