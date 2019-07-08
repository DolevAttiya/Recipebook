package model;

import java.util.ArrayList;

public class Allergen extends  Entities{
	
	/*Attributes*/
	private static int maxAllergen=0;
	private Integer allergenId;
	private String  allergenName;
	
	 /*Contractor*/
	public Allergen(Integer allergenId,String  allergenName)
	{
		this.setAllergenId(allergenId);
		this.setAllergenName(allergenName);
	}
	@Override
	protected String Class() {
		return "Allergen";
	}
	public Integer getAllergenId() {
		return this.allergenId; 
	}
	public String getAllergenName() {
		return this.allergenName; 
	}
	 void setAllergenName(String allergenName ) {
		 this.allergenName=allergenName; 
	}
	 void setAllergenId(Integer AllergenId ) {
		 this.allergenId=AllergenId; 
	}
	public static int getMaxAllergen() {
		return maxAllergen;
	}
	private static void setMaxAllergen(int maxAllergen) {
		Allergen.maxAllergen = maxAllergen;
	}
	
	@Override
	protected String getEntitieKey() {
		return "allergenId";
	}
	@Override
	protected String getEntitieKeyValue() {
		return this.getAllergenId().toString();
	}
	@Override
	protected String getEntitieAttributesNames() {		
		return "allergenId, allergenName";
	}
	@Override
	
	protected String getEntitieAttributesValues() {
		return " "+this.getAllergenId().toString()+", "+this.getAllergenName();
	}
	@Override
	protected String getEntitieAttributesNamesValues() {
		return "allergenId= "+this.getAllergenId().toString()+", allergenName"+this.getAllergenName();
	}
	@Override
	protected String getAllergenInsert(int place) {
		return null;
	}
	@Override
	protected String getIngredientInsert(int place) {
		return null;
	}
	@Override
	protected Integer[] getAllergenArray() {		
		return null;
	}
	@Override
	protected ArrayList<Integer> getIngredientArray() {
		return null;
	}
	@Override
	protected int getmaxIngredieantCount() {
		return 0;
	}
     
}