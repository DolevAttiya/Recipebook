package driver;

import controller.Controller;
import controller.MyController;
import model.model;
import model.User;
import model.Allergen;
import model.Dietitian;
import model.Entities;
import model.Ingredient;
import model.IngredientType;
import model.Person;
import view.Login;
import view.MainPage;

public class MVCDriver {
	public static void main(String[] args) {
		Controller controller = new MyController();
		model model = new Models();
		
		//create an object from every class
		
		
		model.addObserver(controller);
		
		//add all the rest of the view observers
		
		//view.start();
	}
}
