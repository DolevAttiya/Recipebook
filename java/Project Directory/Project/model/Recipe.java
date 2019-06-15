package model;
import java.sql.Blob;
import java.sql.Time;
import java.util.ArrayList;
public class Recipe extends Entities{

	/*Attributes*/
	private Integer recipeId;
	private String  recipeName;
	private Blob recipeImage;
	private Double recipeTotalCalories;
	private Double recipeTotalCarbohydrate;
	private Double recipeTotalProtein;
	private Double recipeTotalFat;
	private Integer recipeKashruth;
	private Time recipeTimeToMake;
	private Integer recipeComplex;
	private Integer recipeRate;
	private String recipeDescription;
	private String recipeProcses;
	private String recipePersonEmail;
	private ArrayList<Integer> recipeIngredientId;
	private ArrayList<Integer> recipeIngredientsType;
	private ArrayList<Double> recipeIngredientsAmount;
	private Integer recipeAllergen[];


	/*Contractor*/
	public Recipe( Integer recipeId,String  recipeName, Integer[] recipeAllergen,Double recipeTotalCalories,Double recipeTotalCarbohydrate,Double recipeTotalProtein,Double recipeTotalFat, Integer recipeKashruth, Blob recipeImage, Time recipeTimeToMake ,Integer recipeComplex,String recipePersonEmail,Integer recipeRate, String recipeDescription, String recipeProcses ,ArrayList<Integer> recipeIngredientId, ArrayList<Integer> recipeIngredientsType, ArrayList<Double> recipeIngredientsAmount)
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
		this.setRecipeProcses(recipeProcses);	
		this.setRecipeImage(recipeImage);
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
		this.recipeAllergen= new Integer[Allergen.getMaxAllergen()];
		for (int i=0;i<Allergen.getMaxAllergen();i++)
			this.recipeAllergen[i]=recipeAllergen[i];
	}
	public ArrayList<Integer> getRecipeIngredientId() {
		return recipeIngredientId;
	}
	public void setRecipeIngredientId(ArrayList<Integer> recipeIngredientId) {
		recipeIngredientId.forEach((n) -> this.recipeIngredientId.add(n));
	}
	public ArrayList<Integer> getRecipeIngredientsType() {
		return recipeIngredientsType;
	}
	public void setRecipeIngredientsType(ArrayList<Integer> recipeIngredientsType) {
		recipeIngredientsType.forEach((n) -> this.recipeIngredientsType.add(n));
	}
	public ArrayList<Double> getRecipeIngredientsAmount() {
		return recipeIngredientsAmount;
	}
	public void setRecipeIngredientsAmount(ArrayList<Double> recipeIngredientsAmount) {
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
	public Blob getRecipeImage() {
		return recipeImage;
	}
	public void setRecipeImage(Blob recipeImage) {
		this.recipeImage = recipeImage;
	}
	public Time getRecipeTimeToMake() {
		return recipeTimeToMake;
	}
	public void setRecipeTimeToMake(Time recipeTimeToMake) {
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
	public String getRecipeProcses() {
		return recipeProcses;
	}
	public void setRecipeProcses(String recipeProcses) {
		this.recipeProcses = recipeProcses;
	}
	public void addIngredient(Integer IngredientId,IngredientType ingredientType, Double IngredientAmount)/*Kosher levels: 0 parve, 1 milk,2 meat, 3 pig*/
	{
		Ingredient newIngredient=Models.GetIngredientFromDB(IngredientId);//***//
		this.recipeIngredientId.add(newIngredient.getIngredientId()); 
		this.recipeIngredientsType.add(ingredientType.getIngredientTypeId());
		this.recipeIngredientsAmount.add(IngredientAmount);
		this.recipeTotalCalories+=(newIngredient.getIngredientCalories()*IngredientAmount*ingredientType.getIngredientTypeValue());
		this.recipeTotalCarbohydrate+=newIngredient.getIngredientCarbohydrate()*IngredientAmount*ingredientType.getIngredientTypeValue();
		this.recipeTotalFat+=newIngredient.getIngredientFat()*IngredientAmount*ingredientType.getIngredientTypeValue();
		//*protein*//
		{
			if(newIngredient.getIngredientKashruth()!=0) //*Kosher check*//
				if(this.getRecipeKashruth()!=3)
					if(this.getRecipeKashruth()==0) {this.setRecipeKashruth(newIngredient.getIngredientKashruth());}
					else if (this.getRecipeKashruth()!=newIngredient.getIngredientKashruth())
						this.setRecipeKashruth(3);
		}
		for( int i=0;i<Allergen.getMaxAllergen();i++)
		{
			if(newIngredient.getIngredientAllergen(i)>0)
				this.recipeAllergen[i]++;//***//
		}	 
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
		return " recipeId , recipeName , recipeImage , recipeTotalCalories, recipeTotalCarbohydrate, recipeTotalProtein , recipeTotalFat , recipeKashruth , recipeTimeToMake, recipeComplex , recipeRate , recipeDescription  , recipeProcses, recipePersonEmail ";
	}
	@Override
	protected String getEntitieAttributesValues() {
		return this.getRecipeId().toString() +" , " +
				this.getRecipeName() +" , " +
				this.getRecipeImage()+" , " +
				this.getRecipeTotalCalories().toString() +" , " +
				this.getRecipeTotalCarbohydrate().toString() +" , " +
				this.getRecipeTotalProtein().toString() +" , " +
				this.getRecipeTotalFat().toString() +" , " +
				this.getRecipeKashruth().toString()+" , " +
				this.getRecipeTimeToMake().toString()+" , " +
				this.getRecipeComplex().toString()+" , " +
				this.getRecipeRate().toString()+" , " +
				this.getRecipeDescription()+" , " +
				this.getRecipeProcses()+" , " +
				this.getRecipePersonEmail();
	}
	@Override
	protected String getEntitieAttributesNamesValues() {
		return  " recipeId = "+this.getRecipeId().toString() +" , " +
				", recipeName = "+	this.getRecipeName() +" , " +
				", recipeImage = "+	this.getRecipeImage().toString() +" , " +
				", recipeTotalCalories = "+	this.getRecipeTotalCalories().toString() +" , " +
				", recipeTotalCarbohydrate = "+	this.getRecipeTotalCarbohydrate().toString() +" , " +
				", recipeTotalProtein = "+	this.getRecipeTotalProtein().toString() +" , " +
				", recipeTotalFat = "+	this.getRecipeTotalFat().toString() +" , " +
				", recipeKashruth = "+	this.getRecipeKashruth().toString() +" , " +
				", recipeTimeToMake = "+	this.getRecipeTimeToMake().toString() +" , " +
				", recipeComplex = "+	this.getRecipeComplex().toString() +" , " +
				", recipeRate = "+	this.getRecipeRate().toString() +" , " +
				", recipeDescription = "+	this.getRecipeDescription() +" , " +
				", recipeProcses = "+	this.getRecipeProcses()+" , " +
				", recipePersonEmail = "+	this.getRecipePersonEmail() +" ";
	}

	@Override
	protected int getmaxIngredieantCount(){return this.recipeIngredientId.size();}
	@Override
	protected String getAllergenInsert(int place){return this.recipeAllergen[place].toString();}
	@Override
	protected String getIngredientInsert(int place){return this.recipeIngredientId.get(place).toString();}

	//"INSERT INTO <CLASS NAME> (<ATTRIBUTES>) VALUES (<VALUES>)"
	@Override
	protected Integer[] getAllergenArray() {
		return this.getRecipeAllergen();
	}
	@Override
	protected ArrayList<Integer> getIngredientArray() {
		return this.getRecipeIngredientId();
	}
}

