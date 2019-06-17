package view;

import java.awt.im.InputContext;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Event;

public class myView extends Observable implements View {
 User myUser;
	public void login (String email, String pass)
	{
		Event ev=new Event();
		ev.getArr.add("userLogin");
		ev.getArr.add(email);
		ev.getArr.add(pass);
		setChanged();
		notifyObservers(ev);
	}
	
	public void loginResponse (ArrayList<Object> us) {
			if((ArrayList<User>)(us.get(1)).size()>0) // if the user exists in the DB
			{
				myUser=(ArrayList<User>)(us.get(1)).get(0));
				MainPage frame = new MainPage();
			}
			else JOptionPane.showMessageDialog(null,"One of the parameters is wrong, Please try again");
	}
}