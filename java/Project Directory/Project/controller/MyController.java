package controller;

import java.util.Observable;
import java.util.ArrayList;
import model.*;
import model.User;
import view.*;


public class MyController implements Controller{

	private model model;
	private View view;

	public MyController(model model, View view){
		this.view = view;
		this.model = model;
	}

	@SuppressWarnings("unchecked")
	public void update(Observable o, Object arg) {
		switch ((String)((Event)arg).getArr().get(0)) {
		//---------Login Page------------
		case "user_login":
			/* 0 - Event name
			   1 - User name
			   2 - Password */
			model.CheckPasswordAndEmail((String)((Event)arg).getArr().get(1),(String)((Event)arg).getArr().get(2));
			break;

		case "user_login_response":
			/* 0 - Event name
			   1 - Array list */
			view.uloginResponse((ArrayList<User>)((Event)arg).getArr().get(1));
			break;

		case "dietitian_login_response":
			/* 0 - Event name
			   1 - Array list */
			view.dloginResponse((ArrayList<Dietitian>)((Event)arg).getArr().get(1));
			break;

		case "user_register":
			model.insertUser((User)((Event)arg).getArr().get(1));
			break;

		case "user_register_response":
			view.uRegisterResponse((ArrayList<User>)((Event)arg).getArr().get(1));
			break;

		case "dietitian_register":
			model.insertDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;

		case "dietitian_register_response":
			view.dRegisterResponse((ArrayList<Dietitian>)((Event)arg).getArr().get(1));
			break;
			//-------------------------------

			//---------User Settings---------
		case "user_update":
			model.updateUser((User)((Event)arg).getArr().get(1));
			break;

		case "user_update_response":
			view.userUpdateResponse((ArrayList<User>)((Event)arg).getArr().get(1));
			break;

		case "user_delete":
			model.deleteUser((User)((Event)arg).getArr().get(1));
			break;

		case "user_delete_response":
			view.deleteUserResponse((ArrayList<User>)((Event)arg).getArr().get(1));
			break;

		case "dietitian_update":
			model.updateDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;

		case "dietitian_update_response":
			view.dietitianUpdateResponse((ArrayList<Dietitian>)((Event)arg).getArr().get(1));
			break;

		case "dietitian_delete":
			model.deleteDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;

		case "dietitian_delete_response":
			view.deleteDietitianResponse((ArrayList<Dietitian>)((Event)arg).getArr().get(1));
			break;
			//-------------------------------

			//---------Menu Page-------------	
		case "all_recipes":
			model.allRecipes();
			break;

		case "all_recipes_response":
			view.getAllRecipesResponse((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;

		case "top_10":
			model.top10();
			break;

		case "top_10_response":
			view.getTop10Response((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;	

		case "my_recipes":
			/* 0 - Event name
			   1 - user email */
			model.myRecipes((String)((Event)arg).getArr().get(1));
			break;

		case "my_recipes_response":
			view.myRecipesResponse((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;

		case "favorite_recipes":
			/* 0 - Event name
			   1 - user email */
			model.myFavoriteRecipes((String)((Event)arg).getArr().get(1));
			break;

		case "favorite_recipes_response":
			view.myFavoriteResponse((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;

		case "menu_search":
			model.Search((ArrayList<Object>)((Event)arg).getArr());
			break;

		case "advanced_search":
			/* 0 - Event name
			   1 - search string
			   2 - kashrot
			   3 - complexity
			   4 - cooking time
			   5 - rate above
			   5 - allergen array */
			model.Search((ArrayList<Object>)((Event)arg).getArr());
			break;

		case "search_response":
			view.searchResponse((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;
			//-------------------------------

			//---------Recipe Page-----------
		case "recipe_insert":
			model.insertRecipe((Recipe)((Event)arg).getArr().get(1));
			break;

		case "recipe_insert_response":
			view.addRecipeResponse((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;

		case "recipe_update":
			model.updateRecipe((Recipe)((Event)arg).getArr().get(1));
			break;

		case "recipe_update_response":
			view.recipeUpdateResponse((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;

		case "recipe_delete":
			model.deleteRecipe((Recipe)((Event)arg).getArr().get(1));
			break;

		case "recipe_delete_response":
			view.deleteRecipeResponse((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;
			//-------------------------------

			//---------Ingredient Page-------
		case "ingredient_insert":
			model.insertIngredient((Ingredient)((Event)arg).getArr().get(1));
			break;

		case "ingredient_insert_response":
			view.addIngredientResponse((ArrayList<Ingredient>)((Event)arg).getArr().get(1));
			break;

		case "ingredient_type_getall":
			model.allIngredientType();
			break;

		case "ingredient_type_getall_response":
			view.getAllMeasuringTypesResponse((ArrayList<IngredientType>)((Event)arg).getArr().get(1));
			break;

		case "ingredient_getall":
			model.allIngredient();
			break;

		case "ingredient_getall_response":
			view.getAllIngredientResponse((ArrayList<Ingredient>)((Event)arg).getArr().get(1));
			break;

			/*case "ingredient_update": //not in use in the meanwhile for future implementation (manager function)
			model.updateIngredient((Ingredient)((Event)arg).getArr().get(1));
			break;*/

			/*case "ingredient_update_response": //not in use in the meanwhile for future implementation (manager function)
			view.ingredientUpdateResponse((ArrayList<Ingredient>)((Event)arg).getArr().get(1));
			break;*/

			/*case "ingredient_delete": //not in use in the meanwhile for future implementation (manager function)
			model.deleteIngredient((Ingredient)((Event)arg).getArr().get(1));
			break;*/

			/*case "ingredient_delete_response": //not in use in the meanwhile for future implementation (manager function)
			view.deleteIngredientResponse((ArrayList<Ingredient>)((Event)arg).getArr().get(1));
			break;*/
			//-------------------------------

			//-----------Reports-------------
		case "recipe_report":
			model.getRecipesReport();
			break;

		case "recipe_report_response":
			//view.///\\\((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;

		case "ingredient_report":
			model.getIngredientReport();
			break;

		case "ingredient_report_response":
			//view.///\\\((ArrayList<Ingredient>)((Event)arg).getArr().get(1));
			break;
			//-------------------------------

		default:
			System.out.println("error");

		}	
	}	
}