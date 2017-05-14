package main;

public class RotKata {

	public String grossschreibung(String word) {
		return word.toUpperCase().replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE");
	}

	// public int toASCII(char character) {
	// return character;
	// }

	public char charSwitcher(char oldChar, int versatz) {
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

		char newChar = oldChar;
		if (versatz > alphabet.length) {
			versatz = versatz % alphabet.length;
		}

		for (int i = 0; i <= alphabet.length; i++) {
			if (oldChar == alphabet[i]) {
				if (i >= alphabet.length - versatz) {
					i = versatz - (alphabet.length - i);
					return newChar = alphabet[i];
				} else
					return newChar = alphabet[i + versatz];
			}
		}
		return newChar;
	}

	public String rotKataService(String word, int versatz) {
		char[] keyword = grossschreibung(word).toCharArray();
		for (int i = 0; i < keyword.length; i++) {
			keyword[i] = charSwitcher(keyword[i], versatz);
		}
		return new String(keyword);
	}

}
