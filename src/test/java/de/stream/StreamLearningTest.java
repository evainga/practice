package de.stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;

public class StreamLearningTest {
	private StreamLearning learning = new StreamLearning();

	@Test
	public void playAroundTest() throws Exception {
		assertThat(learning.playAround(), hasSize(1));
	}

	@Test
	public void streamAlphabetTest() throws Exception {
		assertThat(learning.streamAlphabet(), hasSize(26));
		assertThat(learning.streamAlphabet(), hasItem('A'));
		assertThat(learning.streamAlphabet(), hasItem('Z'));
	}

	@Test
	public void addAToAlphabetTest() throws Exception {
		assertThat(learning.addAToAlphabetTest(), hasSize(26));
		assertThat(learning.addAToAlphabetTest(), hasItem("AA"));
		assertThat(learning.addAToAlphabetTest(), hasItem("ZA"));
	}

}
