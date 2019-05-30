package model;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ingredient extends Entities {
	
	/*Attributes*/
 private Integer ingredientId;
 private String  ingredientName;
 private Allergen ingredientAllergen[];
 private Integer ingredientCalories;
 private Integer ingredientCarbohydrate;
 private Integer ingredientProtein;
 private Integer ingredientFat;
 private Integer ingredientKashruth;
 private Blob ingredientImage;
 
 /*Contractors*/
 public Ingredient(Integer num) {
		ResultSet ingredient = SelectSpecific("Ingredient","ingredientId",num.toString());
		try {
			this.setIngredientId(ingredient.getInt("ingredientId"));
			this.setIngredientName(ingredient.getString("ingredientName"));
			ResultSet ingredientAllergens = SelectSpecific("IngredientAllergen","ingredientId",this.getIngredientId().toString());
			Allergen[] allergen= new Allergen[ingredientAllergens.getFetchSize()];
			for(int i=0;ingredientAllergens.next();i++)
			{
				allergen[i]=new Allergen(ingredientAllergens);
			}
			this.setIngredientAllergen(allergen);
			this.setIngredientCalories(ingredient.getInt("ingredientCalories"));
			this.setIngredientCarbohydrate(ingredient.getInt("ingredientCarbohydrate"));
			this.setIngredientProtein(ingredient.getInt("ingredientProtein"));
			this.setIngredientFat(ingredient.getInt("ingredientFat"));
			this.setIngredientKashruth(ingredient.getInt("ingredientKashruth"));
			this.setIngredientImage(ingredient.getBlob("ingredientImage"));
			} catch (SQLException e) {
					// 	TODO Auto-generated catch block
					e.printStackTrace();
			}
 }
public Ingredient( Integer ingredientId,String  ingredientName,Allergen ingredientAllergen[],Integer ingredientCalories,Integer ingredientCarbohydrate,Integer ingredientProtein,Integer ingredientFat, Integer ingredientKashruth, Blob ingredientImage)
{
	this.setIngredientId(ingredientId);
	this.setIngredientName(ingredientName);
	this.setIngredientAllergen(ingredientAllergen);
	this.setIngredientCalories(ingredientCalories);
	this.setIngredientCarbohydrate(ingredientCarbohydrate);
	this.setIngredientProtein(ingredientProtein);
	this.setIngredientFat(ingredientFat);
	this.setIngredientKashruth(ingredientKashruth);
	this.setIngredientImage(ingredientImage);
}
public Ingredient(ResultSet rs) {
		try {
			this.setIngredientId(rs.getInt("ingredientId"));
			this.setIngredientName(rs.getString("ingredientName"));
			ResultSet ingredientAllergens = SelectSpecific("IngredientAllergen","ingredientId",this.getIngredientId().toString());
			Allergen[] allergen= new Allergen[ingredientAllergens.getFetchSize()];
			for(int i=0;ingredientAllergens.next();i++)
			{
				allergen[i]=new Allergen(ingredientAllergens);
			}
			this.setIngredientAllergen(allergen);
			this.setIngredientCalories(rs.getInt("ingredientCalories"));
			this.setIngredientCarbohydrate(rs.getInt("ingredientCarbohydrate"));
			this.setIngredientProtein(rs.getInt("ingredientProtein"));
			this.setIngredientFat(rs.getInt("ingredientFat"));
			this.setIngredientKashruth(rs.getInt("ingredientKashruth"));
			this.setIngredientImage(rs.getBlob("ingredientImage"));
			} catch (SQLException e) {
					// 	TODO Auto-generated catch block
					e.printStackTrace();
			}
}
public Integer getIngredientId() {
	return ingredientId;
}
public void setIngredientId(Integer ingredientId) {
	this.ingredientId = ingredientId;
}
public String getIngredientName() {
	return ingredientName;
}
public void setIngredientName(String ingredientName) {
	this.ingredientName = ingredientName;
}
public Integer getIngredientCalories() {
	return ingredientCalories;
}
public void setIngredientCalories(Integer ingredientCalories) {
	this.ingredientCalories = ingredientCalories;
}
public Integer getIngredientCarbohydrate() {
	return ingredientCarbohydrate;
}
public void setIngredientCarbohydrate(Integer ingredientCarbohydrate) {
	this.ingredientCarbohydrate = ingredientCarbohydrate;
}
public Integer getIngredientProtein() {
	return ingredientProtein;
}
public void setIngredientProtein(Integer ingredientProtein) {
	this.ingredientProtein = ingredientProtein;
}
public Integer getIngredientKashruth() {
	return ingredientKashruth;
}
public void setIngredientKashruth(Integer ingredientKashruth) {
	this.ingredientKashruth = ingredientKashruth;
}
public Integer getIngredientFat() {
	return ingredientFat;
}
public void setIngredientFat(Integer ingredientFat) {
	this.ingredientFat = ingredientFat;
}
public Blob getIngredientImage() {
	return ingredientImage;
}
public void setIngredientImage(Blob ingredientImage) {
	this.ingredientImage = ingredientImage;
}
public Allergen[] getIngridiAntallergen() {
	return ingredientAllergen;
}
public Integer getIngredientAllergen(int i) {
	return ingredientAllergen[i].getAllergenId();
}
public void setIngredientAllergen(Allergen ingredientAllergen[]) {
	for (int i=0;i<ingredientAllergen.length;i++)
		this.ingredientAllergen[i]=ingredientAllergen[i];
}
@Override
String getEntitieKey() {
	return "ingredientId";
}
@Override
String getEntitieKeyValue() {
	return getIngredientId().toString();
}
@Override
String getEntitieAttributesNames() {
	return " ingredientId , ingredientName , ingredientCalories , ingredientCarbohydrate , ingredientProtein , ingredientFat , ingredientKashruth , ingredientImage ";
}
@Override
String getEntitieAttributesValues() {
	return this.getIngredientId().toString() +" , " +
	this.getIngredientName() +" , " +
	this.getIngredientCalories().toString() +" , " +
	this.getIngredientCarbohydrate().toString() +" , " +
	this.getIngredientProtein().toString() +" , " +
	this.getIngredientFat().toString() +" , " +
	this.getIngredientKashruth().toString() +" , " +
	this.getIngredientImage();
}
@Override
String getEntitieAttributesNamesValues() {
	return  " ingredientId = "+this.getIngredientId().toString() +" , " +
			 ", ingredientName = "+	this.getIngredientName() +" , " +
			 ", ingredientCalories = "+	this.getIngredientCalories().toString() +" , " +
			 ", ingredientCarbohydrate = "+	this.getIngredientCarbohydrate().toString() +" , " +
			 ", ingredientProtein = "+	this.getIngredientProtein().toString() +" , " +
			 ", ingredientFat = "+	this.getIngredientKashruth().toString() +" , " +
			 ", ingredientKashruth = "+	this.getIngredientKashruth().toString() +" , " +
			 ", ingredientImage = "+	this.getIngredientImage();
}
@Override
public void getPsmtmt(PreparedStatement pstmt) {
	try {
       	
		pstmt.setInt(1, ingredientId);
		pstmt.setString(2, ingredientName);
		pstmt.setInt(3, ingredientCalories);
		pstmt.setInt(4, ingredientCarbohydrate);
		pstmt.setInt(5, ingredientProtein);
		pstmt.setInt(6, ingredientFat);
		pstmt.setInt(7, ingredientKashruth);
		pstmt.setBlob(8, ingredientImage);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
 
}
