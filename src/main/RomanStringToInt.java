package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RomanStringToInt {

	private RomanCharToInt romanCharToInt = new RomanCharToInt();

	public int romanStringToInt(String romanString) {

		// int result = 0;
		List<Character> romanNumberList = romanString.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		List<Integer> romanIntegerList = new ArrayList<Integer>();

		for (int i = 0; i < romanNumberList.size(); i++) {
			romanIntegerList.add(romanCharToInt.romanCharToInt(romanNumberList.get(i)));
		}

		int sum = romanIntegerList.stream().mapToInt(Integer::intValue).sum();

		return sum;

	}
}
