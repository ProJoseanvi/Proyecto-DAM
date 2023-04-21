package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo.Medicamento;

public class MedicamentosDao extends ConnectionDao{ 
		
	public Medicamento get(String code) {
		Medicamento result = new Medicamento();
	    try (Connection conn = this.getConnection();
	         PreparedStatement ps = get(conn, code); 
	         ResultSet rs = ps.executeQuery()){
	    	if (rs.next()) {
            	result.setCodigoBarras(rs.getString("Codigo_barras"));
            	result.setNombreMedicamento(rs.getString("Nombre_medicamento"));
            }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	private PreparedStatement get (Connection con, String code) throws SQLException {
	    String sql = "SELECT Codigo_barras,"
				+ "   Nombre_medicamento"
				+ "   FROM Medicamentos WHERE Codigo_barras = ? ;";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1,code);
	    return ps;
	}
	
	public static void main(String[] args) {  
        MedicamentosDao dao = new MedicamentosDao(); 
        Medicamento medicamento = dao.get("2727");
        		System.out.println(medicamento.toString());
    }  
}
