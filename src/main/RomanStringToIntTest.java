
package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RomanStringToIntTest {

	private RomanStringToInt romanStringToInt = new RomanStringToInt();

	@DataProvider(name = "romanStringToIntList")
	public Object[][] createData1() {
		return new Object[][] {
				{ "I", Arrays.asList(1) },
				{ "II", Arrays.asList(1, 1) },
				{ "IV", Arrays.asList(1, 5) },
				{ "XLI", Arrays.asList(10, 50, 1) },
				{ "XLIX", Arrays.asList(10, 50, 1, 10) },
				{ "XCVII", Arrays.asList(10, 100, 5, 1, 1) },
				{ "CMLXXIX", Arrays.asList(100, 1000, 50, 10, 10, 1, 10) },
				{ "MCMLXXXIV", Arrays.asList(1000, 100, 1000, 50, 10, 10, 10, 1, 5) },
		};
	}

	@Test(dataProvider = "romanStringToIntList")
	public void romanStringToIntList(String romanNumber, List<Integer> intList) {
		assertThat(romanStringToInt.romanStringToIntList(romanNumber), is(intList));
	}

	@DataProvider(name = "romanStringToIntResult")
	public Object[][] createData2() {
		return new Object[][] {
				{ "I", 1 },
				{ "II", 2 },
				{ "IV", 4 },
				{ "V", 5 },
				{ "IX", 9 },
				{ "XLI", 41 },
				{ "XLII", 42 },
				{ "XLIX", 49 },
				{ "XCVII", 97 },
				{ "LXIX", 69 },
				{ "XCIX", 99 },
				{ "CMLXXIX", 979 },
				{ "MMXIII", 2013 },
				{ "MCMLXXXIV", 1984 },
				{ "BCD", 0 },
				{ "XI I", 0 },
		};
	}

	@Test(dataProvider = "romanStringToIntResult")
	public void romanStringToIntResult(String romanNumber, int decimal) {
		assertThat(romanStringToInt.romanStringToIntResult(romanNumber), is(decimal));
	}
}
