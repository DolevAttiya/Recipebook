package controller;

import java.util.Observable;
import java.util.function.BooleanSupplier;
import java.util.ArrayList;
import model.*;
import model.User;
import view.*;


public class MyController implements Controller{

	public static boolean visit=false;
	private model model;
	private View view;
	private View test;

	public MyController(model model, View view, View test){
		this.view = view;
		this.model = model;
		this.test = test;
	}

	public MyController() {
		// TODO Auto-generated constructor stub
	}

	public void update(Observable o, Object arg) {
		switch ((String)((Event)arg).getArr().get(0)) {
		//---------Login Page------------
		case "user_login":
			/* 0 - Event name
			   1 - User name
			   2 - Password */
			visit=true;
			((Models)model).CheckPasswordAndEmail((String)((Event)arg).getArr().get(1),(String)((Event)arg).getArr().get(2));
			break;

		case "user_login_response":
			/* 0 - Event name
			   1 - Array list */
			((myView)view).loginResponse((ArrayList<User>)((Event)arg).getArr().get(1));
			break;

		case "dietitian_login_response":
			/* 0 - Event name
			   1 - Array list */
			((myView)view).loginResponse((ArrayList<Dietitian>)((Event)arg).getArr().get(1));
			break;

		case "user_register":
			((Models)model).insertUser((User)((Event)arg).getArr().get(1));
			break;

		case "user_register_response":
			((myView)view).uRegisterResponse((ArrayList<User>)((Event)arg).getArr().get(1));
			break;

		case "dietitian_register":
			((Models)model).insertDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;

		case "dietitian_register_response":
			((myView)view).dRegisterResponse((ArrayList<Dietitian>)((Event)arg).getArr().get(1));
			break;
			//-------------------------------
			//---------User Settings---------
		case "user_update":
			((Models)model).updateUser((User)((Event)arg).getArr().get(1));
			break;

		case "user_update_response":
			//rotem's function
			break;

		case "user_delete":
			((Models)model).deleteUser((User)((Event)arg).getArr().get(1));
			break;

		case "user_delete_response":
			//rotem's function
			break;

		case "dietitian_update":
			((Models)model).updateDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;

		case "dietitian_update_response":
			//rotem's function
			break;

		case "dietitian_delete":
			((Models)model).deleteDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;

		case "dietitian_delete_response":
			//rotem's function
			break;
			//-------------------------------
			//---------Menu Page-------------	
		case "top_10":
			((Models)model).top10();
			break;

		case "top_10_response":
			//rotem's function
			break;	

		case "my_recipes":
			/* 0 - Event name
			   1 - user email */
			((Models)model).myRecipes((String)((Event)arg).getArr().get(1));
			break;

		case "my_recipes_response":
			//rotem's function
			break;

		case "favorite_recipes":
			/* 0 - Event name
			   1 - user email */
			((Models)model).myFavoriteRecipes((String)((Event)arg).getArr().get(1));
			break;

		case "favorite_recipes_response":
			//rotem's function
			break;

		case "menu_search":
			((Models)model).Search((String)((Event)arg).getArr().get(1));
			break;

		case "advenced_search":
			/* 0 - Event name
			   1 - search string
			   2 - kashrot
			   3 - complexity
			   4 - cooking time
			   5 - rate above
			   5 - allergen array */
			((Models)model).Search((String)((Event)arg).getArr().get(1));
			break;

		case "search_response":
			((myView)view).searchResponse((ArrayList<Recipe>)((Event)arg).getArr().get(1));
			break;
			//-------------------------------
			//---------Recipe Page-----------
		case "recipe_insert":
			((Models)model).insertRecipe((Recipe)((Event)arg).getArr().get(1));
			break;

		case "recipe_insert_response":
			//rotem's function
			break;

		case "recipe_update":
			((Models)model).updateRecipe((Recipe)((Event)arg).getArr().get(1));
			break;

		case "recipe_update_response":
			//rotem's function
			break;

		case "recipe_delete":
			((Models)model).deleteRecipe((Recipe)((Event)arg).getArr().get(1));
			break;

		case "recipe_delete_response":
			//rotem's function
			break;

		case "select_user":
			/* 0 - Event name
			   1 - user email */
			((Models)model).selectUser((String)((Event)arg).getArr().get(1));
			break;

		case "select_user_response":
			//rotem's function
			break;

		case "select_dietitian":
			/* 0 - Event name
			   1 - dietitian email */
			((Models)model).selectDietitian((String)((Event)arg).getArr().get(1));
			break;

		case "select_dietitian_response":
			//rotem's function
			break;
			//-------------------------------
			//---------Ingredient Page-------
		case "ingredient_insert":
			((Models)model).insertIngredient((Ingredient)((Event)arg).getArr().get(1));
			break;

		case "ingredient_insert_response":
			//rotem's function
			break;

		case "ingredient_update":
			((Models)model).updateIngredient((Ingredient)((Event)arg).getArr().get(1));
			break;

		case "ingredient_update_response":
			//rotem's function
			break;

		case "ingredient_delete":
			((Models)model).deleteIngredient((Ingredient)((Event)arg).getArr().get(1));
			break;

		case "ingredient_delete_response":
			//rotem's function
			break;
			//-------------------------------
		}	
	}	
}