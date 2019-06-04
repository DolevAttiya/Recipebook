package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	@Test
	void update() {
		pe= new Ingredient(5);
		pe.setIngredientCarbohydrate(13.0);
		pe.Update();
		pe1= new Ingredient(5);
		assertEquals(13.0, (double)pe1.getIngredientCarbohydrate(),0);
		reupdate();
	}	
private	void reupdate() {
		pe= new Ingredient(5);
		pe.setIngredientCarbohydrate(28.3);
		pe.Update();
		pe=null;
		pe1=null;
	}
	@Test
	void insertAndDelete() {
		Integer[] al = new Integer[]{ 1,2,3,4,5,6 };
		pe= new Ingredient(99,"\"test\"",al,99.9,99.9,99.9,99.9,0,null);
		pe.Insert();
		pe1= new Ingredient(99);
		assertTrue(pe1!=null);
		pe1=null;
		pe.Delete();
		ResultSet rs =Entities.SelectSpecific("Ingredient", "ingredientId", "99");
		try {
			assertTrue(rs.getInt("ingredientId")==0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
}
	

