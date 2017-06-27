package de.regex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class TxtReaderTest {
	private TxtReader fileReader = new TxtReader();
	private String filePath = "/guest-and-host.txt";

	private String txtToString(String filePath) throws IOException {
		String filename = TxtReader.class.getResource(filePath).getFile();
		return FileUtils.readFileToString(new File(filename), "UTF-8");
	}

	@Test
	public void txtToString() throws IOException {
		assertThat(txtToString(filePath), startsWith("4. The Master ascended the high seat."));
		assertThat(txtToString(filePath),
				endsWith("Rinzai‘s (Linji) host and guest, ask the head monks of the two halls."));
	}

	@Test
	public void findAllWords() throws IOException {
		String allWords = "[\\p{L}‘]+";
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, txtToString(filePath)), hasSize(168));
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, txtToString(filePath)), hasItem("Heshang"));
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, txtToString(filePath)), hasItem("you‘d"));
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, txtToString(filePath)), hasItem("Rinzai‘s"));
		assertThat(fileReader.findRegExMatchingStringsInText(allWords, txtToString(filePath)), hasItem("Oshô"));
	}

	@Test
	public void startsWithUpperCaseTest() throws IOException {
		String startsWithUpperCase = "[\\p{Lu}]([\\p{L}‘])*";
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, txtToString(filePath)),
				hasItem("Heshang"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, txtToString(filePath)),
				hasItem("Rinzai‘s"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, txtToString(filePath)),
				hasItem("Oshô"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, txtToString(filePath)),
				not(hasItem("the")));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithUpperCase, txtToString(filePath)), hasSize(43));
	}

	@Test
	public void startsWithLowerCaseMTest() throws IOException {
		String startsWithLowerCaseM = "\\bm([\\p{L}‘])*";
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, txtToString(filePath)),
				not(hasItem("Master")));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, txtToString(filePath)),
				not(hasItem("mmediately")));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, txtToString(filePath)),
				hasItem("me"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, txtToString(filePath)),
				hasItem("monks"));
		assertThat(fileReader.findRegExMatchingStringsInText(startsWithLowerCaseM, txtToString(filePath)), hasSize(16));
	}

	@Test
	public void hasFourLettersTest() throws IOException {
		String hasFourLetters = "(?<=\\W)(\\p{L}(‘)?){3}\\p{L}(?=\\W)";
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)),
				not(hasItem("It‘s")));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)),
				not(hasItem("Mast")));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)), hasItem("high"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)), hasItem("came"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)), hasItem("monk"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)),
				not(hasItem("mday,")));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)), hasItem("Oshô"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)),
				not(hasItem("you‘")));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)),
				hasItem("you‘d"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasFourLetters, txtToString(filePath)), hasSize(42));
		// solution if "It's" and not "you'd" is seen as four letters:
		// "(?<=\\W)([\\p{L}‘]{4})(?=\\W)"
	}

	@Test
	public void endsWithEdTest() throws IOException {
		String endsWithEd = "([\\p{L}‘])*ed\\b";
		assertThat(fileReader.findRegExMatchingStringsInText(endsWithEd, txtToString(filePath)), hasItem("ascended"));
		assertThat(fileReader.findRegExMatchingStringsInText(endsWithEd, txtToString(filePath)), not(hasItem("immed")));
		assertThat(fileReader.findRegExMatchingStringsInText(endsWithEd, txtToString(filePath)), hasSize(14));
	}

	@Test
	public void hasALetterTest() throws IOException {
		String hasALetter = "([\\p{L}‘])*a([\\p{L}‘])*";
		assertThat(fileReader.findRegExMatchingStringsInText(hasALetter, txtToString(filePath)), hasItem("Heshang"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasALetter, txtToString(filePath)), hasItem("a"));
		assertThat(fileReader.findRegExMatchingStringsInText(hasALetter, txtToString(filePath)),
				not(hasItem("Another")));
		assertThat(fileReader.findRegExMatchingStringsInText(hasALetter, txtToString(filePath)), hasSize(62));
	}

	@Test
	public void getNumericsTest() throws IOException {
		String numerics = "\\d";
		assertThat(fileReader.findRegExMatchingStringsInText(numerics, txtToString(filePath)), contains("4"));
		assertThat(fileReader.findRegExMatchingStringsInText(numerics, txtToString(filePath)), hasSize(1));
	}

	@Test
	public void hasCommaTest() throws IOException {
		String hasComma = ", ";
		assertThat(fileReader.findRegExMatchingStringsInText(hasComma, txtToString(filePath)), hasItem(", "));
		assertThat(fileReader.findRegExMatchingStringsInText(hasComma, txtToString(filePath)), hasSize(15));
	}

}
