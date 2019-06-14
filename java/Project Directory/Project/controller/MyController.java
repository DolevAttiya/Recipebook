package controller;

import java.util.Observable;

import model.model;
import model.User;
import model.Allergen;
import model.Dietitian;
import model.Entities;
import model.Ingredient;
import model.IngredientType;
import model.Recipe;
import view.Login;
import view.MainPage;

public class MyController implements Controller{
	public void update(Observable o, Object arg) {
		Event e = (Event)arg;
		
		switch (e.getName()) {
		case "top_10":
			//top10(); model function call
			break;
			
		case "user_login":
			Event<User> userEvent = e;
			User user = userEvent.getEntity();
			//user.login(); model function call
			break;
			
		case "recipe_insert":
			Event<Recipe> recipeIEvent = e;
			Recipe recipeI = recipeIEvent.getEntity();
			//recipe.insert(); model function call
			break;
			
		case "recipe_update":
			Event<Recipe> recipeUEvent = e;
			Recipe recipeU = recipeUEvent.getEntity();
			//recipe.update(); model function call
			break;
			
		case "recipe_delete":
			Event<Recipe> recipeDEvent = e;
			Recipe recipeD = recipeDEvent.getEntity();
			//recipe.delete(); model function call
			break;
		}
		
	}	
}