package org.matt1.functional;

import org.matt1.functional.Event.Type;

public class Supplier {

	public void doEvent() {		
		Object[] data = {null,1,null};
		
		// Pass in a method reference for the callback.  
		EventHandler.event(Type.Open, this::report, data);
	}
	
	// This is called as the call back.  Note no interface in this class!  The name of the 
	// method is not important
	public void report(Object... response) {
		System.out.println("We got a callback");

	}

}
