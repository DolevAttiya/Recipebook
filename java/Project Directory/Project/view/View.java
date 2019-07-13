package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import controller.Event;
import model.Dietitian;
import model.Ingredient;
import model.Recipe;
import model.User;
import view.myView;

public interface View { 
	
	public void uloginResponse (ArrayList<model.User> usU);
	public void dloginResponse (ArrayList<Dietitian> usD);
	public void dRegisterResponse(ArrayList<Dietitian> usD);
	public void uRegisterResponse(ArrayList<model.User> usU);
	public void getTop10Response(ArrayList<Recipe> r);
	public void searchResponse(ArrayList<Recipe> r);
	public void myFavoriteResponse(ArrayList<Recipe> r);
	public void myRecipesResponse(ArrayList<Recipe> r);  
	public void addRecipeResponse(ArrayList<Recipe> r);
	public void addIngredientResponse(ArrayList<Ingredient> in);
	public void userUpdateResponse(ArrayList<User> usU);
	public void dietitianUpdateResponse(ArrayList<Dietitian> usD);
	
	//update ingredient, remove ingredient
	//update recipe
}