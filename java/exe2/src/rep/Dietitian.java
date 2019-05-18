package rep;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

public class Dietitian extends Person {

private int dietitianId;
private Date dieticianStatDate;
public Dietitian(String personEmail, String personFirstName, String personLastName, Date personDateOfBirth,
			String personHashPass, ArrayList<Integer> personsFavoriteRecipe, ImageIcon personImage,int dietitianId, Date dieticianStatDate) {
		super(personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass, personsFavoriteRecipe,
				personImage);
		setDietitianId(dietitianId);
		setDieticianStatDate(dieticianStatDate);
	}
public int getDietitianId() {
	return dietitianId;
}
public void setDietitianId(int dietitianId) {
	this.dietitianId = dietitianId;
}
public Date getDieticianStatDate() {
	return dieticianStatDate;
}
public void setDieticianStatDate(Date dieticianStatDate) {
	this.dieticianStatDate = dieticianStatDate;

}

public int reputetionYears() {
	Date Now= new Date();
	
return Now.compareTo(getDieticianStatDate());	
} 
}