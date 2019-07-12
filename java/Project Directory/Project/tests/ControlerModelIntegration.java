package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import controller.Event;
import controller.Controller;
import controller.MyController;
import model.Dietitian;
import model.Models;
import model.User;
import model.model;
import view.View;
import view.myView;

public class ControlerModelIntegration {

	Event ev;
	static model m;
	static View v;
	static Controller controllerTest;
	User user;
	Dietitian dietitian;

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
		Integer[] al = new Integer[]{0,0,0,0,1,0,0,1,0,0,1,0};
		user= new User("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, al, true, false);
		ev.getArr().add("user_register");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
		user = Models.GetUserFromDB("idontknowhatemailis");
		user.Delete();
	}
	
	@Test
	void dietitianRegisterTest() {
		ev = new Event();
		dietitian = new Dietitian("idontknowhatemailis", "elad", "valad",LocalDate.parse("2019-06-17"), "eladvald", null, 99, LocalDate.parse("2010-06-17"));
		ev.getArr().add("dietitian_register");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
		dietitian = Models.GetDietitianFromDB("idontknowhatemailis");
		dietitian.Delete();
	}
	
	@Test
	void userUpdateTest() {
		ev = new Event();
		user= Models.GetUserFromDB("drakarisValyrian.com");
		user.setUserKashruth(true);
		ev.getArr().add("user_update");
		ev.getArr().add(user);
		((MyController)controllerTest).update(null, ev);
		user.setUserKashruth(false);
	}
	
}
