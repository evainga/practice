package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class KataHappy {

	private List<Integer> numbers = new ArrayList<Integer>();

	public int returnSquareSumOfNumber(int number) {
		number = Math.abs(number);
		int length = String.valueOf(number).length();
		int[] array = new int[length];
		String stringNumber = Integer.toString(number);
		for (int i = 0; i < length; i++) {
			int intNumber = Character.getNumericValue(stringNumber.charAt(i));
			array[i] = intNumber * intNumber;
		}
		return IntStream.of(array).sum();
	}

	public boolean happyCheck(int number, boolean iscalledExternally) {
		if (iscalledExternally) {
			numbers.clear();
		}

		if (number == 1)
			return true;
		int squareSum = returnSquareSumOfNumber(number);

		if (numbers.contains(squareSum))
			return false;
		else {
			numbers.add(squareSum);
			return happyCheck(squareSum, false);
		}

	}

}
