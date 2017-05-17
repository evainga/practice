
package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RomanStringToIntTest {

	private RomanStringToInt intNumber = new RomanStringToInt();

	@DataProvider(name = "romanStringToInt")
	public Object[][] createData1() {
		return new Object[][] {
				{ "MDCCCCLXXXIIII", 1984 },
				{ "XXXV", 35 },
				{ "MMMMMDDDII", 6502 },
		};
	}

	@Test(dataProvider = "romanStringToInt")
	public void romanStringToInt(String romanNumber, int decimal) {
		assertThat(intNumber.romanStringToInt(romanNumber), is(decimal));
	}
}
