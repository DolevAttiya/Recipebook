package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import controller.Controller;
import controller.Event;
import controller.MyController;
import model.*;
import model.Ingredient;
import model.User;
import view.*;

class ControllerViewIntegration {

	Event ev;
	static model m;
	static View v;
	static Controller controllerTest;
	User user;
	Dietitian dietitian;
	Recipe recipe;

	@BeforeAll
	static void setup() {
		m = new Models();
		v = new myView();
		controllerTest = new MyController(m,v);
		((myView)v).addObserver(controllerTest);
		((Models)m).addObserver(controllerTest);
	}

	// LOGIN //
	@Test
	void testTrueLogin() {
		v.login("drakarisValyrian.com","khaleesi");
		assertTrue(myView.check);
	}
	@Test
	void testFalseLogin() {
		v.login("eld","valad");
		assertFalse(myView.check);
	}

	// REGISTER //
	@Test
	void testTrueUserRegister() {
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafiasafi", "asafiasafi",
				"1991-01-10", 0, null, 1, null, 0,0,0,0,0,0,0,0,0,0,0,0,1);
		assertTrue(myView.check);
		myView.myUser.Delete();
	}
	@Test
	void testTrueDietitianRegister() {
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafiasafi", "asafiasafi",
				"1991-01-10", 1, "1234", 1, "1991-01-10", 0,0,0,0,0,0,0,0,0,0,0,0,1);
		assertTrue(myView.check);
		myView.myDietitian.Delete();
	}
	@Test
	void testPassLengthTrueCompareFalseRegister() {
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafiasafi", "asafiasafj",
				"1991-01-10", 1, "1234", 1, "1991-01-10", 0,0,0,0,0,0,0,0,0,0,0,0,1);			
		assertFalse(myView.check);
	}
	@Test
	void testPassLengthFalseCompareTrueRegister() {
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafi", "asafi",
				"1991-01-10", 1, "1234", 1, "1991-01-10", 0,0,0,0,0,0,0,0,0,0,0,0,1);		
		assertFalse(myView.check);
	}
	@Test
	void testFalseRegister() // <6 & !=
	{
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafi", "asafj",
				"1991-01-10", 1, "1234", 1, "1991-01-10", 0,0,0,0,0,0,0,0,0,0,0,0,1);		
		assertFalse(myView.check);
	}
	@Test
	void testFalseRegisterExist() // If the user exists
	{
		v.register("Daenerys", "Targaryen", "drakarisValyrian.com", "khaleesi", "khaleesi",
				"2019-06-17", 0, null, 1, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
		assertFalse(myView.check);
	}

	// MAIN PAGE //
	@Test
	void testTrueGetTop10() {
		v.getTop10();
		assertNotNull(myView.recipeArray);
	}
	@Test
	void testTrueMainSearch()
	{
		myView.myUser=Models.GetUserFromDB("faceless@winterfall.com");
		v.mainSearch("Ommlete");
		assertTrue(myView.check);
	}
	@Test
	void testFalseMainSearch() // No results
	{
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.mainSearch("rotem");
		assertFalse(myView.check);
	}
	@Test
	void testMyFavorite() {
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.myFavorite();
		assertNotNull(myView.recipeArray);
	}
	@Test
	void testGetAllRecipes() {
		v.getAllRecipes();
		assertNotEquals(0, myView.recipeArray);
	}

	// ADVANCED SEARCH //
	@Test
	void testTrueAdvancedSearch() // Found results in DB
	{
		v.advancedSearch("Ommelete", 0, 3, null, "50", 0,0,0,0,0,0,1,0,0,0,0,0);
		assertNotNull(myView.recipeArray);
	}
	@Test
	void testFalseAdvancedSearch() // No results
	{
		v.advancedSearch("lazania", 1, 0, "60", "100", 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0);
		assertEquals(0,myView.recipeArray.size());
	}

	// ADD RECIPE //
	@Test
	void testTrueUserAddRecipe() // success
	{
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.initializeRecipe();
		Recipe r;
		v.addRecipe("Lazania", "best Lazania ever", 3, 30, "1. Go to a resturant and give up on the Lazania");
		assertTrue(myView.check);
		ResultSet rs =Models.SelectSpecificFrom("Max( recipeId ) as max", "Recipe", null, null);
		try {
			r = Models.GetRecipeFromDB(rs.getInt("max"));
			r.Delete();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	@Test
	void testTrueDietitianAddRecipe() // success
	{
		myView.myDietitian=Models.GetDietitianFromDB("midget@kingslanding.com");
		v.initializeRecipe();
		Recipe r;
		v.addRecipe("Lazania", "best Lazania ever", 3, 30, "1. Go to a resturant and give up on the Lazania");
		assertTrue(myView.check);
		ResultSet rs =Models.SelectSpecificFrom("Max( recipeId ) as max", "Recipe", null, null);
		try {
			r = Models.GetRecipeFromDB(rs.getInt("max"));
			r.Delete();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	@Test
	void testFalseAddRecipe() // Recipe exists
	{
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.initializeRecipe();
		v.addRecipe("Ommlete", "best ommlete ever", 3, 30, "1. Break 3 eggs into a boal");
		assertFalse(myView.check);		
	}
	
	@Test
	void testFillIngredientIdToName() {
		myView.myRecipe=Models.GetRecipeFromDB(1);
		v.fillIngredientIdToName();
	}

	// ADD INGREDIENT //
	@Test
	void testTrueAddIngredient()
	{
		Ingredient ing;
		v.addIngredient("cheese", 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2.0, 1.0, 1.0, 1.0);
		assertTrue(myView.check);
		ResultSet rs =Models.SelectSpecificFrom("Max( ingredientId ) as max", "Ingredient", null, null);
		try {
			ing = Models.GetIngredientFromDB(rs.getInt("max"));
			ing.Delete();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	void testFalseAddIngredient() // already exist in DB
	{
		v.addIngredient("Wheat flour",0,0,0,1,0,0,0,0,0,0,0,0,0,0.0,0.0,0.0,0.0);
		assertFalse(myView.check);
	}

	// PANEL //
	@Test
	void testMyRecipes() {
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.myRecipes();
		assertNotEquals(0, myView.recipeArray);
	}

	// UPDATE //
	@Test
	void testTrueUserUpdate() {
		v.register("yuvali", "yuvali", "yuvali", "yuvali", "yuvali", "1993-04-04", 0, null, 1, null, 0, 0, 0,0,0,0,0,0,0,0,0,0,0);
		v.userUpdate("rotem", "hayout", "yuvali", "asafiasafi", "asafiasafi","1991-01-10", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
		assertTrue(myView.check);
		v.deleteUser();
	}
	@Test
	void testTrueDietitianUpdate() {
		v.register("yuvali", "yuvali", "yuvali", "yuvali", "yuvali", "1993-04-04", 1, "12", 1, "1993-04-05", 0, 0, 0,0,0,0,0,0,0,0,0,0,0);
		v.dietitianUpdate("rotem", "hayout", "yuvali", "asafiasafi", "asafiasafi", "1991-01-10", "1234", "1991-08-10");
		assertTrue(myView.check);
		myView.myDietitian.Delete();
	}

	// USER //
	@Test
	void testTrueDeleteUser() {
		v.register("yuvali", "yuvali", "yuvali", "yuvali", "yuvali", "1993-04-04", 0, null, 1, null, 0, 0, 0,0,0,0,0,0,0,0,0,0,0);
		v.deleteUser();
		assertTrue(myView.check);
	}
	@Test
	void testFalseDeleteUser() {
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		ArrayList<Integer> favres = new ArrayList<Integer>();
		favres.add(1);
		myView.myUser=new User("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", favres, 99, al, true, false);
		v.deleteUser();
		assertFalse(myView.check);
	}

	// DIETITIAN //
	@Test
	void testTrueDeleteDietitian() {
		v.register("yuvali", "yuvali", "yuvali", "yuvali", "yuvali", "1993-04-04", 1, "12", 1, "1993-04-05", 0, 0, 0,0,0,0,0,0,0,0,0,0,0);
		v.deleteDietitian();
		assertTrue(myView.check);
	}
	@Test
	void testFalseDeleteDietitian() {
		myView.myDietitian= new Dietitian("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, LocalDate.parse("2010-06-17"));
		v.deleteDietitian();
		assertFalse(myView.check);
	}

	// INGREDIENT // not implemented
	/*
	@Test
	void testTrueDeleteIngredient() throws SQLException {
		Ingredient ing=null;
		v.addIngredient("cheese", 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2.0, 1.0, 1.0, 1.0);
		ResultSet rs =Models.SelectSpecificFrom("Max( ingredientId ) as max", "Ingredient", null, null);
		try {
			ing = Models.GetIngredientFromDB(rs.getInt("max"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		v.deleteIngredient(ing);
		assertTrue(myView.check);
	}
	@Test
	void testIngredientUpdate() {
		fail("Not yet implemented"); // TODO
	}
	 */

	// RECIPE //
	@Test
	void testTrueUserDeleteRecipe() // was able to delete
	{
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.initializeRecipe();
		Recipe r=null;
		v.addRecipe("Lazanaia", "best Lazania ever", 3, 30, "1. Go to a resturant and give up on the Lazania");
		ResultSet rs =Models.SelectSpecificFrom("Max( recipeId ) as max", "Recipe", null, null);
		try {
			r = Models.GetRecipeFromDB(rs.getInt("max"));
			v.deleteRecipe();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	@Test	
	void testTrueUserLikePressed() // changed the data
	{
		myView.myDietitian=null;
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		myView.myRecipe=Models.GetRecipeFromDB(1);
		v.likePressed();
		assertTrue(myView.check);
	}
	@Test
	void testTrueDietitianLikePressed() // changed the data
	{
		myView.myUser=null;
		myView.myDietitian=Models.GetDietitianFromDB("midget@kingslanding.com");
		myView.myRecipe=Models.GetRecipeFromDB(1);
		v.likePressed();
		assertTrue(myView.check);
	}
	@Test
	void testRecipeUpdate() {
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.initializeRecipe();
		v.addRecipe("Lazania", "best Lazania ever", 3, 30, "1. Go to a resturant and give up on the Lazania");
		v.recipeUpdate(myView.myRecipe.getRecipeName(), myView.myRecipe.getRecipeDescription(), myView.myRecipe.getRecipeComplex(), myView.myRecipe.getRecipeTimeToMake(), myView.myRecipe.getRecipeProcess());
		assertTrue(myView.check);
		myView.myRecipe.Delete();

	}

	// REPORTS //
	@Test
	void testRecipeReport() {
		v.recipeReport(1);
		assertNotEquals(0, myView.recipeArray.size());
	}
	@Test
	void testIngredientReport() {
		v.ingredientReport(1);
		assertNotEquals(0, myView.ingredientArray.size());
	}
		
}