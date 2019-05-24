package rep;

import java.sql.Blob;
import java.sql.PreparedStatement;
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
 
 /*Contractor*/
 public Ingredient(int num) {}// do later getting from DB all the attributes 
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
public void getPsmtmt(PreparedStatement pstmt, int i) {
	try {
       	
		pstmt.setInt(1, ingredientId);
		if(i==0) {
		pstmt.setString(2, ingredientName);
		pstmt.setInt(3, ingredientCalories);
		pstmt.setInt(4, ingredientCarbohydrate);
		pstmt.setInt(5, ingredientProtein);
		pstmt.setInt(6, ingredientFat);
		pstmt.setInt(7, ingredientKashruth);
		pstmt.setBlob(8, ingredientImage);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
 
}
