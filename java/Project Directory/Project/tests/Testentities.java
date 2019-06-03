package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

import model.*;

class Testentities {
	Allergen al;
	Ingredient pe;
	Ingredient pe1;
	@Test
	void test() {
		al= new Allergen(5);
		assertEquals("accept", "Lactose intolerance", al.getAllergenName());
	}
	@SuppressWarnings("deprecation")
	@Test
	void test1() {
		pe= new Ingredient(5);
		pe.setIngredientCarbohydrate(13.0);
		pe.Update();
		pe1= new Ingredient(5);
	//	System.out.println(pe1.getIngredientCarbohydrate());
		assertEquals("accept",13.0,(double)pe1.getIngredientCarbohydrate());
	}	
@SuppressWarnings("deprecation")
	@Test
	void test2() {
		pe= new Ingredient(5);
		pe.setIngredientCarbohydrate(28.3);
		pe.Update();
		pe1= new Ingredient(5);
		assertEquals("accept",28.3,(double)pe1.getIngredientCarbohydrate());


	}
}
	

