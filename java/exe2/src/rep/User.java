package rep;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

public class User extends Person {

private int userId;
private int userAllergies[];
public User(String personEmail, String personFirstName, String personLastName, Date personDateOfBirth,
			String personHashPass, ArrayList<Integer> personsFavoriteRecipe, ImageIcon personImage,int userId, int userAllergies[]) {
		super(personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass, personsFavoriteRecipe,
				personImage);
		setUserId(userId);
		setUserAllergen(userAllergies);
	}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int[] getUserAllergen() {
	return userAllergies;
}
public void setUserAllergen(int[] userAllergies) {
	this.userAllergies= new int[Allergen.getMaxAllergies()];
	for (int i=0;i<Allergen.getMaxAllergies();i++)
		this.userAllergies[i]=userAllergies[i];
}
}
