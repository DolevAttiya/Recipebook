package model;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Person extends Entities{
	private String personEmail;
	private String personFirstName;
	private String personLastName;
	private	LocalDate personDateOfBirth;
	private	String personHashPass;
	private ArrayList<Integer> personsFavoriteRecipe;
	public Person( String personEmail, String personFirstName, String personLastName, LocalDate personDateOfBirth, String personHashPass, ArrayList<Integer> personsFavoriteRecipe) {
		setPersonEmail(personEmail);
		setPersonFirstName(personFirstName);
		setPersonLastName(personLastName);
		setPersonDateOfBirth(personDateOfBirth);
		setPersonHashPass(personHashPass);
		setPersonsFavoriteRecipe(personsFavoriteRecipe);
	}
	@Override
	protected String Class() {
		return " Person";
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
	public LocalDate getPersonDateOfBirth() {
		return personDateOfBirth;
	}
	public void setPersonDateOfBirth(LocalDate personDateOfBirth) {
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
		this.personsFavoriteRecipe= new ArrayList<Integer>();
		if( personsFavoriteRecipe!=null)
			personsFavoriteRecipe.forEach((n) -> this.personsFavoriteRecipe.add(n));
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
	protected String getEntitieKey() {
		return "personEmail ";
	}
	@Override
	protected String getEntitieKeyValue() {
		return this.getPersonEmail();
	}
	@Override
	protected String getEntitieAttributesNames() {
		return "personEmail, personFirstName, personLastName, personDateOfBirth, personHashPass ";
	}
	@Override
	protected String getEntitieAttributesValues() {
		return this.getPersonEmail()+" , "+this.getPersonFirstName()+" , "+this.getPersonLastName()+" , "+this.getPersonDateOfBirth()+" , "+this.getPersonHashPass()+" ";
	}
	@Override
	protected String getEntitieAttributesNamesValues() {
		// TODO Auto-generated method stub
		return " personFirstName = "+this.getPersonFirstName()+" , personLastName = "+this.getPersonLastName()+" , personDateOfBirth = "+this.getPersonDateOfBirth()+" , personHashPass = "+ this.getPersonHashPass() + " ";

	}
	/*@Override
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
	}*/

}

