package main;

import java.util.stream.IntStream;

public class RomanStringToInt {

	RomanCharToInt romanCharToInt = new RomanCharToInt();

	public int romanStringToInt(String romanString) {

		// List<Character> romanNumberList = romanString.chars().mapToObj(i ->
		// (char) i).collect(Collectors.toList());
		char[] romanStringArray = romanString.toCharArray();
		int[] romanIntArray = new int[romanStringArray.length];

		for (int i = 0; i < romanStringArray.length; i++) {
			romanIntArray[i] = romanCharToInt.romanCharToInt(romanStringArray[i]);
		}

		int sum = IntStream.of(romanIntArray).sum();

		return sum;

	}
}
