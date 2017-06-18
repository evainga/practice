package de.regex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

public class RegExTest {

	RegEx word = new RegEx();

	@Test
	public void upperCase() {
		assertThat(word.startsWithUpperCase("Beispiel"), is(true));
		assertThat(word.startsWithUpperCase("BSP"), is(true));
		assertThat(word.startsWithUpperCase("beispielhaft"), is(false));
		assertThat(word.startsWithUpperCase(" beispielhaft"), is(false));
	}

	@Test
	public void lowerCaseM() {
		assertThat(word.startsWithLowerCaseM("Beispiel"), is(false));
		assertThat(word.startsWithLowerCaseM("Motivation"), is(false));
		assertThat(word.startsWithLowerCaseM("monDay"), is(true)); // evtl
																	// nochanpassen
		assertThat(word.startsWithLowerCaseM(" monday"), is(false));
	}

	@Test
	public void fourLetters() {
		assertThat(word.hasFourLetters("Haus"), is(true));
		assertThat(word.hasFourLetters("12dr"), is(false));
		assertThat(word.hasFourLetters("HAUS"), is(true));
		assertThat(word.hasFourLetters("hauS"), is(true)); // evtl noch anpassen
		assertThat(word.hasFourLetters("Häuser"), is(false));
		assertThat(word.hasFourLetters("Häu"), is(false));
	}

	@Test
	public void endsWithEd() {
		assertThat(word.endsWithEd("played"), is(true));
		assertThat(word.endsWithEd("Googled"), is(true));
		assertThat(word.endsWithEd("Ed"), is(false));
		assertThat(word.endsWithEd("ed"), is(true));
		assertThat(word.endsWithEd("Leder"), is(false));
	}

	@Test
	public void hasALetter() {
		assertThat(word.hasALetter("played"), is(true));
		assertThat(word.hasALetter("Googled"), is(false));
		assertThat(word.hasALetter("Ad"), is(false));
		assertThat(word.hasALetter("Ada"), is(true));
		assertThat(word.hasALetter("Alaaf"), is(true));
	}

	// @Test
	// public void isNumber() {
	// assertThat(word.isNumber("1"), is(true));
	// assertThat(word.isNumber("12"), is(true));
	// assertThat(word.isNumber("13d"), is(true));
	// assertThat(word.isNumber("1haus"), is(true));
	// assertThat(word.isNumber("chap1"), is(true));
	// assertThat(word.isNumber("chap"), is(false));
	// }
}
