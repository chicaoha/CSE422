package com.clp.data;

import com.clp.entity.User;
import com.clp.repository.InMemoryRepository;

public class InMemoryDataStorage extends DataStorage{
	private static InMemoryDataStorage storage;
	
	private InMemoryDataStorage () {
         InMemoryRepository<User> users = new InMemoryRepository<User>();
	}
	public static InMemoryDataStorage getInstance() {
		if( storage == null) {
			storage = new InMemoryDataStorage();
		}
		return storage;
	}

}
