package Connectivity;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
   
public class Connect {  
    
	
    public static void connect() {  
        Connection conn = null;  
        try {  
         
            String url = "jdbc:sqlite:C:/database/BDproyecto.db";   
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Conectado a SQlite con éxito");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        connect();  
    }  
}  
