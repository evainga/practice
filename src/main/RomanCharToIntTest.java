package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RomanCharToIntTest {

	private RomanCharToInt intNumber = new RomanCharToInt();

	@DataProvider(name = "romanCharToInt")
	public Object[][] createData1() {
		return new Object[][] {
				{ 'I', 1 },
				{ 'V', 5 },
				{ 'X', 10 },
				{ 'L', 50 },
				{ 'C', 100 },
				{ 'D', 500 },
				{ 'M', 1000 },
				{ 'A', 0 },
				{ 'Z', 0 },

		};
	}

	@Test(dataProvider = "romanCharToInt")
	public void romanCharToInt(char romanChar, int decimal) {
		assertThat(intNumber.romanCharToInt(romanChar), is(decimal));
	}
}
