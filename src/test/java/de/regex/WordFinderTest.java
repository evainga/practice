package de.regex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import java.io.IOException;

import org.testng.annotations.Test;

public class WordFinderTest {

	private WordFinder wordFinder = new WordFinder();

	@Test
	public void getWords() {
		assertThat(wordFinder.getWords("Ich bin ein Berliner."), contains("Ich", "bin", "ein", "Berliner"));
		assertThat(wordFinder.getWords("Ich bin ein Berliner."), hasSize(4));
		assertThat(
				wordFinder.getWords(
						"4. The Master seat. A monk low. shouted. said, ―Venerable Oshô (Heshang), you‘d BuddhaDharma? Rinzai‘s (Linji) "),
				contains("4", "The", "Master", "seat", "A", "monk", "low",
						"shouted", "said", "Venerable", "Oshô", "Heshang", "you‘d", "BuddhaDharma", "Rinzai‘s",
						"Linji"));
	}

	@Test
	public void txtToWordList() throws IOException {
		assertThat(wordFinder.txtToWordList(), hasSize(169));
		assertThat(wordFinder.txtToWordList(), hasItem("Heshang"));
		assertThat(wordFinder.txtToWordList(), hasItem("you‘d"));
	}

	@Test
	public void getUpperCaseWords() throws IOException {
		assertThat(wordFinder.getWordsThatStartWithUpperCase(), hasSize(43));
		assertThat(wordFinder.getWordsThatStartWithUpperCase(), hasItem("Heshang"));
		assertThat(wordFinder.getWordsThatStartWithUpperCase(), hasItem("Rinzai‘s"));
		assertThat(wordFinder.getWordsThatStartWithUpperCase(), hasItem("Oshô"));
		// check with Marco why not options are also green here
		assertThat(wordFinder.getWordsThatStartWithUpperCase(), hasItem(not("the")));
	}

}
