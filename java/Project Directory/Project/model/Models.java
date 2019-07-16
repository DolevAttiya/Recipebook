package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import controller.Event;

public class Models extends Observable implements model  {
	Event ev;

	public Models() {
	}
	public void allIngredientType() {
		ev=new Event();
		String sql= " Select * From IngredientType";
		ArrayList<IngredientType> ingredient= new ArrayList<IngredientType>();
		ResultSet rs=getFromWithDB(sql);
		try {
			while(rs.next())
			{
				ingredient.add(GetIngredientTypeParser(rs));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ev.getArr().add("ingredient_type_getall_response");
		ev.getArr().add(ingredient);
		setChanged();
		notifyObservers(ev);
	}
	public void allIngredient() {
		ev=new Event();
		String sql= " Select * From Ingredient order by ingredientId";
		ArrayList<Ingredient> ingredient= new ArrayList<Ingredient>();
		ResultSet rs=getFromWithDB(sql);
		try {
			while(rs.next())
			{
				ingredient.add(GetIngredientParser(rs));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
		ev.getArr().add("ingredient_getall_response");
		ev.getArr().add(ingredient);
		setChanged();
		notifyObservers(ev);
	}
	public void allRecipes() {
		ev=new Event();
		String sql= " Select * From Recipe order by recipeRate";
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		ResultSet rs=getFromWithDB(sql);
		try {
			while(rs.next())
			{
				recipe.add(GetRecipeParser(rs));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ev.getArr().add("all_recipes_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);
	}

	public void myFavoriteRecipes(String Email) {
		ev=new Event();
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		String sql= " Select * From Recipe Join PersonFavoriteRecipe using (recipeId) Where PersonFavoriteRecipe.personEmail = "+" \""+Email+"\" ";

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
		ev.getArr().add("favorite_recipes_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);
	}
	public void Search(ArrayList<Object> search) {
		ev=new Event();
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		String sql= " Select * From Recipe Join RecipeAllergen using (RecipeId) Where recipeName like '%" +(String)search.get(1)+"%' ";
		if(search.get(2)!=null)
			if(search.get(7)!= null) {
				Integer x= 4;
				if((int)search.get(2)!=x)

					sql+=" AND recipeKashruth = "+(int)search.get(2);
				else 
					sql+=" AND recipeKashruth != 3";
			}
		if(search.get(3)!=null)
			sql+=" AND recipeComplex <= "+(int)search.get(3);
		if(search.get(4)!=null)
			sql+=" AND recipeTimeToMake <= "+(String)search.get(4);
		if(search.get(5)!=null)
			sql+=" AND recipeRate >= "+(String)search.get(5);
		if(search.get(6)!=null)
			for(int i=0;i<((Integer[])search.get(6)).length;i++)
			{ int x =((Integer[])search.get(6))[i];
				if(x!=0)
				sql+=" AND AllergenId is not "+i;
			}
		sql+=" order by recipeRate ";

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
		ev.getArr().add("search_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);
	}
	public void myRecipes(String Email) {
		ev=new Event();
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		String sql= " Select * From Recipe  Where personEmail = "+" \""+Email+"\" ";

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
		ev.getArr().add("my_recipes_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);
	}
	public void top10(){
		ev=new Event();
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

	public void getRecipesReport(Integer x) {
		ev=new Event();
		String sql= "select recipe.* from recipe where recipe.recipeId in (select DISTINCT recipeid from RecipeAllergen as r1 where not exists (select allergenId from allergen where allergenid != \"+ x.toString() + \" and allergenId not in (select allergenid from RecipeAllergen as r2 where r1.recipeId= r2.recipeId))) order by recipeRate";
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		ResultSet rs=getFromWithDB(sql);
		try {
			while(rs.next())
			{
				recipe.add(GetRecipeParser(rs));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ev.getArr().add("recipe_report_response");
		ev.getArr().add(recipe);
		setChanged();
		notifyObservers(ev);
	}
	public void getIngredientReport(Integer x) {
		ev=new Event();
		String sql= "select ingredient.* from Ingredient join (select count(ingredientId) as counter ,ingredientId from RecipeIngredient group by (ingredientId)) as counter using (ingredientId) order by counter.counter";
		ArrayList<Ingredient> ingredient= new ArrayList<Ingredient>();
		ResultSet rs=getFromWithDB(sql);
		try {
			while(rs.next())
			{
				ingredient.add(GetIngredientParser(rs));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ev.getArr().add("ingredient_report_response");
		ev.getArr().add(ingredient);
		setChanged();
		notifyObservers(ev);
	}
	
	public void CheckPasswordAndEmail(String Email, String Password){
		ev=new Event();
		ArrayList<Object> args=new ArrayList<Object>();

		args.add("User");
		args.add(Email);
		args.add(Password);
		ResultSet rs=search("CheckPasswordAndEmail",args);
		try {
			if(rs.next()){
				ArrayList<User> user= new ArrayList<User>();
				user.add(GetUserParser(rs));
				ev.getArr().add("user_login_response");
				ev.getArr().add(user);
			}
			else
			{
				args.set(0, "Dietitian");
				rs=search("CheckPasswordAndEmail",args);
				if(rs.next()){
					ArrayList<Dietitian> diet= new ArrayList<Dietitian>();
					diet.add(GetDietitianParser(rs));
					ev.getArr().add("dietitian_login_response");
					ev.getArr().add(diet);
				}else
				{
					ev.getArr().add("user_login_response");
					ev.getArr().add(null);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		setChanged();
		notifyObservers(ev);
	}

	private ResultSet search(String typeSearch,ArrayList<Object> args) {
		String sql="";
		if(typeSearch.compareTo("Top10Recipe")==0) 
			sql="  select * from Recipe order by recipeRate desc ";
		if(typeSearch.compareTo("CheckPasswordAndEmail")==0)
			if (((String)args.get(0)).compareTo("User")==0)
				sql="  select * from UserPerson where personEmail = \""+(String)args.get(1)+"\" And PersonHashPass = \""+(String)args.get(2)+"\" And userId is not null ";			else
				sql="  select * from DietitianPerson where personEmail = \""+(String)args.get(1)+"\" And PersonHashPass = \""+(String)args.get(2)+"\" And dietitianId is not null ";
		ResultSet rs =getFromWithDB(sql) ;
		return rs;


	}

	public static User GetUserFromDB(String email)
	{ResultSet rs=SelectSpecific("UserPerson","personEmail","\""+email+"\"");
	User user =GetUserParser(rs);
	return user;
	}
	private static User GetUserParser(ResultSet rs) {
		Integer[] ar=new Integer[1];
		ar[0]=0;
		User per=new User(null,null,null,null,null,null, null, ar,false,false); 
		try {
			per.setUserId(rs.getInt("userId"));
			ResultSet userAllergens = Models.SelectSpecificFrom("Count( allergenId ) as counter", "Allergen", null, null);
			Integer[] allergen= new Integer[userAllergens.getInt("counter")];
			userAllergens = SelectSpecific("UserAllergen","userId",per.getUserId().toString());
			while(userAllergens.next())
			{
				allergen[userAllergens.getInt("allergenId")]=1;
			}
			per.setUserAllergen(allergen);
			per.setUserAllergens(rs.getBoolean("userAllergen"));
			per.setUserKashruth(rs.getBoolean("userKashruth"));
			per.setPersonEmail(rs.getString("personEmail"));
			per.setPersonFirstName(rs.getString("personFirstName"));
			per.setPersonLastName(rs.getString("personLastName"));
			per.setPersonDateOfBirth(LocalDate.parse(rs.getString("personDateOfBirth")));
			per.setPersonHashPass(rs.getString("personHashPass"));
			ArrayList<Integer> personsFavoriteRecipes = new ArrayList<Integer>();
			ResultSet favorite =SelectSpecific("PersonFavoriteRecipe","personEmail"," \""+per.getPersonEmail()+"\" ");
			while(favorite.next())
				personsFavoriteRecipes.add(favorite.getInt("recipeId"));
			per.setPersonsFavoriteRecipe(personsFavoriteRecipes);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return per;
	}
	public void insertUser(User us){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<User> user= new ArrayList<User>();
		ResultSet saftiePerson  =Models.SelectSpecificFrom("Count( PersonEmail ) as count", "Person", "PersonEmail", " \"" +us.getPersonEmail()+"\" ");
		ResultSet rs =Models.SelectSpecificFrom("Max( userId ) as max", "User", null, null);
		try {
			us.setUserId(rs.getInt("max")+1);
			if(saftiePerson.getInt("count")==0&&us.Insert()) {
				user.add(GetUserFromDB(us.getPersonEmail()));
				ev.getArr().add("user_register_response");
				ev.getArr().add(user);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("user_register_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ev.getArr().add("user_register_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}	
	}
	public void updateUser(User us){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ResultSet saftie  =Models.SelectSpecificFrom("Count( userId ) as count", "User", "PersonEmail"," \"" +us.getPersonEmail()+"\" ");

		ArrayList<User> user= new ArrayList<User>();
		try {
			if(saftie.getInt("count")!=0&&us.Update())
			{
				user.add(GetUserFromDB(us.getPersonEmail()));

				ev.getArr().add("user_update_response");
				ev.getArr().add(user);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("user_update_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteUser(User us){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<User> user= new ArrayList<User>();
		ResultSet saftie  =Models.SelectSpecificFrom("Count( userId ) as count", "User", "PersonEmail"," \"" +us.getPersonEmail()+"\" ");
		try {
			if(saftie.getInt("count")==0)
			{	
				user.add(us);
				ev.getArr().add("user_delete_response");
				ev.getArr().add(user);
				setChanged();
				notifyObservers(ev);
			}
			else {if
			(!us.Delete())
			{
				user.add(GetUserFromDB(us.getPersonEmail()));
				ev.getArr().add("user_delete_response");
				ev.getArr().add(user);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("user_delete_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}}
		} catch (SQLException e) {
			e.printStackTrace();
			ev.getArr().add("user_delete_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
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
	{ResultSet rs=SelectSpecific("DietitianPerson","personEmail","\""+email+"\"");
	Dietitian dietitian =GetDietitianParser(rs);
	return dietitian;
	}
	private static Dietitian GetDietitianParser(ResultSet rs) {
		Dietitian per=new Dietitian(null,null,null,null,null,null, null, null); 
		try {
			per.setDietitianId(rs.getInt("dietitianId"));
			//LocalDate d = LocalDate.parse(rs.getString("dietitianStatDate"));
			per.setDietitianStatDate(LocalDate.parse(rs.getString("dietitianStatDate")));
			per.setPersonEmail(rs.getString("personEmail"));
			per.setPersonFirstName(rs.getString("personFirstName"));
			per.setPersonLastName(rs.getString("personLastName"));
			per.setPersonDateOfBirth(LocalDate.parse(rs.getString("personDateOfBirth")));
			per.setPersonHashPass(rs.getString("personHashPass"));
			ArrayList<Integer> personsFavoriteRecipes = new ArrayList<Integer>();
			ResultSet favorite =SelectSpecific(" PersonFavoriteRecipe "," personEmail " , " \""+per.getPersonEmail()+"\" ");
			while(favorite.next())
				personsFavoriteRecipes.add(favorite.getInt("recipeId"));
			per.setPersonsFavoriteRecipe(personsFavoriteRecipes);
			/*Blob blob = rs.getBlob("personImage");               
			byte [] data = blob.getBytes( 1, ( int ) blob.length() );
			BufferedImage img = null;
			try {
				img = ImageIO.read(new ByteArrayInputStream(data));
			} catch (IOException e) {
				e.printStackTrace();
			}
			per.setPersonImage(img);*/
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return per;
	}
	public void insertDietitian(Dietitian dt){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Dietitian> dietitian= new ArrayList<Dietitian>();
		ResultSet saftiePerson  =Models.SelectSpecificFrom("Count( PersonEmail ) as count", "Person", "PersonEmail", " \"" +dt.getPersonEmail()+"\" ");
		ResultSet saftieDietitian = Models.SelectSpecificFrom("Count( dietitianId ) as count", "Dietitian" , "dietitianId", dt.getDietitianId().toString());
		try {
			if(saftieDietitian.getInt("count")==0&&saftiePerson.getInt("count")==0&&dt.Insert())
			{
				dietitian.add(GetDietitianFromDB(dt.getPersonEmail()));
				ev.getArr().add("dietitian_register_response");
				ev.getArr().add(dietitian);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("dietitian_register_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ev.getArr().add("dietitian_register_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	}
	public void updateDietitian(Dietitian dt){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Dietitian> dietitian= new ArrayList<Dietitian>();
		ResultSet saftie  =Models.SelectSpecificFrom("Count( dietitianId ) as count", "Dietitian", "PersonEmail"," \"" +dt.getPersonEmail()+"\" ");

		try {
			if(saftie.getInt("count")!=0&&dt.Update())
			{
				dietitian.add(GetDietitianFromDB(dt.getPersonEmail()));
				ev.getArr().add("dietitian_update_response");
				ev.getArr().add(dietitian);
				setChanged();
				notifyObservers(ev);
			}
			else {
				ev.getArr().add("dietitian_update_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ev.getArr().add("dietitian_update_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	}
	public void deleteDietitian(Dietitian dt){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Dietitian> dietitian= new ArrayList<Dietitian>();
		ResultSet saftie  =Models.SelectSpecificFrom("Count( dietitianId ) as count", "Dietitian", "PersonEmail", " \"" +dt.getPersonEmail()+"\" ");
		try {
			if(saftie.getInt("count")==0)
			{
				dietitian.add(dt);
				ev.getArr().add("dietitian_delete_response");
				ev.getArr().add(dietitian);
				setChanged();
				notifyObservers(ev);
			}
			else if(!dt.Delete())
			{
				dietitian.add(GetDietitianFromDB(dt.getPersonEmail()));
				ev.getArr().add("dietitian_delete_response");
				ev.getArr().add(dietitian);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("dietitian_delete_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ev.getArr().add("dietitian_delete_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
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
		ResultSet saftie  =Models.SelectSpecificFrom("Count( allergenId ) as count", "Dietitian", "allergenId", al.getAllergenId().toString());
		ArrayList<Allergen> allergen= new ArrayList<Allergen>();
		try {
			if(saftie.getInt("count")==0&&al.Insert())
			{
				allergen.add(GetAllergenFromDB(al.getAllergenId()));
				ev.getArr().add("allergen_insert_response");
				ev.getArr().add(allergen);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("allergen_insert_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ev.getArr().add("allergen_insert_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	}
	public void updateAllergen(Allergen al){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Allergen> allergen= new ArrayList<Allergen>();
		ResultSet saftie  =Models.SelectSpecificFrom("Count( allergenId ) as count", "Dietitian", "allergenId", al.getAllergenId().toString());
		try {
			if(saftie.getInt("count")!=0&&al.Update())
			{
				allergen.add(GetAllergenFromDB(al.getAllergenId()));
				ev.getArr().add("allergen_update_response");
				ev.getArr().add(allergen);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("allergen_update_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ev.getArr().add("allergen_update_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);

		}

	}
	public void deleteAllergen(Allergen al){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Allergen> allergen= new ArrayList<Allergen>();
		ResultSet saftie  =Models.SelectSpecificFrom("Count( allergenId ) as count", "Dietitian", "allergenId", al.getAllergenId().toString());

		try {
		if(saftie.getInt("count")==0)
		{
			allergen.add(al);
			ev.getArr().add("allergen_delete_response");
			ev.getArr().add(al);
			setChanged();
			notifyObservers(ev);
		}
		else if
		(!al.Delete())
		{
			allergen.add(GetAllergenFromDB(al.getAllergenId()));
			ev.getArr().add("allergen_delete_response");
			ev.getArr().add(allergen);
			setChanged();
			notifyObservers(ev);
		}
		else
		{
			ev.getArr().add("allergen_delete_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	} catch (SQLException e) {
		e.printStackTrace();
		ev.getArr().add("allergen_delete_response");
		ev.getArr().add(null);
		setChanged();
		notifyObservers(ev);
	}
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
		Integer[] ar=new Integer[1];
		ar[0]=0;
		Ingredient ingredient = new Ingredient(null,null,ar,null,null,null,null,null);
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
				int x =ingredientAllergens.getInt("allergenId");
				allergen[x]++;
			}
			ingredient.setIngredientAllergen(allergen);
			ingredient.setIngredientCalories(rs.getDouble("ingredientCalories"));
			ingredient.setIngredientCarbohydrate(rs.getDouble("ingredientCarbohydrate"));
			ingredient.setIngredientProtein(rs.getDouble("ingredientProtein"));
			ingredient.setIngredientFat(rs.getDouble("ingredientFat"));
			ingredient.setIngredientKashruth(rs.getInt("ingredientKashruth"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingredient;
	}
	public void insertIngredient(Ingredient ing){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Ingredient> ingredient= new ArrayList<Ingredient>();
		ResultSet saftie  =Models.SelectSpecificFrom("Count( ingredientId ) as count", "Ingredient", "ingredientName"," \""+ing.getIngredientName()+"\" ");
		ResultSet rs =Models.SelectSpecificFrom("Max( ingredientId ) as max", "Ingredient", null, null);
		try {
			ing.setIngredientId(rs.getInt("max")+1);
			if(saftie.getInt("count")==0&&ing.Insert())
			{
				ingredient.add(GetIngredientFromDB(ing.getIngredientId()));
				ev.getArr().add("ingredient_insert_response");
				ev.getArr().add(ingredient);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("ingredient_insert_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			ev.getArr().add("ingredient_insert_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}

	}
	public void updateIngredient(Ingredient ing){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ResultSet saftie  =Models.SelectSpecificFrom("Count( ingredientId ) as count", "Ingredient", "ingredientId",ing.getIngredientId().toString());
		ArrayList<Ingredient> ingredient= new ArrayList<Ingredient>();
		try {

			if(saftie.getInt("count")!=0&&ing.Update())
			{
				ingredient.add(GetIngredientFromDB(ing.getIngredientId()));
				ev.getArr().add("ingredient_update_response");
				ev.getArr().add(ingredient);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("ingredient_update_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			ev.getArr().add("ingredient_update_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	}
	public void deleteIngredient(Ingredient ing){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ResultSet saftie  =Models.SelectSpecificFrom("Count( ingredientId ) as count", "Ingredient", "ingredientId",ing.getIngredientId().toString());
		ArrayList<Ingredient> ingredient= new ArrayList<Ingredient>();
		try {
		if(saftie.getInt("count")==0)
		{
			ingredient.add(ing);
			ev.getArr().add("ingredient_delete_response");
			ev.getArr().add(ing);
			setChanged();
			notifyObservers(ev);
		}
		else if
		(!ing.Delete())
		{
			ingredient.add(GetIngredientFromDB(ing.getIngredientId()));
			ev.getArr().add("ingredient_delete_response");
			ev.getArr().add(ingredient);
			setChanged();
			notifyObservers(ev);
		}
		else
		{
			ev.getArr().add("ingredient_delete_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	} catch (SQLException e) {
		e.printStackTrace();
		ev.getArr().add("ingredient_delete_response");
		ev.getArr().add(null);
		setChanged();
		notifyObservers(ev);
	}
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
		ResultSet rs=SelectSpecific("IngredientType","ingredientId",id.toString());
		IngredientType ingredient =GetIngredientTypeParser(rs);
		return ingredient;
	}
	private static IngredientType GetIngredientTypeParser(ResultSet rs) {
		IngredientType ingredient = new IngredientType(0,null,null);
		try {
			ingredient.setIngredientTypeId(rs.getInt("ingredientId"));
			ingredient.setIngredientTypeName(rs.getString("ingredientName"));
			ingredient.setIngredientTypeValue(rs.getInt("ingredientValue"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingredient;
	}
	public void insertIngredientType(IngredientType ing){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<IngredientType> ingredient= new ArrayList<IngredientType>();
		ResultSet saftie  =Models.SelectSpecificFrom("Count( ingredientId ) as count", "IngredientType", "ingredientId",ing.getIngredientTypeId().toString());
		ResultSet rs =Models.SelectSpecificFrom("Max( ingredientId ) as max", "IngredientType", null, null);
		try {
			ing.setIngredientTypeId(rs.getInt("max")+1);
			if(saftie.getInt("count")==0&&ing.Insert())
			{
				ingredient.add(GetIngredientTypeFromDB(ing.getIngredientTypeId()));
				ev.getArr().add("ingredient_insert_response");
				ev.getArr().add(ingredient);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("ingredient_insert_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			ev.getArr().add("ingredient_insert_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}

	}
	public void updateIngredientType(IngredientType ing){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ResultSet saftie  =Models.SelectSpecificFrom("Count( ingredientId ) as count", "IngredientType", "ingredientId",ing.getIngredientTypeId().toString());
		ArrayList<IngredientType> ingredient= new ArrayList<IngredientType>();
		try {

			if(saftie.getInt("count")!=0&&ing.Update())
			{
				ingredient.add(GetIngredientTypeFromDB(ing.getIngredientTypeId()));
				ev.getArr().add("ingredient_update_response");
				ev.getArr().add(ingredient);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("ingredient_update_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			ev.getArr().add("ingredient_update_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	}
	public void deleteIngredientType(IngredientType ing){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ResultSet saftie  =Models.SelectSpecificFrom("Count( ingredientId ) as count", "IngredientType", "ingredientId",ing.getIngredientTypeId().toString());
		ArrayList<IngredientType> ingredient= new ArrayList<IngredientType>();
		try {
		if(saftie.getInt("count")==0)
		{
			ingredient.add(ing);
			ev.getArr().add("ingredient_delete_response");
			ev.getArr().add(ing);
			setChanged();
			notifyObservers(ev);
		}
		else if
		(!ing.Delete())
		{
			ingredient.add(GetIngredientTypeFromDB(ing.getIngredientTypeId()));
			ev.getArr().add("ingredient_delete_response");
			ev.getArr().add(ingredient);
			setChanged();
			notifyObservers(ev);
		}
		else
		{
			ev.getArr().add("ingredient_delete_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	} catch (SQLException e) {
		e.printStackTrace();
		ev.getArr().add("ingredient_delete_response");
		ev.getArr().add(null);
		setChanged();
		notifyObservers(ev);
	}
	}
	public void selectIngredientType(Integer id) {
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<IngredientType> ingredient= new ArrayList<IngredientType>();
		ingredient.add(GetIngredientTypeFromDB(id));
		ev.getArr().add("ingredient_select_response");
		ev.getArr().add(ingredient);
		setChanged();
		notifyObservers(ev);
	}	

	public static Recipe GetRecipeFromDB(Integer id) {
		ResultSet rs=SelectSpecific("Recipe","recipeId",id.toString());
		Recipe recipe =GetRecipeParser(rs);
		return recipe;
	}
	private static Recipe GetRecipeParser(ResultSet rs) {
		Integer[] ar=new Integer[1];
		ar[0]=0;
		Recipe recipe = new Recipe(null,null,ar,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
		try {
			recipe.setRecipeId(rs.getInt("recipeId"));
			recipe.setRecipeName(rs.getString("recipeName"));
			ResultSet recipeAllergens = Models.SelectSpecificFrom("Count( allergenId ) as counter", "Allergen", null, null);
			Integer[] allergen= new Integer[recipeAllergens.getInt("counter")];
			recipeAllergens = Models.SelectSpecific("RecipeAllergen","recipeId",recipe.getRecipeId().toString());
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
				IngredientsType.add(recipeIngredientVals.getInt("ingredientId"));
				IngredientsAmount.add(recipeIngredientVals.getDouble("IngredientAmount"));
				ingredients.add(recipeIngredientVals.getInt("IngredientId"));

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
			recipe.setRecipePersonEmail(rs.getString("PersonEmail"));
			recipe.setRecipeRate(rs.getInt("recipeRate"));
			recipe.setRecipeDescription(rs.getString("recipeDescription"));
			recipe.setRecipeProcess(rs.getString("recipeProcess"));	
			//recipe.setRecipeImage(rs.getBlob("recipeImage"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recipe;
	}
	public void insertRecipe(Recipe res){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		ResultSet saftie  =Models.SelectSpecificFrom("Count( recipeId ) as count", "Recipe", "recipeName","\""+res.getRecipeName()+"\"");
		ResultSet rs =Models.SelectSpecificFrom("Max( recipeId ) as max", "Recipe", null, null);
		try {
			res.setRecipeId(rs.getInt("max")+1);
			if(saftie.getInt("count")==0&&res.Insert())
			{
				recipe.add(GetRecipeFromDB(res.getRecipeId()));
				ev.getArr().add("recipe_insert_response");
				ev.getArr().add(recipe);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("recipe_insert_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			ev.getArr().add("recipe_insert_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}

	}
	public void updateRecipe(Recipe res){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ResultSet saftie  =Models.SelectSpecificFrom("Count( recipeId ) as count", "Recipe", "recipeName","\""+res.getRecipeName()+"\"");
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		try {

			if(saftie.getInt("count")!=0&&res.Update())
			{
				recipe.add(GetRecipeFromDB(res.getRecipeId()));
				ev.getArr().add("recipe_update_response");
				ev.getArr().add(recipe);
				setChanged();
				notifyObservers(ev);
			}
			else
			{
				ev.getArr().add("recipe_update_response");
				ev.getArr().add(null);
				setChanged();
				notifyObservers(ev);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			ev.getArr().add("recipe_update_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	}
	public void deleteRecipe(Recipe res){
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ResultSet saftie  =Models.SelectSpecificFrom("Count( recipeId ) as count", "Recipe", "recipeId",res.getRecipeId().toString());
		ArrayList<Recipe> recipe= new ArrayList<Recipe>();
		try {
		if(saftie.getInt("count")==0)
		{
			recipe.add(res);
			ev.getArr().add("recipe_delete_response");
			ev.getArr().add(recipe);
			setChanged();
			notifyObservers(ev);
		}
		else if
		(!res.Delete())
		{
			recipe.add(GetRecipeFromDB(res.getRecipeId()));
			ev.getArr().add("recipe_delete_response");
			ev.getArr().add(recipe);
			setChanged();
			notifyObservers(ev);
		}
		else
		{
			ev.getArr().add("recipe_delete_response");
			ev.getArr().add(null);
			setChanged();
			notifyObservers(ev);
		}
	} catch (SQLException e) {
		e.printStackTrace();
		ev.getArr().add("recipe_delete_response");
		ev.getArr().add(null);
		setChanged();
		notifyObservers(ev);
	}
	}
	public void selectRecipe(Integer id) {
		ev=new Event();
		// select column_name from table_name order by column_name desc limit size.
		ArrayList<IngredientType> ingredient= new ArrayList<IngredientType>();
		ingredient.add(GetIngredientTypeFromDB(id));
		ev.getArr().add("ingredient_select_response");
		ev.getArr().add(ingredient);
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

}
