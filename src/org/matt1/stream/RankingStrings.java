package org.matt1.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RankingStrings extends StringPlay {

	public static void main(String[] args) {
		RankingStrings f = new RankingStrings();
		f.go();
	}
	
	
	public Function<String,Integer> getQueryScorer(String query) {
		// This returns a function that will be used by the Collectors.groupingBy
		// function.  We're passing in the query here now as Collectors.groupinbBy
		// expects a java.util.function.Function type that takes one argument.
		// This lambda expression "captures" the query variable.
		return word -> {return String.valueOf(word).indexOf(query);};	
	}
	
	public void go() {
		List<String> words = getWords();
		
		// Generate a query scoring function (we're using ZS as the query as we know it
		// is in the random strings a lot.
		Function<String,Integer> scorer = getQueryScorer("ZS");
		
		// This is a monster!  In summary it is:
		//  1 - getting the first 500 words from the word list
		//  2 - collecting the score-words results into a Map<Integer,String> using the scorer
		//  3 - then getting a stream of the entry set of that map
		//  4 - filter the entry set for negative scores (not found)
		//  5 - then iterate over each result and print it
		// This would make sense to break out into separate steps for readability but I 
		// just wanted to see what it would look like.
		words.parallelStream().limit(500).collect(Collectors.groupingBy(scorer)).
			entrySet().stream().filter((p) -> p.getKey() > -1).forEach(es -> {
				System.out.println(es.getKey() + ": " + es.getValue());
		});
		
		
	}
	
}
