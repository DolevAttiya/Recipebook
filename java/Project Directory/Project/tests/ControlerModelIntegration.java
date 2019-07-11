package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import controller.Event;
import controller.MyController;
import model.Models;
import model.model;
import view.View;
import view.myView;
import controller.Controller;

public class ControlerModelIntegration {

	Event ev;
	static model m;
	static View v;
	static Controller controllerTest;

	@BeforeAll
	static void setup() {
		m = new Models();
		v = new myView();
		controllerTest = new MyController(m,v);
		((Models)m).addObserver(controllerTest);
	}

	@Test
	void userLoginTest() {
		ev = new Event();
		ev.getArr().add("user_login");
		ev.getArr().add("username");
		ev.getArr().add("password");
		((MyController)controllerTest).update(null, ev);
	}
	
	@Test
	void userRegisterTest() {
		ev = new Event();
		ev.getArr().add("user_register");
		ev.getArr().add("username");
		ev.getArr().add("password");
		((MyController)controllerTest).update(null, ev);
	}
}
