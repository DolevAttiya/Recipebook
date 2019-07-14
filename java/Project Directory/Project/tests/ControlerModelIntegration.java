package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import controller.Event;
import controller.Controller;
import controller.MyController;
import model.Dietitian;
import model.Models;
import model.Recipe;
import model.User;
import model.model;
import view.View;
import view.myView;

public class ControlerModelIntegration {

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
		v = new ViewMock();
		controllerTest = new MyController(m,v);
		((Models)m).addObserver(controllerTest);
	}

	@Test
	void userLoginTrueTest() {
		ev = new Event();
		ev.getArr().add("user_login");
		ev.getArr().add("drakarisValyrian.com");
		ev.getArr().add("89d31d9d76e49bcbb132e6f01cb05625bd03e48c59f62573f97077ef12e14947");
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void LoginFalseTest() {
		ev = new Event();
		ev.getArr().add("user_login");
		ev.getArr().add("saywhattttt");
		ev.getArr().add("idontknow");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void dietitianLoginTrueTest() {
		ev = new Event();
		ev.getArr().add("user_login");
		ev.getArr().add("midget@kingslanding.com");
		ev.getArr().add("3940821ae292629029cb646e9b2aba67695958924953818e0ef00cdfc7c567f9");
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void userRegisterTrueTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		user= new User("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, al, true, false);
		ev.getArr().add("user_register");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
		user = Models.GetUserFromDB("idontknowhatemailis");
		user.Delete();
	}

	@Test
	void userRegisterFalseTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		user = new User("drakarisValyrian.com", "Daenerys", "Targaryen",LocalDate.parse("2019-06-17"), "eladvald", null, 99, al, true, false);
		ev.getArr().add("user_register");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void dietitianRegisterTrueTest() {
		ev = new Event();
		dietitian = new Dietitian("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, LocalDate.parse("2010-06-17"));
		ev.getArr().add("dietitian_register");
		ev.getArr().add(dietitian);
		((MyController)controllerTest).update(null, ev);
		dietitian = Models.GetDietitianFromDB("idontknowhatemailis");
		dietitian.Delete();
	}

	@Test
	void dietitianRegisterFalseTest() {
		ev = new Event();
		dietitian = new Dietitian("midget@kingslanding.com", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, LocalDate.parse("2010-06-17"));
		ev.getArr().add("dietitian_register");
		ev.getArr().add(dietitian);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void userUpdateTrueTest() {
		ev = new Event();
		user = Models.GetUserFromDB("drakarisValyrian.com");
		user.setUserKashruth(true);
		ev.getArr().add("user_update");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
		user.setUserKashruth(false);
	}

	@Test
	void userUpdateFalseTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		user= new User("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, al, true, false);
		user.setUserKashruth(true);
		ev.getArr().add("user_update");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
		user.setUserKashruth(false);
	}
	
	/*@Test
	void userDeleteTrueTest() {
		ev = new Event();
		user = Models.GetUserFromDB("drakarisValyrian.com");
		user.setUserKashruth(true);
		ev.getArr().add("user_update");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
		user.setUserKashruth(false);
	}*/

	/*@Test
	void userDeleteFalseTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		user= new User("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, al, true, false);
		user.setUserKashruth(true);
		ev.getArr().add("user_update");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
		user.setUserKashruth(false);
	}*/

	@Test
	void dietitianUpdateTrueTest() {
		ev = new Event();
		dietitian = Models.GetDietitianFromDB("midget@kingslanding.com");
		dietitian.setDietitianStatDate(LocalDate.parse("1996-06-17"));
		ev.getArr().add("dietitian_update");
		ev.getArr().add(dietitian);
		((MyController)controllerTest).update(null, ev);
		dietitian.setDietitianStatDate(LocalDate.parse("2000-01-01"));
		dietitian.Update();
	}

	@Test
	void dietitianUpdateFalseTest() {
		ev = new Event();
		dietitian= new Dietitian("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, LocalDate.parse("2010-06-17"));
		dietitian.setDietitianStatDate(LocalDate.parse("1996-06-17"));
		ev.getArr().add("dietitian_update");
		ev.getArr().add(dietitian);
		((MyController)controllerTest).update(null, ev);
	}
	
	/*@Test
	void dietitianDeleteTrueTest() {
		ev = new Event();
		dietitian = Models.GetDietitianFromDB("midget@kingslanding.com");
		dietitian.setDietitianStatDate(LocalDate.parse("1996-06-17"));
		ev.getArr().add("dietitian_update");
		ev.getArr().add(dietitian);
		((MyController)controllerTest).update(null, ev);
		dietitian.setDietitianStatDate(LocalDate.parse("2000-01-01"));
		dietitian.Update();
	}*/

	/*@Test
	void dietitianDeleteFalseTest() {
		ev = new Event();
		dietitian= new Dietitian("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, LocalDate.parse("2010-06-17"));
		dietitian.setDietitianStatDate(LocalDate.parse("1996-06-17"));
		ev.getArr().add("dietitian_update");
		ev.getArr().add(dietitian);
		((MyController)controllerTest).update(null, ev);
	}*/
	
	@Test
	void getAllRecipesTest() {
		ev = new Event();
		ev.getArr().add("all_recipes");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void Top10Test() {
		ev = new Event();
		ev.getArr().add("top_10");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void myRecipesTest() {
		ev = new Event();
		ev.getArr().add("my_recipes");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void myFavoriteRecipesTest() {
		ev = new Event();
		ev.getArr().add("favorite_recipes");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void searchTrueTest() {
		ev = new Event();
		ev.getArr().add("search");
		ev.getArr().add("ommlete");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void searchFalseTest() {
		ev = new Event();
		ev.getArr().add("search");
		ev.getArr().add("banana");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void addRecipeTrueTest() {
		Integer[] rA= {0,0,0,0,1,0,0,1,0,0,1,0};
		ev = new Event();
		user = Models.GetUserFromDB("drakarisValyrian.com");
		recipe = new Recipe(null, "yuval's matkon", rA, null, null, null, null, null, null, null, "drakarisValyrian.com", null, null, null, null, null, null);
		ev.getArr().add("recipe_insert");
		ev.getArr().add(recipe);
		((MyController)controllerTest).update(null, ev);
		ResultSet rs =Models.SelectSpecificFrom("Max( recipeId ) as max", "Recipe", null, null);
		try {
		recipe = Models.GetRecipeFromDB(rs.getInt("max"));
		recipe.Delete();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void addRecipeFalseTest() {
		Integer[] rA= {0,0,0,0,1,0,0,1,0,0,1,0};
		ev = new Event();
		recipe = new Recipe(null, "ommlete", rA, null, null, null, null, null, null, null, "drakarisValyrian.com", null, null, null, null, null, null);
		ev.getArr().add("recipe_insert");
		ev.getArr().add(recipe);
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void updateRecipeTest() {
		ev = new Event();
		ev.getArr().add("recipe_update");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void deleteRecipeTest() {
		ev = new Event();
		ev.getArr().add("recipe_delete");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void addIngredientTest() {
		ev = new Event();
		ev.getArr().add("ingredient_insert");
		((MyController)controllerTest).update(null, ev);
	}
}
