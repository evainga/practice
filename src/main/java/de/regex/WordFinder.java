package de.regex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordFinder {

	private TxtReader fileReader = new TxtReader();

	public List<String> getWords(String string) {
		string = string.replaceAll("[^\\wô‘ ]", "");
		return Arrays.asList(string.split("\\s+"));
	}

	public List<String> txtToWordList() throws IOException {
		return getWords(fileReader.txtToString(fileReader.filepath));
	}

	public List<String> getWordsThatStartWithUpperCase() throws IOException {
		List<String> allWords = txtToWordList();
		RegEx regex = new RegEx();
		List<String> filteredWords = new ArrayList<>();
		for (int i = 0; i < allWords.size(); i++) {
			if (regex.startsWithUpperCase(allWords.get(i))) {
				filteredWords.add(allWords.get(i));
			}
		}
		return filteredWords;
	}

}
