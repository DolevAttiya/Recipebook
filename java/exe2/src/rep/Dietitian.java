package rep;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Dietitian extends Person {

private Integer dietitianId;
private Date dieticianStatDate;
public Dietitian(String personEmail, String personFirstName, String personLastName, Date personDateOfBirth,
			String personHashPass, ArrayList<Integer> personsFavoriteRecipe, Blob personImage,Integer dietitianId, Date dieticianStatDate) {
		super(personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass, personsFavoriteRecipe,
				personImage);
		setDietitianId(dietitianId);
		setDieticianStatDate(dieticianStatDate);
	}
public Integer getDietitianId() {
	return dietitianId;
}
public void setDietitianId(Integer dietitianId) {
	this.dietitianId = dietitianId;
}
public Date getDieticianStatDate() {
	return dieticianStatDate;
}
public void setDieticianStatDate(Date dieticianStatDate) {
	this.dieticianStatDate = dieticianStatDate;

}

public Integer reputetionYears() {
	Date Now= new Date();
	
return Now.compareTo(getDieticianStatDate());	
}
@Override
String getEntitieKey() {
	return "dietitianId";
}
@Override
String getEntitieKeyValue() {
	return this.getDietitianId().toString();
}
@Override
String getEntitieAttributesNames() {
	return " dietitianId , dieticianStatDate ";
}
@Override
String getEntitieAttributesValues() {
	return " "+this.getDietitianId().toString()+" , "+this.getDieticianStatDate().toString();
}
@Override
String getEntitieAttributesNamesValues() { 
	return " dietitianId = "+this.getDietitianId().toString()+" , dieticianStatDate = "+this.getDieticianStatDate().toString();
}
@Override
public void getPsmtmt(PreparedStatement pstmt, int i) {
	try {
       	
		pstmt.setInt(1, dietitianId);
		if(i==0) {
		pstmt.setDate(2, (java.sql.Date) dieticianStatDate);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
} 
}