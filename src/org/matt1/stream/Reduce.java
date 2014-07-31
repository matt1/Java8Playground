package org.matt1.stream;

import java.util.ArrayList;
import java.util.List;

public class Reduce {

	public static void main(String[] args) {
		Reduce r = new Reduce();
		r.go();
	}
	
	private int print(int x, int y) {
		System.out.println("X is " + x + " Y is " + y);
		return x +y;
	}
	
	public void go() {
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(0);
		
		// The "identity" 0 is the mathematical identity
		// Reduce function is expecting a java.util.function.BinaryOperator, x is the
		// accumulator, y is the next item in the stream
		// Could have just done a lambda here (x,y) -> x+y
		int sum = numbers.stream().reduce(0, this::print);
		
		
		System.out.println(sum);
		
	
		
	}
	
}
