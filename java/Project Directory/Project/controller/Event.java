package controller;

import java.util.ArrayList;

public class Event {
	
	private ArrayList<Object> arr;
	
	public Event() {
		setArr(new ArrayList<Object>());
	}

	public ArrayList<Object> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Object> arr) {
		this.arr = arr;
	}
}