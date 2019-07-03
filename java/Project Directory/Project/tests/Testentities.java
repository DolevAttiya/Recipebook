package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import model.*;
class Testentities {
	Allergen al;
	Ingredient pe;
	Ingredient pe1;
	Recipe re;
	Recipe re1;
	User us;
	User us1;
	Dietitian dt;
	Dietitian dt1;
	@Test
	void test() {
		al= Models.GetAllergenFromDB(5);
		assertEquals("accept", "Lactose intolerance", al.getAllergenName());
	}

	@Test
	void updateIngredient() {
		pe=Models.GetIngredientFromDB(5);
		pe.getIngredientAllergen()[3]=1;
		pe.setIngredientCarbohydrate(13.0);
		pe.Update();
		pe1=Models.GetIngredientFromDB(5);
		assertEquals(13.0, (double)pe1.getIngredientCarbohydrate(),0);
		reupdateIngredient();
	}	
	private	void reupdateIngredient() {
		pe=Models.GetIngredientFromDB(5);
		pe.getIngredientAllergen()[3]=0;
		pe.setIngredientCarbohydrate(28.3);
		pe.Update();
		pe=null;
		pe1=null;
	}
	@Test
	void insertAndDeleteIngredient() {
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		pe= new Ingredient(99,"\"test\"",al,99.9,99.9,99.9,99.9,0,null);
		pe.Insert();
		pe1=Models.GetIngredientFromDB(99);
		assertTrue(pe1!=null);
		pe1=null;
		pe.Delete();
		ResultSet rs =Models.SelectSpecificFrom("Count( \"allergenId\" ) as counter","Ingredient", "ingredientId", "99");
		try {
			assertTrue(rs.getInt("counter")==0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	@Test
	void insertAndDeleteRecipe() {
		Integer recipeId= 99;
		String recipeName="lazania";
		Blob recipeImage=null;
		Double recipeTotalCalories=0.0;
		Double recipeTotalCarbohydrate=0.0;
		Double recipeTotalProtein=0.0;
		Double recipeTotalFat=0.0;
		Integer recipeKashruth=0;
		Time recipeTimeToMake= new Time(225);
		Integer[] recipeAllergen= {0,0,0,0,1,0,0,1,0,0,1,0};
		User Daenerys= Models.GetUserFromDB("\"drakarisValyrian.com\"");
		Integer recipeComplex=3;
		Integer recipeRate= 0;
		String recipeDescription="The Italian cuisine is regional. Historical and cultural impacts, geography, the variety of climatic zones and cultural influences contributed to the diversity found in Italian cooking. This lasagna is made of pasta dough layers filled with bolognese sauce béchamel and Parmesan cheese, in the style of northern Italy.";
		String recipeProcses="Grind 500 grams (1.1 pounds) of beef. Peel, wash and fine dice 150 grams (5 oz) of onion, 200 grams (7 oz) of carrot, and 200 grams (7 oz) of celery stalks.\r\n" + 
				"Peel 500 grams (1 pounds) of tomatoes: use a sharp knife and make a crosswise incision. Place in boiling water for one minute, and shock in ice water. Remove the skins and dice the tomatoes.\r\n" + 
				"Heat 30 grams (1 oz) of oil and 60 grams (2 oz) of butter in a pan over medium heat. Add the onion and cook until translucent. Add the celery and the carrot and cook for a minute or two, stirring occasionally.\r\n" + 
				"Add the ground beef and season right away with 2 teaspoon of salt and ½ teaspoon of ground black pepper. Cook until the meat changes its red color.\r\n" + 
				"Add 350 ml (12 fl oz) of milk and a pinch of nutmeg. Simmer until it evaporates. Add 250 ml (8.5 oz) of dry white wine, and cook until it evaporates. Add the tomatoes and simmer over low heat for at least 3 hours, stirring from time to time. If the bolognese dries out, add ½ cup of water or stock.\r\n" + 
				"Pasta: While the bolognese is cooking, make the pasta dough. Sift 200 grams (7 oz) of flour into the mixing bowl. Add a pinch of salt and two eggs. Mix on low speed until smooth and elastic. Finish kneading the dough by hand, on a lightly floured surface. Gather into a ball, cover and let the dough relax for at least 40 minutes. You can also mix the dough by hand.\r\n" + 
				"Béchamel: To make white roux melt 60 grams (2 oz) of butter over low heat. Add 70 grams (2.5 oz) of flour, stir until smooth. Cook for two minutes, the roux should have a chalky color. Gradually add 750 ml (25 fl oz) of milk, whisking constantly. Add 1/2 teaspoon of salt and an onion pique. To make an onion pique, peel a whole onion, and use a clove to attach a bay leaf. Simmer, stirring frequently, until the sauce is smooth and thickened. Remove the onion pique and strain the béchamel.\r\n" + 
				"Roll the pasta 1 mm thick (1/20 inch) rectangles.\r\n" + 
				"Bring 4 Liters of water to boil and add 4 teaspoons of salt. Slip four sheets of pasta at a time. Cook for 5 seconds, remove from the boiling water and drop into cold water. Spread on a towel to pat dry.\r\n" + 
				"Assembling: Brush a 13×30 cm (5×12 inch) pan with melted butter and spread tablespoon of béchamel. Line with a single layer of pasta sheets, spread a thin layer of béchamel, spread a layer of bolognese sauce and sprinkle with grated Parmesan cheese. Repeat this process until there are eight layers of pasta.\r\n" + 
				"Spread a thin layer of béchamel sauce over the top layer, sprinkle with Parmesan and dot with 20 grams (2/3 oz) of butter. You will need a total of 80 grams (3 oz) of Parmesan cheese.\r\n" + 
				"Bake at a 200°C (400°F) oven for 15 minutes.\r\n" + 
				"Allow the lasagna to rest for a few minutes before serving. Serve directly from the pan or slice into individual portions.\r\n";
		ArrayList<Integer> recipeIngredientId= new ArrayList<Integer>();
		recipeIngredientId.add(1);
		recipeIngredientId.add(75);
		recipeIngredientId.add(101);
		recipeIngredientId.add(74);
		recipeIngredientId.add(102);
		recipeIngredientId.add(53);
		recipeIngredientId.add(23);
		recipeIngredientId.add(24);
		recipeIngredientId.add(103);
		recipeIngredientId.add(15);
		recipeIngredientId.add(44);
		recipeIngredientId.add(104);
		recipeIngredientId.add(105);
		recipeIngredientId.add(106);
		recipeIngredientId.add(107);
		recipeIngredientId.add(108);
		recipeIngredientId.add(109);
		ArrayList<Integer> recipeIngredientsType=new ArrayList<Integer>();
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(15);//item
		recipeIngredientsType.add(2);//teaspoon
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(13);//KL
		recipeIngredientsType.add(12);//ml
		recipeIngredientsType.add(1);//TS
		recipeIngredientsType.add(2);//0.5TS
		recipeIngredientsType.add(4);//0.125TS
		recipeIngredientsType.add(15);//item
		recipeIngredientsType.add(11);//item
		ArrayList<Double> recipeIngredientsAmount=new ArrayList<Double>();
		recipeIngredientsAmount.add(270.0);
		recipeIngredientsAmount.add(2.0);
		recipeIngredientsAmount.add(3.01);
		recipeIngredientsAmount.add(500.0);
		recipeIngredientsAmount.add(30.0);
		recipeIngredientsAmount.add(120.0);
		recipeIngredientsAmount.add(150.0);
		recipeIngredientsAmount.add(200.0);
		recipeIngredientsAmount.add(200.0);
		recipeIngredientsAmount.add(500.0);
		recipeIngredientsAmount.add(1.1);
		recipeIngredientsAmount.add(250.0);
		recipeIngredientsAmount.add(1.0);
		recipeIngredientsAmount.add(1.0);
		recipeIngredientsAmount.add(1.0);
		recipeIngredientsAmount.add(50.0);
		recipeIngredientsAmount.add(50.0);
		re= new Recipe(recipeId, recipeName, recipeAllergen, recipeTotalCalories, recipeTotalCarbohydrate, recipeTotalProtein, recipeTotalFat, recipeKashruth, recipeImage, recipeTimeToMake, recipeComplex,Daenerys.getPersonEmail() , recipeRate, recipeDescription, recipeProcses, recipeIngredientId,recipeIngredientsType ,recipeIngredientsAmount );
		re.Insert();
		re1=Models.GetRecipeFromDB(99);
		assertTrue(re1!=null);
		re1=null;
		re.Delete();
		ResultSet rs =Models.SelectSpecificFrom("Count( \"recipeId\" ) as counter","Recipe", "recipeId", "99");
		try {
			assertTrue(rs.getInt("counter")==0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void Updaterecipe()
	{
		Integer recipeId= 99;
		String recipeName="lazania";
		Blob recipeImage=null;
		Double recipeTotalCalories=0.0;
		Double recipeTotalCarbohydrate=0.0;
		Double recipeTotalProtein=0.0;
		Double recipeTotalFat=0.0;
		Integer recipeKashruth=0;
		Time recipeTimeToMake= new Time(225);
		Integer[] recipeAllergen= {0,0,0,0,1,0,0,1,0,0,1,0};
		User Daenerys= Models.GetUserFromDB("\"drakarisValyrian.com\"");
		Integer recipeComplex=3;
		Integer recipeRate= 0;
		String recipeDescription="The Italian cuisine is regional. Historical and cultural impacts, geography, the variety of climatic zones and cultural influences contributed to the diversity found in Italian cooking. This lasagna is made of pasta dough layers filled with bolognese sauce béchamel and Parmesan cheese, in the style of northern Italy.";
		String recipeProcses="Grind 500 grams (1.1 pounds) of beef. Peel, wash and fine dice 150 grams (5 oz) of onion, 200 grams (7 oz) of carrot, and 200 grams (7 oz) of celery stalks.\r\n" + 
				"Peel 500 grams (1 pounds) of tomatoes: use a sharp knife and make a crosswise incision. Place in boiling water for one minute, and shock in ice water. Remove the skins and dice the tomatoes.\r\n" + 
				"Heat 30 grams (1 oz) of oil and 60 grams (2 oz) of butter in a pan over medium heat. Add the onion and cook until translucent. Add the celery and the carrot and cook for a minute or two, stirring occasionally.\r\n" + 
				"Add the ground beef and season right away with 2 teaspoon of salt and ½ teaspoon of ground black pepper. Cook until the meat changes its red color.\r\n" + 
				"Add 350 ml (12 fl oz) of milk and a pinch of nutmeg. Simmer until it evaporates. Add 250 ml (8.5 oz) of dry white wine, and cook until it evaporates. Add the tomatoes and simmer over low heat for at least 3 hours, stirring from time to time. If the bolognese dries out, add ½ cup of water or stock.\r\n" + 
				"Pasta: While the bolognese is cooking, make the pasta dough. Sift 200 grams (7 oz) of flour into the mixing bowl. Add a pinch of salt and two eggs. Mix on low speed until smooth and elastic. Finish kneading the dough by hand, on a lightly floured surface. Gather into a ball, cover and let the dough relax for at least 40 minutes. You can also mix the dough by hand.\r\n" + 
				"Béchamel: To make white roux melt 60 grams (2 oz) of butter over low heat. Add 70 grams (2.5 oz) of flour, stir until smooth. Cook for two minutes, the roux should have a chalky color. Gradually add 750 ml (25 fl oz) of milk, whisking constantly. Add 1/2 teaspoon of salt and an onion pique. To make an onion pique, peel a whole onion, and use a clove to attach a bay leaf. Simmer, stirring frequently, until the sauce is smooth and thickened. Remove the onion pique and strain the béchamel.\r\n" + 
				"Roll the pasta 1 mm thick (1/20 inch) rectangles.\r\n" + 
				"Bring 4 Liters of water to boil and add 4 teaspoons of salt. Slip four sheets of pasta at a time. Cook for 5 seconds, remove from the boiling water and drop into cold water. Spread on a towel to pat dry.\r\n" + 
				"Assembling: Brush a 13×30 cm (5×12 inch) pan with melted butter and spread tablespoon of béchamel. Line with a single layer of pasta sheets, spread a thin layer of béchamel, spread a layer of bolognese sauce and sprinkle with grated Parmesan cheese. Repeat this process until there are eight layers of pasta.\r\n" + 
				"Spread a thin layer of béchamel sauce over the top layer, sprinkle with Parmesan and dot with 20 grams (2/3 oz) of butter. You will need a total of 80 grams (3 oz) of Parmesan cheese.\r\n" + 
				"Bake at a 200°C (400°F) oven for 15 minutes.\r\n" + 
				"Allow the lasagna to rest for a few minutes before serving. Serve directly from the pan or slice into individual portions.\r\n";
		ArrayList<Integer> recipeIngredientId= new ArrayList<Integer>();
		recipeIngredientId.add(1);
		recipeIngredientId.add(75);
		recipeIngredientId.add(101);
		recipeIngredientId.add(74);
		recipeIngredientId.add(102);
		recipeIngredientId.add(53);
		recipeIngredientId.add(23);
		recipeIngredientId.add(24);
		recipeIngredientId.add(103);
		recipeIngredientId.add(15);
		recipeIngredientId.add(44);
		recipeIngredientId.add(104);
		recipeIngredientId.add(105);
		recipeIngredientId.add(106);
		recipeIngredientId.add(107);
		recipeIngredientId.add(108);
		recipeIngredientId.add(109);
		ArrayList<Integer> recipeIngredientsType=new ArrayList<Integer>();
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(15);//item
		recipeIngredientsType.add(2);//teaspoon
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(11);//g
		recipeIngredientsType.add(13);//KL
		recipeIngredientsType.add(12);//ml
		recipeIngredientsType.add(1);//TS
		recipeIngredientsType.add(2);//0.5TS
		recipeIngredientsType.add(4);//0.125TS
		recipeIngredientsType.add(15);//item
		recipeIngredientsType.add(11);//item
		ArrayList<Double> recipeIngredientsAmount=new ArrayList<Double>();
		recipeIngredientsAmount.add(270.0);
		recipeIngredientsAmount.add(2.0);
		recipeIngredientsAmount.add(3.01);
		recipeIngredientsAmount.add(500.0);
		recipeIngredientsAmount.add(30.0);
		recipeIngredientsAmount.add(120.0);
		recipeIngredientsAmount.add(150.0);
		recipeIngredientsAmount.add(200.0);
		recipeIngredientsAmount.add(200.0);
		recipeIngredientsAmount.add(500.0);
		recipeIngredientsAmount.add(1.1);
		recipeIngredientsAmount.add(250.0);
		recipeIngredientsAmount.add(1.0);
		recipeIngredientsAmount.add(1.0);
		recipeIngredientsAmount.add(1.0);
		recipeIngredientsAmount.add(50.0);
		recipeIngredientsAmount.add(50.0);
		re= new Recipe(recipeId, recipeName, recipeAllergen, recipeTotalCalories, recipeTotalCarbohydrate, recipeTotalProtein, recipeTotalFat, recipeKashruth, recipeImage, recipeTimeToMake, recipeComplex,Daenerys.getPersonEmail() , recipeRate, recipeDescription, recipeProcses, recipeIngredientId,recipeIngredientsType ,recipeIngredientsAmount );
		re.Insert();
		re=Models.GetRecipeFromDB(99);
		re.setRecipeRate(9);
		re.Update();
		re1=Models.GetRecipeFromDB(99);
		assertEquals(9, (double)re1.getRecipeRate(),0);
		reupdateRecipe();
	}
	private	void reupdateRecipe() {
		re=Models.GetRecipeFromDB(99);
		re.Update();
		re.Delete();
		re=null;
	}

	@Test
	void updateUser() {
		us= Models.GetUserFromDB("\"drakarisValyrian.com\"");
		us.setUserKashruth(true);
		us.Update();
		us1=Models.GetUserFromDB("\"drakarisValyrian.com\"");
		assertEquals((Boolean)true, us1.getUserKashruth());
		reupdateUser();
	}

	private	void reupdateUser() {
		us1=Models.GetUserFromDB("\"drakarisValyrian.com\"");
		us.setUserKashruth(true);
		us.Update();}

	@Test
	void insertAndDeleteUser() {
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		us= new User("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, null, 99, al, true, false);
		us.Insert();
		us1=Models.GetUserFromDB("idontknowhatemailis");
		assertTrue(us1!=null);
		us1=null;
		us.Delete();
		ResultSet rs =Models.SelectSpecificFrom("Count( \"userId\" ) as counter","User", "userId", "99");
		try {
			assertTrue(rs.getInt("counter")==0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*void updateDietitian() {}
	private	void reupdateDietitian() {}
	void insertAndDeleteDietitian() {}*/


}