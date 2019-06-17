package controller;

import java.util.Observable;
import java.util.ArrayList;
import model.*;
import view.View;


public class MyController implements Controller{
	public void update(Observable o, Object arg) {
		
		private model model;
		private View view;
		
		public MyController(model model, View view){
			this.view = view;
			this.model = model;
		}
		
		switch ((String)((Event)arg).getArr().get(0)) {
		//---------Login Page------------
		case "user_login":
			/* 0 - Event name
			   1 - User name
			   2 - Password */
			Models.CheckPasswordAndEmail((String)((Event)arg).getArr().get(1),(String)((Event)arg).getArr().get(2));
			break;
		
		case "user_login_response":
			/* 0 - Event name
			   1 - Array list */
			//rotem's function
			break;
			
		case "user_register":
			Models.insertUser((User)((Event)arg).getArr().get(1));
			break;
			
		case "user_register_response":
			//rotem's function
			break;
			
		case "dietitian_register":
			Models.insertDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;
			
		case "dietitian_register_response":
			//rotem's function
			break;
		//-------------------------------
		//---------User Settings---------
		case "user_update":
			Models.updateUser((User)((Event)arg).getArr().get(1));
			break;
			
		case "user_update_response":
			//rotem's function
			break;
			
		case "user_delete":
			Models.deleteUser((User)((Event)arg).getArr().get(1));
			break;
			
		case "user_delete_response":
			//rotem's function
			break;
			
		case "dietitian_update":
			Models.updateDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;
			
		case "dietitian_update_response":
			//rotem's function
			break;
			
		case "dietitian_delete":
			Models.deleteDietitian((Dietitian)((Event)arg).getArr().get(1));
			break;
			
		case "dietitian_delete_response":
			//rotem's function
			break;
		//-------------------------------
		//---------Menu Page-------------	
		case "top_10":
			Models.top10();
			break;
			
		case "top_10_response":
			//rotem's function
			break;	
			
		case "my_recipes":
			//dolev's function
			break;
			
		case "my_recipes_response":
			//rotem's function
			break;
			
		case "menu_search":
			//dolev's function
			break;
			
		case "menu_search_response":
			//rotem's function
			break;
			
		case "advenced_search":
			/* 0 - Event name
			   1 - search string
			   2 - kashrot
			   3 - complexity
			   4 - cooking time
			   5 - rate above
			   5 - allergen array */
			//dolev's function
			break;
			
		case "advenced_search_response":
			//rotem's function
			break;
		//-------------------------------
		//---------Recipe Page-----------
		case "recipe_insert":
			//dolev's function
			break;
			
		case "recipe_insert_response":
			//rotem's function
			break;
			
		case "recipe_update":
			//dolev's function
			break;
			
		case "recipe_update_response":
			//rotem's function
			break;
			
		case "recipe_delete":
			//dolev's function
			break;
			
		case "recipe_delete_response":
			//rotem's function
			break;
			
		case "select_user":
			//dolev's function
			break;
			
		case "select_user_response":
			//rotem's function
			break;
			
		case "select_dietitian":
			//dolev's function
			break;
			
		case "select_dietitian_response":
			//rotem's function
			break;
		//-------------------------------
		//---------Ingredient Page-------
		case "ingredient_insert":
			//dolev's function
			break;
			
		case "ingredient_insert_response":
			//rotem's function
			break;
			
		case "ingredient_update":
			//dolev's function
			break;
			
		case "ingredient_update_response":
			//rotem's function
			break;
			
		case "ingredient_delete":
			//dolev's function
			break;
			
		case "ingredient_delete_response":
			//rotem's function
			break;
		//-------------------------------
		}	
	}	
}