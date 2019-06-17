package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;

import controller.Event;
public class Models extends Observable implements model  {
	Event ev;

	public Models() {
	}
	void top10(){
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		ResultSet rs=search("Top10Recipe",null);
		int i;
		try {
			for(i=0;i<10&&rs.next();i++)
			{
				recipe.add(GetRecipeParser(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ev.getArr().add("top_10_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);

	}

	public void CheckPasswordAndEmail(String Email, String Password){
		// select column_name from table_name order by column_name desc limit size.
		ev=new Event();
		ArrayList<Object> args=new ArrayList<Object>();
		args.add(Email);
		args.add(Password);
		ArrayList<User> user= new ArrayList<User>();
		ResultSet rs=search("CheckPasswordAndEmail",args);
		user.add(GetUserParser(rs));
		ev.getArr().add("user_login_response");
		ev.getArr().add(user);
		setChanged();
		notifyObservers(ev);
	}

	private ResultSet search(String typeSearch,ArrayList<Object> args) {
		String sql="";
		if(typeSearch.compareTo("Top10Recipe")==0) 
			sql="  select * from Recipe order by recipeRate desc ";
		if(typeSearch.compareTo("CheckPasswordAndEmail")==0)
			sql="  select * from UserPerson where personEmail = "+(String)args.get(0)+" And PersonHash = "+(String)args.get(1);
		ResultSet rs =getFromWithDB(sql) ;
		return rs;


	}

	public static User GetUserFromDB(String email)
	{ResultSet rs=SelectSpecific("UserPerson","personEmail",email);
	User user =GetUserParser(rs);
	return user;
	}
	private static User GetUserParser(ResultSet rs) {
		User per=new User(null,null,null,null,null,null,null, null, null); 
		try {
			per.setUserId(rs.getInt("userId"));
			ResultSet userAllergens = Models.SelectSpecificFrom("Count( allergenId ) as counter", "Allergen", null, null);
			Integer[] allergen= new Integer[userAllergens.getInt("counter")];
			userAllergens = SelectSpecific("UserAllergen","ingredientId",per.getUserId().toString());
			while(userAllergens.next())
			{
				allergen[userAllergens.getInt("allergenId")]=1;
			}
			per.setUserAllergen(allergen);
			per.setPersonEmail(rs.getString("personEmail"));
			per.setPersonFirstName(rs.getString("personFirstName"));
			per.setPersonLastName(rs.getString("personLastName"));
			per.setPersonDateOfBirth(rs.getDate("personDateOfBirth"));
			per.setPersonHashPass(rs.getString("personHashPass"));
			ArrayList<Integer> personsFavoriteRecipes = new ArrayList<Integer>();
			ResultSet favorite =SelectSpecific("PersonFavoriteRecipe","personEmail",per.getPersonEmail());
			while(favorite.next())
				personsFavoriteRecipes.add(rs.getInt("recipeId"));
			per.setPersonsFavoriteRecipe(personsFavoriteRecipes);
			per.setPersonImage(rs.getBlob("personImage"));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return per;
	}
	public void insertUser(User us){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<User> user= new ArrayList<User>();
		if(us.Insert())
		{
			user.add(GetUserFromDB(us.getPersonEmail()));
		}
		ev.getArr().add("user_register_response");
		ev.getArr().add(user);
		setChanged();
		notifyObservers(ev);
	}
	public void updateUser(User us){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<User> user= new ArrayList<User>();
		if(us.Update())
		{
			user.add(GetUserFromDB(us.getPersonEmail()));
		}
		ev.getArr().add("user_update_response");
		ev.getArr().add(user);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteUser(User us){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<User> user= new ArrayList<User>();
		if(!us.Delete())
		{
			user.add(GetUserFromDB(us.getPersonEmail()));
		}
		ev.getArr().add("user_delete_response");
		ev.getArr().add(user);
		setChanged();
		notifyObservers(ev);
	}
	public void selectUser(String Email) {
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<User> user= new ArrayList<User>();
		user.add(GetUserFromDB(Email));
		ev.getArr().add("user_select_response");
		ev.getArr().add(user);
		setChanged();
		notifyObservers(ev);}	

	public static Dietitian GetDietitianFromDB(String email)
	{ResultSet rs=SelectSpecific("DietitianPerson","personEmail",email);
	Dietitian dietitian =GetDietitianParser(rs);
	return dietitian;
	}
	private static Dietitian GetDietitianParser(ResultSet rs) {
		Dietitian per=new Dietitian(null,null,null,null,null,null,null, null, null); 
		try {
			per.setDietitianId(rs.getInt("dietitianId"));
			per.setPersonDateOfBirth(rs.getDate("dieticianStatDate"));
			per.setPersonEmail(rs.getString("personEmail"));
			per.setPersonFirstName(rs.getString("personFirstName"));
			per.setPersonLastName(rs.getString("personLastName"));
			per.setPersonDateOfBirth(rs.getDate("personDateOfBirth"));
			per.setPersonHashPass(rs.getString("personHashPass"));
			ArrayList<Integer> personsFavoriteRecipes = new ArrayList<Integer>();
			ResultSet favorite =SelectSpecific("PersonFavoriteRecipe","personEmail",per.getPersonEmail());
			while(favorite.next())
				personsFavoriteRecipes.add(rs.getInt("recipeId"));
			per.setPersonsFavoriteRecipe(personsFavoriteRecipes);
			per.setPersonImage(rs.getBlob("personImage"));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return per;
	}
	public void insertDietitian(Dietitian dt){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Dietitian> dietitian= new ArrayList<Dietitian>();
		if(dt.Insert())
		{
			dietitian.add(GetDietitianFromDB(dt.getPersonEmail()));
		}
		ev.getArr().add("dietitian_register_response");
		ev.getArr().add(dietitian);
		setChanged();
		notifyObservers(ev);
	}
	public void updateDietitian(Dietitian dt){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Dietitian> dietitian= new ArrayList<Dietitian>();
		if(dt.Update())
		{
			dietitian.add(GetDietitianFromDB(dt.getPersonEmail()));
		}
		ev.getArr().add("dietitian_update_response");
		ev.getArr().add(dietitian);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteDietitian(Dietitian dt){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Dietitian> dietitian= new ArrayList<Dietitian>();
		if(!dt.Delete())
		{
			dietitian.add(GetDietitianFromDB(dt.getPersonEmail()));
		}
		ev.getArr().add("dietitian_delete_response");
		ev.getArr().add(dietitian);
		setChanged();
		notifyObservers(ev);
	}
	public void selectDietitian(String Email) {
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Dietitian> dietitian= new ArrayList<Dietitian>();
		dietitian.add(GetDietitianFromDB(Email));
		ev.getArr().add("dietitian_select_response");
		ev.getArr().add(dietitian);
		setChanged();
		notifyObservers(ev);
	}	

	public static Allergen GetAllergenFromDB(Integer id) {
		ResultSet rs=SelectSpecific("Allergen","allergenId",id.toString());
		Allergen allergen =GetAllergenParser(rs);
		return allergen;
	}
	private static Allergen GetAllergenParser(ResultSet rs) {
		Allergen allergen = new Allergen(null,null);
		try {
			allergen.setAllergenId(rs.getInt("allergenId"));
			allergen.setAllergenName(rs.getString("allergenName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allergen;
	}
	public void insertAllergen(Allergen al){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Allergen> allergen= new ArrayList<Allergen>();
		if(al.Insert())
		{
			allergen.add(GetAllergenFromDB(al.getAllergenId()));
		}
		ev.getArr().add("allergen_insert_response");
		ev.getArr().add(allergen);
		setChanged();
		notifyObservers(ev);
	}
	public void updateAllergen(Allergen al){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Allergen> allergen= new ArrayList<Allergen>();
		if(al.Update())
		{
			allergen.add(GetAllergenFromDB(al.getAllergenId()));
		}
		ev.getArr().add("allergen_update_response");
		ev.getArr().add(allergen);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteAllergen(Allergen al){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Allergen> allergen= new ArrayList<Allergen>();
		if(!al.Delete())
		{
			allergen.add(GetAllergenFromDB(al.getAllergenId()));
		}
		ev.getArr().add("allergen_delete_response");
		ev.getArr().add(allergen);
		setChanged();
		notifyObservers(ev);
	}
	public void selectAllergen(Integer id) {
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Allergen> allergen= new ArrayList<Allergen>();
		allergen.add(GetAllergenFromDB(id));
		ev.getArr().add("allergen_select_response");
		ev.getArr().add(allergen);
		setChanged();
		notifyObservers(ev);
	}	

	public static Ingredient GetIngredientFromDB(Integer id) {
		ResultSet rs=SelectSpecific("Ingredient","ingredientId",id.toString());
		Ingredient ingredient =GetIngredientParser(rs);
		return ingredient;
	}
	private static Ingredient GetIngredientParser(ResultSet rs) {
		Ingredient ingredient = new Ingredient(null,null,null,null,null,null,null,null,null);
		try {
			ingredient.setIngredientId(rs.getInt("ingredientId"));
			ingredient.setIngredientName(rs.getString("ingredientName"));
			ResultSet ingredientAllergens = Models.SelectSpecificFrom("Count( \"allergenId\" ) as counter", "Allergen", null, null);
			Integer[] allergen= new Integer[ingredientAllergens.getInt("counter")];
			for(int i=0;i<allergen.length;i++)
				allergen[i]=0;
			ingredientAllergens = Models.SelectSpecific("IngredientAllergen","ingredientId",ingredient.getIngredientId().toString());
			while(ingredientAllergens.next())
			{
				allergen[ingredientAllergens.getInt("allergenId")]++;
			}
			ingredient.setIngredientAllergen(allergen);
			ingredient.setIngredientCalories(rs.getDouble("ingredientCalories"));
			ingredient.setIngredientCarbohydrate(rs.getDouble("ingredientCarbohydrate"));
			ingredient.setIngredientProtein(rs.getDouble("ingredientProtein"));
			ingredient.setIngredientFat(rs.getDouble("ingredientFat"));
			ingredient.setIngredientKashruth(rs.getInt("ingredientKashruth"));
			//ingredient.setIngredientImage(rs.getBlob("ingredientImage"));//TODO

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingredient;
	}
	public void insertIngredient(Ingredient ing){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Ingredient> ingredient= new ArrayList<Ingredient>();
		if(ing.Insert())
		{
			ingredient.add(GetIngredientFromDB(ing.getIngredientId()));
		}
		ev.getArr().add("ingredient_insert_response");
		ev.getArr().add(ingredient);
		setChanged();
		notifyObservers(ev);
	}
	public void updateIngredient(Ingredient ing){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Ingredient> ingredient= new ArrayList<Ingredient>();
		if(ing.Update())
		{
			ingredient.add(GetIngredientFromDB(ing.getIngredientId()));
		}
		ev.getArr().add("ingredient_update_response");
		ev.getArr().add(ingredient);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteIngredient(Ingredient ing){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Ingredient> ingredient= new ArrayList<Ingredient>();
		if(!ing.Delete())
		{
			ingredient.add(GetIngredientFromDB(ing.getIngredientId()));
		}
		ev.getArr().add("ingredient_delete_response");
		ev.getArr().add(ingredient);
		setChanged();
		notifyObservers(ev);
	}
	public void selectIngredient(Integer id) {
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Ingredient> ingredient= new ArrayList<Ingredient>();
		ingredient.add(GetIngredientFromDB(id));
		ev.getArr().add("ingredient_select_response");
		ev.getArr().add(ingredient);
		setChanged();
		notifyObservers(ev);
	}	

	public static IngredientType GetIngredientTypeFromDB(Integer id) {
		ResultSet rs=SelectSpecific("IngredientType","ingredientTypeId",id.toString());
		IngredientType ingredientType =GetIngredientTypeParser(rs);
		return ingredientType;
	}
	private static IngredientType GetIngredientTypeParser(ResultSet rs) {
		@SuppressWarnings("null")
		IngredientType ingredientType = new IngredientType( (Integer) null,null,null);
		try {
			ingredientType.setIngredientTypeId(rs.getInt("ingredientTypeId"));
			ingredientType.setIngredientTypeName(rs.getString("ingredientTypeValue"));
			ingredientType.setIngredientTypeName(rs.getString("ingredientTypeName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingredientType;
	}
	public void insertIngredientType(IngredientType ingty){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<IngredientType> ingredientType= new ArrayList<IngredientType>();
		if(ingty.Insert())
		{
			ingredientType.add(GetIngredientTypeFromDB(ingty.getIngredientTypeId()));
		}
		ev.getArr().add("ingredientType_insert_response");
		ev.getArr().add(ingredientType);
		setChanged();
		notifyObservers(ev);
	}
	public void updateIngredientType(IngredientType ingty){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<IngredientType> ingredientType= new ArrayList<IngredientType>();
		if(ingty.Update())
		{
			ingredientType.add(GetIngredientTypeFromDB(ingty.getIngredientTypeId()));
		}
		ev.getArr().add("ingredientType_update_response");
		ev.getArr().add(ingredientType);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteIngredientType(IngredientType ingty){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<IngredientType> ingredientType= new ArrayList<IngredientType>();
		if(!ingty.Delete())
		{
			ingredientType.add(GetIngredientTypeFromDB(ingty.getIngredientTypeId()));
		}
		ev.getArr().add("ingredientType_delete_response");
		ev.getArr().add(ingredientType);
		setChanged();
		notifyObservers(ev);
	}
	public void selectIngredientTypeType(Integer id) {
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<IngredientType> ingredientType= new ArrayList<IngredientType>();
		ingredientType.add(GetIngredientTypeFromDB(id));
		ev.getArr().add("ingredientType_select_response");
		ev.getArr().add(ingredientType);
		setChanged();
		notifyObservers(ev);
	}	

	public static Recipe GetRecipeFromDB(Integer id) {
		ResultSet rs=SelectSpecific("Recipe","recipeId",id.toString());
		Recipe recipe =GetRecipeParser(rs);
		return recipe;
	}
	private static Recipe GetRecipeParser(ResultSet rs) {
		Recipe recipe = new Recipe(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
		try {
			recipe.setRecipeId(rs.getInt("recipeId"));
			recipe.setRecipeName(rs.getString("recipeName"));
			ResultSet recipeAllergens = Models.SelectSpecificFrom("Count( allergenId ) as counter", "Allergen", null, null);
			Integer[] allergen= new Integer[recipeAllergens.getInt("counter")];
			recipeAllergens = Models.SelectSpecific("RecipeAllergen","ingredientId",recipe.getRecipeId().toString());
			while(recipeAllergens.next())
			{
				allergen[recipeAllergens.getInt("allergenId")]=1;
			}
			recipe.setRecipeAllergen(allergen);

			ResultSet recipeIngredientVals = Models.SelectSpecific("RecipeIngredient","recipeId",recipe.getRecipeId().toString());
			ArrayList<Integer> IngredientsType= new ArrayList<Integer>();
			ArrayList<Double> IngredientsAmount= new ArrayList<Double>();
			ArrayList<Integer> ingredients= new ArrayList<Integer>();

			while(recipeIngredientVals.next())
			{
				IngredientsType.add(rs.getInt("ingredientsType"));
				IngredientsAmount.add(rs.getDouble("IngredientsAmount"));
				ingredients.add(rs.getInt("IngredientsAmount"));

			}
			recipe.setRecipeIngredientId(ingredients);
			recipe.setRecipeIngredientsType(IngredientsType);
			recipe.setRecipeIngredientsAmount(IngredientsAmount);
			recipe.setRecipeTotalCalories(rs.getDouble("recipeTotalCalories"));
			recipe.setRecipeTotalCarbohydrate(rs.getDouble("recipeTotalCarbohydrate"));
			recipe.setRecipeTotalProtein(rs.getDouble("recipeTotalProtein"));
			recipe.setRecipeTotalFat(rs.getDouble("recipeTotalFat"));
			recipe.setRecipeKashruth(rs.getInt("recipeKashruth"));
			recipe.setRecipeComplex(rs.getInt("recipeComplex"));
			recipe.setRecipePersonEmail(rs.getString("recipePersonEmail"));
			recipe.setRecipeRate(rs.getInt("recipeRate"));
			recipe.setRecipeDescription(rs.getString("recipeDescription"));
			recipe.setRecipeProcses(rs.getString("recipeProcses"));	
			recipe.setRecipeImage(rs.getBlob("recipeImage"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recipe;
	}
	public void insertRecipe(Recipe res){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		if(res.Insert())
		{
			recipe.add(GetRecipeFromDB(res.getRecipeId()));
		}
		ev.getArr().add("recipe_insert_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);
	}
	public void updateRecipe(Recipe res){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		if(res.Update())
		{
			recipe.add(GetRecipeFromDB(res.getRecipeId()));
		}
		ev.getArr().add("recipe_update_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);
	}
	public void deleteRecipe(Recipe res){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		if(!res.Delete())
		{
			recipe.add(GetRecipeFromDB(res.getRecipeId()));
		}
		ev.getArr().add("recipe_delete_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);
	}
	public void selectRecipe(Integer id) {
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<IngredientType> ingredientType= new ArrayList<IngredientType>();
		ingredientType.add(GetIngredientTypeFromDB(id));
		ev.getArr().add("ingredientType_select_response");
		ev.getArr().add(ingredientType);
		setChanged();
		notifyObservers(ev);
	}	

	public static ResultSet SelectSpecificFrom(String Select, String Table, String Key,String Value) {
		String sql;
		if(Key!=null)
			sql=" SELECT "+Select+" FROM " + Table+" WHERE "+Key+" = "+Value;
		else
			sql=" SELECT "+Select+" FROM " + Table;
		ResultSet rs =getFromWithDB(sql) ;         
		return rs;
	}
	public static Boolean preformWithDB(String sql) {

		try (Connection conn = SingletonDBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) 
		{
			pstmt.executeUpdate();
			return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public static ResultSet SelectSpecific(String Table, String Key,String Value) {
		String sql="SELECT * FROM " + Table+" WHERE "+Key+" = "+Value;
		ResultSet rs =getFromWithDB(sql) ; 
		return rs;
	}
	public static ResultSet getFromWithDB(String sql) {//the preform the connection t
		try {
			Connection conn = SingletonDBConnection.getConnection();
			Statement stmt  = conn.createStatement();
			ResultSet rs    = stmt.executeQuery(sql);
			return rs;

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void Search(ArrayList<Object> search) {
		ev=new Event();
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		String sql= " Select * From Recipe Join RecipeAllergen using (RecipeId) Where recipeName like '%" +(String)search.get(1)+"%' ";
		if(search.get(2)!=null)
			sql+=" AND recipeKashruth = "+search.get(2);
		if(search.get(3)!=null)
			sql+=" AND recipeComplex = "+search.get(3);
		if(search.get(4)!=null)
			sql+=" AND recipeTimeToMake = "+search.get(4);
		if(search.get(5)!=null)
			sql+=" AND recipeRate  "+search.get(5);
		if(search.get(6)!=null)
			for(int i=0;i<((ArrayList<Integer>)search.get(6)).size();i++)
				
			sql+=" AND AllergenId  "+((ArrayList<Integer>)search.get(6)).get(i);
		
			sql+=" Orderby recipeRate ";
			
			
		ResultSet rs =getFromWithDB(sql);
		try {
			while(rs.next())
			{
				recipe.add(GetRecipeParser(rs));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ev.getArr().add("ingredientType_select_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);
	}
}
