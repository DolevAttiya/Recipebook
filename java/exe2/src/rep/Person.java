package rep;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

public abstract class Person {
	private String personEmail;
	private String personFirstName;
	private String personLastName;
	private	Date personDateOfBirth;
	private	String personHashPass;
	private ArrayList<Integer> personsFavoriteRecipe;
	private ImageIcon personImage;
	public Person( String personEmail, String personFirstName, String personLastName, Date personDateOfBirth, String personHashPass, ArrayList<Integer> personsFavoriteRecipe,ImageIcon personImage) {
		setPersonEmail(personEmail);
		setPersonFirstName(personFirstName);
		setPersonLastName(personLastName);
		setPersonDateOfBirth(personDateOfBirth);
		setPersonHashPass(personHashPass);
		setPersonsFavoriteRecipe(personsFavoriteRecipe);
		setPersonImage(personImage);
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
	public ImageIcon getPersonImage() {
		return personImage;
	}
	public void setPersonImage(ImageIcon personImage) {
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

}