package model;

import java.sql.Blob;
//import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

public class User extends Person {

	private Integer userId;
	private Integer userAllergen[];
	public User(String personEmail, String personFirstName, String personLastName, Date personDateOfBirth,
			String personHashPass, ArrayList<Integer> personsFavoriteRecipe, Blob personImage,Integer userId, Integer userAllergen[]) {
		super(personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass, personsFavoriteRecipe,
				personImage);
		this.setUserId(userId);
		this.setUserAllergen(userAllergen);
	}

	@Override
	protected String Class() {
		return " User";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer[] getUserAllergen() {
		return userAllergen;
	}
	public void setUserAllergen(Integer[] userAllergen) {
		for (int i=0;i<Allergen.getMaxAllergen();i++)
			this.userAllergen[i]=userAllergen[i];
	}
	@Override
	protected String getEntitieKey() {	
		return " userId ";
	}
	@Override
	protected String getEntitieKeyValue() {
		return this.getUserId().toString();
	}
	@Override
	protected String getEntitieAttributesNames() {
		return getEntitieKey();
	}
	@Override
	protected String getEntitieAttributesValues() {
		return this.getUserId().toString();
	}
	@Override
	protected String getEntitieAttributesNamesValues() {
		return " "+getEntitieKey()+" = "+this.getUserId().toString()+" ";
	}
	/*@Override
public void getPsmtmt(PreparedStatement pstmt) {
	 try {

			pstmt.setInt(1, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
}*/
	@Override
	protected String getAllergenInsert(int place) {
		// TODO Auto-generated method stub
		return  this.userAllergen[place].toString();
	}
	@Override
	protected String getIngredientInsert(int place) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected Integer[] getAllergenArray() {
		// TODO Auto-generated method stub
		return  this.getUserAllergen();
	}
	@Override
	protected ArrayList<Integer> getIngredientArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected int getmaxIngredieantCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
