package com.doctorplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.doctorplus.dto.Med;

@Repository
public class MedsDao extends ConnectionDao{ 
		
	private static final Logger logger = LogManager.getLogger(UsersDao.class);	

	public List<Med> list() {
		List<Med> result = new ArrayList<>();
		
		try (Connection conn = this.getConnection();
	         PreparedStatement ps = list(conn); 
	         ResultSet rs = ps.executeQuery()){
	    	while (rs.next()) {
	    		Med med = new Med();
	    		med.setName(rs.getString("Nombre_medicamento"));
	        	result.add(med);
	        }
	    } catch (Exception e) {
	    	logger.error(e);
	    }
		
		return result;
	}
	
	private PreparedStatement list(Connection con) throws SQLException {
	    String sql = "SELECT Nombre_medicamento FROM Medicamentos";
	    PreparedStatement ps = con.prepareStatement(sql);
	    return ps;
	}
}
