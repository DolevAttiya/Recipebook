package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Models implements model {

	public Models() {
	}
	ArrayList<Recipe> top10(){
	 // select column_name from table_name order by column_name desc limit size.
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		ResultSet rs=search("Top10Recipe",null);
		int i;
		try {
			for(i=0;i<10&&rs.next();i++)
			{
				recipe.add(new Recipe(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recipe;
		
	}

	ArrayList<User> CheckPasswordAndEmail(User us){
	 // select column_name from table_name order by column_name desc limit size.
		String[] args=new String[2];
		args[0]=us.getPersonEmail();
		args[1]=us.getPersonHashPass();
		ArrayList<User> user= new ArrayList<User>();
		ResultSet rs=search("CheckPasswordAndEmail",args);
		int i;
		try {
			for(i=0;i<10&&rs.next();i++)
			{
				user.add(new User(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	ArrayList<User> InsertUser(User us){
		 // select column_name from table_name order by column_name desc limit size.
		ArrayList<User> user= new ArrayList<User>();
		if(us.Update())
			{
				String[] args=new String[1];
				args[0]=us.getPersonEmail();
				ResultSet rs=search("InsertUser",args);
				int i;
				try {
					for(i=0;i<10&&rs.next();i++)
					{
						user.add(new User(rs));
					}
				} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return user;
			
		}
	private ResultSet search(String typeSearch, Object args[]) {
		String sql="";
		if(typeSearch.compareTo("Top10Recipe")==0) 
		sql="  select * from Recipe order by recipeRate desc ";
		if(typeSearch.compareTo("CheckPasswordAndEmail")==0)
		sql="  select * from UserPerson where personEmail = "+(String)args[0]+" And PersonHash = "+(String)args[1];
		ResultSet rs =getFromWithDB(sql) ;    
		if(typeSearch.compareTo("InsertUser")==0)
		sql="  select * from UserPerson where personEmail = "+(String)args[0];
		 return rs;
		

	}
	public static ResultSet SelectSpecificFrom(String Select, String Table, String Key,String Value) {
		String sql;
		if(Key!=null)
			sql=" SELECT "+Select+" FROM " + Table+" WHERE "+Key+" = "+Value;
		else
			sql=" SELECT "+Select+" FROM " + Table;
		 ResultSet rs =getFromWithDB(sql) ;         
		 return rs;
	}
	public static Boolean preformWithDB(String sql) {
		 
		 try (Connection conn = SingletonDBConnection.getConnection();
				 PreparedStatement pstmt = conn.prepareStatement(sql)) 
		 {
			 pstmt.executeUpdate();
			 return true;
		 }
		 catch (SQLException e) {
			 System.out.println(e.getMessage());
			 return false;
		 }
	}
	public static ResultSet SelectSpecific(String Table, String Key,String Value) {
		 String sql="SELECT * FROM " + Table+" WHERE "+Key+" = "+Value;
		 ResultSet rs =getFromWithDB(sql) ; 
		 return rs;
	}
	public static ResultSet getFromWithDB(String sql) {//the preform the connection t
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