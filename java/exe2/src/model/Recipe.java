package model;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
public class Recipe extends Entities{
	
	/*Attributes*/
 private Integer recipeId;
 private String  recipeName;
 private Blob recipeImage;
 private Integer recipeTotalCalories;
 private Integer recipeTotalCarbohydrate;
 private Integer recipeTotalProtein;
 private Integer recipeTotalFat;
 private Integer recipeKashruth;
 private Time recipeTimeToMake;
 private Integer recipeComplex;
 private Integer recipeRate;
 private String recipeDescription;
 private String recipeProcses;
 private String recipePersonEmail;
 private ArrayList<Integer> recipeIngredientId;
 private ArrayList<Integer> recipeIngredientsType;
 private ArrayList<Integer> recipeIngredientsAmount;
 private Integer recipeAllergen[];
 
 
 /*Contractor*/
public Recipe( Integer recipeId,String  recipeName, Integer[] recipeAllergen,Integer recipeTotalCalories,Integer recipeTotalCarbohydrate,Integer recipeTotalProtein,Integer recipeTotalFat, Integer recipeKashruth, Blob recipeImage, Time recipeTimeToMakeprivate ,Integer recipeComplex,String recipePersonEmail,Integer recipeRate, String recipeDescription, String recipeProcses ,ArrayList<Integer> recipeIngredientId, ArrayList<Integer> recipeIngredientsType, ArrayList<Integer> recipeIngredientsAmount)
{
	this.setRecipeAllergen(recipeAllergen);
	this.setRecipeId(recipeId);
	this.setRecipeName(recipeName);
	this.setRecipeIngredientId(recipeIngredientId);
	this.setRecipeIngredientsType(recipeIngredientsType);
	this.setRecipeIngredientsAmount(recipeIngredientsAmount);
	this.setRecipeTotalCalories(recipeTotalCalories);
	this.setRecipeTotalCarbohydrate(recipeTotalCarbohydrate);
	this.setRecipeTotalProtein(recipeTotalProtein);
	this.setRecipeTotalFat(recipeTotalFat);
	this.setRecipeKashruth(recipeKashruth);
	this.setRecipeComplex(recipeComplex);
	this.setRecipePersonEmail(recipePersonEmail);
	this.setRecipeRate(recipeRate);
	this.setRecipeDescription(recipeDescription);
	this.setRecipeProcses(recipeProcses);	
	this.setRecipeImage(recipeImage);
}
public Recipe(ResultSet rs) {
	try {
	ResultSet RecipeAllergens = SelectSpecific("RecipeAllergen","ingredientId",this.getRecipeId().toString());
	Integer[] allergen= new Integer[RecipeAllergens.getFetchSize()];
	while(RecipeAllergens.next())
	{
		allergen[RecipeAllergens.getInt("allergenId")]=1;
	}
	this.setRecipeAllergen(allergen);
	this.setRecipeId(rs.getInt("recipeId"));
	this.setRecipeName(rs.getString("recipeName"));
	ResultSet recipeIngredientVals = SelectSpecific("RecipeIngredient","recipeId",this.getRecipeId().toString());
	ArrayList<Integer> IngredientsType= new ArrayList<Integer>();
	ArrayList<Integer> IngredientsAmount= new ArrayList<Integer>();
	ArrayList<Integer> ingredients= new ArrayList<Integer>();

	while(recipeIngredientVals.next())
		
	{
		IngredientsType.add(rs.getInt("ingredientsType"));
		IngredientsAmount.add(rs.getInt("IngredientsAmount"));
		ingredients.add(rs.getInt("IngredientsAmount"));

	}
	this.setRecipeIngredientId(ingredients);
	this.setRecipeIngredientsType(IngredientsType);
	this.setRecipeIngredientsAmount(IngredientsAmount);
	this.setRecipeTotalCalories(rs.getInt("recipeTotalCalories"));
	this.setRecipeTotalCarbohydrate(rs.getInt("recipeTotalCarbohydrate"));
	this.setRecipeTotalProtein(rs.getInt("recipeTotalProtein"));
	this.setRecipeTotalFat(rs.getInt("recipeTotalFat"));
	this.setRecipeKashruth(rs.getInt("recipeKashruth"));
	this.setRecipeComplex(rs.getInt("recipeComplex"));
	this.setRecipePersonEmail(rs.getString("recipePersonEmail"));
	this.setRecipeRate(rs.getInt("recipeRate"));
	this.setRecipeDescription(rs.getString("recipeDescription"));
	this.setRecipeProcses(rs.getString("recipeProcses"));	
	this.setRecipeImage(rs.getBlob("recipeImage"));
} catch (SQLException e) {
	e.printStackTrace();
}

}
public Integer getRecipeId() {
	return recipeId;
}
public void setRecipeId(Integer recipeId) {
	this.recipeId = recipeId;
}
public String getRecipeName() {
	return recipeName;
}
public void setRecipeName(String recipeName) {
	this.recipeName = recipeName;
}
public Integer[] getRecipeAllergen() {
	return recipeAllergen;
}
public void setRecipeAllergen(Integer[] recipeAllergen) {
	this.recipeAllergen= new Integer[Allergen.getMaxAllergen()];
	for (int i=0;i<Allergen.getMaxAllergen();i++)
		this.recipeAllergen[i]=recipeAllergen[i];
}
public ArrayList<Integer> getRecipeIngredientId() {
	return recipeIngredientId;
}
public void setRecipeIngredientId(ArrayList<Integer> recipeIngredientId) {
	recipeIngredientId.forEach((n) -> this.recipeIngredientId.add(n));
}
public ArrayList<Integer> getRecipeIngredientsType() {
	return recipeIngredientsType;
}
public void setRecipeIngredientsType(ArrayList<Integer> recipeIngredientsType) {
	recipeIngredientsType.forEach((n) -> this.recipeIngredientsType.add(n));
}
public ArrayList<Integer> getRecipeIngredientsAmount() {
	return recipeIngredientsAmount;
}
public void setRecipeIngredientsAmount(ArrayList<Integer> recipeIngredientsAmount) {
	recipeIngredientsAmount.forEach((n) -> this.recipeIngredientsAmount.add(n));
}
public Integer getRecipeTotalCalories() {
	return recipeTotalCalories;
}
public void setRecipeTotalCalories(Integer recipeTotalCalories) {
	this.recipeTotalCalories = recipeTotalCalories;
}
public Integer getRecipeTotalCarbohydrate() {
	return recipeTotalCarbohydrate;
}
public void setRecipeTotalCarbohydrate(Integer recipeTotalCarbohydrate) {
	this.recipeTotalCarbohydrate = recipeTotalCarbohydrate;
}
public Integer getRecipeTotalProtein() {
	return recipeTotalProtein;
}
public void setRecipeTotalProtein(Integer recipeTotalProtein) {
	this.recipeTotalProtein = recipeTotalProtein;
}
public Integer getRecipeKashruth() {
	return recipeKashruth;
}
public void setRecipeKashruth(Integer recipeKashruth) {
	this.recipeKashruth = recipeKashruth;
}
public Integer getRecipeTotalFat() {
	return recipeTotalFat;
}
public void setRecipeTotalFat(Integer recipeTotalFat) {
	this.recipeTotalFat = recipeTotalFat;
}
public Blob getRecipeImage() {
	return recipeImage;
}
public void setRecipeImage(Blob recipeImage) {
	this.recipeImage = recipeImage;
}
public Time getRecipeTimeToMake() {
	return recipeTimeToMake;
}
public void setRecipeTimeToMake(Time recipeTimeToMake) {
	this.recipeTimeToMake = recipeTimeToMake;
}
public Integer getRecipeComplex() {
	return recipeComplex;
}
public void setRecipeComplex(Integer recipeComplex) {
	this.recipeComplex = recipeComplex;
}
public String getRecipePersonEmail() {
	return recipePersonEmail;
}
public void setRecipePersonEmail(String recipePersonEmail) {
	this.recipePersonEmail = recipePersonEmail;
}
public Integer getRecipeRate() {
	return recipeRate;
}
public void setRecipeRate(Integer recipeRate) {
	this.recipeRate = recipeRate;
}
public String getRecipeDescription() {
	return recipeDescription;
}
public void setRecipeDescription(String recipeDescription) {
	this.recipeDescription = recipeDescription;
}
public String getRecipeProcses() {
	return recipeProcses;
}
public void setRecipeProcses(String recipeProcses) {
	this.recipeProcses = recipeProcses;
}
public void addIngredient(Integer IngredientId,IngredientType ingredientType, Integer IngredientAmount)/*Kosher levels: 0 parve, 1 milk,2 meat, 3 pig*/
{
	Ingredient newIngredient= new Ingredient(IngredientId);//***//
	 this.recipeIngredientId.add(newIngredient.getIngredientId()); 
	 this.recipeIngredientsType.add(ingredientType.getIngredientTypeId());
	 this.recipeIngredientsAmount.add(IngredientAmount);
	 this.recipeTotalCalories+=(newIngredient.getIngredientCalories()*IngredientAmount*ingredientType.getIngredientTypeValue());
	 this.recipeTotalCarbohydrate+=newIngredient.getIngredientCarbohydrate()*IngredientAmount*ingredientType.getIngredientTypeValue();
	 this.recipeTotalFat+=newIngredient.getIngredientFat()*IngredientAmount*ingredientType.getIngredientTypeValue();
	 //*protein*//
	 {
		 if(newIngredient.getIngredientKashruth()!=0) //*Kosher check*//
			 	if(this.getRecipeKashruth()!=3)
			 			if(this.getRecipeKashruth()==0) {this.setRecipeKashruth(newIngredient.getIngredientKashruth());}
			 			else if (this.getRecipeKashruth()!=newIngredient.getIngredientKashruth())
			 				this.setRecipeKashruth(3);
	 }
	 for( int i=0;i<Allergen.getMaxAllergen();i++)
	 {
		 if(newIngredient.getIngredientAllergen(i)>0)
			 this.recipeAllergen[i]++;//***//
	 }	 
}
@Override
String getEntitieKey() {
	return "recipeId";
}
@Override
String getEntitieKeyValue() {
	return getRecipeId().toString();
}
@Override
String getEntitieAttributesNames() {
	return " recipeId , recipeName , recipeImage , recipeTotalCalories, recipeTotalCarbohydrate, recipeTotalProtein , recipeTotalFat , recipeKashruth , recipeTimeToMake, recipeComplex , recipeRate , recipeDescription  , recipeProcses, recipePersonEmail ";
}
@Override
String getEntitieAttributesValues() {
	return this.getRecipeId().toString() +" , " +
	this.getRecipeName() +" , " +
	this.getRecipeImage()+" , " +
	this.getRecipeTotalCalories().toString() +" , " +
	this.getRecipeTotalCarbohydrate().toString() +" , " +
	this.getRecipeTotalProtein().toString() +" , " +
	this.getRecipeTotalFat().toString() +" , " +
	this.getRecipeKashruth().toString()+" , " +
	this.getRecipeTimeToMake().toString()+" , " +
	this.getRecipeComplex().toString()+" , " +
	this.getRecipeRate().toString()+" , " +
	this.getRecipeDescription()+" , " +
	this.getRecipeProcses()+" , " +
	this.getRecipePersonEmail();
}
@Override
String getEntitieAttributesNamesValues() {
	return  " recipeId = "+this.getRecipeId().toString() +" , " +
			 ", recipeName = "+	this.getRecipeName() +" , " +
			 ", recipeImage = "+	this.getRecipeImage().toString() +" , " +
			 ", recipeTotalCalories = "+	this.getRecipeTotalCalories().toString() +" , " +
			 ", recipeTotalCarbohydrate = "+	this.getRecipeTotalCarbohydrate().toString() +" , " +
			 ", recipeTotalProtein = "+	this.getRecipeTotalProtein().toString() +" , " +
			 ", recipeTotalFat = "+	this.getRecipeTotalFat().toString() +" , " +
			 ", recipeKashruth = "+	this.getRecipeKashruth().toString() +" , " +
			 ", recipeTimeToMake = "+	this.getRecipeTimeToMake().toString() +" , " +
			 ", recipeComplex = "+	this.getRecipeComplex().toString() +" , " +
			 ", recipeRate = "+	this.getRecipeRate().toString() +" , " +
			 ", recipeDescription = "+	this.getRecipeDescription() +" , " +
			 ", recipeProcses = "+	this.getRecipeProcses()+" , " +
			 ", recipePersonEmail = "+	this.getRecipePersonEmail() +" ";
}
@Override
public void getPsmtmt(PreparedStatement pstmt) {
	try {
       	
		pstmt.setInt(1, recipeId);
		pstmt.setString(2, recipeName);
		pstmt.setBlob(3, recipeImage);
		pstmt.setInt(4, recipeTotalCalories);
		pstmt.setInt(5, recipeTotalCarbohydrate);
		pstmt.setInt(6, recipeTotalProtein);
		pstmt.setInt(7, recipeTotalFat);
		pstmt.setInt(8, recipeKashruth);
		pstmt.setTime(9, recipeTimeToMake);
		pstmt.setInt(10, recipeComplex);
		pstmt.setString(11, recipeDescription);
		pstmt.setString(12, recipeProcses);
		pstmt.setString(13, recipePersonEmail);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
 
}
