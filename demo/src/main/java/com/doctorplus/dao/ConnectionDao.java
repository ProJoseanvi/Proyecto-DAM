package com.doctorplus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionDao {
	private final static String FILEPATH ="C:/database/BDproyecto.db";
	
	public ConnectionDao() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection () throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String url = "jdbc:sqlite:" + FILEPATH;   
        conn = DriverManager.getConnection(url);
        return conn;
	}

}

