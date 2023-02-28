package com.clp.chat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;

import com.clp.entity.User;
import com.clp.repository.InMemoryRepository;
import com.clp.repository.Repository;

public class main {

	public static void main(String[] args) {
		Date date = new Date(1999, 05, 23); 
		InMemoryRepository<User> users= new InMemoryRepository<User>();
		User u1= new User("a", "b", "abc", "abcd","hash","male",date,01);
		User u2= new User("c", "b", "abc", "abcd","hash","male",date,01);
		users.insert(u1);
		users.insert(u2);
		System.out.print(users.getById(01).getFullName());
	}

}
