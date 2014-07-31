package org.matt1.functional;

public class Main {

	public static void main(String[] args) {
				
		long start = System.currentTimeMillis();
		for (int i = 0;i<1000;i++) {
			// Add a method reference to the event handler, not an object
			EventHandler.add(new EventConsumer("Consumer " + i)::event);
		}
		
		Supplier s = new Supplier();
		s.doEvent();
		long end = System.currentTimeMillis();
		System.out.println("Event processing took: " + (end - start) + "ms");
		
		
	}
	
}

