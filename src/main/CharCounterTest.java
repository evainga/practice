package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CharCounterTest {

	CharCounter charCounter = new CharCounter();

	@Test
	public void countChars() {
		assertThat(charCounter.countChars("hallllooo"),
				allOf(hasEntry('h', 1), hasEntry('a', 1), hasEntry('l', 4), hasEntry('o', 3)));
		assertThat(charCounter.countChars("hallooolloo"),
				allOf(hasEntry('h', 1), hasEntry('a', 1), hasEntry('l', 4), hasEntry('o', 5)));
		assertThat(charCounter.countChars("Das darf nicht sein"),
				allOf(hasEntry('D', 1), hasEntry('a', 2), hasEntry('s', 2), hasEntry(' ', 3), hasEntry('d', 1),
						hasEntry('r', 1), hasEntry('f', 1), hasEntry('n', 2), hasEntry('i', 2), hasEntry('c', 1),
						hasEntry('h', 1), hasEntry('e', 1), hasEntry('t', 1)));

	}

	@DataProvider(name = "sizeProvider")
	public Object[][] createData2() {
		return new Object[][] {
				{ "hallllooo", 4 },
				{ "hallooolloo", 4 },
				{ "Das darf nicht sein", 13 },

		};
	}

	@Test(dataProvider = "sizeProvider")
	public void testSize(String string, Integer size) {
		assertThat(charCounter.countChars(string).size(),
				is(equalTo(size)));

	}

}
