package tests;

import static org.junit.Assert.*;
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
	public void dietitianUpdateResponse(ArrayList<Dietitian> usD) {
		if(usD!=null)
			assertEquals("1996-06-17", usD.get(0).getDietitianStatDate());
		else
			assertNull(usD);
	}

	@Override
	public void getTop10Response(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void myFavoriteResponse(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void myRecipesResponse(ArrayList<Recipe> r) {
		assertNotEquals(0,r.size());
	}

	@Override
	public void searchResponse(ArrayList<Recipe> r) {
		if(r!=null)
			assertNotNull(r);
		else
			assertNull(r);
	}

	@Override
	public void addIngredientResponse(Integer ingredientId) {//not in use, delete after merge with rotem
		// TODO Auto-generated method stub

	}

	@Override
	public void addRecipeResponse(ArrayList<Recipe> r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addIngredientResponse(ArrayList<Ingredient> in) {
		// TODO Auto-generated method stub

	}
}
