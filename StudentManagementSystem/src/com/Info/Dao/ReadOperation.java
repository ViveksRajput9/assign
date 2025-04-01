package com.Info.Dao;

import java.sql.*;

public class ReadOperation {
	private static final ReadOperation instance = new ReadOperation();
	private ReadOperation() {}
	public static ReadOperation Read() { return instance;}
	
	public ResultSet getAllDetail(String tableName) throws SQLException{
		String query = "SELECT * FROM "+tableName;
		return Database.database().getConnection().prepareStatement(query).executeQuery();
	}
}
