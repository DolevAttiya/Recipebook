package rep;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;


public class Recipe {
 private int recipeId;
 private String  recipeName;
 private int recipeallergies[];
 private ArrayList<Ingridiant> recipeIngridiants;
 private ArrayList<Integer> recipeIngridiantsType;
 private ArrayList<Integer> recipeIngridiantsAmount;
 private int recipeCalories;
 private int recipeCarbohydrate;
 private int recipeProtein;
 private int recipeFat;
 private int recipeKosher;
 private ImageIcon recipeImage;
 private TimeUnit recipeTimeToMake;
 private int recipeComplex;
 private int recipeUserID;
 private int recipeStars;
 private String recipeDescription;
 private String recipeProcses;
 /*Contractor*/
public Recipe( int recipeId,String  recipeName, int[] recipeallergies,int recipeCalories,int recipeCarbohydrate,int recipeProtein,int recipeFat, int recipeKosher, ImageIcon recipeImage, TimeUnit recipeTimeToMakeprivate ,int recipeComplex,int recipeUserID,int recipeStars, String recipeDescription, String recipeProcses ,ArrayList<Ingridiant> recipeIngridiants, ArrayList<Integer> recipeIngridiantsType, ArrayList<Integer> recipeIngridiantsAmount)
{
	this.setRecipeallergies(recipeallergies);
	this.setRecipeId(recipeId);
	this.setRecipeName(recipeName);
	this.setRecipeIngridiants(recipeIngridiants);
	this.setRecipeIngridiantsType(recipeIngridiantsType);
	this.setRecipeIngridiantsAmount(recipeIngridiantsAmount);
	this.setRecipeCalories(recipeCalories);
	this.setRecipeCarbohydrate(recipeCarbohydrate);
	this.setRecipeProtein(recipeProtein);
	this.setRecipeFat(recipeFat);
	this.setRecipeKosher(recipeKosher);
	this.setRecipeComplex(recipeComplex);
	this.setRecipeUserID(recipeUserID);
	this.setRecipeStars(recipeStars);
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
public int[] getRecipeallergies() {
	return recipeallergies;
}
public void setRecipeallergies(int[] recipeallergies) {
	this.recipeallergies= new int[Allergies.getMaxAllergies()];
	for (int i=0;i<Allergies.getMaxAllergies();i++)
		this.recipeallergies[i]=recipeallergies[i];
}
public ArrayList<Ingridiant> getRecipeIngridiants() {
	return recipeIngridiants;
}
public void setRecipeIngridiants(ArrayList<Ingridiant> recipeIngridiants) {
	recipeIngridiants.forEach((n) -> this.recipeIngridiants.add(n));
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
	return recipeCalories;
}
public void setRecipeCalories(int recipeCalories) {
	this.recipeCalories = recipeCalories;
}
public int getRecipeCarbohydrate() {
	return recipeCarbohydrate;
}
public void setRecipeCarbohydrate(int recipeCarbohydrate) {
	this.recipeCarbohydrate = recipeCarbohydrate;
}
public int getRecipeProtein() {
	return recipeProtein;
}
public void setRecipeProtein(int recipeProtein) {
	this.recipeProtein = recipeProtein;
}
public int getRecipeKosher() {
	return recipeKosher;
}
public void setRecipeKosher(int recipeKosher) {
	this.recipeKosher = recipeKosher;
}
public int getRecipeFat() {
	return recipeFat;
}
public void setRecipeFat(int recipeFat) {
	this.recipeFat = recipeFat;
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
public int getRecipeUserID() {
	return recipeUserID;
}
public void setRecipeUserID(int recipeUserID) {
	this.recipeUserID = recipeUserID;
}
public int getRecipeStars() {
	return recipeStars;
}
public void setRecipeStars(int recipeStars) {
	this.recipeStars = recipeStars;
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
	 this.recipeIngridiants.add(newIngridiant); 
	 this.recipeIngridiantsType.add(ingridiantType.getIngridiantTypeId());
	 this.recipeIngridiantsAmount.add(IngridiantAmount);
	 this.recipeCalories+=(newIngridiant.getIngridiantalergieCalories()*IngridiantAmount*ingridiantType.getIngridiantTypeValue());
	 this.recipeCarbohydrate+=newIngridiant.getIngridiantCarbohydrate()*IngridiantAmount*ingridiantType.getIngridiantTypeValue();
	 this.recipeFat+=newIngridiant.getIngridiantFat()*IngridiantAmount*ingridiantType.getIngridiantTypeValue();
	 //*protein*//
	 {
		 if(newIngridiant.getIngridiantKosher()!=0) //*Kosher check*//
			 	if(this.getRecipeKosher()!=3)
			 			if(this.getRecipeKosher()==0) {this.setRecipeKosher(newIngridiant.getIngridiantKosher());}
			 			else if (this.getRecipeKosher()!=newIngridiant.getIngridiantKosher())
			 				this.setRecipeKosher(3);
	 }
	 for( int i=0;i<Allergies.getMaxAllergies();i++)
	 {
		 if(newIngridiant.getIngridiantalergies(i)>0)
			 this.recipeallergies[i]=1;//***//
	 }	 
}
}
