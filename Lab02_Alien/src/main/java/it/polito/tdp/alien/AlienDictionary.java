package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced> dictionary;

	public AlienDictionary() {
		dictionary = new ArrayList<WordEnhanced>();
	}

	public void resetDictionary() {
		dictionary.clear();
	}
	
	public void addWord(String alienWord, String translation) {
		WordEnhanced w= new WordEnhanced(alienWord);
		
		if(dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTraslation(translation);
			return;
		}
		
		w.setTraslation(translation);
		dictionary.add(w);
		return;
	}
	
	public String translateWord(String alienWord) {
		WordEnhanced w= new WordEnhanced(alienWord);
		
		if(dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTraslation();
		}
		return null;
	}
	
	public String translateWordWildCard (String alienWord) {
		
		alienWord = alienWord.replaceAll("\\?", ".");
		
		int matchCounter = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(WordEnhanced w: dictionary) {
			
			if (w.compareWild(alienWord)) {
				
				matchCounter++;
				sb.append(w.getTraslation() + "\n");
			}
		}
		
		if (matchCounter !=0) {
			return sb.toString();
		}else
			return null;
	}
}
