package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PrimzahlCheckTest {

	private PrimzahlCheck primzahlService = new PrimzahlCheck();

	@DataProvider(name = "primzahlCheck")
	public Object[][] createData1() {
		return new Object[][] {
				{ 1, false },
				{ 2, true },
				{ 3, true },
				{ 4, false },
				{ 5, true },
				{ 6, false },
				{ 7, true },
				{ 8, false },
				{ 9, false },
				{ 10, false },
				{ 11, true },
				{ 12, false },
				{ 13, true },
				{ 19, true },
				{ 47, true },
				{ 100, false },
				{ -10, false },
				{ -14, false },
				{ -17, false }

		};
	}

	@Test(dataProvider = "primzahlCheck")
	public void primzahl(int number, boolean primzahl) {
		assertThat(primzahlService.primzahlCheck(number), is(primzahl));

	}

	@DataProvider(name = "validNumber")
	public Object[] createData2() {
		return new Object[] {
				1,
				-10,
				-17,
				-4
		};
	}

	@Test(dataProvider = "validNumber")
	public void validNumber(int number) {
		assertThat(primzahlService.validNumber(number), is("Please insert a natural number higher than 1"));
	}

}
