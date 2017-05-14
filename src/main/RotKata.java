package main;

public class RotKata {

	public String grossschreibung(String word) {
		return word.toUpperCase().replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE");
	}

	// public int toASCII(char character) {
	// return character;
	// }

	public char charSwitcher(char oldChar, int shiftNumber) {
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

		char newChar = oldChar;
		if (shiftNumber > alphabet.length) {
			shiftNumber = shiftNumber % alphabet.length;
		}

		for (int i = 0; i <= alphabet.length; i++) {
			if (oldChar == alphabet[i]) {
				if (i >= alphabet.length - shiftNumber) {
					i = shiftNumber - (alphabet.length - i);
					return alphabet[i];
				} else
					return alphabet[i + shiftNumber];
			}
		}
		return newChar;
	}

	public String rotKataEncrypter(String word, int versatz) {
		char[] keyword = grossschreibung(word).toCharArray();
		for (int i = 0; i < keyword.length; i++) {
			keyword[i] = charSwitcher(keyword[i], versatz);
		}
		return new String(keyword);
	}

}
