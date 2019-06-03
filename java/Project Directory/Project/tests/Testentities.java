package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

import model.*;

class Testentities {
	Allergen al;
	Ingredient pe;
	@Test
	void test() {
		al= new Allergen(5);
		assertEquals("accept", "Lactose intolerance", al.getAllergenName());
	}
	@Test
	void test1() {
		pe= new Ingredient(5);
		pe.setIngredientCarbohydrate(13);
		pe.Update();
		Ingredient pe1= new Ingredient(5);

		
		assertEquals("accept",13,(int)pe1.getIngredientCarbohydrate());
	}
}
	

