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
			view.loginResponse((ArrayList<User>)((Event)arg).getArr().get(1));
			break;
			
		case "dietitian_login_response":
			/* 0 - Event name
			   1 - Array list */
			view.loginResponse((ArrayList<Dietitian>)((Event)arg).getArr().get(1));
			break;
			
		case "user_register":
			model.insertUser((User)((Event)arg).getArr().get(1));
			break;
			
		case "user_register_response":
			//rotem's function
			break;
			
		case "dietitian_register":
			model.insertDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;
			
		case "dietitian_register_response":
			//rotem's function
			break;
		//-------------------------------
		//---------User Settings---------
		case "user_update":
			model.updateUser((User)((Event)arg).getArr().get(1));
			break;
			
		case "user_update_response":
			//rotem's function
			break;
			
		case "user_delete":
			model.deleteUser((User)((Event)arg).getArr().get(1));
			break;
			
		case "user_delete_response":
			//rotem's function
			break;
			
		case "dietitian_update":
			model.updateDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;
			
		case "dietitian_update_response":
			//rotem's function
			break;
			
		case "dietitian_delete":
			model.deleteDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;
			
		case "dietitian_delete_response":
			//rotem's function
			break;
		//-------------------------------
		//---------Menu Page-------------	
		case "top_10":
			model.top10();
			break;
			
		case "top_10_response":
			//rotem's function
			break;	
			
		case "my_recipes":
			/* 0 - Event name
			   1 - user email */
			model.myRecipes((String)((Event)arg).getArr().get(1));
			break;
			
		case "my_recipes_response":
			//rotem's function
			break;
			
		case "favorite_recipes":
			/* 0 - Event name
			   1 - user email */
			model.myFavoriteRecipes((String)((Event)arg).getArr().get(1));
			break;
			
		case "favorite_recipes_response":
			//rotem's function
			break;
			
		case "menu_search":
			model.Search((String)((Event)arg).getArr().get(1));
			break;
			
		case "advenced_search":
			/* 0 - Event name
			   1 - search string
			   2 - kashrot
			   3 - complexity
			   4 - cooking time
			   5 - rate above
			   5 - allergen array */
			model.Search((String)((Event)arg).getArr().get(1));
			break;
			
		case "search_response":
			//rotem's function
			break;
		//-------------------------------
		//---------Recipe Page-----------
		case "recipe_insert":
			model.insertRecipe((Recipe)((Event)arg).getArr().get(1));
			break;
			
		case "recipe_insert_response":
			//rotem's function
			break;
			
		case "recipe_update":
			model.updateRecipe((Recipe)((Event)arg).getArr().get(1));
			break;
			
		case "recipe_update_response":
			//rotem's function
			break;
			
		case "recipe_delete":
			model.deleteRecipe((Recipe)((Event)arg).getArr().get(1));
			break;
			
		case "recipe_delete_response":
			//rotem's function
			break;
			
		case "select_user":
			/* 0 - Event name
			   1 - user email */
			model.selectUser((String)((Event)arg).getArr().get(1));
			break;
			
		case "select_user_response":
			//rotem's function
			break;
			
		case "select_dietitian":
			/* 0 - Event name
			   1 - dietitian email */
			model.selectDietitian((String)((Event)arg).getArr().get(1));
			break;
			
		case "select_dietitian_response":
			//rotem's function
			break;
		//-------------------------------
		//---------Ingredient Page-------
		case "ingredient_insert":
			model.insertIngredient((Recipe)((Event)arg).getArr().get(1));
			break;
			
		case "ingredient_insert_response":
			//rotem's function
			break;
			
		case "ingredient_update":
			model.updateIngredient((Recipe)((Event)arg).getArr().get(1));
			break;
			
		case "ingredient_update_response":
			//rotem's function
			break;
			
		case "ingredient_delete":
			model.deleteIngredient((Recipe)((Event)arg).getArr().get(1));
			break;
			
		case "ingredient_delete_response":
			//rotem's function
			break;
		//-------------------------------
		}	
	}	
}