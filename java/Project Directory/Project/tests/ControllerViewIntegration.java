package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import controller.Controller;
import controller.Event;
import controller.MyController;
import model.*;
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

	@Test
	void testTrueLogin() {
		String email = "drakarisValyrian.com";
		String pass = "khaleesi";
		v.login(email,pass);
		assertTrue(myView.check);
	}

	@Test
	void testFalseLogin() {
		String email = "eld";
		String pass = "valad";
		v.login(email,pass);
		assertFalse(myView.check);
	}

	@SuppressWarnings("static-access")
	@Test
	void testTrueUserRegister() {
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafiasafi", "asafiasafi",
				"1991-01-10", false, null, true, null, 0,0,0,0,0,0,0,0,0,0,0,0,true);
		assertTrue(myView.check);
		myView.myUser.Delete();
	}
	@SuppressWarnings("static-access")
	@Test
	void testTrueDietitianRegister() {
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafiasafi", "asafiasafi",
				"1991-01-10", true, "1234", true, "1991-01-10", 0,0,0,0,0,0,0,0,0,0,0,0,true);
		assertTrue(myView.check);
		myView.myDietitian.Delete();
	}


	@Test
	void testPassLengthTrueCompareFalseRegister() {
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafiasafi", "asafiasafj",
				"1991-01-10", true, "1234", true, "1991-01-10", 0,0,0,0,0,0,0,0,0,0,0,0,true);			
		assertFalse(myView.check);
	}

	@Test
	void testPassLengthFalseCompareTrueRegister() {
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafi", "asafi",
				"1991-01-10", true, "1234", true, "1991-01-10", 0,0,0,0,0,0,0,0,0,0,0,0,true);		
		assertFalse(myView.check);
	}

	@Test
	void testFalseRegister() // <6 & !=
	{
		v.register("rotem", "hayout", "rotemhy@gmail.com", "asafi", "asafj",
				"1991-01-10", true, "1234", true, "1991-01-10", 0,0,0,0,0,0,0,0,0,0,0,0,true);		
		assertFalse(myView.check);
	}

	@Test
	void testFalseRegisterExist()
	{
		v.register("Daenerys", "Targaryen", "drakarisValyrian.com", "khaleesi", "khaleesi",
				"2019-06-17", false, null, true, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, true);
		assertFalse(myView.check);
	}

	@Test
	void testTrueGetTop10() {
		v.getTop10();
		assertNotNull(myView.recipeArray);
	}

	@SuppressWarnings("static-access")
	@Test
	void testTrueMainSearch() {
		myView.myUser=Models.GetUserFromDB("drakarisValyrian.com");
		v.mainSearch("Ommlete");
		assertNotNull(myView.recipeArray);
	}

	@Test
	void testFalseMainSearch() {
		v.mainSearch("rotem");
		assertNull(myView.recipeArray);
	}

	@Test
	void testTrueAdvancedSearch() {
		v.advancedSearch("Ommelete", 0, 3, null, "50", 0,0,0,0,0,0,1,0,0,0,0,0);
		assertNotNull(myView.recipeArray);
	}

	@Test
	void testFalseAdvancedSearch() {
		v.advancedSearch("lazania", 1, 0, "60", "100", 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0);
		assertNull(myView.recipeArray);
	}

	@Test
	void testAddIngredient() {
		v.addIngredient("cheese", 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2.0, 1.0, 1.0, 1.0);
		
	}

	@Test
	void testMyFavorite() {
		v.myFavorite();
		assertNotNull(myView.recipeArray);
	}



	@Test
	void testMyRecipes() {
		v.myRecipes();
		assertNotNull(myView.recipeArray);
	}


	@Test
	void testGetRecipes() {
		v.getAllRecipes();
		assertNotNull(myView.recipeArray);
	}


	@Test
	void testUserUpdate() {
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

}
