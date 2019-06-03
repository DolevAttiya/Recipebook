package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public abstract class Person extends Entities{
	private String personEmail;
	private String personFirstName;
	private String personLastName;
	private	Date personDateOfBirth;
	private	String personHashPass;
	private ArrayList<Integer> personsFavoriteRecipe;
	private Blob personImage;
	public Person( String personEmail, String personFirstName, String personLastName, Date personDateOfBirth, String personHashPass, ArrayList<Integer> personsFavoriteRecipe,Blob personImage) {
		setPersonEmail(personEmail);
		setPersonFirstName(personFirstName);
		setPersonLastName(personLastName);
		setPersonDateOfBirth(personDateOfBirth);
		setPersonHashPass(personHashPass);
		setPersonsFavoriteRecipe(personsFavoriteRecipe);
		setPersonImage(personImage);
	}
	public Person(String email)
	{			
		this(SelectSpecific("Person","personEmail",email));		
	}
	public Person(ResultSet rs)
	{
		try {
			this.setPersonEmail(rs.getString("personEmail"));
			this.setPersonFirstName(rs.getString("personFirstName"));
			this.setPersonLastName(rs.getString("personLastName"));
			this.setPersonDateOfBirth(rs.getDate("personDateOfBirth"));
			this.setPersonHashPass(rs.getString("personHashPass"));
			ArrayList<Integer> personsFavoriteRecipes = new ArrayList<Integer>();
			ResultSet favorite = SelectSpecific("PersonFavoriteRecipe","personEmail",this.getPersonEmail());
			while(favorite.next())
				personsFavoriteRecipes.add(rs.getInt("recipeId"));
			this.setPersonsFavoriteRecipe(personsFavoriteRecipes);
			this.setPersonImage(rs.getBlob("personImage"));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	@Override
	String Class() {
		return "Person";
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	public String getPersonFirstName() {
		return personFirstName;
	}
	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}
	public String getPersonLastName() {
		return personLastName;
	}
	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}
	public Date getPersonDateOfBirth() {
		return personDateOfBirth;
	}
	public void setPersonDateOfBirth(Date personDateOfBirth) {
		this.personDateOfBirth = personDateOfBirth;
	}
	public String getPersonHashPass() {
		return personHashPass;
	}
	public void setPersonHashPass(String personHashPass) {
		this.personHashPass = personHashPass;
	}
	public ArrayList<Integer> getPersonsFavoriteRecipe() {
		return personsFavoriteRecipe;
	}
	public void setPersonsFavoriteRecipe(ArrayList<Integer> personsFavoriteRecipe) {
		personsFavoriteRecipe.forEach((n) -> this.personsFavoriteRecipe.add(n));

	}
	public Blob getPersonImage() {
		return personImage;
	}
	public void setPersonImage(Blob personImage) {
		this.personImage = personImage;
	}
	public String ConvertPassTOHash(String password) throws NoSuchAlgorithmException {
		
		final MessageDigest digest = MessageDigest.getInstance("SHA3_256");
		final byte[] hashbytes = digest.digest(
				password.getBytes(StandardCharsets.UTF_8));
		String sha3_256hex = bytesToHex(hashbytes);
		
		
		return sha3_256hex;
	}
	  private static String bytesToHex(byte[] hashInBytes) {

	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();

	    }
	@Override
	String getEntitieKey() {
		return "personEmail ";
	}
	@Override
	String getEntitieKeyValue() {
		return this.getPersonEmail();
	}
	@Override
	String getEntitieAttributesNames() {
		return "personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass, personImage";
	}
	@Override
	String getEntitieAttributesValues() {
		return this.getPersonEmail()+" , "+this.getPersonFirstName()+" , "+this.getPersonLastName()+" , "+this.getPersonDateOfBirth().toString()+" , "+this.getPersonHashPass()+" , "+this.getPersonImage();
	}
	@Override
	String getEntitieAttributesNamesValues() {
		// TODO Auto-generated method stub
		return "personEmail = "+ this.getPersonEmail()+" , personFirstName = "+this.getPersonFirstName()+" , personLastName = "+this.getPersonLastName()+" , personDateOfBirth = "+this.getPersonDateOfBirth().toString()+" , personHashPass = "+ this.getPersonHashPass() + " , personImage = "+ this.getPersonImage();

	}
	@Override
	public void getPsmtmt(PreparedStatement pstmt) {
		 try {
			    pstmt.setString(1, personEmail);
				pstmt.setString(2, personFirstName);
				pstmt.setString(3, personLastName);
				pstmt.setDate(4, (java.sql.Date) personDateOfBirth);
				pstmt.setBlob(5, (Blob) personImage);
				pstmt.setBlob(5, personImage);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}

}
