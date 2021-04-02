package it.polito.tdp.alien;

public class Word {

	private String alienWord;
	private String traslation;
	

	public Word(String alienWord) {
		this.alienWord = alienWord;
	}


	public Word(String alienWord, String traslation) {
		super();
		this.alienWord = alienWord;
		this.traslation = traslation;
	}

	public String getTraslation() {
		return traslation;
	}


	public void setTraslation(String traslation) {
		this.traslation = traslation;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}


}
