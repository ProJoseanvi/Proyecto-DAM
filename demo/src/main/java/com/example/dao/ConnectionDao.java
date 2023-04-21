package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionDao {
	private final static String FILEPATH ="C:/database/BDproyecto.db";
	
	protected Connection getConnection () throws SQLException {
		Connection conn = null;
		
		String url = "jdbc:sqlite:" + FILEPATH;   
        conn = DriverManager.getConnection(url);
        return conn;
	}

}

