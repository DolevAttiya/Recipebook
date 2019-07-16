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
	void testTrueMainSearch() {
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.mainSearch("Ommlete");
		assertNotNull(myView.recipeArray);
	}
	@Test
	void testFalseMainSearch() {
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.mainSearch("rotem");
		assertEquals(0,myView.recipeArray.size());
	}
	@Test
	void testMyFavorite() {
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.myFavorite();
		assertNotNull(myView.recipeArray);
	}
	@Test
	void testAddRecipe() {
		fail("Not yet implemented"); // TODO
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
		fail("Not yet implemented"); // TODO
	}

/*	
	@Test
	void testInitializeRecipe() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAddIngredientToRecipe() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFillIngredientIdToName() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	void testGetAllIngredient() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	void testGetAllRecipes() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetAllMeasuringTypes() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUserUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUserUpdateForFavorite() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDietitianUpdateForFavorite() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDietitianUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeleteUser() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	void testDeleteDietitian() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeleteIngredient() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeleteRecipe() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	void testRecipeUpdate() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	void testIngredientUpdate() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	void testRecipeReport() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testIngredientReport() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testLikePressed() {
		fail("Not yet implemented"); // TODO
	}
*/
/*
	

	@Test
	void testMyRecipes() {
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.myRecipes();
		assertNotNull(myView.recipeArray);
	}

	@Test
	void testGetRecipes() {
		v.getAllRecipes();
		assertNotNull(myView.recipeArray);
	}

	@Test
	void testTrueUserUpdate() {
		v.register("yuvali", "yuvali", "yuvali", "yuvali", "yuvali", "1993-04-04", 0, null, 1, null, 0, 0, 0,0,0,0,0,0,0,0,0,0,0);
		v.userUpdate("rotem", "hayout", "yuvali", "asafiasafi", "asafiasafi","1991-01-10", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
		assertTrue(myView.check);
		v.deleteUser();
	}


	/*
	@Test
	void testFalseUserUpdate() // User doesn't exist in DB
	{
		v.userUpdate("rotem", "hayout", "rotemhy@gmail.com", "asafiasafi", "asafiasafi", "1991-01-10", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
		assertFalse(myView.check);
	}
	@Test
	void testTrueDietitianUpdate() {
		v.register("yuvali", "yuvali", "yuvali", "yuvali", "yuvali", "1993-04-04", 1, "12", 1, "1993-04-05", 0, 0, 0,0,0,0,0,0,0,0,0,0,0);
		v.dietitianUpdate("rotem", "hayout", "yuvali", "asafiasafi", "asafiasafi", "1991-01-10", "1234", "1991-08-10");
		assertTrue(myView.check);
		myView.myDietitian.Delete();
	}

	@Test
	void testFalseDietitianUpdate() // Dietitian doesn't exist in DB
	{
		v.userUpdate("rotem", "hayout", "rotemhy@gmail.com", "asafiasafi", "asafiasafi","1991-01-10", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
		assertFalse(myView.check);
	}


	@Test // good
	void testTrueDeleteUser() {
		v.register("yuvali", "yuvali", "yuvali", "yuvali", "yuvali", "1993-04-04", 0, null, 1, null, 0, 0, 0,0,0,0,0,0,0,0,0,0,0);
		v.deleteUser();
		assertTrue(myView.check);
	}
*/
/*
	@Test // good
	void testFalseDeleteUser() {
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		ArrayList<Integer> favres = new ArrayList<Integer>();
		favres.add(1);
		myView.myUser=new User("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", favres, 99, al, true, false);
		v.deleteUser();
		assertFalse(myView.check);
	}

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


	@Test
	void testTrueDeleteIngredient() {
		fail("Not yet implemented"); // TODO
	}


	@Test
	void testFalseDeleteIngredient() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testTrueDeleteRecipe() {
		fail("Not yet implemented"); // TODO
	}


	@Test
	void testFalseDeleteRecipe() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testTrueRecipeUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFalseRecipeUpdate() {
		fail("Not yet implemented"); // TODO
	}


	@Test
	void testTrueIngredientUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFalseIngredientUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRecipeReport() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	void testIngredientReport() {
		fail("Not yet implemented"); // TODO
	}
	@Test

	void testTrueUserLikePressed() // changed the data
	{
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		myView.myRecipe=Models.GetRecipeFromDB(1);
		v.likePressed();
		assertTrue(myView.check);
	}

/*
	@Test
	void testTrueDietitianLikePressed() // changed the data
	{

		v.likePressed();
		assertTrue(myView.check);
	}

	@Test
	void testFalseLikePressed() // changed the data
	{
		v.likePressed();
		assertFalse(myView.check);
}

	 */
}
/*
@Test
void testTrueDeleteIngredient() {
	fail("Not yet implemented"); // TODO
@@ -267,18 +267,42 @@ void testTrueIngredientUpdate() {
void testFalseIngredientUpdate() {
	fail("Not yet implemented"); // TODO
}


@Test
void testRecipeReport() {
	fail("Not yet implemented"); // TODO
	v.recipeReport(1);
	assertNotNull(myView.recipeArray);
}

@Test
void testIngredientReport() {
	fail("Not yet implemented"); // TODO
	v.ingredientReport(1);
	assertNotNull(myView.ingredientArray);
}

@Test
void testLikePressed() {
	fail("Not yet implemented"); // TODO
void testTrueUserLikePressed() // changed the data
{
	myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");

	v.likePressed();
	assertTrue(myView.check);
}
*/
/*
@Test
void testTrueDietitianLikePressed() // changed the data
{
	
	v.likePressed();
	assertTrue(myView.check);
}
@Test
void testFalseLikePressed() // changed the data
{
	v.likePressed();
	assertFalse(myView.check);
}
*/