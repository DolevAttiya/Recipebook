package rep;

import javax.swing.ImageIcon;

public class Ingridiant {
	
	/*Attributes*/
 private int ingridiantId;
 private String  ingridiantName;
 private Allergen ingridiantalergie[];
 private int ingridiantalergieCalories;
 private int ingridiantCarbohydrate;
 private int ingridiantProtein;
 private int ingridiantFat;
 private int ingridiantKashruth;
 private ImageIcon ingridiantImage;
 
 /*Contractor*/
 public Ingridiant(int num) {}// do later getting from DB all the artibutes 
public Ingridiant( int ingridiantId,String  ingridiantName,Allergen ingridiantalergie[],int ingridiantalergieCalories,int ingridiantCarbohydrate,int ingridiantProtein,int ingridiantFat, int ingridiantKashruth, ImageIcon ingridiantImage)
{
	this.ingridiantId=ingridiantId;
	this.ingridiantName=ingridiantName;
	this.ingridiantalergie=new Allergen[ingridiantalergie.length];
	for (int i=0;i<ingridiantalergie.length;i++)
		this.ingridiantalergie[i]=ingridiantalergie[i];
	this.ingridiantalergieCalories=ingridiantalergieCalories;
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
public int getIngridiantalergieCalories() {
	return ingridiantalergieCalories;
}
public void setIngridiantalergieCalories(int ingridiantalergieCalories) {
	this.ingridiantalergieCalories = ingridiantalergieCalories;
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
public Allergen[] getIngridiantalergies() {
	return ingridiantalergie;
}
public int getIngridiantalergies(int i) {
	return ingridiantalergie[i].getAllergieId();
}
public void setIngridiantalergies(Allergen ingridiantalergie[]) {
	this.ingridiantalergie = ingridiantalergie;
}
 
}
