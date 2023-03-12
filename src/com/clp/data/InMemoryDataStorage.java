package com.clp.data;

import com.clp.entity.Group;
import com.clp.entity.Message;
import com.clp.entity.User;
import com.clp.repository.InMemoryRepository;

public class InMemoryDataStorage extends DataStorage {
	private static InMemoryDataStorage storage;

	private InMemoryDataStorage() {
		users = new InMemoryRepository<User>();
		group = new InMemoryRepository<Group>();
		message = new InMemoryRepository<Message>();
	}

	public static InMemoryDataStorage getInstance() {
		if (storage == null) {
			storage = new InMemoryDataStorage();
		}
		return storage;
	}

}
