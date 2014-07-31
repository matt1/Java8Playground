package org.matt1.functional;

public class EventConsumer {

	private String name;
	public EventConsumer(String name) {
		this.name = name;
	}
		
	// Note that this class is NOT implementing an interface - this function could be
	// called anything
	public void event(Event events) {
		System.out.println(name +  " got Event");
		
	}


}
