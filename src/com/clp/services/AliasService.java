package com.clp.services;

import com.clp.data.DataStorage;
import com.clp.entity.Alias;
import com.clp.entity.User;
import com.clp.repository.Repository;

public class AliasService {
	private final DataStorage storage;

	public AliasService(DataStorage storage) {
		super();
		this.storage = storage;
	}

	public void setAlias(User assignor, User Assignee, String Alias) {
		Repository<Alias> aliasRepository = storage.getAlias();
		Alias oldAlias = aliasRepository
				.find(alias -> alias.getAssignee().equals(Assignee) && alias.getAssignor().equals(assignor));
		if (oldAlias != null) {
			oldAlias.setAlias(Alias);
		} else {
			Alias newAlias = new Alias(assignor, Assignee, Alias);
			aliasRepository.insert(newAlias);
		}
	}
}
