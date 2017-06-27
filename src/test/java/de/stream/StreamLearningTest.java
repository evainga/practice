package de.stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;

public class StreamLearningTest {
	private StreamLearning learning = new StreamLearning();

	@Test
	public void playAround() throws Exception {
		assertThat(learning.playAround(), hasSize(1));
	}
}
