package com.enigmacamp.friends.db;

import java.sql.*;

public class Database {
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	
	public Database() {
		String connectionString = "jdbc:" + 
			ConnectionConfig.DATABASE_ENGINE.toString() +
			"://" + 
			ConnectionConfig.DATABASE_HOST.toString() +
			":" +
			ConnectionConfig.DATABASE_PORT.toString() +
			"/" + 
			ConnectionConfig.DATABASE_NAME.toString() + 
			"?useUnicode=true&serverTimezone=Asia/Jakarta";
		
		try {
			this.connection = DriverManager.getConnection(connectionString, ConnectionConfig.DATABASE_USER.toString(), ConnectionConfig.DATABASE_PASSWORD.toString());
			this.statement = connection.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String sql) throws SQLException {
		return this.statement.executeQuery(sql);
	}
	
	public boolean execute(String sql) throws SQLException {
		return this.statement.execute(sql);
	}
	
	public int executeUpdate(String sql) throws SQLException {
		return this.statement.executeUpdate(sql);
	}
	
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return this.connection.prepareStatement(sql);
	}
	
}
