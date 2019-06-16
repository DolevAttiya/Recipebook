package controller;

import java.util.Observable;
import java.util.ArrayList;
import model.Models;


public class MyController implements Controller{
	public void update(Observable o, Object arg) {
		
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
			//dolev's function
			break;
			
		case "user_register_response":
			//rotem's function
			break;
		//-------------------------------
		//---------User Settings---------
		case "user_change_settings":
			//dolev's function
			break;
			
		case "user_change_settings_response":
			//rotem's function
			break;
			
		case "user_update":
			//dolev's function
			break;
			
		case "user_update_response":
			//rotem's function
			break;
			
		case "user_delete":
			//dolev's function
			break;
			
		case "user_delete_response":
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
			
		case "menu_search":
			//dolev's function
			break;
			
		case "menu_search_response":
			//rotem's function
			break;
			
		case "advenced_search":
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