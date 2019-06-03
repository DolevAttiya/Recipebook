package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public  abstract class  Entities {
	
	abstract String getEntitieKey();
	abstract String getEntitieKeyValue();
	abstract String getEntitieAttributesNames();
	abstract String getEntitieAttributesValues();
	abstract String getEntitieAttributesNamesValues();
	abstract public void getPsmtmt( PreparedStatement pstmt) ;

	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:";
        Connection conn = null;
        try { 
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	void Update() {String sql=" UPDATE"+this.getClass().getName()+"SET "+this.getEntitieAttributesNamesValues()+" WHERE "+ this.getEntitieKey()+ " =" +this.getEntitieKeyValue();
	 preformWithDB(sql);
	 }
	void Insert() {String sql="INSERT INTO" + this.getClass().getName()+"("+this.getEntitieAttributesNames()+") VALUES("+this.getEntitieAttributesValues()+")";
	 preformWithDB(sql);
	}
	void Delete() {String sql="DELETE FROM "+ this.getClass().getName()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
	 preformWithDB(sql);
	}
	ResultSet Select() {
	 String sql="SELECT * FROM" + this.getClass().getName()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
	 return (getFromWithDB(sql)) ;
	}
	ResultSet SelectSpecific(String Table, String Key,String Value) {
		 String sql="SELECT * FROM" + Table+" WHERE "+Key+" = "+Value;
		 return (getFromWithDB(sql)) ;
	}
	public void preformWithDB(String sql) {
		 
		 try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	         
       // set the corresponding param
				 this.getPsmtmt(pstmt);
       // update 
       pstmt.executeUpdate();

		 }
		 catch (SQLException e) {
        System.out.println(e.getMessage());
		 }
	}
	
	public ResultSet getFromWithDB(String sql) {
		try (
				Connection conn = this.connect();
	            Statement stmt  = conn.createStatement();
	            ResultSet rs    = stmt.executeQuery(sql); 
				)
		{return rs;}
		catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return null;
		}
}
