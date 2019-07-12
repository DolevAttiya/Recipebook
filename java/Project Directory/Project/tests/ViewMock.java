package tests;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import model.Dietitian;
import model.Recipe;
import model.User;
import view.View;

public class ViewMock implements View {

	@Override
	public void loginResponse(ArrayList<User> us) {
		if(us.get(0)!=null)
			assertEquals("drakarisValyrian.com", us.get(0).getPersonEmail());
		else
			assertNull(us.get(0));
	}

	@Override
	public void dRegisterResponse(ArrayList<Dietitian> usD) {
		if(usD.get(0)!=null)
			assertEquals("midget@kingslanding.com", usD.get(0).getPersonEmail());
		else
			assertNull(usD.get(0));
	}

	@Override
	public void uRegisterResponse(ArrayList<User> usU) {
		if(usU.get(0)!=null)
			assertEquals("drakarisValyrian.com", usU.get(0).getPersonEmail());
		else
			assertNull(usU.get(0));
	}

	@Override
	public void getTop10Response(ArrayList<Recipe> r) {
		assertNotNull(r.get(0));
	}

	@Override
	public void searchResponse(ArrayList<Recipe> r) {
		assertNotNull(r.get(0));
	}

	@Override
	public void addIngredientResponse(Integer ingredientId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void myFavoriteResponse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void myRecipesResponse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRecipeResponse() {
		// TODO Auto-generated method stub

	}

}
