package de.regex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;

import java.io.IOException;

import org.testng.annotations.Test;

public class TxtReaderTest {
	private TxtReader fileReader = new TxtReader();
	private String filePath = "/guest-and-host.txt";

	@Test
	public void txtToString() throws IOException {
		assertThat(fileReader.txtToString(filePath), startsWith("4. The Master ascended the high seat."));
		assertThat(fileReader.txtToString(filePath),
				endsWith("Rinzai‘s (Linji) host and guest, ask the head monks of the two halls."));
	}

	@Test
	public void findAllWords() throws IOException {
		String allWords = "[\\p{L}‘]+";
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, filePath), hasSize(168));
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, filePath), hasItem("Heshang"));
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, filePath), hasItem("you‘d"));
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, filePath), hasItem("Rinzai‘s"));
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, filePath), hasItem("Oshô"));
	}

	@Test
	public void startsWithUpperCaseTest() throws IOException {
		String startsWithUpperCase = "[\\p{Lu}]([\\p{L}‘])*";
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, filePath), hasItem("Heshang"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, filePath), hasItem("Rinzai‘s"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, filePath), hasItem("Oshô"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, filePath), not(hasItem("the")));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, filePath), hasSize(43));
	}

	@Test
	public void startsWithLowerCaseMTest() throws IOException {
		String startsWithLowerCaseM = "\\bm([\\p{L}‘])*";
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, filePath), not(hasItem("Master")));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, filePath),
				not(hasItem("mmediately")));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, filePath), hasItem("me"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, filePath), hasItem("monks"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, filePath), hasSize(16));
	}

	@Test
	public void hasFourLettersTest() throws IOException {
		String hasFourLetters = "\\b[\\p{L}‘]{4}\\b";
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, filePath), not(hasItem("Mast")));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, filePath), hasItem("high"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, filePath), hasItem("came"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, filePath), hasItem("monk"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, filePath), not(hasItem("mday,")));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, filePath), hasItem("Oshô"));
		// assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters,
		// filePath), hasItem("It‘s"));
		// assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters,
		// filePath), not(hasItem("you‘")));
		// assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters,
		// filePath), hasSize(41));
		// to be fixed
	}

	@Test
	public void endsWithEdTest() throws IOException {
		String endsWithEd = "([\\p{L}‘])*ed\\b";
		assertThat(fileReader.findRegExMatchingStringsInText(endsWithEd, filePath), hasItem("ascended"));
		assertThat(fileReader.findRegExMatchingStringsInText(endsWithEd, filePath), not(hasItem("immed")));
		assertThat(fileReader.findRegExMatchingStringsInText(endsWithEd, filePath), hasSize(14));
	}

	@Test
	public void hasALetterTest() throws IOException {
		String hasALetter = "([\\p{L}‘])*a([\\p{L}‘])*";
		assertThat(fileReader.findRegExMatchingStringsInText(hasALetter, filePath), hasItem("Heshang"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasALetter, filePath), hasItem("a"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasALetter, filePath), not(hasItem("Another")));
		assertThat(fileReader.findRegExMatchingStringsInText(hasALetter, filePath), hasSize(62));
	}

	@Test
	public void getNumericsTest() throws IOException {
		String numerics = "\\d";
		assertThat(fileReader.findRegExMatchingStringsInText(numerics, filePath), contains("4"));
		assertThat(fileReader.findRegExMatchingStringsInText(numerics, filePath), hasSize(1));
	}

	@Test
	public void hasCommaTest() throws IOException {
		String hasComma = ", ";
		assertThat(fileReader.findRegExMatchingStringsInText(hasComma, filePath), hasItem(", "));
		assertThat(fileReader.findRegExMatchingStringsInText(hasComma, filePath), hasSize(15));
	}

}
