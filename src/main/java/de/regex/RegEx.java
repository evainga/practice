package de.regex;

public class RegEx {

	boolean startsWithUpperCase(String word) {
		return word.matches("[A-Z]([a-zA-Z])*");
	}

	boolean startsWithLowerCaseM(String word) {
		return word.matches("m([a-zA-Z])*");
	}

	boolean hasFourLetters(String word) {
		return word.matches("[a-zA-Z]{4}");
	}

	boolean endsWithEd(String word) {
		return word.matches("([a-zA-Z])*ed");
	}

	boolean hasALetter(String word) {
		return word.matches("([a-zA-Z])*a([a-z])*");
	}

	// boolean isNumber(String word) {
	// return word.matches("\\d");

}
