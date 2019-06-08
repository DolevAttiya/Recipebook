package model;

import java.sql.Blob;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public Dietitian(ResultSet rs) {
	super(rs);
	try {
		this.setDietitianId(rs.getInt("dietitianId"));
		this.setDieticianStatDate(rs.getDate("dieticianStatDate"));
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
@Override
protected String Class() {
	return "Dietitian";
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
protected String getEntitieKey() {
	return "dietitianId";
}
@Override
protected String getEntitieKeyValue() {
	return this.getDietitianId().toString();
}
@Override
protected String getEntitieAttributesNames() {
	return " dietitianId , dieticianStatDate ";
}
@Override
protected String getEntitieAttributesValues() {
	return " "+this.getDietitianId().toString()+" , "+this.getDieticianStatDate().toString();
}
@Override
protected String getEntitieAttributesNamesValues() { 
	return " dietitianId = "+this.getDietitianId().toString()+" , dieticianStatDate = "+this.getDieticianStatDate().toString();
}
/*@Override
public void getPsmtmt(PreparedStatement pstmt) {
	try {
       	
		pstmt.setInt(1, dietitianId);
		pstmt.setDate(2, (java.sql.Date) dieticianStatDate);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
} */
@Override
protected String getAllergenInsert(int place) {
	return null;
}
@Override
protected String getIngredientInsert(int place) {
	return null;
}
@Override
protected Integer[] getAllergenArray() {
	return null;
}
@Override
protected ArrayList<Integer> getIngredientArray() {
	return null;
}
@Override
protected int getmaxIngredieantCount() {
	return 0;
}
}