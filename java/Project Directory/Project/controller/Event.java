package controller;

public class Event<T> {

	private String eventName;
	private T entity;
	
	public Event() {
		this.eventName = "nullEvent";
		this.entity = null;
	}
	
	public Event(String name, T entity) {
		this.eventName = name;
		this.entity = entity;
	}
	
	public T getEntity() {
		return this.entity;
	}
	
	public String getName() {
		return this.eventName;
	}
}
