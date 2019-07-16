package model;

import java.util.ArrayList;

public interface model {
	public void top10();
	public void allIngredient();
	public void allIngredientType();
	public void CheckPasswordAndEmail(String Email, String Password);
	public void Search(ArrayList<Object> search);
	public void myFavoriteRecipes(String Email);
	public void myRecipes(String Email);
	public void allRecipes();

	public void insertUser(User us);
	public void updateUser(User us);
	public void deleteUser(User us);
	public void selectUser(String Email);

	public void insertDietitian(Dietitian dt);
	public void updateDietitian(Dietitian dt);
	public void deleteDietitian(Dietitian dt);
	public void selectDietitian(String Email);

	public void insertAllergen(Allergen al);
	public void updateAllergen(Allergen al);
	public void deleteAllergen(Allergen al);
	public void selectAllergen(Integer id);

	public void insertIngredient(Ingredient ing);
	public void updateIngredient(Ingredient ing);
	public void deleteIngredient(Ingredient ing);
	public void selectIngredient(Integer id);

	public void insertIngredientType(IngredientType ingty);
	public void updateIngredientType(IngredientType ingty);
	public void deleteIngredientType(IngredientType ingty);
	public void selectIngredientType(Integer id);

	public void insertRecipe(Recipe res);
	public void updateRecipe(Recipe res);
	public void deleteRecipe(Recipe res);
	public void selectRecipe(Integer id);

}
