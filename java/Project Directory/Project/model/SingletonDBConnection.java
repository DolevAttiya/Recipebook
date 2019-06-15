package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class SingletonDBConnection {
	
    private SingletonDBConnection() {}
    
        static Connection conn = null;
        static String url = "jdbc:sqlite:Project/database/database.db";
    public static Connection getConnection() {
        try {
        	if(conn==null) {
            // db parameters
        		
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");   
        	}
        	else if(conn.isClosed())
        		conn = DriverManager.getConnection(url);
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