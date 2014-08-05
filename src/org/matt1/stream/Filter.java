package org.matt1.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Filter extends StringPlay {

	public static void main(String[] args) {
		Filter f = new Filter();
		f.go();
	}
	
	public void go() {
		List<String> words = getWords();
		
		// Filter takes java.util.function.Predicate, which takes one
		// argument and returns a boolean
		long start = System.currentTimeMillis();
		List<String> startsWithA = 
				words.parallelStream()	.filter(word -> word.startsWith("A"))
										.collect(Collectors.toList());		
		long end = System.currentTimeMillis();
		
		
		System.out.println("Original : " + words.size() + " words.");
		System.out.println("Filtered : " + startsWithA.size() + " words.");
		System.out.println("Time: " + (end - start) + "ms");
		
	}
	
}
