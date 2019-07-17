package model;

import java.util.ArrayList;
public class Recipe extends Entities{

	/*Attributes*/
	private Integer recipeId;
	private String  recipeName;
	private Double recipeTotalCalories;
	private Double recipeTotalCarbohydrate;
	private Double recipeTotalProtein;
	private Double recipeTotalFat;
	private Integer recipeKashruth;
	private Integer recipeTimeToMake;
	private Integer recipeComplex;
	private Integer recipeRate;
	private String recipeDescription;
	private String recipeProcess;
	private String recipePersonEmail;
	private ArrayList<Integer> recipeIngredientId;
	private ArrayList<Integer> recipeIngredientsType;
	private ArrayList<Double> recipeIngredientsAmount;
	private Integer recipeAllergen[];


	/*Contractor*/
	public Recipe( Integer recipeId,String  recipeName, Integer[] recipeAllergen,Double recipeTotalCalories,Double recipeTotalCarbohydrate,Double recipeTotalProtein,Double recipeTotalFat, Integer recipeKashruth, Integer recipeTimeToMake ,Integer recipeComplex,String recipePersonEmail,Integer recipeRate, String recipeDescription, String recipeProcess ,ArrayList<Integer> recipeIngredientId, ArrayList<Integer> recipeIngredientsType, ArrayList<Double> recipeIngredientsAmount)
	{ 
		this.setRecipeAllergen(recipeAllergen);
		this.setRecipeId(recipeId);
		this.setRecipeName(recipeName);
		this.setRecipeIngredientId(recipeIngredientId);
		this.setRecipeIngredientsType(recipeIngredientsType);
		this.setRecipeIngredientsAmount(recipeIngredientsAmount);
		this.setRecipeTotalCalories(recipeTotalCalories);
		this.setRecipeTotalCarbohydrate(recipeTotalCarbohydrate);
		this.setRecipeTotalProtein(recipeTotalProtein);
		this.setRecipeTotalFat(recipeTotalFat);
		this.setRecipeKashruth(recipeKashruth);
		this.setRecipeComplex(recipeComplex);
		this.setRecipeTimeToMake(recipeTimeToMake);
		this.setRecipePersonEmail(recipePersonEmail);
		this.setRecipeRate(recipeRate);
		this.setRecipeDescription(recipeDescription);
		this.setRecipeProcess(recipeProcess);	
	}
	@Override
	protected String Class() {
		return " Recipe";
	}
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public Integer[] getRecipeAllergen() {
		return recipeAllergen;
	}
	public void setRecipeAllergen(Integer[] recipeAllergen) {
		this.recipeAllergen= new Integer[recipeAllergen.length];
		for (int i=0;i<recipeAllergen.length;i++)
			this.recipeAllergen[i]=recipeAllergen[i];
	}
	public ArrayList<Integer> getRecipeIngredientId() {
		return recipeIngredientId;
	}
	public void setRecipeIngredientId(ArrayList<Integer> recipeIngredientId) {
		this.recipeIngredientId = new ArrayList<Integer>();
		if(recipeIngredientId!=null)
			recipeIngredientId.forEach(n -> this.recipeIngredientId.add(n));
	}
	public ArrayList<Integer> getRecipeIngredientsType() {
		return recipeIngredientsType;
	}
	public void setRecipeIngredientsType(ArrayList<Integer> recipeIngredientsType) {
		this.recipeIngredientsType = new ArrayList<Integer>();
		if(recipeIngredientsType!=null)
			recipeIngredientsType.forEach((n) -> this.recipeIngredientsType.add(n));
	}
	public ArrayList<Double> getRecipeIngredientsAmount() {
		return recipeIngredientsAmount;
	}
	public void setRecipeIngredientsAmount(ArrayList<Double> recipeIngredientsAmount) {
		this.recipeIngredientsAmount = new ArrayList<Double>();
		if(recipeIngredientsAmount!=null)
			recipeIngredientsAmount.forEach((n) -> this.recipeIngredientsAmount.add(n));
	}
	public Double getRecipeTotalCalories() {
		return recipeTotalCalories;
	}
	public void setRecipeTotalCalories(Double recipeTotalCalories) {
		this.recipeTotalCalories = recipeTotalCalories;
	}
	public Double getRecipeTotalCarbohydrate() {
		return recipeTotalCarbohydrate;
	}
	public void setRecipeTotalCarbohydrate(Double recipeTotalCarbohydrate) {
		this.recipeTotalCarbohydrate = recipeTotalCarbohydrate;
	}
	public Double getRecipeTotalProtein() {
		return recipeTotalProtein;
	}
	public void setRecipeTotalProtein(Double recipeTotalProtein) {
		this.recipeTotalProtein = recipeTotalProtein;
	}
	public Integer getRecipeKashruth() {
		return recipeKashruth;
	}
	public void setRecipeKashruth(Integer recipeKashruth) {
		this.recipeKashruth = recipeKashruth;
	}
	public Double getRecipeTotalFat() {
		return recipeTotalFat;
	}
	public void setRecipeTotalFat(Double recipeTotalFat) {
		this.recipeTotalFat = recipeTotalFat;
	}
	public Integer getRecipeTimeToMake() {
		return recipeTimeToMake;
	}
	public void setRecipeTimeToMake(Integer recipeTimeToMake) {
		this.recipeTimeToMake = recipeTimeToMake;
	}
	public Integer getRecipeComplex() {
		return recipeComplex;
	}
	public void setRecipeComplex(Integer recipeComplex) {
		this.recipeComplex = recipeComplex;
	}
	public String getRecipePersonEmail() {
		return recipePersonEmail;
	}
	public void setRecipePersonEmail(String recipePersonEmail) {
		this.recipePersonEmail = recipePersonEmail;
	}
	public Integer getRecipeRate() {
		return recipeRate;
	}
	public void setRecipeRate(Integer recipeRate) {
		this.recipeRate = recipeRate;
	}
	public String getRecipeDescription() {
		return recipeDescription;
	}
	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}
	public String getRecipeProcess() {
		return recipeProcess;
	}
	public void setRecipeProcess(String recipeProcess) {
		this.recipeProcess = recipeProcess;
	}
	@Override
	protected String getEntitieKey() {
		return "recipeId";
	}
	@Override
	protected String getEntitieKeyValue() {
		return getRecipeId().toString();
	}
	@Override
	protected String getEntitieAttributesNames() {
		return " recipeId , recipeName  , recipeTotalCalories, recipeTotalCarbohydrate, recipeTotalProtein , recipeTotalFat , recipeKashruth , recipeTimeToMake, recipeComplex , recipeRate , recipeDescription  , recipeProcess, PersonEmail ";
	}
	@Override
	protected String getEntitieAttributesValues() {
		return this.getRecipeId().toString() +" , \"" +
				this.getRecipeName() +"\" , " +
				this.getRecipeTotalCalories().toString() +" , " +
				this.getRecipeTotalCarbohydrate().toString() +" , " +
				this.getRecipeTotalProtein().toString() +" , " +
				this.getRecipeTotalFat().toString() +" , " +
				this.getRecipeKashruth().toString()+" , "+
				this.getRecipeTimeToMake() +" , " +
				this.getRecipeComplex().toString()+" , " +
				this.getRecipeRate().toString()+" , \"" +
				this.getRecipeDescription()+"\" , \"" +
				this.getRecipeProcess()+"\" , \"" +
				this.getRecipePersonEmail()+"\" ";
	}
	@Override
	protected String getEntitieAttributesNamesValues() {
		return  " recipeName = \""+	this.getRecipeName() +"\" , " +
				" recipeTotalCalories = "+	this.getRecipeTotalCalories().toString() +" , " +
				" recipeTotalCarbohydrate = "+	this.getRecipeTotalCarbohydrate().toString() +" , " +
				" recipeTotalProtein = "+	this.getRecipeTotalProtein().toString() +" , " +
				" recipeTotalFat = "+	this.getRecipeTotalFat().toString() +" , " +
				" recipeKashruth = "+	this.getRecipeKashruth().toString() +" , " +
				" recipeTimeToMake = "+	this.getRecipeTimeToMake() +" , " +
				" recipeComplex = "+	this.getRecipeComplex().toString() +" , " +
				" recipeRate = "+	this.getRecipeRate().toString() +" , " +
				" recipeDescription = \""+	this.getRecipeDescription() +"\" , " +
				" recipeProcess = \""+	this.getRecipeProcess()+"\" , " +
				" PersonEmail = \""+	this.getRecipePersonEmail() +"\" ";
	}

	@Override
	protected int getmaxSubtbleCount(){return this.recipeIngredientId.size();}
	@Override
	protected String getAllergenInsert(int place){return this.recipeAllergen[place].toString();}
	@Override
	protected String getSubtbleInsert(int place){return " "+this.recipeIngredientId.get(place).toString()+" , "+this.recipeIngredientsAmount.get(place).toString()+" , "+this.recipeIngredientsType.get(place)+" ";}

	//"INSERT INTO <CLASS NAME> (<ATTRIBUTES>) VALUES (<VALUES>)"
	@Override
	protected Integer[] getAllergenArray() {
		return this.getRecipeAllergen();
	}
	@Override
	protected ArrayList<Integer> getSubtbleArray() {
		return this.getRecipeIngredientId();
	}
	@Override
	protected String getSubtbleDelete(int place) {
		// TODO Auto-generated method stub
		return this.recipeIngredientId.get(place).toString();
	}
	@Override
	protected String getPersonAttributesNamesValues() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getPersonAttributesValues() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getPersonAttributesNames() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getPersonKeyValue() {
		// TODO Auto-generated method stub
		return null;
	}
}

