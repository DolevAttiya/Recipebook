package tests;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
import org.junit.jupiter.api.Test;
//import controller.Controller;
import controller.Event;
import controller.MyController;
import view.View;

import java.util.Observable;

public class ControlerModelIntegration extends Observable implements View {

	Event ev;
	/*Controller controller = new MyController();
	ControlerModelIntegration test=new ControlerModelIntegration();
	test.addObserver(controller);*/
	ControlerModelIntegration tester;
	
	@Test
	void userLoginTest()  {
		ev = new Event();
		int num=0;
		ev.getArr().add("user_login");
		ev.getArr().add("username");
		ev.getArr().add("password");
		setChanged();
		notifyObservers(ev);
		num=tester.countObservers();
		assertTrue(MyController.visit);
	}

}
