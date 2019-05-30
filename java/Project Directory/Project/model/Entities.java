package model;

import java.util.Observable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("deprecation")
public class  Entities extends Observable implements model{
	
	String getEntitieKey() {return "Entitiy error";}
	String getEntitieKeyValue(){return "Entitiy error";}
	String getEntitieAttributesNames() {return "Entitiy error";}
	String getEntitieAttributesValues() {return "Entitiy error";}
	String getEntitieAttributesNamesValues(){return "Entitiy error";}
  	public void getPsmtmt( PreparedStatement pstmt) {}
 
	public static Connection connect() {
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
	void Select() {
	 String sql="SELECT * FROM" + this.getClass().getName()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
	  notifyObservers((getFromWithDB(sql)));
	}
	 static ResultSet SelectSpecific(String Table, String Key,String Value) {
		 String sql="SELECT * FROM" + Table+" WHERE "+Key+" = "+Value;
		 return (getFromWithDB(sql)) ;
	}
	public void preformWithDB(String sql) {
		 
		 try (Connection conn = connect();
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
	
	public static ResultSet getFromWithDB(String sql) {
		try (
				Connection conn = Entities.connect();
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
