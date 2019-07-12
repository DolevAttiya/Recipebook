package view;

import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Observable;

import javax.swing.JOptionPane;
import controller.Event;
import model.Dietitian;
import model.Ingredient;
import model.Models;
import model.Recipe;
import model.User;

public class myView extends Observable implements View {
	public myView() {};
	public static myView statview = new myView();
	static boolean check=true;
	static User myUser;
	static Dietitian myDietitian;
	public static String ConvertPassToHash(String input)  {
		try { 
			MessageDigest md = MessageDigest.getInstance("SHA-256"); 
			byte[] messageDigest = md.digest(input.getBytes()); 
			BigInteger no = new BigInteger(1, messageDigest); 
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		} 
		catch (NoSuchAlgorithmException e) { 
			System.out.println("Exception thrown" + " for incorrect algorithm: " + e); 
			return null; 
		} 
	} 
	public void login (String email, String pass)
	{
		pass=ConvertPassToHash(pass);
		Event ev=new Event();
		ev.getArr().add("user_login");
		ev.getArr().add(email);
		ev.getArr().add(pass);
		setChanged();
		notifyObservers(ev);
	}	
	public void dloginResponse (ArrayList<Dietitian> usD) {
		if(usD.get(0)!=null) // if the user exists in the DB
		{
			myDietitian=usD.get(0);
			check=true; // open main page
		}
		else check=false; // show error
	}
	public void uloginResponse (ArrayList<model.User> usU) {
		if(usU.get(0)!=null) // if the user exists in the DB
		{
			myUser=usU.get(0);
			check=true; // open main page
		}
		else check=false; // show error
	}
	public void register(String firstName, String lastName, String email, String pass, LocalDate dateOfBirth, boolean isDietitian, Integer dietitianNum, boolean isKosher, LocalDate dietitianStatDate, Integer[] allergies, boolean wantAllerg) {
		Dietitian newDietitian;
		model.User newUser;
		String hashPass;
		Event ev=new Event();
		hashPass = ConvertPassToHash(pass);
		if (isDietitian==true)
		{
			newDietitian = new Dietitian(email, firstName, lastName, dateOfBirth, hashPass, null, dietitianNum, dietitianStatDate);
			ev.getArr().add("dietitian_register");
			ev.getArr().add(newDietitian);
		}
		else
		{
			newUser=new model.User(email, firstName, lastName, dateOfBirth, hashPass, null, 1, allergies, wantAllerg, isKosher);
			ev.getArr().add("user_register");
			ev.getArr().add(newUser);
		}
		setChanged();
		notifyObservers(ev);		
	}
	public void dRegisterResponse(ArrayList<Dietitian> usD) {
		if (usD.get(0)!=null)
		{
			check=true; // everything was OK
			myDietitian=usD.get(0);
		}
		else // something went wrong (could'nt save / already exist)
		{
			check=false;
		}			
	}
	public void uRegisterResponse(ArrayList<model.User> usU) {
		if (usU.get(0)!=null)
		{
			check=true; // everything was OK
			myUser=usU.get(0);
		}
		else // something went wrong (could'nt save / already exist)
		{
			check=false;
		}	
	}
	public void getTop10(ArrayList<Recipe> r) {
		Event ev=new Event();
		ev.getArr().add("top_10");
		setChanged();
		notifyObservers(ev);
	}
	public void getTop10Response (ArrayList<Recipe> r) {} // find out how to show the information in the window
	public void mainSearch(String s) {
		Event ev=new Event();
		ev.getArr().add("menu_search");
		ev.getArr().add(s); // what string we want to search
		if (myUser!=null) // User
		{
			if (myUser.getUserKashruth()==true) // wants to see adapted results
				ev.getArr().add(4); // 4 means that the user wants only Kosher recipes
			else ev.getArr().add(null); // null means wants all results
			ev.getArr().add(null); // Complexity - Irrelevant in search from menu
			ev.getArr().add(null); // Cooking Time - Irrelevant in search from menu
			ev.getArr().add(null); // Rate Above - Irrelevant in search from menu
			if (myUser.getUserAllergens()==true) // wants to see adapted results
				ev.getArr().add(myUser.getUserAllergen()); // sends the user's allergies
			else ev.getArr().add(null); // null means wants all results
			if (myUser.getUserKashruth()==true) // wants to see adapted results
				ev.getArr().add(4); // 4 means that the user wants only Kosher recipes
			else ev.getArr().add(null); // null means wants all results
		}
		else // Dietitian
		{
			ev.getArr().add(null); // null means wants all results
			ev.getArr().add(null); // Complexity - Irrelevant in search from menu
			ev.getArr().add(null); // Cooking Time - Irrelevant in search from menu
			ev.getArr().add(null); // Rate Above - Irrelevant in search from menu
			ev.getArr().add(null); // null means wants all results
			ev.getArr().add(null);
		}
		setChanged();
		notifyObservers(ev);
	}
	public void searchResponse (ArrayList<Recipe> r) {} // find out how to show the information in the window
	public void advancedSearch(String s, Integer catagory, Integer complexity, Integer timeToMake, Integer rateAbove, ArrayList<Integer> allergies, Boolean showOnlyKosher) {
		Event ev=new Event();
		ev.getArr().add("advanced_search");
		ev.getArr().add(s); // what string we want to search
		if (showOnlyKosher==true) // wants to see adapted results
			ev.getArr().add(4); // 4 means that the user wants only Kosher recipes
		else ev.getArr().add(null); // null means wants all results
		ev.getArr().add(complexity);
		ev.getArr().add(timeToMake); 
		ev.getArr().add(rateAbove);
		ev.getArr().add(allergies); // sends the user's allergies
		if (showOnlyKosher==true) // wants to see adapted results
			ev.getArr().add(4); // 4 means that the user wants only Kosher recipes
		else ev.getArr().add(null); // null means wants all results
		setChanged();
		notifyObservers(ev);
	}
	public void addIngredient (String ingredientName, Integer catagory, Integer[] allergies, Integer[] measureType, Double calories, Double carbohydrate, Double fat, Double protein, Integer kashruth) { 
		Ingredient newIngredient=new Ingredient(null, ingredientName, allergies, calories, carbohydrate, protein, fat, kashruth);
		Event ev=new Event();
		ev.getArr().add("ingredient_insert");
		ev.getArr().add(newIngredient);
		setChanged();
		notifyObservers(ev);
	}
	public void addIngredientResponse(Ingredient newIngredient) {
		if (newIngredient.getIngredientId()!=null)
			check=true; // updated successfully
		else check=false; // not successfully
	}
	public void myFavorite ()
	{
		Event ev=new Event();
		ev.getArr().add("favorite_recipes");
		if (myUser!=null) // User
			ev.getArr().add(myUser);
		else // Dietitian
			ev.getArr().add(myDietitian);
		setChanged();
		notifyObservers(ev);
	}
	public void myFavoriteResponse() {} // find out how to show the information in the window
	public void myRecipes ()
	{
		Event ev=new Event();
		ev.getArr().add("my_recipes");
		if (myUser!=null) // User
			ev.getArr().add(myUser);
		else // Dietitian
			ev.getArr().add(myDietitian);
		setChanged();
		notifyObservers(ev);
	}
	public void myRecipesResponse() {} // find out how to show the information in the window
	public void addRecipe(String recipeName, Double totalCalories, Double totalCarbohydrate, ArrayList<Ingredient>, Integer[] allergies) {
		//	String ingredientName, Integer catagory, Integer[] allergies, Integer[] measureType, Double calories, 
		//  Double carbohydrate, Double fat, Double protein, Integer kashruth
	} 
	public void addRecipeResponse(Recipe newRecipe) {
		if (newRecipe.getRecipeId()!=null)
			check=true; // updated successfully
		else check=false; // not successfully
	}
	public void userUpdate(String firstName, String lastName, String email, String pass, LocalDate dateOfBirth, boolean isDietitian, Integer dietitianNum, boolean isKosher, LocalDate dietitianStatDate, Integer[] allergies, boolean wantAllerg) {
		String hashPass;
		hashPass = ConvertPassToHash(pass);
		Event ev=new Event();
		if (myUser!=null) // user
		{
			ev.getArr().add("user_update");
			myUser.setPersonFirstName(firstName);
			myUser.setPersonLastName(lastName);
			myUser.setPersonEmail(email);
			myUser.setPersonDateOfBirth(dateOfBirth);
			myUser.setPersonHashPass(hashPass);
			myUser.setUserKashruth(isKosher);
			myUser.setUserAllergen(allergies);
			myUser.setUserAllergens(wantAllerg);
		}
		else // dietitian
		{
			ev.getArr().add("dietitian_update");
			myDietitian.setPersonFirstName(firstName);
			myDietitian.setPersonLastName(lastName);
			myDietitian.setPersonEmail(email);
			myDietitian.setPersonDateOfBirth(dateOfBirth);
			myDietitian.setPersonHashPass(hashPass);
			myDietitian.setDietitianStatDate(dietitianStatDate);
			//	myDietitian.setDietitianId(dietitianNum);
		}
		setChanged();
		notifyObservers(ev);
	}
	public void userUpdateResponse(User usU) {
		if (usU!=null)
			check=true;
		check=false;
	}
	public void dietitianUpdateResponse(Dietitian usD) {
		if (usD!=null)
			check=true;
		check=false;
	}
}
/*
//---------Login Page------------
case "user_login": // DONE
case "user_register": //DONE
case "dietitian_register": //DONE
	//---------User Settings---------
case "user_update": //DONE
case "user_delete": // we need to discuss that !
case "dietitian_update": //DONE
case "dietitian_delete": // we need to discuss that !
	//---------Menu Page-------------	
case "top_10": //DONE
case "my_recipes": //DONE
case "menu_search": //DONE
	//-------advanced search---------		
case "advanced_search":	//DONE
	//---------Recipe Page-----------
case "recipe_insert":
case "recipe_update":
case "recipe_delete": // we need to discuss that !
case "select_user":
case "select_dietitian":
	//---------Ingredient Page-------
case "ingredient_insert": //DONE
case "ingredient_update":
case "ingredient_delete": // we need to discuss that !
 */
/*
 * timeToMake:
 * 0 - 0-30 minutes
 * 1 - 30-60 minutes
 * 2 - 60-90 minutes
 * 3 - 90-120 minutes
 * 4 - more than 2 hours 
 * rateAbove:
 * 0 - 0 stars
 * 1 - 5 stars
 * 2 - 10 stars
 * 3 - 15 stars
 * 4 - 20 stars
 * catagory:
 * 0 - חלבי
 * 1 - בשרי
 * 2 - פרווה
 * 3 - לא כשר יענו בייקון וכו?
 */
