package view;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
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
	public static ArrayList<Ingredient> ingredientArray=new ArrayList<Ingredient>();
	public static ArrayList<Recipe> recipeArray=new ArrayList<Recipe>();

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
	public void register(String firstName, String lastName, String email, String pass,String pass2, LocalDate dateOfBirth, boolean isDietitian, Integer dietitianNum, boolean isKosher, LocalDate dietitianStatDate,  Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate, boolean wantAllerg) {
		if ((pass.length()<6) || (pass.compareTo(pass2)==0))
			check=false; // can't save > we will show an error ! 
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
			Integer[] allergies= {isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate};
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
	public void getTop10Response (ArrayList<Recipe> r) {
		recipeArray=r;
	}
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
			ev.getArr().add(null); // null means wants all results
		}
		setChanged();
		notifyObservers(ev);
	}
	public void searchResponse (ArrayList<Recipe> r) {
		recipeArray=r;
	} 
	public void advancedSearch(String s, Integer kashruth, Integer complexity, String timeToMake, String rateAbove,  Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate) {
		Integer[] allergies= {isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate};
		Event ev=new Event();
		ev.getArr().add("advanced_search");
		ev.getArr().add(s); // what string we want to search
		if (kashruth==4) // wants to see adapted results
			ev.getArr().add(4); // 4 means that the user wants only Kosher recipes
		else ev.getArr().add(null); // null means wants all results
		ev.getArr().add(complexity);
		ev.getArr().add(timeToMake); 
		ev.getArr().add(rateAbove);
		if (myUser!=null) // connected as User
			ev.getArr().add(allergies); // sends the user's allergies
		else // connected as Dietitian
			ev.getArr().add(null); // Dietitian doesn't have allergies
		if (kashruth==4) // wants to see adapted results
			ev.getArr().add(4); // 4 means that the user wants only Kosher recipes
		else ev.getArr().add(null); // null means wants all results
		setChanged();
		notifyObservers(ev);
	}
	public void addIngredient (String ingredientName, Integer catagory,  Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate, Integer[] measureType, Double calories, Double carbohydrate, Double fat, Double protein, Integer kashruth) { 
		Integer[] allergies= {isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate};
		Ingredient newIngredient=new Ingredient(null, ingredientName, allergies, calories, carbohydrate, protein, fat, kashruth);
		Event ev=new Event();
		ev.getArr().add("ingredient_insert");
		ev.getArr().add(newIngredient);
		setChanged();
		notifyObservers(ev);
	}
	public void addIngredientResponse(ArrayList<Ingredient> in) {
		if (in.get(0).getIngredientId()!=null)
			check=true; // updated successfully
		else check=false; // not successfully (couldn't save / already exist at the DB)
	}
	public void myFavorite ()
	{
		Integer recipeId= 99;
		String recipeName="lazania";
		Double recipeTotalCalories=0.0;
		Double recipeTotalCarbohydrate=0.0;
		Double recipeTotalProtein=0.0;
		Double recipeTotalFat=0.0;
		Integer recipeKashruth=0;
		Integer recipeTimeToMake= 3;
		Integer[] recipeAllergen= {0,0,0,0,1,0,0,1,0,0,1,0};
		User Daenerys=new User("rotem", "rotem", null, null,null,null,null,recipeAllergen,false,true);
		Integer recipeComplex=3;
		Integer recipeRate= 0;
		String recipeDescription="The Italian cuisine is regional. Historical and cultural impacts, geography, the variety of climatic zones and cultural influences contributed to the diversity found in Italian cooking. This lasagna is made of pasta dough layers filled with bolognese sauce béchamel and Parmesan cheese, in the style of northern Italy.";
		String recipeProcses="Grind 500 grams (1.1 pounds) of beef. Peel, wash and fine dice 150 grams (5 oz) of onion, 200 grams (7 oz) of carrot, and 200 grams (7 oz) of celery stalks.\r\n" + 
				"Peel 500 grams (1 pounds) of tomatoes: use a sharp knife and make a crosswise incision. Place in boiling water for one minute, and shock in ice water. Remove the skins and dice the tomatoes.\r\n" + 
				"Heat 30 grams (1 oz) of oil and 60 grams (2 oz) of butter in a pan over medium heat. Add the onion and cook until translucent. Add the celery and the carrot and cook for a minute or two, stirring occasionally.\r\n" + 
				"Add the ground beef and season right away with 2 teaspoon of salt and ½ teaspoon of ground black pepper. Cook until the meat changes its red color.\r\n" + 
				"Add 350 ml (12 fl oz) of milk and a pinch of nutmeg. Simmer until it evaporates. Add 250 ml (8.5 oz) of dry white wine, and cook until it evaporates. Add the tomatoes and simmer over low heat for at least 3 hours, stirring from time to time. If the bolognese dries out, add ½ cup of water or stock.\r\n" + 
				"Pasta: While the bolognese is cooking, make the pasta dough. Sift 200 grams (7 oz) of flour into the mixing bowl. Add a pinch of salt and two eggs. Mix on low speed until smooth and elastic. Finish kneading the dough by hand, on a lightly floured surface. Gather into a ball, cover and let the dough relax for at least 40 minutes. You can also mix the dough by hand.\r\n" + 
				"Béchamel: To make white roux melt 60 grams (2 oz) of butter over low heat. Add 70 grams (2.5 oz) of flour, stir until smooth. Cook for two minutes, the roux should have a chalky color. Gradually add 750 ml (25 fl oz) of milk, whisking constantly. Add 1/2 teaspoon of salt and an onion pique. To make an onion pique, peel a whole onion, and use a clove to attach a bay leaf. Simmer, stirring frequently, until the sauce is smooth and thickened. Remove the onion pique and strain the béchamel.\r\n" + 
				"Roll the pasta 1 mm thick (1/20 inch) rectangles.\r\n" + 
				"Bring 4 Liters of water to boil and add 4 teaspoons of salt. Slip four sheets of pasta at a time. Cook for 5 seconds, remove from the boiling water and drop into cold water. Spread on a towel to pat dry.\r\n" + 
				"Assembling: Brush a 13×30 cm (5×12 inch) pan with melted butter and spread tablespoon of béchamel. Line with a single layer of pasta sheets, spread a thin layer of béchamel, spread a layer of bolognese sauce and sprinkle with grated Parmesan cheese. Repeat this process until there are eight layers of pasta.\r\n" + 
				"Spread a thin layer of béchamel sauce over the top layer, sprinkle with Parmesan and dot with 20 grams (2/3 oz) of butter. You will need a total of 80 grams (3 oz) of Parmesan cheese.\r\n" + 
				"Bake at a 200°C (400°F) oven for 15 minutes.\r\n" + 
				"Allow the lasagna to rest for a few minutes before serving. Serve directly from the pan or slice into individual portions.\r\n";
		ArrayList<Integer> recipeIngredientId= new ArrayList<Integer>();
		recipeIngredientId.add(1);
		recipeIngredientId.add(75);
		recipeIngredientId.add(101);
		recipeIngredientId.add(74);
		recipeIngredientId.add(102);
		recipeIngredientId.add(53);
		recipeIngredientId.add(23);
		recipeIngredientId.add(24);
		recipeIngredientId.add(103);
		recipeIngredientId.add(15);
		recipeIngredientId.add(44);
		recipeIngredientId.add(104);
		recipeIngredientId.add(105);
		recipeIngredientId.add(106);
		recipeIngredientId.add(107);
		recipeIngredientId.add(108);
		recipeIngredientId.add(109);
		ArrayList<Integer> recipeIngredientsType=new ArrayList<Integer>();
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(15);//item
		recipeIngredientsType.add(2);//teaspoon
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(13);//KL
		recipeIngredientsType.add(12);//ml
		recipeIngredientsType.add(1);//TS
		recipeIngredientsType.add(2);//0.5TS
		recipeIngredientsType.add(4);//0.125TS
		recipeIngredientsType.add(15);//item
		recipeIngredientsType.add(11);//item
		ArrayList<Double> recipeIngredientsAmount=new ArrayList<Double>();
		recipeIngredientsAmount.add(270.0);
		recipeIngredientsAmount.add(2.0);
		recipeIngredientsAmount.add(3.01);
		recipeIngredientsAmount.add(500.0);
		recipeIngredientsAmount.add(30.0);
		recipeIngredientsAmount.add(120.0);
		recipeIngredientsAmount.add(150.0);
		recipeIngredientsAmount.add(200.0);
		recipeIngredientsAmount.add(200.0);
		recipeIngredientsAmount.add(500.0);
		recipeIngredientsAmount.add(1.1);
		recipeIngredientsAmount.add(250.0);
		recipeIngredientsAmount.add(1.0);
		recipeIngredientsAmount.add(1.0);
		recipeIngredientsAmount.add(1.0);
		recipeIngredientsAmount.add(50.0);
		recipeIngredientsAmount.add(50.0);
		Recipe re = new Recipe(recipeId, recipeName, recipeAllergen, recipeTotalCalories, recipeTotalCarbohydrate, recipeTotalProtein, recipeTotalFat, recipeKashruth, recipeTimeToMake, recipeComplex,Daenerys.getPersonEmail() , recipeRate, recipeDescription, recipeProcses, recipeIngredientId,recipeIngredientsType ,recipeIngredientsAmount );
		recipeArray.add(0,re);
		recipeArray.add(1,re);
		/*Event ev=new Event();
		ev.getArr().add("favorite_recipes");
		if (myUser!=null) // User
			ev.getArr().add(myUser);
		else // Dietitian
			ev.getArr().add(myDietitian);
		setChanged();
		notifyObservers(ev);*/
	}
	public void myFavoriteResponse(ArrayList<Recipe> r) {
		recipeArray=r;
	} 
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
	public void myRecipesResponse(ArrayList<Recipe> r) {
		recipeArray=r;
	} 
	//public void addRecipe(String recipeName, Double totalCalories, Double totalCarbohydrate, ArrayList<Ingredient>, Integer[] allergies) {} 
	public void addRecipeResponse(ArrayList<Recipe> r) {
		if (r.get(0).getRecipeId()!=null)
			check=true; // updated successfully
		else check=false; // not successfully (couldn't save / already exist at the DB)
	}
	public void getRecipes() {
		Event ev=new Event();
		ev.getArr().add("all_recipes");
		setChanged();
		notifyObservers(ev);
	}
	public void getAllRecipesResponse(ArrayList<Recipe> r) {
		recipeArray=r;
	}
	public void userUpdate(String firstName, String lastName, String email, String pass, String pass2, LocalDate dateOfBirth, boolean isKosher, Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate , boolean wantAllerg) {
		if ((pass.length()<6) || (pass.compareTo(pass2)==0))
			check=false; // can't save > we will show an error ! 
		String hashPass;
		hashPass = ConvertPassToHash(pass);
		Event ev=new Event();
		Integer[] allergies= {isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate};
		ev.getArr().add("user_update");
		myUser.setPersonFirstName(firstName);
		myUser.setPersonLastName(lastName);
		myUser.setPersonEmail(email);
		myUser.setPersonDateOfBirth(dateOfBirth);
		myUser.setPersonHashPass(hashPass);
		myUser.setUserKashruth(isKosher);
		myUser.setUserAllergen(allergies);
		myUser.setUserAllergens(wantAllerg);
		setChanged();
		notifyObservers(ev);
	}
	public void userUpdateResponse(ArrayList<User> usU) {
		if (usU.get(0)!=null)
			check=true; // everything was OK
		check=false; // something went wrong (could'nt save / already exist)
	}
	public void dietitianUpdate(String firstName, String lastName, String email, String pass, String pass2, LocalDate dateOfBirth, Integer dietitianNum, LocalDate dietitianStatDate) {
		if ((pass.length()<6) || (pass.compareTo(pass2)==0))
			check=false; // can't save > we will show an error ! 
		String hashPass;
		hashPass = ConvertPassToHash(pass);
		Event ev=new Event();
		ev.getArr().add("dietitian_update");
		myDietitian.setPersonFirstName(firstName);
		myDietitian.setPersonLastName(lastName);
		myDietitian.setPersonEmail(email);
		myDietitian.setPersonDateOfBirth(dateOfBirth);
		myDietitian.setPersonHashPass(hashPass);
		myDietitian.setDietitianStatDate(dietitianStatDate);
		//	myDietitian.setDietitianId(dietitianNum);
		setChanged();
		notifyObservers(ev);
	}
	public void dietitianUpdateResponse(ArrayList<Dietitian> usD) {
		if (usD.get(0)!=null)
			check=true; // everything was OK
		check=false; // something went wrong (could'nt save / already exist)
	}
	public void deleteUser() {
		Event ev=new Event();
		ev.getArr().add("user_delete");
		ev.getArr().add(myUser);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteUserResponse(ArrayList<User> usU) {
		if (usU.get(0)==null) // was able to delete
		{
			check=true; // move to login
			myUser=null;
		}	
		else check=false; // error
	}
	public void deleteDietitian() {
		Event ev=new Event();
		ev.getArr().add("dietitian_delete");
		ev.getArr().add(myDietitian);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteDietitianResponse(ArrayList<User> usD) {
		if (usD.get(0)==null) // was able to delete
		{
			check=true; // move to login
			myDietitian=null;
		}	
		else check=false; // error
	}
	public void deleteIngredient(Ingredient ing) {
		Event ev=new Event();
		ev.getArr().add("ingredient_delete");
		ev.getArr().add(ing);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteIngredientResponse(ArrayList<Ingredient> in) {
		if (in.get(0)==null)
		{
			check=true; // move to menu
			ingredientArray=in;
		}
		else check=false; // error
	}
	public void deleteRecipe(Recipe rec) {
		Event ev=new Event();
		ev.getArr().add("recipe_delete");
		ev.getArr().add(rec);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteRecipeResponse(ArrayList<Recipe> rec) {
		if (rec.get(0)==null)
		{
			check=true; // move to menu
			recipeArray=rec;
		}
		else check=false; // error
	}
	public void recipeUpdate(Recipe rec) {
		Event ev=new Event();
		ev.getArr().add("recipe_update");
		ev.getArr().add(rec);
		setChanged();
		notifyObservers(ev);
	}
	public void recipeUpdateResponse(ArrayList<Recipe> r) {
		if (r.get(0)!=null)
			check=true; // everything was OK
		check=false; // something went wrong 
	}
	public void ingredientUpdate(Ingredient ing) {
		Event ev=new Event();
		ev.getArr().add("ingredient_update");
		ev.getArr().add(ing);
		setChanged();
		notifyObservers(ev);
	}
	public void ingredientUpdateResponse(ArrayList<Ingredient> in) {
		if (in.get(0)!=null)
			check=true; // everything was OK
		check=false; // something went wrong 
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
 * 0 - çìáé
 * 1 - áùøé
 * 2 - ôøååä
 * 3 - ìà ëùø éòðå áéé÷åï åëå?
 */