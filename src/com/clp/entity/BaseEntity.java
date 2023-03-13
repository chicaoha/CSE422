
package com.clp.entity;

public abstract class BaseEntity {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public void setIdIfNotExist(int id) {
		if (id != 0) {
			setId(id);
		}
	}
}
