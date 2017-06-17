package de.romannumbers;

public class RomanNumberValidator {

	public boolean validateLetters(String romanNumber) {

		if (!romanNumber.matches("[IVXLCDM]*")) {
			System.out.println("This is not a valid Roman Number. Please enter a valid Number.");
			return false;
		}

		return true;

	}

}
