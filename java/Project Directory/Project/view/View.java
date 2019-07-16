package view;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.Event;
import model.Dietitian;
import model.Ingredient;
import model.IngredientType;
import model.Recipe;
import model.User;

public interface View {

	//Responses
	public void uloginResponse (ArrayList<model.User> usU);
	public void dloginResponse (ArrayList<Dietitian> usD);
	public void dRegisterResponse(ArrayList<Dietitian> usD);
	public void uRegisterResponse(ArrayList<model.User> usU);
	public void getTop10Response(ArrayList<Recipe> r);
	public void searchResponse(ArrayList<Recipe> r);
	public void myFavoriteResponse(ArrayList<Recipe> r);
	public void myRecipesResponse(ArrayList<Recipe> r);  
	public void addRecipeResponse(ArrayList<Recipe> r);
	public void addIngredientResponse(ArrayList<Ingredient> in);
	public void userUpdateResponse(ArrayList<User> usU);
	public void dietitianUpdateResponse(ArrayList<Dietitian> usD);
	public void getAllRecipesResponse(ArrayList<Recipe> r);
	public void deleteUserResponse(ArrayList<User> usU);
	public void deleteDietitianResponse(ArrayList<Dietitian> usD);
	public void deleteRecipeResponse(ArrayList<Recipe> rec);
	public void recipeUpdateResponse(ArrayList<Recipe> r);
	public void ingredientUpdateResponse(ArrayList<Ingredient> in);
	public void getAllMeasuringTypesResponse(ArrayList<IngredientType> measuring);
	public void getAllIngredientResponse(ArrayList<Ingredient> ing);
	
	//From GUI to myView
	public void login (String email, String pass);
	public void register(String firstName, String lastName, String email, String pass,String pass2, String dateOfBirth, Integer isDietitian, String dietitianNum, Integer isKosher, String dietitianStatDate,  Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate, Integer wantAllerg);
	public void getTop10();
	public void mainSearch(String s); 
	public void advancedSearch(String s, Integer kashruth, Integer complexity, String timeToMake, String rateAbove,  Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate);
	public void addIngredient (String ingredientName, Integer kashruth,  Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate, Double calories, Double carbohydrate, Double fat, Double protein);
	public void myFavorite ();
	public void myRecipes ();
	public void addRecipe(String recipeName,Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate, String description, Integer complexity, Integer timeToMake, String instructions);
	public void getAllRecipes();
	public void userUpdate(String firstName, String lastName, String email, String pass, String pass2, String dateOfBirth, boolean isKosher, Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate , boolean wantAllerg);
	public void dietitianUpdate(String firstName, String lastName, String email, String pass, String pass2, String dateOfBirth, String dietitianNum, String dietitianStatDate);
	public void deleteUser();
	public void deleteDietitian();
	public void deleteIngredient(Ingredient ing);
	public void deleteRecipe(Recipe rec);
	public void recipeUpdate(Recipe rec);
	public void ingredientUpdate(Ingredient ing);
	public void getAllMeasuringTypes();
	public void addIngredientToRecipe(Ingredient newIngredient,IngredientType newingredientType, Double IngredientAmount); // small add button, adds to Recipe automatically
	public void getAllIngredient();
	public void fillIngredientIdToName();
	public void initializeRecipe();
}
//update ingredient, remove ingredient
//update recipe