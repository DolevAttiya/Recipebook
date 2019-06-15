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
		User user = new User();
		Dietitian dietitian = new Dietitian();
		//create an object from every class
		
		
		user.addObserver(controller);
		dietitian.addObserver(controller);
		//add all the rest of the observers
		
		//view.start();
	}
}
