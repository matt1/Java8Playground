package org.matt1.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoin extends StringPlay {

	public static void main(String[] args) {
		StringJoin f = new StringJoin();
		f.go();
	}
	
	public void go() {
		List<String> words = getWords();
		
		// The java.util.stream.Collectors class has lots of useful things 
		String result = words.stream().limit(5).collect(Collectors.joining(","));
		
		System.out.println(result);
		
		String[] arr = {"one","two","three"};
		
		System.out.println(Arrays.stream(arr).collect(Collectors.joining(",")));
		
		
		
	}
	
}
