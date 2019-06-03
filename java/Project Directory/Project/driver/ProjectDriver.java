package driver;

import model.Allergen;
import model.Entities;
import model.model;

public class ProjectDriver {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		model Model = new Entities();
		Allergen al= new Allergen(5);
		System.out.print(al.getAllergenName());
	}

}
