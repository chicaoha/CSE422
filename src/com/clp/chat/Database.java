package com.clp.chat;

public class Database {
	private static Database instance;

	public Database(Database instance) {
		super();
		this.instance = instance;
	}

	public static Database getInstance() {
		if( instance == null) {
			synchronized (Database.class) {
				if(instance != null) {
					instance = new Database(instance);
				}
			}
		}
		return instance;
	}



}
