package tests;

import static org.junit.Assert.*;


import java.util.ArrayList;

import model.Allergen;
import model.Dietitian;
import model.Ingredient;
import model.IngredientType;
import model.Recipe;
import model.User;
import model.model;

public class ModelMock implements model {
	@Override
	public void top10() {
		assertTrue(true);
	}
	
	@Override
	public void CheckPasswordAndEmail(String Email, String Password) {
		assertEquals("username", Email, "ok");
		assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", Password);
	}
	
	@Override
	public void Search(ArrayList<Object> search) {
		assertEquals("hello world", (String)search.get(1));
	}
	
	@Override
	public void insertUser(User us) {
		assertEquals(true, us.getUserKashruth());
	}
	
	@Override
	public void updateUser(User us) {
		assertEquals(true, us.getUserKashruth());
	}
	
	@Override
	public void deleteUser(User us) {
		assertEquals(true, us.getUserKashruth());
	}
	
	@Override
	public void selectUser(String Email) {
		assertEquals("username", Email);
	}
	
	@Override
	public void insertDietitian(Dietitian dt) {
		assertEquals(99, dt.getDietitianId(),0);
	}
	
	@Override
	public void updateDietitian(Dietitian dt) {
		assertEquals(99, dt.getDietitianId(),0);
	}
	
	@Override
	public void deleteDietitian(Dietitian dt) {
		assertEquals(99, dt.getDietitianId(),0);
	}
	
	@Override
	public void selectDietitian(String Email) {
		assertEquals("username", Email);
	}

	@Override
	public void insertAllergen(Allergen al) {
		assertEquals(99, al.getAllergenId(),0);
	}

	@Override
	public void updateAllergen(Allergen al) {
		assertEquals(99, al.getAllergenId(),0);
	}

	@Override
	public void deleteAllergen(Allergen al) {
		assertEquals(99, al.getAllergenId(),0);
	}

	@Override
	public void selectAllergen(Integer id) {
		assertEquals(99,id,0);
	}

	@Override
	public void insertIngredient(Ingredient ing) {
		assertEquals(99, ing.getIngredientId(),0);
	}

	@Override
	public void updateIngredient(Ingredient ing) {
		assertEquals(99, ing.getIngredientId(),0);
	}

	@Override
	public void deleteIngredient(Ingredient ing) {
		assertEquals(99, ing.getIngredientId(),0);
	}

	@Override
	public void selectIngredient(Integer id) {
		assertEquals(99,id,0);
	}

	@Override
	public void insertIngredientType(IngredientType ingty) {
		assertEquals(99, ingty.getIngredientTypeId(),0);
	}

	@Override
	public void updateIngredientType(IngredientType ingty) {
		assertEquals(99, ingty.getIngredientTypeId(),0);
	}

	@Override
	public void deleteIngredientType(IngredientType ingty) {
		assertEquals(99, ingty.getIngredientTypeId(),0);

	}

	@Override
	public void selectIngredientType(Integer id) {
		assertEquals(99, id,0);
	}

	@Override
	public void insertRecipe(Recipe res) {
		assertEquals(99, res.getRecipeId(),0);

	}

	@Override
	public void updateRecipe(Recipe res) {
		assertEquals(99, res.getRecipeId(),0);

	}

	@Override
	public void deleteRecipe(Recipe res) {
		assertEquals(99, res.getRecipeId(),0);

	}

	@Override
	public void selectRecipe(Integer id) {
		assertEquals(99, id,0);

	}
	@Override
	public void myFavoriteRecipes(String Email) {
		assertEquals("idontknowhatemailis", Email);
	}
	
	@Override
	public void myRecipes(String Email) {
		assertEquals("idontknowhatemailis", Email);
	}

	@Override
	public void allRecipes() {
		// TODO Auto-generated method stub
		
	}



}
