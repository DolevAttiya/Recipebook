package model;

import java.util.ArrayList;
import java.util.Collections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public abstract class  Entities  {
	
	protected abstract String Class();//Override for all. return the name of the class (the regular get this class return the package name too)
	protected abstract String getEntitieKey();//Override for all. return the primary key for the table
	protected abstract String getEntitieKeyValue();//Override for all. return the primary key value for the table
	protected abstract String getEntitieAttributesNames() ;//Override for all. return the attributes names for the table
	protected abstract String getEntitieAttributesValues(); //Override for all. return the attributes values for the table
	protected abstract String getEntitieAttributesNamesValues();//Override for all. return the attributes names + values for the table
	protected abstract String getAllergenInsert(int place);//Override for Ingredient, User, Recipe. making the sql string for the connection Allergen table
	protected abstract String getIngredientInsert(int place);//Override for recipe. making the sql string for the connection Ingredients table for Insert
	protected abstract Integer[] getAllergenArray(); //Override for Ingredient, User, Recipe. retrieve the array list of the allergens from the class 
	protected abstract ArrayList<Integer> getIngredientArray();//Override for Recipe. retrieve the array list of the ingredient from the class 
	protected abstract int getmaxIngredieantCount();//Override for recipe. receive the count of the ingredients for each recipe
  	private String getStringAllergiesForInsert(int i) {
  		return " INSERT INTO " +this.Class()+"Allergen "+" ( "+this.getEntitieKey()+" , allergenId ) VALUES ( "+this.getEntitieKeyValue()+" , "+i+" ) ";}
  	private String getStringIngredientForInsert(int i) {
  		return " INSERT INTO " +this.Class()+"Ingrediant " + " ( " +this.getEntitieKey()+ " , ingredientId ) VALUES ( "+this.getEntitieKeyValue()+" , "+this.getIngredientInsert(i)+" ) ";}
	private String getStringAllergiesForDelete(int i) {
		return " DELETE FROM "+ this.Class()+"Allergen	 "+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue()+" and "+"allergenId = "+i;
	}
	private String getStringIngredientForDelete(int i) {
		return " DELETE FROM "+ this.Class()+"Ingredient "+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue()+" and "+"ingredientId = "+i;}
	protected int getResultSetSize(ResultSet rs) {
		int size =0;
	if (rs != null) 
	{
	  try {
		  while(rs.next())
				size++;
			
	  } catch (SQLException e) {
		e.printStackTrace();
	} 
	}
	return size;
	}
	public void Update() {
		String sqlconnections;
		Integer[] dbal;
		String sql=" UPDATE "+this.Class()+" SET "+this.getEntitieAttributesNamesValues()+" WHERE "+ this.getEntitieKey()+ " =" +this.getEntitieKeyValue();
		if (this.Class().compareTo(" Ingredient")==0||this.Class().compareTo(" User")==0) //case connection with allergen table need to be updated
		{
			try {
				ResultSet rs=Entities.SelectSpecific(this.Class()+"Allergen ", this.getEntitieKey(), this.getEntitieKeyValue());
				Integer[] allergentoupdate= getAllergenArray();
				dbal = new Integer[allergentoupdate.length];
				for(int i=0;i<allergentoupdate.length;i++) {dbal[i]=0;}
				while(rs.next())	
						dbal[rs.getInt("allergenId")]=1;		
				
				for (int j=0;j<allergentoupdate.length;j++)
				{
					if(dbal[j]!=allergentoupdate[j])
					{
						if(dbal[j]==1)
							sqlconnections=getStringAllergiesForDelete(j);
						else
							sqlconnections= getStringAllergiesForInsert(j);
						preformWithDB(sqlconnections);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		else if (this.Class().compareTo(" Recipe")==0) //case connection with Recipe and Ingredient, connection between Recipe and Allergen table need to be updated
			{
				ResultSet rs=Entities.SelectSpecific(this.Class()+"Allergen ", this.getEntitieKey(), this.getEntitieKeyValue());
				try {
					Integer[] allergentoupdate= getAllergenArray();
					dbal = new Integer[allergentoupdate.length];	
					while(rs.next())
						dbal[rs.getInt("allergenId")]=rs.getInt("recipeAllergenAmount");
					
					for (int j=0;j<allergentoupdate.length;j++)
					{
						if(dbal[j]!=0&&allergentoupdate[j]!=0)
						{
							if(dbal[j]==0&&allergentoupdate[j]!=0)
								sqlconnections=getStringAllergiesForInsert(j);
							else if (dbal[j]==0&&allergentoupdate[j]!=0)
								sqlconnections=getStringAllergiesForDelete(j);
							else
								sqlconnections=" UPDATE "+this.Class()+"Allergen "+" SET "+this.getEntitieAttributesNamesValues()+" WHERE "+ this.getEntitieKey()+ " =" +this.getEntitieKeyValue()+" and "+"allergenId = "+j;
							preformWithDB(sqlconnections);
						}
					}
				} 
				catch (SQLException e) {
				e.printStackTrace();
			}
			ArrayList<Integer> ingredientToUpDate= getIngredientArray();
			Collections.sort(ingredientToUpDate);
			 rs=Entities.SelectSpecific(this.Class()+" Ingredient ", this.getEntitieKey(), this.getEntitieKeyValue());
			 ArrayList<Integer> ingredientFromDB= new ArrayList<Integer>();
			try {
			while(rs.next())
				
				ingredientFromDB.add(rs.getInt("ingredientId"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			Collections.sort(ingredientFromDB);
			int i=0,j=0;
			while(ingredientFromDB.size()!=i&&ingredientToUpDate.size()!=j)
			{
				if(ingredientFromDB.get(i)!=ingredientToUpDate.get(j))
				{
					if(ingredientFromDB.get(i)<ingredientToUpDate.get(j)) {
						sqlconnections=getStringIngredientForDelete(ingredientFromDB.get(i));
						i++;}
					else 
					{	
						sqlconnections=getStringIngredientForInsert(i);
						j++;
					}
					preformWithDB(sqlconnections);	
				}
				else {i++;j++;}
			}
			while(ingredientFromDB.size()!=i)
			{
				sqlconnections=getStringIngredientForDelete(ingredientFromDB.get(i));
				i++;
			}
			while(ingredientFromDB.size()!=j)
			{	
				sqlconnections=getStringIngredientForInsert(i);
				j++;
			}
			}
		preformWithDB(sql);
	 }
	
	public void Insert() {//"INSERT INTO <CLASS NAME> (<ATTRIBUTES>) VALUES (<VALUES>)"
		String sql=" INSERT INTO " +this.Class()+" ("+this.getEntitieAttributesNames()+" ) VALUES ( "+this.getEntitieAttributesValues()+" ) ";
		preformWithDB(sql);
		if (this.Class().compareTo(" Ingredient")==0||this.Class().compareTo(" Recipe")==0||this.Class().compareTo(" User")==0) {//case connection with allergen table need to be added
			String sqlconnections;
			for(int i=0;i<this.getAllergenArray().length;i++) {
				if(this.getAllergenArray()[i]>=1)
				{
				sqlconnections=getStringAllergiesForInsert(i);
				preformWithDB(sqlconnections);
				}
			}

			if (this.Class().compareTo("Recipe")==0)//case connection with Recipe and Ingredient table need to be added
			{
				int nmax= this.getmaxIngredieantCount();
				for(int i=0;i<nmax;i++) {
					sqlconnections=getStringIngredientForInsert(i);
					preformWithDB(sqlconnections); 
				}
			}
		}
		
	}
	
	public  void Delete() {
		String sql=" DELETE FROM "+ this.Class()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
		preformWithDB(sql);
		if (this.Class().compareTo(" Ingredient")==0||this.Class().compareTo(" Recipe")==0||this.Class().compareTo(" User")==0)//case connection with allergen table need to be deleted
		{
			String sqlconnections;
			for(int i=0;i<this.getAllergenArray().length;i++) {
				if(this.getAllergenArray()[i]>=1) {
				sqlconnections=getStringAllergiesForDelete(i);
				preformWithDB(sqlconnections); }
			}
			if (this.Class().compareTo("Recipe")==0)//case connection with Recipe and Ingredient table need to be deleted
			{
				int nmax= this.getmaxIngredieantCount();
				for(int i=0;i<nmax;i++) {
					sqlconnections=getStringIngredientForDelete(i);
					preformWithDB(sqlconnections); 
				}
			}
		}
		
	}
	
	public	ResultSet Select() {
		String sql=" SELECT * FROM " + this.Class()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
		return getFromWithDB(sql);
	}

	public static ResultSet SelectSpecific(String Table, String Key,String Value) {
		 String sql="SELECT * FROM " + Table+" WHERE "+Key+" = "+Value;
		 ResultSet rs =getFromWithDB(sql) ; 
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
