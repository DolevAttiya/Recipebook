package driver;

import controller.Controller;
import controller.MyController;
import model.model;
import model.Models;
import view.View;
import view.myView;

public class MVCDriver {
	public static void main(String[] args) {
		Controller controller = new MyController();
		model model = new Models();
		View view = new myView();
		
		model.addObserver(controller);
		view.addObserver(controller);
	}
}
