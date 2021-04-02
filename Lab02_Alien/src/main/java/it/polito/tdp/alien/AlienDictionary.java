package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> dictionary;

	public AlienDictionary(List<Word> dictionary) {
		dictionary = new ArrayList<Word>();
	}

	public void resetDictionary() {
		dictionary.clear();
	}
	
	public void addWord(String alienWord, String translation) {
		Word w= new Word(alienWord, translation);
		
		if(dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTraslation(translation);
			return;
		}
		dictionary.add(w);
		return;
	}
	
	public String translateWord(String alienWord) {
		Word w= new Word(alienWord);
		
		if(dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTraslation();
		}
		return null;
	}
}
