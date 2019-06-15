package controller;

import java.util.Observable;
import java.util.ArrayList;
import model.Models;


public class MyController implements Controller{
	public void update(Observable o, Object arg) {
		
		switch ((String)((Event)arg).getArr().get(0)) {
		
		case "top_10":
			Models.top10();
			break;
			
		case "top_10_response":
			//rotem's function
			break;
			
		case "user_login":
			/*
			 * 0 - Event name
			 * 1 - User name
			 * 2 - Password
			 */
			Models.CheckPasswordAndEmail((String)((Event)arg).getArr().get(1),(String)((Event)arg).getArr().get(2));
			break;
			
		case "user_login_response":
			/*
			 * 0 - Event name
			 * 1 - Array list
			 */
			//rotem's function
			break;
			
		case "recipe_insert":
		
			//recipe.insert(); model function call
			break;
			
		case "recipe_update":
			
			//recipe.update(); model function call
			break;
			
		case "recipe_delete":
		
			//recipe.delete(); model function call
			break;
			
		case "ingredient_insert":
		
			//ingredient.insert(); model function call
			break;
			
		case "ingredient_update":
		
			//ingredient.update(); model function call
			break;
			
		case "ingredient_delete":
			
			//ingredient.delete(); model function call
			break;
		}
		
	}	
}