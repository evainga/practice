package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RomanNumberValidatorTest {
	RomanNumberValidator romanNumberValidator = new RomanNumberValidator();

	@DataProvider(name = "letterValidator")
	public Object[][] createData1() {
		return new Object[][] {
				{ "I", true },
				{ "X", true },
				{ "II", true },
				{ "IX", true },
				{ "XLI", true },
				{ "XLIX", true },
				{ "XCVII", true },
				{ "LXIX", true },
				{ "XCIX", true },
				{ "CMLXXIX", true },
				{ "MMXIII", true },
				{ "MCMLXXXIV", true },
				{ "CMLXXXIX", true },
				{ "LXIXA", false },
				{ "XC IX", false },
		};
	}

	@Test(dataProvider = "letterValidator")
	public void romanNumberValidator(String romanNumber, boolean valid) {
		assertThat(romanNumberValidator.validateLetters(romanNumber), is(valid));
	}

	// other cases to be validated
	// { "MMXIIIM", false },
	// { "MCMLXXXXIV", false },
}
