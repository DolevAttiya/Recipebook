
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.sql.ResultSet;
import java.sql.SQLException;
public abstract class  Entities  {

	protected abstract String Class();//Override for all. return the name of the class (the regular get this class return the package name too)
	protected abstract String getEntitieKey();//Override for all. return the primary key for the table
	protected abstract String getEntitieKeyValue();//Override for all. return the primary key value for the table
	protected abstract String getEntitieAttributesNames() ;//Override for all. return the attributes names for the table
	protected abstract String getEntitieAttributesValues(); //Override for all. return the attributes values for the table
	protected abstract String getEntitieAttributesNamesValues();//Override for all. return the attributes names + values for the table
	protected abstract String getAllergenInsert(int place);//Override for Ingredient, User, Recipe. making the sql string for the connection Allergen table
	protected abstract String getSubtbleInsert(int place);//Override for recipe. making the sql string for the connection Ingredients table for Insert
	protected abstract String getSubtbleDelete(int place);//Override for recipe. making the sql string for the connection Ingredients table for Delete
	protected abstract Integer[] getAllergenArray(); //Override for Ingredient, User, Recipe. retrieve the array list of the allergens from the class 
	protected abstract ArrayList<Integer> getSubtbleArray();//Override for Recipe. retrieve the array list of the ingredient from the class 
	protected abstract int getmaxSubtbleCount();//Override for recipe. receive the count of the ingredients for each recipe
	protected abstract String getPersonAttributesNamesValues();//Override for all. return the attributes names + values for the table
	protected abstract String getPersonAttributesValues();
	protected abstract String getPersonAttributesNames();
	protected abstract String getPersonKeyValue() ;

	private String getStringAllergiesForInsert(int i) {
		String sql = " INSERT INTO " +this.Class()+"Allergen "+" ( "+this.getEntitieKey()+" , allergenId ";
		if (this.Class().compareTo(" Recipe")==0) 
			sql+=", recipeAllergenAmount ";
		sql+=" ) VALUES ( "+this.getEntitieKeyValue()+" , "+i;
		if (this.Class().compareTo(" Recipe")==0)
			sql+=" , "+this.getAllergenInsert(i);
		sql+=" ) ";
		return sql;}
	private String getStringIngredientForInsert(int i) {
		return " INSERT INTO " +this.Class()+"Ingredient " + " ( " +this.getEntitieKey()+ " , ingredientId , ingredientAmount ,  ingredientTypeId ) VALUES ( "+this.getEntitieKeyValue()+" , "+this.getSubtbleInsert(i)+" ) ";}
	private String getStringAllergiesForDelete(int i) {
		return " DELETE FROM "+ this.Class()+"Allergen	 "+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue()+" and "+"allergenId = "+i;}
	private String getStringIngredientForDelete(int i) {
		return " DELETE FROM "+ this.Class()+"Ingredient "+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue()+" and "+"ingredientId = "+getSubtbleDelete(i);}
	private String getStringRecipeForInsert(int i) {
		return " INSERT INTO PersonFavoriteRecipe ( personEmail , recipeId) VALUES ( "+this.getPersonKeyValue()+" , "+this.getSubtbleInsert(i)+" ) ";}
	private String getStringRecipeForDelete(int i) {
		return " DELETE FROM PersonFavoriteRecipe WHERE personEmail = "+this.getPersonKeyValue()+" and "+"recipeId = "+getSubtbleDelete(i);}
	
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

	public Boolean Update() {
		Boolean x=true,y=true,z=true,q=true;
		String sqlconnections;
		Integer[] dbal;
		String sql;
		if(this.Class().compareTo(" User")==0||this.Class().compareTo(" Dietitian")==0) {
			ResultSet rs;
			sql=" UPDATE  Person SET"+this.getPersonAttributesNamesValues()+" WHERE personEmail = "+this.getPersonKeyValue()+" ";
			q= Models.preformWithDB(sql);
			
			
			ArrayList<Integer> favoriteRecipeToUpDate= getSubtbleArray();
			Collections.sort(favoriteRecipeToUpDate);
			rs=Models.SelectSpecific("PersonFavoriteRecipe ", "personEmail", this.getPersonKeyValue());//
			ArrayList<Integer> recipeFromDB= new ArrayList<Integer>();
			try {
				while(rs.next())

					recipeFromDB.add(rs.getInt("recipeId"));
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			Collections.sort(recipeFromDB);
			int i=0,j=0;
			while(recipeFromDB.size()!=i&&favoriteRecipeToUpDate.size()!=j)
			{
				if(recipeFromDB.get(i)!=favoriteRecipeToUpDate.get(j))
				{
					if(recipeFromDB.get(i)<favoriteRecipeToUpDate.get(j)) {
						sqlconnections=getStringRecipeForDelete(recipeFromDB.get(i));
						i++;}
					else 
					{	
						sqlconnections=getStringRecipeForInsert(i);
						j++;
					}
					Models.preformWithDB(sqlconnections);	
				}
				else {i++;j++;}
			}
			while(recipeFromDB.size()!=i)
			{
				sqlconnections=getStringRecipeForDelete(recipeFromDB.get(i));
				i++;
				Models.preformWithDB(sqlconnections);	

			}
			while(favoriteRecipeToUpDate.size()!=j)
			{	
				sqlconnections=getStringRecipeForInsert(j);
				j++;
				Models.preformWithDB(sqlconnections);	

			
			}}
		
		sql=" UPDATE "+this.Class()+" SET "+this.getEntitieAttributesNamesValues()+" WHERE "+ this.getEntitieKey()+ " = \"" +this.getEntitieKeyValue()+"\" ";
		if (this.Class().compareTo(" Ingredient")==0||this.Class().compareTo(" User")==0) //case connection with allergen table need to be updated
		{
			try {
				ResultSet rs=Models.SelectSpecific(this.Class()+"Allergen ", this.getEntitieKey(), this.getEntitieKeyValue());
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
						x=Models.preformWithDB(sqlconnections);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		}
		else if (this.Class().compareTo(" Recipe")==0) //case connection with Recipe and Ingredient, connection between Recipe and Allergen table need to be updated
		{
			ResultSet rs=Models.SelectSpecific(this.Class()+"Allergen ", this.getEntitieKey(), this.getEntitieKeyValue());
			try {
				Integer[] allergentoupdate= getAllergenArray();
				dbal = new Integer[allergentoupdate.length];	
				while(rs.next()&&y)
					dbal[rs.getInt("allergenId")]=rs.getInt("recipeAllergenAmount");

				for (int j=0;j<allergentoupdate.length&&y;j++)
				{
					if(dbal[j]!=null&&allergentoupdate[j]!=null)
					{
						if(dbal[j]==null&&allergentoupdate[j]!=null)
							sqlconnections=getStringAllergiesForInsert(j);
						else if (dbal[j]==0&&allergentoupdate[j]!=null)
							sqlconnections=getStringAllergiesForDelete(j);
						else
							sqlconnections=" UPDATE "+this.Class()+"Allergen "+" SET recipeAllergenAmount = "+getAllergenInsert(j)+" WHERE "+ this.getEntitieKey()+ " = " +this.getEntitieKeyValue()+" and "+"allergenId = "+j;
						y=Models.preformWithDB(sqlconnections);
					}
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			ArrayList<Integer> ingredientToUpDate= getSubtbleArray();
			Collections.sort(ingredientToUpDate);
			rs=Models.SelectSpecific(this.Class()+"Ingredient ", this.getEntitieKey(), this.getEntitieKeyValue());
			ArrayList<Integer> ingredientFromDB= new ArrayList<Integer>();
			try {
				while(rs.next())

					ingredientFromDB.add(rs.getInt("ingredientId"));
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
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
					Models.preformWithDB(sqlconnections);	
				}
				else {i++;j++;}
			}
			while(ingredientFromDB.size()!=i)
			{
				sqlconnections=getStringIngredientForDelete(ingredientFromDB.get(i));
				i++;
				Models.preformWithDB(sqlconnections);	
			}
			while(ingredientToUpDate.size()!=j)
			{	
				sqlconnections=getStringIngredientForInsert(j);
				j++;
				Models.preformWithDB(sqlconnections);	
			}
		}
		z=Models.preformWithDB(sql);

		return x&&y&&z&&q;
	}

	public Boolean Insert() {//"INSERT INTO <CLASS NAME> (<ATTRIBUTES>) VALUES (<VALUES>)"
		Boolean x=true,y=true,z=true,q=true;
		String sql;
		if(this.Class().compareTo(" User")==0||this.Class().compareTo(" Dietitian")==0) {
			sql=" INSERT INTO Person ("+this.getPersonAttributesNames()+" ) VALUES ( "+this.getPersonAttributesValues()+" ) ";
			q= Models.preformWithDB(sql);
			for (int i =0; i<this.getmaxSubtbleCount();i++) {
			sql=" INSERT INTO PersonFavoriteRecipe ( recipeId , personEmail ) VALUES ( "+this.getSubtbleInsert(i)+" , "+this.getPersonKeyValue()+" ) ";
			q= Models.preformWithDB(sql);}
		}
		sql=" INSERT INTO " +this.Class()+" ("+this.getEntitieAttributesNames()+" ) VALUES ( "+this.getEntitieAttributesValues()+" ) ";
		z= Models.preformWithDB(sql);
		if( (this.Class().compareTo(" Ingredient")==0||this.Class().compareTo(" Recipe")==0||this.Class().compareTo(" User")==0)&&z) {//case connection with allergen table need to be added
			String sqlconnections;
			for(int i=0;i<this.getAllergenArray().length&&y;i++) {
				if(this.getAllergenArray()[i]>=1)
				{
					sqlconnections=getStringAllergiesForInsert(i);
					y=Models.preformWithDB(sqlconnections);
				}
			}

			if (this.Class()==" Recipe")//case connection with Recipe and Ingredient table need to be added
			{
				int nmax= this.getmaxSubtbleCount();
				for(int i=0;i<nmax&&x;i++) {
					sqlconnections=getStringIngredientForInsert(i);
					x= Models.preformWithDB(sqlconnections); 
				}
			}
		}
		return x&&y&&z&&q; 

	}

	public  Boolean Delete() {
		Boolean x=true,y=true,z=true,q=true;
		String sql=" DELETE FROM "+ this.Class()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
		
		if ((this.Class().compareTo(" Ingredient")==0||this.Class().compareTo(" Recipe")==0||this.Class().compareTo(" User")==0)&&z)//case connection with allergen table need to be deleted
		{
			String sqlconnections;
			for(int i=0;i<this.getAllergenArray().length&&x;i++) {
				if(this.getAllergenArray()[i]!=null) 
				{
					sqlconnections=getStringAllergiesForDelete(i);
					x=Models.preformWithDB(sqlconnections); 
				}
			}
			if (this.Class().compareTo(" Recipe")==0)//case connection with Recipe and Ingredient table need to be deleted
			{
				int nmax= this.getmaxSubtbleCount();
				for(int i=0;i<nmax&&y;i++)
				{
					sqlconnections=getStringIngredientForDelete(i);
					y=Models.preformWithDB(sqlconnections); 
				}
			}
		}
		z= Models.preformWithDB(sql);
		if(this.Class().compareTo(" User")==0||this.Class().compareTo(" Dietitian")==0) {
			for (int i =0; i<this.getmaxSubtbleCount();i++) {
				sql=" Delete From PersonFavoriteRecipe WHERE personEmail =  "+this.getPersonKeyValue()+" AND recipeId = "+getSubtbleDelete(i) +" ";
				q&= Models.preformWithDB(sql);}
			sql=" Delete From Person WHERE personEmail = "+this.getPersonKeyValue();
			q= Models.preformWithDB(sql);
			
		}
		return x&&y&&z&&q; 


	}

	public	 Object Select() {
		String sql=" SELECT * FROM " + this.Class()+" WHERE "+this.getEntitieKey()+" = "+this.getEntitieKeyValue();
		return Models.getFromWithDB(sql);
	}

}
