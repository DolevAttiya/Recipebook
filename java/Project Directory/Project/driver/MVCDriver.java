package driver;

import controller.Controller;
import controller.MyController;
import model.model;
import model.Models;
import view.View;
import view.myView;

public class MVCDriver {
	public static void main(String[] args) {
		model model = new Models();
		View view = new myView();
		
		Controller controller = new MyController(model, view);
		((Models)model).addObserver(controller);
		((myView)view).addObserver(controller);
		view.start();

	}
}
