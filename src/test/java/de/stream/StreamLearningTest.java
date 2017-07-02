package de.stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

public class StreamLearningTest {
	private StreamLearning learning = new StreamLearning();

	@Test
	public void playAroundTest() {
		assertThat(learning.playAround(), hasSize(1));
	}

	@Test
	public void streamAlphabetTest() {
		assertThat(learning.streamAlphabet(), hasSize(26));
		assertThat(learning.streamAlphabet(), hasItem('A'));
		assertThat(learning.streamAlphabet(), hasItem('Z'));
	}

	@Test
	public void addAToAlphabetTest() {
		assertThat(learning.addAToAlphabetTest(), hasSize(26));
		assertThat(learning.addAToAlphabetTest(), hasItem("AA"));
		assertThat(learning.addAToAlphabetTest(), hasItem("ZA"));
	}

	@Test
	public void getFilteredHighHeels38() {
		assertThat(learning.filterHighheels38(), hasSize(2));
		assertThat(learning.filterHighheels38().get(0).getColor(), is("black"));
		assertThat(learning.filterHighheels38().get(1).getColor(), is("red"));
	}

	@Test
	public void makeNewShoesInMySize() {
		assertThat(learning.makeNewShoesInMySize(), hasSize(5));
		assertThat(learning.makeNewShoesInMySize().get(1).getColor(), is("red"));
		assertThat(learning.makeNewShoesInMySize().get(1).getSize(), is(38));
		assertThat(learning.makeNewShoesInMySize().get(1).isHighHeel(), is(false));

	}
}
