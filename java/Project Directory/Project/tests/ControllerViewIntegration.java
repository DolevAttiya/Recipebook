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

	@Test
	void testTrueUserRegister() {
		String firstName="rotem";
		String lastName="hayout";
		String email="rotemhy@gmail.com";
		String pass="asafiasafi";
		String pass2="asafiasafi";
		String dateOfBirth="1991-01-10";
		boolean isDietitian=false;
		String dietitianNum=null;
		boolean isKosher=true;
		String dietitianStatDate=null;
		Integer isFish=0;
		Integer isStrawberries=0;
		Integer isCoffie=0;
		Integer isGluten=0;
		Integer isLactose=0;
		Integer isMilk=0;
		Integer isEggs=0;
		Integer isSeeds=0;
		Integer isTreeNuts=0;
		Integer isPeanut=0;
		Integer isAcidity=0; 
		Integer isChocolate=0; 
		boolean wantAllerg=true;
		v.register(firstName, lastName, email, pass, pass2, dateOfBirth, isDietitian, dietitianNum, isKosher, dietitianStatDate, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, wantAllerg);
		assertTrue(myView.check);
	}

@Test
	void testTrueDietitianRegister() {
		String firstName="rotem";
		String lastName="hamalka";
		String email="rotemhy@gmail.com";
		String pass="asafiasafi";
		String pass2="asafiasafi";
		String dateOfBirth="1991-01-10";
		boolean isDietitian=true;
		String dietitianNum="1234";
		boolean isKosher=true;
		String dietitianStatDate="1991-01-10";
		Integer isFish=0;
		Integer isStrawberries=0;
		Integer isCoffie=0;
		Integer isGluten=0;
		Integer isLactose=0;
		Integer isMilk=0;
		Integer isEggs=0;
		Integer isSeeds=0;
		Integer isTreeNuts=0;
		Integer isPeanut=0;
		Integer isAcidity=0; 
		Integer isChocolate=0; 
		boolean wantAllerg=true;
		v.register(firstName, lastName, email, pass, pass2, dateOfBirth, isDietitian, dietitianNum, isKosher, dietitianStatDate, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, wantAllerg);
	}

	
	@Test
	void testPassLengthTrueCompareFalseRegister() {
		String firstName="rotem";
		String lastName="hayout";
		String email="rotemhy@gmail.com";
		String pass="assafi";
		String pass2="assafj";
		String dateOfBirth="1991-01-10";
		boolean isDietitian=false;
		String dietitianNum=null;
		boolean isKosher=true;
		String dietitianStatDate=null;
		Integer isFish=0;
		Integer isStrawberries=0;
		Integer isCoffie=0;
		Integer isGluten=0;
		Integer isLactose=0;
		Integer isMilk=0;
		Integer isEggs=0;
		Integer isSeeds=0;
		Integer isTreeNuts=0;
		Integer isPeanut=0;
		Integer isAcidity=0; 
		Integer isChocolate=0; 
		boolean wantAllerg=true;
		v.register(firstName, lastName, email, pass, pass2, dateOfBirth, isDietitian, dietitianNum, isKosher, dietitianStatDate, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, wantAllerg);
		assertFalse(myView.check);

	}
	
	@Test
	void testPassLengthFalseCompareTrueRegister() {
		String firstName="rotem";
		String lastName="hayout";
		String email="rotemhy@gmail.com";
		String pass="asafi";
		String pass2="asafi";
		String dateOfBirth=null;
		boolean isDietitian=false;
		String dietitianNum=null;
		boolean isKosher=true;
		String dietitianStatDate=null;
		Integer isFish=0;
		Integer isStrawberries=0;
		Integer isCoffie=0;
		Integer isGluten=0;
		Integer isLactose=0;
		Integer isMilk=0;
		Integer isEggs=0;
		Integer isSeeds=0;
		Integer isTreeNuts=0;
		Integer isPeanut=0;
		Integer isAcidity=0; 
		Integer isChocolate=0; 
		boolean wantAllerg=true;
		v.register(firstName, lastName, email, pass, pass2, dateOfBirth, isDietitian, dietitianNum, isKosher, dietitianStatDate, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, wantAllerg);
		assertFalse(myView.check);
	}
	
	@Test
	void testFalseRegister() // <6 & !=
	{
		String firstName="rotem";
		String lastName="hayout";
		String email="rotemhy@gmail.com";
		String pass="asafi";
		String pass2="asafj";
		String dateOfBirth="1991-01-10";
		boolean isDietitian=false;
		String dietitianNum=null;
		boolean isKosher=true;
		String dietitianStatDate=null;
		Integer isFish=0;
		Integer isStrawberries=0;
		Integer isCoffie=0;
		Integer isGluten=0;
		Integer isLactose=0;
		Integer isMilk=0;
		Integer isEggs=0;
		Integer isSeeds=0;
		Integer isTreeNuts=0;
		Integer isPeanut=0;
		Integer isAcidity=0; 
		Integer isChocolate=0; 
		boolean wantAllerg=true;
		v.register(firstName, lastName, email, pass, pass2, dateOfBirth, isDietitian, dietitianNum, isKosher, dietitianStatDate, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, wantAllerg);
		assertFalse(myView.check);
	}

	@Test
	void testFalseRegisterExist()
	{
		String firstName="Daenerys";
		String lastName="Targaryen";
		String email="drakarisValyrian.com";
		String pass="khaleesi";
		String pass2="khaleesi";
		String dateOfBirth="2019-06-17";
		boolean isDietitian=false;
		String dietitianNum=null;
		boolean isKosher=true;
		String dietitianStatDate=null;
		Integer isFish=0;
		Integer isStrawberries=0;
		Integer isCoffie=0;
		Integer isGluten=0;
		Integer isLactose=0;
		Integer isMilk=0;
		Integer isEggs=0;
		Integer isSeeds=0;
		Integer isTreeNuts=0;
		Integer isPeanut=0;
		Integer isAcidity=0; 
		Integer isChocolate=0; 
		boolean wantAllerg=true;
		v.register(firstName, lastName, email, pass, pass2, dateOfBirth, isDietitian, dietitianNum, isKosher, dietitianStatDate, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, wantAllerg);
		assertFalse(myView.check);
	}

	@Test
	void testGetTop10() {
		v.getTop10();
		assertNotNull(myView.recipeArray);
	}

/*
	@Test
	void testMainSearch() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAdvancedSearch() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAddIngredient() {
		fail("Not yet implemented"); // TODO
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
		v.getRecipes();
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
*/

}
