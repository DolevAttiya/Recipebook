package view;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;
import controller.Event;
import model.Dietitian;
import model.Ingredient;
import model.IngredientType;
import model.Recipe;
import model.User;

public class myView extends Observable implements View {
	public myView() {};
	public static myView statview = new myView();
	public static boolean check=true;
	public static User myUser;
	public static Dietitian myDietitian;
	public static ArrayList<Ingredient> ingredientArray=new ArrayList<Ingredient>();
	public static ArrayList<Recipe> recipeArray=new ArrayList<Recipe>();
	public static ArrayList<IngredientType> myMeasuring;
	public static Recipe myRecipe=null;
	public static Ingredient myIngredient;
	public static ArrayList<Ingredient> ingredientArrayForNewRecipe=new ArrayList<Ingredient>();
	public static ArrayList<IngredientType> myMeasuringForNewRecipe;
	
	Event ev;
	
	private static String ConvertPassToHash(String input)  {
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
		ev=new Event();
		ev.getArr().add("user_login");
		ev.getArr().add(email);
		ev.getArr().add(pass);
		setChanged();
		notifyObservers(ev);
	}	
	public void dloginResponse (ArrayList<Dietitian> usD) {
		if(usD!=null) // if the user exists in the DB
		{
			myDietitian=usD.get(0);
			check=true; // open main page
		}
		else check=false; // show error
	}
	public void uloginResponse (ArrayList<model.User> usU) {
		if(usU!=null) // if the user exists in the DB
		{
			myUser=usU.get(0);
			check=true; // open main page
		}
		else check=false; // show error
	}
	public void register(String firstName, String lastName, String email, String pass,String pass2, String dateOfBirth, boolean isDietitian, String dietitianNum, boolean isKosher, String dietitianStatDate,  Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate, boolean wantAllerg) {
		if ((pass.length()<6) || (pass.compareTo(pass2)!=0))
			check=false; // can't save > we will show an error ! 
		else
		{
			Dietitian newDietitian;
			model.User newUser;
			String hashPass;
			ev=new Event();
			hashPass = ConvertPassToHash(pass);
			LocalDate dateBirth = LocalDate.parse(dateOfBirth);				
			if (isDietitian==true)
			{
				Integer dietNum=Integer.parseInt(dietitianNum);
				LocalDate dietitianDate = LocalDate.parse(dietitianStatDate);
				newDietitian = new Dietitian(email, firstName, lastName, dateBirth, hashPass, null, dietNum, dietitianDate);
					ev.getArr().add("dietitian_register");
					ev.getArr().add(newDietitian);
			}
			else
			{
				Integer[] allergies= {isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate};
				newUser=new model.User(email, firstName, lastName, dateBirth, hashPass, null,null, allergies, wantAllerg, isKosher);
				ev.getArr().add("user_register");
				ev.getArr().add(newUser);
			}
			setChanged();
			notifyObservers(ev);		
		}
	}
	public void dRegisterResponse(ArrayList<Dietitian> usD) {
		if (usD!=null)
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
		if (usU!=null)
		{
			check=true; // everything was OK
			myUser=usU.get(0);
		}
		else // something went wrong (could'nt save / already exist)
		{
			check=false;
		}	
	}
	public void getTop10() {
		ev=new Event();
		ev.getArr().add("top_10");
		setChanged();
		notifyObservers(ev);
	}
	public void getTop10Response (ArrayList<Recipe> r) {
		recipeArray=r;
	}
	public void mainSearch(String s) {
		ev=new Event();
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
		ev=new Event();
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
	public void addIngredient (String ingredientName, Integer kashruth,  Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate, Double calories, Double carbohydrate, Double fat, Double protein) { 
		Integer[] allergies= {isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate};
		Ingredient newIngredient=new Ingredient(null, ingredientName, allergies, calories, carbohydrate, protein, fat, kashruth);
		Event ev=new Event();
		ev.getArr().add("ingredient_insert");
		ev.getArr().add(newIngredient);
		setChanged();
		notifyObservers(ev);
	}
	public void addIngredientResponse(ArrayList<Ingredient> in) {
		if (in!=null)
			check=true; // updated successfully
		else check=false; // not successfully (couldn't save / already exist at the DB)
	}
	public void myFavorite ()
	{
		ev=new Event();
		ev.getArr().add("favorite_recipes");
		if (myUser!=null) // Connected as User
			ev.getArr().add(myUser);
		else // Connected as Dietitian
			ev.getArr().add(myDietitian);
		setChanged();
		notifyObservers(ev);
	}
	public void myFavoriteResponse(ArrayList<Recipe> r) {
		recipeArray=r;
	} 
	public void myRecipes ()
	{
		ev=new Event();
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
	public void addRecipe(String recipeName, Double totalCalories, Double totalCarbohydrate, ArrayList<Ingredient> ing, Integer[] allergies) {
		
	} 
	public void addIngredientToRecipe(Ingredient newIngredient,IngredientType newingredientType, Double IngredientAmount)/*Kosher levels: 0 parve, 1 milk,2 meat, 3 pig*/
	{	
		if (myRecipe==null) { 
		Integer[] ar=new Integer[1];
		ar[0]=0;
		myRecipe = new Recipe(null,"recipeName",ar,0.0,0.0,0.0,0.0,0,0,0,"personEmail",0,"recipeDescription","recipeProcess",new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Double>());
		}
		myRecipe.getRecipeIngredientId().add(newIngredient.getIngredientId()); 
		myRecipe.getRecipeIngredientsType().add(newingredientType.getIngredientTypeId());
		myRecipe.getRecipeIngredientsAmount().add(IngredientAmount);
		myRecipe.setRecipeTotalCalories(myRecipe.getRecipeTotalCalories()+(newIngredient.getIngredientCalories()*IngredientAmount*newingredientType.getIngredientTypeValue()));
		myRecipe.setRecipeTotalCarbohydrate(myRecipe.getRecipeTotalCarbohydrate()+newIngredient.getIngredientCarbohydrate()*IngredientAmount*newingredientType.getIngredientTypeValue());
		myRecipe.setRecipeTotalFat(myRecipe.getRecipeTotalFat()+newIngredient.getIngredientFat()*IngredientAmount*newingredientType.getIngredientTypeValue());
		myRecipe.setRecipeTotalProtein(myRecipe.getRecipeTotalProtein()+newIngredient.getIngredientProtein()*IngredientAmount*newingredientType.getIngredientTypeValue());
		{
			if(newIngredient.getIngredientKashruth()!=0) //*Kosher check*//
				if(myRecipe.getRecipeKashruth()!=3)
					if(myRecipe.getRecipeKashruth()==0) {myRecipe.setRecipeKashruth(newIngredient.getIngredientKashruth());}
					else if (myRecipe.getRecipeKashruth()!=newIngredient.getIngredientKashruth())
						myRecipe.setRecipeKashruth(3);
		}
		for( int i=0;i<myRecipe.getRecipeAllergen().length;i++)
		{
			if(newIngredient.getIngredientAllergen(i)>0)
			{
				Integer[] newarray= myRecipe.getRecipeAllergen();
				newarray[i]+=1;
				myRecipe.setRecipeAllergen(newarray);
			}
		}	 
	}
	
	public void addRecipeResponse(ArrayList<Recipe> r) {
		if (r!=null)
			check=true; // updated successfully
		else check=false; // not successfully (couldn't save / already exist at the DB)
	}
	
	public void getAllIngredient() {
		ev=new Event();
		ev.getArr().add("ingredient_getall");
		setChanged();
		notifyObservers(ev);
	}
	public void getAllIngredientResponse(ArrayList<Ingredient> ing) {
		ingredientArray=ing;
	}
	
	public void getAllRecipes() {
		ev=new Event();
		ev.getArr().add("all_recipes");
		setChanged();
		notifyObservers(ev);
	}
	public void getAllRecipesResponse(ArrayList<Recipe> r) {
		recipeArray=r;
	}
	public void getAllMeasuringTypes() {
		ev=new Event();
		ev.getArr().add("ingredient_type_insert");
		setChanged();
		notifyObservers(ev);
	}
	public void getAllMeasuringTypesResponse(ArrayList<IngredientType> m) {
		myMeasuring=m;
	}
	public void userUpdate(String firstName, String lastName, String email, String pass, String pass2, String dateOfBirth, boolean isKosher, Integer isFish, Integer isStrawberries, Integer isCoffie, Integer isGluten, Integer isLactose, Integer isMilk, Integer isEggs, Integer isSeeds, Integer isTreeNuts, Integer isPeanut, Integer isAcidity, Integer isChocolate , boolean wantAllerg) {
		if ((pass.length()<6) || (pass.compareTo(pass2)==0))
			check=false; // can't save > we will show an error ! 
		String hashPass;
		hashPass = ConvertPassToHash(pass);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate dateBirth = LocalDate.parse(dateOfBirth, formatter);	
		ev=new Event();
		Integer[] allergies= {isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate};
		ev.getArr().add("user_update");
		myUser.setPersonFirstName(firstName);
		myUser.setPersonLastName(lastName);
		myUser.setPersonEmail(email);
		myUser.setPersonDateOfBirth(dateBirth);
		myUser.setPersonHashPass(hashPass);
		myUser.setUserKashruth(isKosher);
		myUser.setUserAllergen(allergies);
		myUser.setUserAllergens(wantAllerg);
		setChanged();
		notifyObservers(ev);
	}
	public void userUpdateResponse(ArrayList<User> usU) {
		if (usU!=null)
			check=true; // everything was OK
		check=false; // something went wrong (could'nt save / already exist)
	}
	public void dietitianUpdate(String firstName, String lastName, String email, String pass, String pass2, String dateOfBirth, String dietitianNum, String dietitianStatDate) {
		if ((pass.length()<6) || (pass.compareTo(pass2)==0))
			check=false; // can't save > we will show an error ! 
		String hashPass;
		hashPass = ConvertPassToHash(pass);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate dateBirth = LocalDate.parse(dateOfBirth, formatter);	
		LocalDate dietitianDate = LocalDate.parse(dateOfBirth, formatter);	
		ev=new Event();
		ev.getArr().add("dietitian_update");
		myDietitian.setPersonFirstName(firstName);
		myDietitian.setPersonLastName(lastName);
		myDietitian.setPersonEmail(email);
		myDietitian.setPersonDateOfBirth(dateBirth);
		myDietitian.setPersonHashPass(hashPass);
		myDietitian.setDietitianStatDate(dietitianDate);
		setChanged();
		notifyObservers(ev);
	}
	public void dietitianUpdateResponse(ArrayList<Dietitian> usD) {
		if (usD!=null)
			check=true; // everything was OK
		check=false; // something went wrong (could'nt save / already exist)
	}
	public void deleteUser() {
		ev=new Event();
		ev.getArr().add("user_delete");
		ev.getArr().add(myUser);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteUserResponse(ArrayList<User> usU) {
		if (usU==null) // was able to delete
		{
			check=true; // move to login
			myUser=null;
		}	
		else check=false; // error
	}
	public void deleteDietitian() {
		ev=new Event();
		ev.getArr().add("dietitian_delete");
		ev.getArr().add(myDietitian);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteDietitianResponse(ArrayList<Dietitian> usD) {
		if (usD==null) // was able to delete
		{
			check=true; // move to login
			myDietitian=null;
		}	
		else check=false; // error
	}
	public void deleteIngredient(Ingredient ing) {
		ev=new Event();
		ev.getArr().add("ingredient_delete");
		ev.getArr().add(ing);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteIngredientResponse(ArrayList<Ingredient> in) {
		if (in==null)
		{
			check=true; // move to menu
			ingredientArray=in;
		}
		else check=false; // error
	}
	public void deleteRecipe(Recipe rec) {
		ev=new Event();
		ev.getArr().add("recipe_delete");
		ev.getArr().add(rec);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteRecipeResponse(ArrayList<Recipe> rec) {
		if (rec==null)
		{
			check=true; // move to menu
			recipeArray=rec;
		}
		else check=false; // error
	}
	public void recipeUpdate(Recipe rec) {
		ev=new Event();
		ev.getArr().add("recipe_update");
		ev.getArr().add(rec);
		setChanged();
		notifyObservers(ev);
	}
	public void recipeUpdateResponse(ArrayList<Recipe> r) {
		if (r!=null)
			check=true; // everything was OK
		check=false; // something went wrong 
	}
	public void ingredientUpdate(Ingredient ing) {
		ev=new Event();
		ev.getArr().add("ingredient_update");
		ev.getArr().add(ing);
		setChanged();
		notifyObservers(ev);
	}
	public void ingredientUpdateResponse(ArrayList<Ingredient> in) {
		if (in!=null)
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
 * 0 - חלבי
 * 1 - בשרי
 * 2 - פרווה
 * 3 - לא כשר יענו בייקון וכו?
 */