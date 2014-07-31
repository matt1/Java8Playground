package org.matt1.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventHandler {

	// List of method references
	private static List<Consumer<Event>> eventConsumers = new ArrayList<Consumer<Event>>();
	
	// using java.util.function.Consumer type here to accept a method reference
	public static void add(Consumer<Event> e) {
		eventConsumers.add(e);
	}
	
	// Note that again we use the Consumer type to accept a callback method reference
	public static void event(Event.Type t, Consumer<Object> c, Object... objects) {
		Event event = new Event(t,c,objects);
		
		// Parallel stream to process each event handler.
		// We also use a lambda expression to "accept()" the consumer, which in effect is 
		// calling the passed in method.
		eventConsumers.parallelStream().forEach((e) -> e.accept(event));
			
		// Again, we have the accept on the method reference
		c.accept(objects);
		
	}
	
	
	
}
