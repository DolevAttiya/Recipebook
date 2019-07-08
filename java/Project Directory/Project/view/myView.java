package view;

import java.awt.datatransfer.StringSelection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Observable;

import javax.swing.JOptionPane;
import controller.Event;
import model.Dietitian;
import model.Recipe;

public class myView extends Observable implements View {
	public myView() {};
	public static myView statview = new myView();
	User myUser;
	Dietitian myDietitian;
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
	public void login (String email, char[] cPass)
	{
		String sPass=new String(cPass);
		try {
			sPass=ConvertPassTOHash(sPass);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Event ev=new Event();
		ev.getArr().add("userLogin");
		ev.getArr().add(email);
		ev.getArr().add(sPass);
		setChanged();
		notifyObservers(ev);
	}	
	public void loginResponse (ArrayList<User> us) {
		if(us.get(0)!=null) // if the user exists in the DB
		{
			myUser=us.get(0);
			MainPage frame = new MainPage(); // create new page of the mainPage and close the last one
		}
		else JOptionPane.showMessageDialog(null,"One of the parameters is wrong, Please try again");
	}

	public void register(String firstName, String lastName, String email, String pass, Date dateOfBirth, boolean isDietitian, int dietitianNum, int isKosher, Date dietitianStatDate, Integer[] allergies) {
		Dietitian newDietitian;
		model.User newUser;
		String hashPass;
		Event ev=new Event();
		try {
			hashPass = ConvertPassTOHash(pass);
			if (isDietitian==true)
			{
				newDietitian = new Dietitian(email, firstName, lastName, dateOfBirth, hashPass, null, null, dietitianNum, dietitianStatDate);
				ev.getArr().add("dietitian_register");
				ev.getArr().add(newDietitian);
			}
			else		
			{
				newUser=new model.User(email, firstName, lastName, dateOfBirth, hashPass, null, null, 1, allergies);
				ev.getArr().add("user_register");
				ev.getArr().add(newUser);
			}
			setChanged();
			notifyObservers(ev);		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dRegisterResponse(ArrayList<Dietitian> usD) {
		if(usD.get(0)!=null) // if the user exists in the DB
		{
			myDietitian=usD.get(0);
			MainPage frame = new MainPage(); // create new page of the mainPage and close the last one
		}
		else JOptionPane.showMessageDialog(null,"Something went wrong, Please try again");
	}
	public void uRegisterResponse(ArrayList<User> usU) {
		if(usU.get(0)!=null) // if the user exists in the DB
		{
			myUser=usU.get(0);
			MainPage frame = new MainPage(); // create new page of the mainPage and close the last one
		}
		else JOptionPane.showMessageDialog(null,"Something went wrong, Please try again");
	}
	
	public void getTop10() {
	//Ovali needs to tell me how he sends me the information
	}
	public void mainSearch(String s) {
		Event ev=new Event();
		ev.getArr().add("menu_search");
		ev.getArr().add(s);
		setChanged();
		notifyObservers(ev);
	}
	public void searchResponse (ArrayList<Recipe> r) {
		
	}











}