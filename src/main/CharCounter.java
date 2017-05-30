package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CharCounter {

	public Map<Character, Integer> countChars(String word) {
		List<Character> charList = word.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		for (int i = 0; i < charList.size(); i++) {
			char currentLetter = charList.get(i);
			if (charCountMap.containsKey(currentLetter)) {
				charCountMap.put(currentLetter, charCountMap.get(currentLetter) + 1);
			} else {
				charCountMap.put(currentLetter, 1);
			}
		}
		return charCountMap;
	}

}
