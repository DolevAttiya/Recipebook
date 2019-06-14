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
		User user = new User();
		Controller controller = new MyController();
		
		model.addObserver(controller);
		Dietitian.addObserver(controller);
		//view.start();
	}
}
