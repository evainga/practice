package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RomanStringToInt {

	private RomanCharToInt romanCharToInt = new RomanCharToInt();
	private RomanNumberValidator romanNumberValidator = new RomanNumberValidator();

	List<Integer> romanStringToIntList(String romanString) {
		List<Integer> intermediateList = new ArrayList<Integer>();
		List<Character> romanNumberList = romanString.chars().mapToObj(i -> (char) i).collect(Collectors.toList());

		for (int i = 0; i < romanNumberList.size(); i++) {
			intermediateList.add(romanCharToInt.romanCharToInt(romanNumberList.get(i)));
		}
		return intermediateList;
	}

	private List<Integer> subtractor(int smallNumber, int bigNumber, List<Integer> romanIntegerList) {

		if (romanIntegerList.contains(smallNumber) && romanIntegerList.contains(bigNumber)) {
			int indexOfBigNumber = romanIntegerList.lastIndexOf(bigNumber);
			int indexOfSmallNumber = romanIntegerList.indexOf(smallNumber);

			if (indexOfBigNumber > indexOfSmallNumber) {
				romanIntegerList.set(indexOfSmallNumber, (smallNumber * -1));
			}
		}
		return new ArrayList<>(romanIntegerList);
	}

	public int romanStringToIntResult(String romanString) {

		int result = 0;

		if (romanNumberValidator.validateLetters(romanString)) {

			List<Integer> romanIntegerList = romanStringToIntList(romanString);

			romanIntegerList = subtractor(1, 5, romanIntegerList);
			romanIntegerList = subtractor(1, 10, romanIntegerList);
			romanIntegerList = subtractor(10, 50, romanIntegerList);
			romanIntegerList = subtractor(10, 100, romanIntegerList);
			romanIntegerList = subtractor(100, 500, romanIntegerList);
			romanIntegerList = subtractor(100, 1000, romanIntegerList);

			result = romanIntegerList.stream().mapToInt(Integer::intValue).sum();

		}
		return result;
	}
}
