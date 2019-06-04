package model;

import java.util.Observable;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class  Entities extends Observable implements model{
	
	protected String Class() {//Override for all. return the name of the class (the regular get this class return the package name too)
		return "Entities";
	}
	protected String getEntitieKey() {return "Entitiy error";}//Override for all. return the primary key for the table
	protected String getEntitieKeyValue(){return "Entitiy error";}//Override for all. return the primary key value for the table
	protected String getEntitieAttributesNames() {return "Entitiy error";}//Override for all. return the attributes names for the table
	protected String getEntitieAttributesValues() {return "Entitiy error";}//Override for all. return the attributes values for the table
	protected String getEntitieAttributesNamesValues(){return "Entitiy error";}//Override for all. return the attributes names + values for the table
	protected String getAllergenforTableForInsert(int place){return "Entitiy error";}//Override for Ingredient, User, Recipe. making the sql string for the connection Allergen table
	protected String getIngredientforTableForInsert(int place){return "Entitiy error";}//Override for recipe. making the sql string for the connection Ingredients table for Insert
	protected String getAllergenforTableForUpdate(int place){return "Entitiy error";}//Override for Ingredient, User, Recipe. making the sql string for the connection Allergen table for Update
	protected String getIngredientforTableForUpdate(int place){return "Entitiy error";}//Override for recipe. making the sql string for the connection Ingredients table for Update
	protected int getmaxIngredieantCount(){return -1;}//Override for recipe. receive the count of the ingredients for each recipe
  	 
	public void Update() {
		String sql=" UPDATE "+this.Class()+" SET "+this.getEntitieAttributesNamesValues()+" WHERE "+ this.getEntitieKey()+ " =" +this.getEntitieKeyValue();
		if (this.Class()=="Ingrediant"||this.Class()=="Recipe"||this.Class()=="User") //case connection with allergen table need to be updated
		{
			String sqlconnections;
			for(int i=0;i<Allergen.getMaxAllergen();i++) {
				sqlconnections=" UPDATE "+this.Class()+"Allergen "+" SET "+getAllergenforTableForUpdate(i)+" WHERE "+ this.getEntitieKey()+ " =" +this.getEntitieKeyValue();
				preformWithDB(sqlconnections);
			}
			if (this.Class()=="Recipe") //case connection with Recipe and Ingredient table need to be updated
			{
				int nmax= this.getmaxIngredieantCount();
				for(int i=0;i<nmax;i++) {	
					sqlconnections=" UPDATE "+this.Class()+"Allergen "+" SET "+getIngredientforTableForUpdate(i)+" WHERE "+ this.getEntitieKey()+ " =" +this.getEntitieKeyValue();
					preformWithDB(sqlconnections); ; 
				}
	

			}
		}
		preformWithDB(sql);
	 }
	
	public void Insert() {
		String sql=" INSERT INTO " +this.Class()+"("+this.getEntitieAttributesNames()+" ) VALUES ( "+this.getEntitieAttributesValues()+" ) ";
		if (this.Class()=="Ingrediant"||this.Class()=="Recipe"||this.Class()=="User") {//case connection with allergen table need to be added
			String sqlconnections;
			for(int i=0;i<Allergen.getMaxAllergen();i++) {
				sqlconnections=" INSERT INTO " +this.Class()+"Allergen "+this.getAllergenforTableForInsert(i);
				preformWithDB(sqlconnections); 
			}

			if (this.Class()=="Recipe")//case connection with Recipe and Ingredient table need to be added
			{
				int nmax= this.getmaxIngredieantCount();
				for(int i=0;i<nmax;i++) {	
					sqlconnections=" INSERT INTO " +this.Class()+"Ingrediant " +this.getIngredientforTableForInsert(i);
					preformWithDB(sqlconnections); 
				}
			}
		}
		preformWithDB(sql);
	}
	public  void Delete() {
		String sql=" DELETE FROM "+ this.Class()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
		if (this.Class()=="Ingrediant"||this.Class()=="Recipe"||this.Class()=="User")//case connection with allergen table need to be deleted
		{
			String sqlconnections="DELETE FROM "+ this.Class()+"Allergen "+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();preformWithDB(sqlconnections);
			if (this.Class()=="Recipe")//case connection with Recipe and Ingredient table need to be deleted
			{
				sqlconnections=" DELETE FROM "+ this.Class()+"Ingrediant "+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
				preformWithDB(sqlconnections); 
			}
		}
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
	 private void preformWithDB(String sql) {
		 
		 try (Connection conn = SingletonDBConnection.getConnection();
				 PreparedStatement pstmt = conn.prepareStatement(sql)) 
		 {
			 pstmt.executeUpdate();
		 }
		 catch (SQLException e) {
			 System.out.println(e.getMessage());
		 }
	}
	
	private static ResultSet getFromWithDB(String sql) {//the preform the connection t
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
