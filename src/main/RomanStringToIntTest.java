
package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RomanStringToIntTest {

	private RomanStringToInt romanStringToInt = new RomanStringToInt();

	@DataProvider(name = "romanStringToInt")
	public Object[][] createData1() {
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
		};
	}

	@Test(dataProvider = "romanStringToInt")
	public void romanStringToInt(String romanNumber, int decimal) {
		assertThat(romanStringToInt.result(romanNumber, true), is(decimal));
	}
}
