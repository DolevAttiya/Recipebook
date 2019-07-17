package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import controller.Event;
import controller.Controller;
import controller.MyController;
import model.Dietitian;
import model.Ingredient;
import model.Models;
import model.Recipe;
import model.User;
import model.model;
import view.View;

public class ControlerModelIntegration {

	Event ev;
	static model m;
	static View v;
	static Controller controllerTest;
	User user;
	Dietitian dietitian;
	Recipe recipe;
	Ingredient ingredient;

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

	@Test
	void userDeleteTrueTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		ArrayList<Integer> favres = new ArrayList<Integer>();
		favres.add(1);
		user = new User("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", favres, 99, al, true, false);
		user.Insert();
		user = Models.GetUserFromDB("idontknowhatemailis");
		ev.getArr().add("user_delete");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void userDeleteFalseTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		ArrayList<Integer> favres = new ArrayList<Integer>();
		favres.add(1);
		user = new User("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", favres, 99, al, true, false);
		ev.getArr().add("user_delete");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
	}

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

	@Test
	void dietitianDeleteTrueTest() {
		ev = new Event();
		ArrayList<Integer> favres = new ArrayList<Integer>();
		favres.add(1);
		dietitian = new Dietitian("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", favres, 99, LocalDate.parse("2010-06-17"));
		dietitian.Insert();
		dietitian = Models.GetDietitianFromDB("idontknowhatemailis");
		ev.getArr().add("dietitian_delete");
		ev.getArr().add(dietitian);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void dietitianDeleteFalseTest() {
		ev = new Event();
		ArrayList<Integer> favres = new ArrayList<Integer>();
		favres.add(1);
		dietitian = new Dietitian("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", favres, 99, LocalDate.parse("2010-06-17"));
		ev.getArr().add("dietitian_delete");
		ev.getArr().add(dietitian);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void getAllRecipesTest() {
		ev = new Event();
		ev.getArr().add("all_recipes");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void getAllIngredientsTest() {
		ev = new Event();
		ev.getArr().add("ingredient_getall");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void getAllIngredientsTypeTest() {
		ev = new Event();
		ev.getArr().add("ingredient_type_getall");
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
		ev.getArr().add("drakarisValyrian.com");
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void myFavoriteRecipesTest() {
		ev = new Event();
		ev.getArr().add("favorite_recipes");
		ev.getArr().add("drakarisValyrian.com");
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void searchTrueTest() {
		ev = new Event();
		ev.getArr().add("menu_search");
		ev.getArr().add("ommlete");
		ev.getArr().add(null);
		ev.getArr().add(null);
		ev.getArr().add(null);
		ev.getArr().add(null);
		ev.getArr().add(null);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void searchFalseTest() {
		ev = new Event();
		ev.getArr().add("menu_search");
		ev.getArr().add("banana");
		ev.getArr().add(null);
		ev.getArr().add(null);
		ev.getArr().add(null);
		ev.getArr().add(null);
		ev.getArr().add(null);
		ev.getArr().add(null);

		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void advSearchTrueTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,0,0,0,0,0,0,0,0};
		ev.getArr().add("advanced_search");
		ev.getArr().add("ommlete");
		ev.getArr().add(0);
		ev.getArr().add(0);
		ev.getArr().add("0");
		ev.getArr().add("0");
		ev.getArr().add(al);
		ev.getArr().add(1);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void advSearchFalseTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		ev.getArr().add("advanced_search");
		ev.getArr().add("banana");
		ev.getArr().add(0);
		ev.getArr().add(0);
		ev.getArr().add("0");
		ev.getArr().add("0");
		ev.getArr().add(al);
		ev.getArr().add(1);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void addRecipeTrueTest() {
		Integer[] rA= {0,0,0,0,1,0,0,1,0,0,1,0};
		ev = new Event();
		user = Models.GetUserFromDB("drakarisValyrian.com");
		recipe = new Recipe(null, "yuvals matkon", rA, 0.0,0.0,0.0,0.0, 0, 0, 0, "drakarisValyrian.com", 0, "", "", null, null, null);
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
		recipe = new Recipe(null, "Ommlete", rA, 0.0,0.0,0.0,0.0, 0, 0, 0, "drakarisValyrian.com", 0, "", "", null, null, null);
		ev.getArr().add("recipe_insert");
		ev.getArr().add(recipe);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void updateRecipeTrueTest() {
		ev = new Event();
		recipe = Models.GetRecipeFromDB(1);
		recipe.setRecipeKashruth(1);
		ev.getArr().add("recipe_update");
		ev.getArr().add(recipe);
		((MyController)controllerTest).update(null, ev);
		recipe.setRecipeKashruth(0);
		recipe.Update();
	}
	
	@Test
	void updateRecipeFalseTest() {
		ev = new Event();
		Integer[] rA= {0,0,0,0,1,0,0,1,0,0,1,0};
		recipe = new Recipe(null, "yuvals matkon", rA, 0.0,0.0,0.0,0.0, 0, 0, 0, "drakarisValyrian.com", 0, "", "", null, null, null);
		recipe.setRecipeKashruth(1);
		ev.getArr().add("recipe_update");
		ev.getArr().add(recipe);
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void deleteRecipeTrueTest() {
		ev = new Event();
		Integer[] rA= {0,0,0,0,1,0,0,1,0,0,1,0};
		ArrayList<Integer> ar= new ArrayList<Integer>();
		ArrayList<Double> ar1= new ArrayList<Double>();
		ar.add(1);
		ar1.add(1.1);
		recipe = new Recipe(9999, "yuvals matkon", rA, 0.0,0.0,0.0,0.0, 0, 0, 0, "drakarisValyrian.com", 0, "", "", ar, ar, ar1);
		recipe.Insert();
		ev.getArr().add("recipe_delete");
		ev.getArr().add(recipe);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void deleteRecipeFalseTest() {
		ev = new Event();
		Integer[] rA= {0,0,0,0,1,0,0,1,0,0,1,0};
		ArrayList<Integer> ar= new ArrayList<Integer>();
		ArrayList<Double> ar1= new ArrayList<Double>();
		ar.add(1);
		ar1.add(1.1);
		recipe = new Recipe(9999, "yuvals matkon", rA, 0.0,0.0,0.0,0.0, 0, 0, 0, "drakarisValyrian.com", 0, "", "", ar, ar, ar1);
		ev.getArr().add("recipe_delete");
		ev.getArr().add(recipe);
		((MyController)controllerTest).update(null, ev);
	}

	@Test
	void addIngredientTrueTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		ingredient = new Ingredient(99,"test",al,99.9,99.9,99.9,99.9,0);
		ev.getArr().add("ingredient_insert");
		ev.getArr().add(ingredient);
		((MyController)controllerTest).update(null, ev);
		ingredient.Delete();
	}
	
	@Test
	void addIngredientFalseTest() {
		ev = new Event();
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		ingredient = new Ingredient(100,"Parmesan",al,99.9,99.9,99.9,99.9,0);
		ev.getArr().add("ingredient_insert");
		ev.getArr().add(ingredient);
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void RecipesReportTest() {
		ev = new Event();
		ev.getArr().add("recipe_report");
		ev.getArr().add(1);
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void IngredientReportTest() {
		ev = new Event();
		ev.getArr().add("ingredient_report");
		ev.getArr().add(1);
		((MyController)controllerTest).update(null, ev);
	}
	
}
