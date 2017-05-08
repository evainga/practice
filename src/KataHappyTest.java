
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

public class KataHappyTest {
	private KataHappy happy = new KataHappy();

	@Test
	public void returnSquareSumOfNumber() {
		assertThat(happy.returnSquareSumOfNumber(123), is(14));
		assertThat(happy.returnSquareSumOfNumber(-76), is(85));
		assertThat(happy.returnSquareSumOfNumber(0), is(0));
		assertThat(happy.returnSquareSumOfNumber(100), is(1));
		// assertThat(happy.returnSumOfNumber(Integer.MAX_VALUE), is(260));

	}

	@Test
	public void happyCheck() {
		assertThat(happy.happyCheck(7, true), is(true));
		assertThat(happy.happyCheck(1, true), is(true));
		assertThat(happy.happyCheck(0, true), is(false));
		assertThat(happy.happyCheck(100, true), is(true));
		assertThat(happy.happyCheck(-76, true), is(false));
		assertThat(happy.happyCheck(-77, true), is(false));
		assertThat(happy.happyCheck(8, true), is(false));
		assertThat(happy.happyCheck(49, true), is(true));

		// test

	}

}
