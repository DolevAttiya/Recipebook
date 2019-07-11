package model;


import java.time.LocalDate;
//import java.sql.PreparedStatement;
import java.util.ArrayList;

public class User extends Person {

	private Integer userId;
	private Integer userAllergen[];
	private Boolean userAllergens;
	private Boolean userKashruth;
	public User(String personEmail, String personFirstName, String personLastName, LocalDate personDateOfBirth,
			String personHashPass, ArrayList<Integer> personsFavoriteRecipe,Integer userId, Integer userAllergen[],Boolean userAllergens, Boolean userKashruth) {
		super(personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass, personsFavoriteRecipe);
		this.setUserId(userId);
		this.setUserAllergen(userAllergen);
		this.setUserAllergens(userAllergens);
		this.setUserKashruth(userKashruth);
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
		this.userAllergen= new Integer[userAllergen.length];
		for (int i=0;i<userAllergen.length;i++)
			this.userAllergen[i]=userAllergen[i];
	}
	public Boolean getUserKashruth() {
		return userKashruth;
	}

	public void setUserKashruth(Boolean userKashruth) {
		if(userKashruth)
			this.userKashruth = true;
		else
			this.userKashruth =false;
	}

	public Boolean getUserAllergens() {
		return userAllergens;
	}

	public void setUserAllergens(Boolean userAllergens) {
		if(userAllergens)
			this.userAllergens = true;
		else
			this.userAllergens =false;	}
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
		return getEntitieKey()+" , userAllergen , userKashruth,  personEmail ";
	}
	@Override
	protected String getEntitieAttributesValues() {
		return " "+this.getUserId().toString()+" , "+this.getUserAllergens().toString()+" , "+this.getUserKashruth().toString()+" , \""+this.getPersonEmail()+"\" ";
	}

	protected String getEntitieAttributesNamesValues() {
		return " "+getEntitieKey()+" = "+this.getUserId().toString()+" , userAllergen = "+this.getUserAllergens().toString()+" , userKashruth = "+this.getUserKashruth().toString()+" , personEmail = \""+this.getPersonEmail()+ "\" ";
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

	@Override
	protected String getIngredientDelete(int place) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getPersonAttributesNames() {
		return "personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass";
	}
	@Override
	protected String getPersonAttributesValues() {
		return " \""+this.getPersonEmail()+"\" , \""+this.getPersonFirstName()+"\" , \""+this.getPersonLastName()+"\" , \""+this.getPersonDateOfBirth().toString()+"\" , \""+this.getPersonHashPass()+"\"  ";
	}
	@Override
	protected String getPersonAttributesNamesValues() {
		// TODO Auto-generated method stub
		return " personFirstName = \""+this.getPersonFirstName()+"\" , personLastName = \""+this.getPersonLastName()+"\" , personDateOfBirth = \""+this.getPersonDateOfBirth().toString()+"\" , personHashPass = \""+ this.getPersonHashPass() + "\" ";

	}
	@Override
	protected String getPersonKeyValue() {
		return " \""+this.getPersonEmail()+"\" ";
	}


}
