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
		// TODO Auto-generated method stub
		
		//command 1=update 2=set 3=delete 4=response from model
		if(o instanceof User)
		{
			switch(User.command) {
			case 1:
				//code block
				break;
				
			case 2:
				//code block
				break;
				
			case 3:
				//code block
				break;
				
			case 4:
				//code block
				break;
			}
		}
		if(o instanceof Recipe)
		{}
		if(o instanceof Dietitian)
		{}
		if(o instanceof Ingredient)
		{}
		if(o instanceof Allergen)
		{}
		if(o instanceof Entities)
		{}
		if(o instanceof IngredientType)
		{}
	}
}