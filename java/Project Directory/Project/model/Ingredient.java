package model;

import java.sql.Blob;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ingredient extends Entities {
	
	/*Attributes*/
 private Integer ingredientId;
 private String  ingredientName;
 private Integer ingredientAllergen[];
 private Double ingredientCalories;
 private Double ingredientCarbohydrate;
 private Double ingredientProtein;
 private Double ingredientFat;
 private Integer ingredientKashruth;
 private Blob ingredientImage;
 
 /*Contractors*/
 public Ingredient(Integer num) {
		this( SelectSpecific("Ingredient","ingredientId",num.toString()));
		
 }
public Ingredient( Integer ingredientId,String  ingredientName,Integer ingredientAllergen[],Double ingredientCalories,Double ingredientCarbohydrate,Double ingredientProtein,Double ingredientFat, Integer ingredientKashruth, Blob ingredientImage)
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
			Integer[] allergen= new Integer[ingredientAllergens.getFetchSize()];
			while(ingredientAllergens.next())
			{
				allergen[ingredientAllergens.getInt("allergenId")]=1;
			}
			this.setIngredientAllergen(allergen);
			this.setIngredientCalories(rs.getDouble("ingredientCalories"));
			this.setIngredientCarbohydrate(rs.getDouble("ingredientCarbohydrate"));
			this.setIngredientProtein(rs.getDouble("ingredientProtein"));
			this.setIngredientFat(rs.getDouble("ingredientFat"));
			this.setIngredientKashruth(rs.getInt("ingredientKashruth"));
			//this.setIngredientImage(rs.getBlob("ingredientImage"));
			} catch (SQLException e) {
					// 	TODO Auto-generated catch block
					e.printStackTrace();
			}
}
public Integer getIngredientId() {
	return ingredientId.intValue();
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
public Double getIngredientCalories() {
	return ingredientCalories;
}
public void setIngredientCalories(Double ingredientCalories) {
	this.ingredientCalories = ingredientCalories;
}
public Double getIngredientCarbohydrate() {
	return ingredientCarbohydrate;
}
public void setIngredientCarbohydrate(Double ingredientCarbohydrate) {
	this.ingredientCarbohydrate = ingredientCarbohydrate;
}
public Double getIngredientProtein() {
	return ingredientProtein;
}
public void setIngredientProtein(Double ingredientProtein) {
	this.ingredientProtein = ingredientProtein;
}
public Integer getIngredientKashruth() {
	return ingredientKashruth;
}
public void setIngredientKashruth(Integer ingredientKashruth) {
	this.ingredientKashruth = ingredientKashruth;
}
public Double getIngredientFat() {
	return ingredientFat;
}
public void setIngredientFat(Double ingredientFat) {
	this.ingredientFat = ingredientFat;
}
public Blob getIngredientImage() {
	return ingredientImage;
}
public void setIngredientImage(Blob ingredientImage) {
	this.ingredientImage = ingredientImage;
}
public Integer[] getIngridiAntallergen() {
	return ingredientAllergen;
}
public Integer getIngredientAllergen(int i) {
	return ingredientAllergen[i];
}
public void setIngredientAllergen(Integer ingredientAllergen[]) {
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
String Class() {return " ingredient ";}
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
	this.getIngredientImage()+" ";
}
@Override
String getEntitieAttributesNamesValues() {
	return  " ingredientId = "+this.getIngredientId().toString() +" , " +
			 " ingredientName = \""+	this.getIngredientName() +"\" , " +
			 " ingredientCalories = "+	this.getIngredientCalories().toString() +" , " +
			 " ingredientCarbohydrate = "+	this.getIngredientCarbohydrate().toString() +" , " +
			 " ingredientProtein = "+	this.getIngredientProtein().toString() +" , " +
			 " ingredientFat = "+	this.getIngredientKashruth().toString() +" , " +
			 " ingredientKashruth = "+	this.getIngredientKashruth().toString() +" , " +
			 " ingredientImage = "+	this.getIngredientImage()+" ";
}
/*@Override
public void getPsmtmt(PreparedStatement pstmt) {
	try {
       	
		pstmt.setInt(1, (int)this.getIngredientId());
		pstmt.setString(2, this.getIngredientName());
		pstmt.setInt(3, this.getIngredientCalories());
		pstmt.setInt(4, this.getIngredientCarbohydrate());
		pstmt.setInt(5, this.getIngredientProtein());
		pstmt.setInt(6, this.getIngredientFat());
		pstmt.setInt(7, this.getIngredientKashruth());
		pstmt.setBlob(8, this.getIngredientImage());
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	*/ 
}
