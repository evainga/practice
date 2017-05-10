
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class KataHappyTest {
	private KataHappy happyService = new KataHappy();

	@DataProvider(name = "happyCheck")
	public Object[][] createData1() {
		return new Object[][] {
				{ 7, true },
				{ 1, true },
				{ 0, false },
				{ 100, true },
				{ -76, false },
				{ -77, false },
				{ 8, false },
				{ 49, true }
		};
	}

	@Test
	public void returnSquareSumOfNumber() {
		assertThat(happyService.returnSquareSumOfNumber(123), is(14));
		assertThat(happyService.returnSquareSumOfNumber(-76), is(85));
		assertThat(happyService.returnSquareSumOfNumber(0), is(0));
		assertThat(happyService.returnSquareSumOfNumber(100), is(1));
		// assertThat(happy.returnSumOfNumber(Integer.MAX_VALUE), is(260));

	}

	@Test(dataProvider = "happyCheck")
	public void happyCheck(int number, boolean happy) {
		assertThat(happyService.happyCheck(number, true), is(happy));
	}

}
