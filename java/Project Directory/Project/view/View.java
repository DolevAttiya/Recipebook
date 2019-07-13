package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import controller.Event;
import model.Dietitian;
import model.Recipe;
import view.myView;

public interface View { 
	
	public void loginResponse(ArrayList<model.User> us);
	public void dRegisterResponse(ArrayList<Dietitian> usD);
	public void uRegisterResponse(ArrayList<model.User> usU);
	public void getTop10Response(ArrayList<Recipe> r);
	public void searchResponse(ArrayList<Recipe> r);
	public void addIngredientResponse(Integer ingredientId);
	public void myFavoriteResponse();
	public void myRecipesResponse();
	public void addRecipeResponse();
}