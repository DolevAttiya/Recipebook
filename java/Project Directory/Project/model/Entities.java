package model;

import java.util.Observable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("deprecation")
public class  Entities extends Observable implements model{
	
	String Class() {
		return "Entities";
	}
	String getEntitieKey() {return "Entitiy error";}
	String getEntitieKeyValue(){return "Entitiy error";}
	String getEntitieAttributesNames() {return "Entitiy error";}
	String getEntitieAttributesValues() {return "Entitiy error";}
	String getEntitieAttributesNamesValues(){return "Entitiy error";}
  	 void getPsmtmt( PreparedStatement pstmt) {}
	public void Update() {String sql=" UPDATE "+this.Class()+" SET "+this.getEntitieAttributesNamesValues()+" WHERE "+ this.getEntitieKey()+ " =" +this.getEntitieKeyValue();
	 preformWithDB(sql);
	 }
	public void Insert() {String sql=" INSERT INTO " +this.Class()+"("+this.getEntitieAttributesNames()+" ) VALUES ( "+this.getEntitieAttributesValues()+" ) ";
	 preformWithDB(sql);
	}
	public  void Delete() {String sql=" DELETE FROM "+ this.Class()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
	 preformWithDB(sql);
	}
	public	void Select() {
	 String sql=" SELECT * FROM " + this.Class()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
	  notifyObservers((getFromWithDB(sql)));
	}
	public static ResultSet SelectSpecific(String Table, String Key,String Value) {
		 String sql="SELECT * FROM " + Table+" WHERE "+Key+" = "+Value;
		 ResultSet rs =getFromWithDB(sql) ;         
		 return rs;
	}
	 public void preformWithDB(String sql) {
		 
		 try (Connection conn = SingletonDBConnection.getConnection();

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
		try {

				Connection conn = SingletonDBConnection.getConnection();

	            Statement stmt  = conn.createStatement();
	            ResultSet rs    = stmt.executeQuery(sql);
	            return rs;
	           
		}
		catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return null;
		}

}
