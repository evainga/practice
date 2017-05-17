package main;

import java.util.List;
import java.util.stream.Collectors;

public class RotKata {
	private List<Character> alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".chars().mapToObj(i -> (char) i)
			.collect(Collectors.toList());
	private int alphabetSize = alphabet.size();

	public String toUpperCaseAndSubstituteUmlauts(String word) {
		return word.toUpperCase().replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE");
	}

	public char rotateByFixedDistance(char oldChar, int shiftNumber) {

		if (shiftNumber > alphabetSize) {
			shiftNumber = shiftNumber % alphabetSize;
		}

		if (!alphabet.contains(oldChar)) {
			return oldChar;
		}

		int i = alphabet.indexOf(oldChar);

		if (i >= alphabetSize - shiftNumber) {
			i = shiftNumber - (alphabetSize - i);
			return alphabet.get(i);
		} else
			return alphabet.get(i + shiftNumber);

	}

	public String encryptToRotKata(String word, int shiftNumber) {
		char[] keyword = toUpperCaseAndSubstituteUmlauts(word).toCharArray();
		for (int i = 0; i < keyword.length; i++) {
			keyword[i] = rotateByFixedDistance(keyword[i], shiftNumber);
		}
		return new String(keyword);
	}

}
