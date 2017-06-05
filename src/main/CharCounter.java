package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CharCounter {

	public Map<Character, Integer> countChars(String word) {

		CharCounter charCounter = new CharCounter();

		List<Character> charList = word.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		Map<Character, Integer> charCountMap = new HashMap<>();

		if (charCounter.validateChars(word)) {
			for (int i = 0; i < charList.size(); i++) {
				char currentLetter = charList.get(i);
				if (charCountMap.containsKey(currentLetter)) {
					charCountMap.put(currentLetter, charCountMap.get(currentLetter) + 1);
				} else {
					charCountMap.put(currentLetter, 1);
				}
			}
		}
		return charCountMap;

	}

	public boolean validateChars(String word) {

		if (!word.matches("[a-zA-Z0-9!?:;,. ]*")) {
			System.out.println("This is not a valid Character. Please enter a valid Character.");
			return false;
		}

		return true;

	}

}
