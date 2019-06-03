package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class SingletonDBConnection {
	
    private SingletonDBConnection() {}
    
        static Connection conn = null;
        
        public static Connection getConnection() {
        try {
        	if(conn==null) {
            // db parameters
            String url = "jdbc:sqlite:Project/database/database.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");   
        	}
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }
        
        public static void closeConnection() {
            //closing the connection to the DB if its open
        try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection to SQLite has been terminated");
                }
             } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
             }
        }
    
    
    public static void main(String[] args) {
    	getConnection();
    	closeConnection();
    }
}