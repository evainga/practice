package de.stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

public class ShoePairTest {
	@Test
	public void allArgsConstructor() {
		ShoePair shoepair = new ShoePair("red", 40, true);
		shoepair.setColor("blue");
		assertThat(shoepair.getColor(), is("blue"));
		assertThat(shoepair.getSize(), is(40));
		assertThat(shoepair.isHighHeel(), is(true));
	}
}
