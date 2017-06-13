package romannumbers;

public class RomanCharToInt {

	public int romanCharToInt(char romanChar) {

		switch (romanChar) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;

		}
		System.out.println("This is not a valid Roman Number. Please enter a valid Number.");
		return 0;
	}

}
