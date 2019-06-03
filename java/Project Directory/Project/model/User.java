package model;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class User extends Person {

private Integer userId;
private Integer userAllergen[];
public User(String personEmail, String personFirstName, String personLastName, Date personDateOfBirth,
			String personHashPass, ArrayList<Integer> personsFavoriteRecipe, Blob personImage,Integer userId, Integer userAllergen[]) {
		super(personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass, personsFavoriteRecipe,
				personImage);
		setUserId(userId);
		setUserAllergen(userAllergen);
	}
public User(ResultSet rs) {
	super(rs);
	try {
		ResultSet userAllergens = SelectSpecific("UserAllergen","ingredientId",this.getUserId().toString());
		Integer[] allergen= new Integer[userAllergens.getFetchSize()];
		while(userAllergens.next())
		{
			allergen[userAllergens.getInt("allergenId")]=1;
		}
		this.setUserId(rs.getInt("dietitianId"));
		this.setUserAllergen(allergen);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
@Override
String Class() {
	return "User";
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
String getEntitieKey() {	
	return " userId ";
}
@Override
String getEntitieKeyValue() {
	return this.getUserId().toString();
}
@Override
String getEntitieAttributesNames() {
	return getEntitieKey();
}
@Override
String getEntitieAttributesValues() {
	return this.getUserId().toString();
}
@Override
String getEntitieAttributesNamesValues() {
	return " "+getEntitieKey()+" = "+this.getUserId().toString()+" ";
}
@Override
public void getPsmtmt(PreparedStatement pstmt) {
	 try {
     	
			pstmt.setInt(1, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
