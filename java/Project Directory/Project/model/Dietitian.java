package model;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dietitian extends Person {

	private Integer dietitianId;
	private LocalDate dietitianStatDate;
	public Dietitian(String personEmail, String personFirstName, String personLastName, LocalDate personDateOfBirth,
			String personHashPass, ArrayList<Integer> personsFavoriteRecipe, BufferedImage personImage,Integer dietitianId, LocalDate dietitianStatDate) {
		super(personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass, personsFavoriteRecipe,
				personImage);
		setDietitianId(dietitianId);
		setDietitianStatDate(dietitianStatDate);
	}
	@Override
	protected String Class() {
		return " Dietitian";
	}
	public Integer getDietitianId() {
		return dietitianId;
	}
	public void setDietitianId(Integer dietitianId) {
		this.dietitianId = dietitianId;
	}
	public LocalDate getDietitianStatDate() {
		return dietitianStatDate;
	}
	public void setDietitianStatDate(LocalDate dietitianStatDate) {
		this.dietitianStatDate = dietitianStatDate;

	}
	public Integer reputetionYears() {
		LocalDate Now= LocalDate.now();

		return Now.compareTo(getDietitianStatDate());	
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
		return " dietitianId , dietitianStatDate ,personEmail ";
	}
	@Override
	protected String getEntitieAttributesValues() {
		return " "+this.getDietitianId().toString()+" , \""+this.getDietitianStatDate().toString()+"\" , \""+this.getPersonEmail()+"\" ";
	}
	@Override
	protected String getEntitieAttributesNamesValues() { 
		return " dietitianId = "+this.getDietitianId().toString()+" , dietitianStatDate = \""+this.getDietitianStatDate().toString()+"\" + personEmail = \""+this.getDietitianStatDate()+"\" ";
	}
	/*@Override
public void getPsmtmt(PreparedStatement pstmt) {
	try {

		pstmt.setInt(1, dietitianId);
		pstmt.setDate(2, (java.sql.Date) dietitianStatDate);
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
	@Override
	protected String getIngredientDelete(int place) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getPersonAttributesNames() {
		return "personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass, personImage";
	}
	@Override
	protected String getPersonAttributesValues() {
		return " \""+this.getPersonEmail()+"\" , \""+this.getPersonFirstName()+"\" , \""+this.getPersonLastName()+"\" , \""+this.getPersonDateOfBirth().toString()+"\" , \""+this.getPersonHashPass()+"\" , "+this.getPersonImage()+ " ";
	}
	@Override
	protected String getPersonAttributesNamesValues() {
		// TODO Auto-generated method stub
		return " personFirstName = \""+this.getPersonFirstName()+"\" , personLastName = \""+this.getPersonLastName()+"\" , personDateOfBirth = \""+this.getPersonDateOfBirth().toString()+"\" , personHashPass = \""+ this.getPersonHashPass() + "\" , personImage = "+ this.getPersonImage();

	}
	@Override
	protected String getPersonKeyValue() {
		return " \""+this.getPersonEmail()+"\" ";
	}
}