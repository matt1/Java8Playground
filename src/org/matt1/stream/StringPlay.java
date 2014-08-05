package org.matt1.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringPlay {

	
	protected List<String> getWords() {
		Random r = new Random(568748973);		
		ArrayList<String> randomWords = new ArrayList<String>();
		
		// Generate a load of words
		int totalWords = (int) (r.nextFloat() * 1000000);		
		for (int i = 0;i<totalWords;i++) {
			// Each word random length, then generate random letters
			int length = r.nextInt(25) + 5;
			String word = "";
			for (int j=0;j<length;j++) {
				int c = (r.nextInt(90 - 65 + 1) + 65);
				word += (char) c;
			}
			randomWords.add(word);
		}
		
		return randomWords;
	}

	
}
