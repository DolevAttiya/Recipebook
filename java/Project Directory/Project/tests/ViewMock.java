package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;

import model.Dietitian;
import model.Ingredient;
import model.IngredientType;
import model.Recipe;
import model.User;
import view.View;

public class ViewMock implements View {

	@Override
	public void uloginResponse(ArrayList<User> usU) {
		if(usU!=null)
			assertEquals("drakarisValyrian.com", usU.get(0).getPersonEmail());
		else
			assertNull(usU);
	}

	@Override
	public void dloginResponse(ArrayList<Dietitian> usD) {
			assertEquals("midget@kingslanding.com", usD.get(0).getPersonEmail());
	}

	@Override
	public void uRegisterResponse(ArrayList<User> usU) {
		if(usU!=null)
			assertEquals("idontknowhatemailis", usU.get(0).getPersonEmail());
		else
			assertNull(usU);
	}

	@Override
	public void dRegisterResponse(ArrayList<Dietitian> usD) {
		if(usD!=null)
			assertEquals("idontknowhatemailis", usD.get(0).getPersonEmail());
		else
			assertNull(usD);
	}

	@Override
	public void userUpdateResponse(ArrayList<User> usU) {
		if(usU!=null)
			assertTrue(usU.get(0).getUserKashruth());
		else
			assertNull(usU);
	}

	@Override
	public void deleteUserResponse(ArrayList<User> usU) {
		if(usU!=null)
			assertNotNull(usU.get(0));
		else
			assertNull(usU);
	}
	
	@Override
	public void dietitianUpdateResponse(ArrayList<Dietitian> usD) {
		if(usD!=null)
			assertEquals("1996-06-17", usD.get(0).getDietitianStatDate().toString());
		else
			assertNull(usD);
	}
	
	@Override
	public void deleteDietitianResponse(ArrayList<Dietitian> usD) {
		if(usD!=null)
			assertNotNull(usD.get(0));
		else
			assertNull(usD);
	}
	
	@Override
	public void getAllRecipesResponse(ArrayList<Recipe> r) { 
		assertNotEquals(0,r.size());
	}
	
	@Override
	public void getAllMeasuringTypesResponse(ArrayList<IngredientType> measuring) {
		assertNotEquals(0,measuring.size());
	}
	
	@Override
	public void getAllIngredientResponse(ArrayList<Ingredient> ing) {
		assertNotEquals(0,ing.size());
	}

	@Override
	public void getTop10Response(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void myRecipesResponse(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void myFavoriteResponse(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void searchResponse(ArrayList<Recipe> r) {
		if(r.size()!=0)
			assertNotNull(r);
		else
			assertEquals(0, r.size());
	}

	@Override
	public void addRecipeResponse(ArrayList<Recipe> r) {
		if(r!=null)
			assertNotNull(r);
		else
			assertNull(r);
	}
	
	@Override
	public void recipeUpdateResponse(ArrayList<Recipe> r) {
		if(r!=null)
			assertEquals(1,(int)r.get(0).getRecipeKashruth());
		else
			assertNull(r);
	}
	
	@Override
	public void deleteRecipeResponse(ArrayList<Recipe> rec) {
		if(rec!=null)
			assertNotNull(rec.get(0));
		else
			assertNull(rec);
	}
	
	@Override
	public void addIngredientResponse(ArrayList<Ingredient> in) {
		if(in!=null)
			assertNotNull(in.get(0));
		else
			assertNull(in);
	}
	
	@Override
	public void recipeReportResponse(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void ingredientReportResponse(ArrayList<Ingredient> ing) {
		assertNotEquals(0,ing.size());
	}

	@Override
	public void ingredientUpdateResponse(ArrayList<Ingredient> in) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(String email, String pass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTop10() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mainSearch(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void advancedSearch(String s, Integer kashruth, Integer complexity, String timeToMake, String rateAbove,
			Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose,
			Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity,
			Integer isChocolate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myFavorite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myRecipes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dietitianUpdate(String firstName, String lastName, String email, String pass, String pass2,
			String dateOfBirth, String dietitianNum, String dietitianStatDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDietitian() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteIngredient(Ingredient ing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recipeUpdate(Recipe rec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ingredientUpdate(Ingredient ing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllRecipes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllMeasuringTypes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addIngredientToRecipe(Ingredient newIngredient, IngredientType newingredientType,
			Double IngredientAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addIngredient(String ingredientName, Integer kashruth, Integer isFish, Integer isStrawberries,
			Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds,
			Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate, Double calories,
			Double carbohydrate, Double fat, Double protein) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllIngredient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(String firstName, String lastName, String email, String pass, String pass2, String dateOfBirth,
			Integer isDietitian, String dietitianNum, Integer isKosher, String dietitianStatDate, Integer isFish,
			Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk,
			Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity,
			Integer isChocolate, Integer wantAllerg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRecipe(String recipeName, Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten,
			Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut,
			Integer isAcidity, Integer isChocolate, String description, Integer complexity, Integer timeToMake,
			String instructions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillIngredientIdToName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeRecipe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recipeReport(Integer allergy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ingredientReport(Integer allergy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userUpdate(String firstName, String lastName, String email, String pass, String pass2,
			String dateOfBirth, Integer isKosher, Integer isFish, Integer isStrawberries, Integer isCoffie,
			Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts,
			Integer isPeanut, Integer isAcidity, Integer isChocolate, Integer wantAllerg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void likePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userUpdateForFavorite(User usU) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dietitianUpdateForFavorite(Dietitian usD) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecipe() {
		// TODO Auto-generated method stub
		
	}
}
