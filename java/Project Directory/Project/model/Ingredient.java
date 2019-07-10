package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ingredient extends Entities {

	/*Attributes*/
	private Integer ingredientId;
	private String  ingredientName;
	private Integer ingredientAllergen[];
	private Double ingredientCalories;
	private Double ingredientCarbohydrate;
	private Double ingredientProtein;
	private Double ingredientFat;
	private Integer ingredientKashruth;
	private BufferedImage ingredientImage;

	/*Contractors*/

	public Ingredient( Integer ingredientId,String  ingredientName,Integer ingredientAllergen[],Double ingredientCalories,Double ingredientCarbohydrate,Double ingredientProtein,Double ingredientFat, Integer ingredientKashruth, BufferedImage ingredientImage)
	{
		this.setIngredientId(ingredientId);
		this.setIngredientName(ingredientName);
		this.setIngredientAllergen(ingredientAllergen);
		this.setIngredientCalories(ingredientCalories);
		this.setIngredientCarbohydrate(ingredientCarbohydrate);
		this.setIngredientProtein(ingredientProtein);
		this.setIngredientFat(ingredientFat);
		this.setIngredientKashruth(ingredientKashruth);
		this.setIngredientImage(ingredientImage);
	}
	public Integer getIngredientId() {
		return ingredientId.intValue();
	}
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public Double getIngredientCalories() {
		return ingredientCalories;
	}
	public void setIngredientCalories(Double ingredientCalories) {
		this.ingredientCalories = ingredientCalories;
	}
	public Double getIngredientCarbohydrate() {
		return ingredientCarbohydrate;
	}
	public void setIngredientCarbohydrate(Double ingredientCarbohydrate) {
		this.ingredientCarbohydrate = ingredientCarbohydrate;
	}
	public Double getIngredientProtein() {
		return ingredientProtein;
	}
	public void setIngredientProtein(Double ingredientProtein) {
		this.ingredientProtein = ingredientProtein;
	}
	public Integer getIngredientKashruth() {
		return ingredientKashruth;
	}
	public void setIngredientKashruth(Integer ingredientKashruth) {
		this.ingredientKashruth = ingredientKashruth;
	}
	public Double getIngredientFat() {
		return ingredientFat;
	}
	public void setIngredientFat(Double ingredientFat) {
		this.ingredientFat = ingredientFat;
	}
	public BufferedImage getIngredientImage() {
		return ingredientImage;
	}
	public void setIngredientImage(BufferedImage ingredientImage) {
		this.ingredientImage = ingredientImage;
	}
	public Integer[] getIngredientAllergen() {
		return ingredientAllergen;
	}
	public Integer getIngredientAllergen(int i) {
		return ingredientAllergen[i];
	}
	public void setIngredientAllergen(Integer ingredientAllergen[]) {
		this.ingredientAllergen= new Integer[ingredientAllergen.length];
		for (int i=0;i<ingredientAllergen.length;i++)
			this.ingredientAllergen[i]=ingredientAllergen[i];
	}
	@Override
	protected String getEntitieKey() {
		return "ingredientId";
	}
	@Override
	protected String getEntitieKeyValue() {
		return getIngredientId().toString();
	}
	@Override
	protected String Class() {return " Ingredient";}
	@Override
	protected String getEntitieAttributesNames() {
		return " ingredientId , ingredientName , ingredientCalories , ingredientCarbohydrate , ingredientProtein , ingredientFat , ingredientKashruth , ingredientImage ";
	}
	@Override
	protected String getEntitieAttributesValues() {
		return this.getIngredientId().toString() +" , " +
				this.getIngredientName() +" , " +
				this.getIngredientCalories().toString() +" , " +
				this.getIngredientCarbohydrate().toString() +" , " +
				this.getIngredientProtein().toString() +" , " +
				this.getIngredientFat().toString() +" , " +
				this.getIngredientKashruth().toString() +" , " +
				this.getIngredientImage()+" ";
	}
	@Override
	protected String getEntitieAttributesNamesValues() {
		return  " ingredientId = "+this.getIngredientId().toString() +" , " +
				" ingredientName = \""+	this.getIngredientName() +"\" , " +
				" ingredientCalories = "+	this.getIngredientCalories().toString() +" , " +
				" ingredientCarbohydrate = "+	this.getIngredientCarbohydrate().toString() +" , " +
				" ingredientProtein = "+	this.getIngredientProtein().toString() +" , " +
				" ingredientFat = "+	this.getIngredientKashruth().toString() +" , " +
				" ingredientKashruth = "+	this.getIngredientKashruth().toString() +" , " +
				" ingredientImage = "+	this.getIngredientImage()+" ";
	}
	/*@Override
public void getPsmtmt(PreparedStatement pstmt) {
	try {

		pstmt.setInt(1, (int)this.getIngredientId());
		pstmt.setString(2, this.getIngredientName());
		pstmt.setInt(3, this.getIngredientCalories());
		pstmt.setInt(4, this.getIngredientCarbohydrate());
		pstmt.setInt(5, this.getIngredientProtein());
		pstmt.setInt(6, this.getIngredientFat());
		pstmt.setInt(7, this.getIngredientKashruth());
		pstmt.setBlob(8, this.getIngredientImage());
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	 */
	@Override
	protected String getAllergenInsert(int place) {
		return this.ingredientAllergen[place].toString();
	}
	@Override
	protected String getIngredientInsert(int place) {
		return null;
	}
	@Override
	protected Integer[] getAllergenArray() {
		return this.getIngredientAllergen();
	}
	@Override
	protected ArrayList<Integer> getIngredientArray() {
		return null;
	}
	@Override
	protected int getmaxIngredieantCount() {
		return 0;
	}
	@Override
	protected String getIngredientDelete(int place) {
		// TODO Auto-generated method stub
		return null;
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
