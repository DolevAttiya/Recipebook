package view;

import java.awt.im.InputContext;
import java.util.Observable;
import controller.Event;

public class myView extends Observable implements View {

	int login (String email, String pass)
	{
		Event ev=new Event();
		if ((email=="rotem") || (pass=="1234"))
			return 1;
		else return 0;	
		setChanged();
		notifyObservers(ev);
	}
}