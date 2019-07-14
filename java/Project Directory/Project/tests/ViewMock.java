package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Dietitian;
import model.Ingredient;
import model.Recipe;
import model.User;
import view.View;

public class ViewMock implements View {

	@Override
	public void uloginResponse(ArrayList<User> usU) {
		if(usU!=null)
			assertEquals("drakarisValyrian.com", usU.get(0).getPersonEmail());
		else
			assertNull(usU);
	}

	@Override
	public void dloginResponse(ArrayList<Dietitian> usD) {
			assertEquals("midget@kingslanding.com", usD.get(0).getPersonEmail());
	}

	@Override
	public void uRegisterResponse(ArrayList<User> usU) {
		if(usU!=null)
			assertEquals("idontknowhatemailis", usU.get(0).getPersonEmail());
		else
			assertNull(usU);
	}

	@Override
	public void dRegisterResponse(ArrayList<Dietitian> usD) {
		if(usD!=null)
			assertEquals("idontknowhatemailis", usD.get(0).getPersonEmail());
		else
			assertNull(usD);
	}

	@Override
	public void userUpdateResponse(ArrayList<User> usU) {
		if(usU!=null)
			assertTrue(usU.get(0).getUserKashruth());
		else
			assertNull(usU);
	}

	@Override
	public void deleteUserResponse(ArrayList<User> usU) {
		if(usU!=null)
			assertNotNull(usU.get(0));
		else
			assertNull(usU);
	}
	
	@Override
	public void dietitianUpdateResponse(ArrayList<Dietitian> usD) {
		if(usD!=null)
			assertEquals("1996-06-17", usD.get(0).getDietitianStatDate().toString());
		else
			assertNull(usD);
	}
	
	@Override
	public void deleteDietitianResponse(ArrayList<Dietitian> usD) {
		if(usD!=null)
			assertNotNull(usD.get(0));
		else
			assertNull(usD);
	}
	
	@Override
	public void getAllRecipesResponse(ArrayList<Recipe> r) { 
		assertNotEquals(0,r.size());
	}

	@Override
	public void getTop10Response(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void myRecipesResponse(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void myFavoriteResponse(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void searchResponse(ArrayList<Recipe> r) {
		if(r.size()!=0)
			assertNotNull(r);
		else
			assertEquals(0, r.size());
	}

	@Override
	public void addRecipeResponse(ArrayList<Recipe> r) {
		if(r!=null)
			assertNotNull(r);
		else
			assertNull(r);
	}
	
	@Override
	public void recipeUpdateResponse(ArrayList<Recipe> r) {
		if(r!=null)
			assertEquals(1,(int)r.get(0).getRecipeKashruth());
		else
			assertNull(r);
	}
	
	@Override
	public void deleteRecipeResponse(ArrayList<Recipe> rec) {
		if(rec!=null)
			assertNotNull(rec.get(0));
		else
			assertNull(rec);
	}
	
	@Override
	public void addIngredientResponse(ArrayList<Ingredient> in) {
		if(in!=null)
			assertNotNull(in.get(0));
		else
			assertNull(in);
	}

	/*@Override
	public void ingredientUpdateResponse(ArrayList<Ingredient> in) {
		if(in!=null)
			assertNotNull(in.get(0));
		else
			assertNull(in);
	}
	
	@Override
	public void deleteIngredientResponse(ArrayList<Ingredient> in) {
		if(in!=null)
			assertNotNull(in.get(0));
		else
			assertNull(in);
	}*/
}
