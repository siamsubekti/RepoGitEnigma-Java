package com.enigmacamp.friends.db;

public enum ConnectionConfig {
	DRIVER("com.mysql.jdbc.Driver"),
	DATABASE_ENGINE("mysql"),
	DATABASE_HOST("localhost"),
	DATABASE_PORT("3306"),
	DATABASE_USER("root"),
	DATABASE_PASSWORD(""),
	DATABASE_NAME("socials");
	
	private String value;
	
	ConnectionConfig(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
