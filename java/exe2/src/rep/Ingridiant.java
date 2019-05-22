package rep;

import javax.swing.ImageIcon;

public class Ingridiant {
	
	/*Attributes*/
 private int ingridiantId;
 private String  ingridiantName;
 private Allergen ingridiantAllergen[];
 private int ingridiantCalories;
 private int ingridiantCarbohydrate;
 private int ingridiantProtein;
 private int ingridiantFat;
 private int ingridiantKashruth;
 private ImageIcon ingridiantImage;
 
 /*Contractor*/
 public Ingridiant(int num) {}// do later getting from DB all the attributes 
public Ingridiant( int ingridiantId,String  ingridiantName,Allergen ingridiantAllergen[],int ingridiantCalories,int ingridiantCarbohydrate,int ingridiantProtein,int ingridiantFat, int ingridiantKashruth, ImageIcon ingridiantImage)
{
	this.ingridiantId=ingridiantId;
	this.ingridiantName=ingridiantName;
	this.ingridiantAllergen=new Allergen[ingridiantAllergen.length];
	for (int i=0;i<ingridiantAllergen.length;i++)
		this.ingridiantAllergen[i]=ingridiantAllergen[i];
	this.ingridiantCalories=ingridiantCalories;
	this.ingridiantCarbohydrate=ingridiantCarbohydrate;
	this.ingridiantProtein=ingridiantProtein;
	this.ingridiantFat=ingridiantFat;
	this.ingridiantKashruth=ingridiantKashruth;
	this.ingridiantImage=ingridiantImage;
}
public int getIngridiantId() {
	return ingridiantId;
}
public void setIngridiantId(int ingridiantId) {
	this.ingridiantId = ingridiantId;
}
public String getIngridiantName() {
	return ingridiantName;
}
public void setIngridiantName(String ingridiantName) {
	this.ingridiantName = ingridiantName;
}
public int getIngridiantCalories() {
	return ingridiantCalories;
}
public void setIngridiantCalories(int ingridiantCalories) {
	this.ingridiantCalories = ingridiantCalories;
}
public int getIngridiantCarbohydrate() {
	return ingridiantCarbohydrate;
}
public void setIngridiantCarbohydrate(int ingridiantCarbohydrate) {
	this.ingridiantCarbohydrate = ingridiantCarbohydrate;
}
public int getIngridiantProtein() {
	return ingridiantProtein;
}
public void setIngridiantProtein(int ingridiantProtein) {
	this.ingridiantProtein = ingridiantProtein;
}
public int getIngridiantKashruth() {
	return ingridiantKashruth;
}
public void setIngridiantKashruth(int ingridiantKashruth) {
	this.ingridiantKashruth = ingridiantKashruth;
}
public int getIngridiantFat() {
	return ingridiantFat;
}
public void setIngridiantFat(int ingridiantFat) {
	this.ingridiantFat = ingridiantFat;
}
public ImageIcon getIngridiantImage() {
	return ingridiantImage;
}
public void setIngridiantImage(ImageIcon ingridiantImage) {
	this.ingridiantImage = ingridiantImage;
}
public Allergen[] getIngridiAntallergen() {
	return ingridiantAllergen;
}
public int getIngridiantAllergen(int i) {
	return ingridiantAllergen[i].getAllergenId();
}
public void setIngridiantAllergen(Allergen ingridiantAllergen[]) {
	this.ingridiantAllergen = ingridiantAllergen;
}
 
}
