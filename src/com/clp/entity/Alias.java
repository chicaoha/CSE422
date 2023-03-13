package com.clp.entity;

public class Alias {
	private User assignor;
	private User assignee;
	private String alias;
	
	public Alias(User assignor, User assignee, String alias) {
		super();
		this.assignor = assignor;
		this.assignee = assignee;
		this.alias = alias;
	}

	public User getAssignor() {
		return assignor;
	}

	public void setAssignor(User assignor) {
		this.assignor = assignor;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
}
