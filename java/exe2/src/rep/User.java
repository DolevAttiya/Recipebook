package rep;

import java.sql.Blob;
import java.sql.PreparedStatement;
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
	this.userAllergen= new Integer[Allergen.getMaxAllergen()];
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
public void getPsmtmt(PreparedStatement pstmt, int i) {
	 try {
     	
			pstmt.setInt(1, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
