package de.regex;

public class RegEx {

	boolean startsWithUpperCase(String word) {
		return word.matches("[A-Z]([a-zA-Zô‘])*");
	}

	boolean startsWithLowerCaseM(String word) {
		return word.matches("m([a-zA-Zô‘])*");
	}

	boolean hasFourLetters(String word) {
		return word.matches("[a-zA-Zô‘]{4}");
	}

	boolean endsWithEd(String word) {
		return word.matches("([a-zA-Zô‘])*ed");
	}

	boolean hasALetter(String word) {
		return word.matches("([a-zA-Zô‘])*a([a-zô‘])*");
	}

	// boolean isNumber(String word) {
	// return word.matches("\\d");

}
