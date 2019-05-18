package rep;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;


public class Recipe {
	
	/*Attributes*/
 private int recipeId;
 private String  recipeName;
 private ImageIcon recipeImage;
 private int recipeTotalCalories;
 private int recipeTotalCarbohydrate;
 private int recipeTotalProtein;
 private int recipeTotalFat;
 private int recipeKashruth;
 private TimeUnit recipeTimeToMake;
 private int recipeComplex;
 private int recipeRate;
 private String recipeDescription;
 private String recipeProcses;
 private String recipePersonEmail;
 private ArrayList<Ingridiant> recipeIngridiantId;
 private ArrayList<Integer> recipeIngridiantsType;
 private ArrayList<Integer> recipeIngridiantsAmount;
 private int recipeAllergen[];
 
 
 /*Contractor*/
public Recipe( int recipeId,String  recipeName, int[] recipeAllergen,int recipeTotalCalories,int recipeTotalCarbohydrate,int recipeTotalProtein,int recipeTotalFat, int recipeKashruth, ImageIcon recipeImage, TimeUnit recipeTimeToMakeprivate ,int recipeComplex,String recipePersonEmail,int recipeRate, String recipeDescription, String recipeProcses ,ArrayList<Ingridiant> recipeIngridiantId, ArrayList<Integer> recipeIngridiantsType, ArrayList<Integer> recipeIngridiantsAmount)
{
	this.setRecipeAllergen(recipeAllergen);
	this.setRecipeId(recipeId);
	this.setRecipeName(recipeName);
	this.setRecipeIngridiantId(recipeIngridiantId);
	this.setRecipeIngridiantsType(recipeIngridiantsType);
	this.setRecipeIngridiantsAmount(recipeIngridiantsAmount);
	this.setRecipeCalories(recipeTotalCalories);
	this.setRecipeTotalCarbohydrate(recipeTotalCarbohydrate);
	this.setRecipeTotalProtein(recipeTotalProtein);
	this.setRecipeTotalFat(recipeTotalFat);
	this.setRecipeKashruth(recipeKashruth);
	this.setRecipeComplex(recipeComplex);
	this.setRecipePersonEmail(recipePersonEmail);
	this.setRecipeRate(recipeRate);
	this.setRecipeDescription(recipeDescription);
	this.setRecipeProcses(recipeProcses);	
	this.setRecipeImage(recipeImage);
}
public int getRecipeId() {
	return recipeId;
}
public void setRecipeId(int recipeId) {
	this.recipeId = recipeId;
}
public String getRecipeName() {
	return recipeName;
}
public void setRecipeName(String recipeName) {
	this.recipeName = recipeName;
}
public int[] getRecipeAllergen() {
	return recipeAllergen;
}
public void setRecipeAllergen(int[] recipeAllergen) {
	this.recipeAllergen= new int[Allergen.getMaxAllergies()];
	for (int i=0;i<Allergen.getMaxAllergies();i++)
		this.recipeAllergen[i]=recipeAllergen[i];
}
public ArrayList<Ingridiant> getRecipeIngridiantId() {
	return recipeIngridiantId;
}
public void setRecipeIngridiantId(ArrayList<Ingridiant> recipeIngridiantId) {
	recipeIngridiantId.forEach((n) -> this.recipeIngridiantId.add(n));
}
public ArrayList<Integer> getRecipeIngridiantsType() {
	return recipeIngridiantsType;
}
public void setRecipeIngridiantsType(ArrayList<Integer> recipeIngridiantsType) {
	recipeIngridiantsType.forEach((n) -> this.recipeIngridiantsType.add(n));
}
public ArrayList<Integer> getRecipeIngridiantsAmount() {
	return recipeIngridiantsAmount;
}
public void setRecipeIngridiantsAmount(ArrayList<Integer> recipeIngridiantsAmount) {
	recipeIngridiantsAmount.forEach((n) -> this.recipeIngridiantsAmount.add(n));
}
public int getRecipeCalories() {
	return recipeTotalCalories;
}
public void setRecipeCalories(int recipeTotalCalories) {
	this.recipeTotalCalories = recipeTotalCalories;
}
public int getRecipeTotalCarbohydrate() {
	return recipeTotalCarbohydrate;
}
public void setRecipeTotalCarbohydrate(int recipeTotalCarbohydrate) {
	this.recipeTotalCarbohydrate = recipeTotalCarbohydrate;
}
public int getRecipeTotalProtein() {
	return recipeTotalProtein;
}
public void setRecipeTotalProtein(int recipeTotalProtein) {
	this.recipeTotalProtein = recipeTotalProtein;
}
public int getRecipeKashruth() {
	return recipeKashruth;
}
public void setRecipeKashruth(int recipeKashruth) {
	this.recipeKashruth = recipeKashruth;
}
public int getRecipeTotalFat() {
	return recipeTotalFat;
}
public void setRecipeTotalFat(int recipeTotalFat) {
	this.recipeTotalFat = recipeTotalFat;
}
public ImageIcon getRecipeImage() {
	return recipeImage;
}
public void setRecipeImage(ImageIcon recipeImage) {
	this.recipeImage = recipeImage;
}
public TimeUnit getRecipeTimeToMake() {
	return recipeTimeToMake;
}
public void setRecipeTimeToMake(TimeUnit recipeTimeToMake) {
	this.recipeTimeToMake = recipeTimeToMake;
}
public int getRecipeComplex() {
	return recipeComplex;
}
public void setRecipeComplex(int recipeComplex) {
	this.recipeComplex = recipeComplex;
}
public String getRecipePersonEmail() {
	return recipePersonEmail;
}
public void setRecipePersonEmail(String recipePersonEmail) {
	this.recipePersonEmail = recipePersonEmail;
}
public int getRecipeRate() {
	return recipeRate;
}
public void setRecipeRate(int recipeRate) {
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
public void addIngridiant(int IngridiantId,IngridiantType ingridiantType, int IngridiantAmount)/*Kosher levels: 0 parve, 1 milk,2 meat, 3 pig*/
{
	Ingridiant newIngridiant= new Ingridiant(IngridiantId);//***//
	 this.recipeIngridiantId.add(newIngridiant); 
	 this.recipeIngridiantsType.add(ingridiantType.getIngridiantTypeId());
	 this.recipeIngridiantsAmount.add(IngridiantAmount);
	 this.recipeTotalCalories+=(newIngridiant.getIngridiantalergieCalories()*IngridiantAmount*ingridiantType.getIngridiantTypeValue());
	 this.recipeTotalCarbohydrate+=newIngridiant.getIngridiantCarbohydrate()*IngridiantAmount*ingridiantType.getIngridiantTypeValue();
	 this.recipeTotalFat+=newIngridiant.getIngridiantFat()*IngridiantAmount*ingridiantType.getIngridiantTypeValue();
	 //*protein*//
	 {
		 if(newIngridiant.getIngridiantKashruth()!=0) //*Kosher check*//
			 	if(this.getRecipeKashruth()!=3)
			 			if(this.getRecipeKashruth()==0) {this.setRecipeKashruth(newIngridiant.getIngridiantKashruth());}
			 			else if (this.getRecipeKashruth()!=newIngridiant.getIngridiantKashruth())
			 				this.setRecipeKashruth(3);
	 }
	 for( int i=0;i<Allergen.getMaxAllergies();i++)
	 {
		 if(newIngridiant.getIngridiantalergies(i)>0)
			 this.recipeAllergen[i]++;//***//
	 }	 
}
}
