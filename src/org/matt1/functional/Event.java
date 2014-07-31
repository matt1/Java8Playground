package org.matt1.functional;

import java.util.function.Consumer;

public class Event {

	public enum Type {
		Open,
		Close
	}
	
	public Event(Type type, Consumer<Object> consumer, Object... message) {
		
	}
	
	
}
