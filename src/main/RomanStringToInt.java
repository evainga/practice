package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RomanStringToInt {

	private RomanCharToInt romanCharToInt = new RomanCharToInt();
	private List<Integer> romanIntegerList = new ArrayList<Integer>();

	private List<Integer> romanStringToInt(String romanString) {

		List<Character> romanNumberList = romanString.chars().mapToObj(i -> (char) i).collect(Collectors.toList());

		for (int i = 0; i < romanNumberList.size(); i++) {
			romanIntegerList.add(romanCharToInt.romanCharToInt(romanNumberList.get(i)));
		}

		return romanIntegerList;
	}

	private void subtractor(int smallNumber, int bigNumber) {

		if (romanIntegerList.contains(smallNumber) && romanIntegerList.contains(bigNumber)) {
			int indexOfBigNumber = romanIntegerList.lastIndexOf(bigNumber);
			int indexOfSmallNumber = romanIntegerList.indexOf(smallNumber);

			if (indexOfBigNumber > indexOfSmallNumber) {
				romanIntegerList.set(indexOfSmallNumber, (smallNumber * -1));
			}

		}
	}

	public int result(String romanString, boolean iscalledExternally) {

		if (iscalledExternally) {
			romanIntegerList.clear();
		}

		int result = 0;
		romanStringToInt(romanString);

		subtractor(1, 5);
		subtractor(1, 10);
		subtractor(10, 50);
		subtractor(10, 100);
		subtractor(100, 500);
		subtractor(100, 1000);

		result = romanIntegerList.stream().mapToInt(Integer::intValue).sum();

		return result;

	}
}
