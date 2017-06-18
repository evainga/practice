package de.regex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordFinder {

	List<String> getWords(String string) {
		string = string.replaceAll("[^\\wô‘ ]", "");
		List<String> wordList = new ArrayList<String>(Arrays.asList(string.split("\\s+")));
		return wordList;
	}

	List<String> txtToWordList() throws IOException {
		TxtReader fileReader = new TxtReader();
		return getWords(fileReader.txtToString());
	}

	List<String> getWordsThatStartWithUpperCase() throws IOException {
		List<String> oldList = txtToWordList();
		RegEx regex = new RegEx();
		List<String> filteredList = new ArrayList<String>();
		for (int i = 0; i < oldList.size(); i++) {
			if (regex.startsWithUpperCase(oldList.get(i))) {
				filteredList.add(oldList.get(i));
			}
		}
		return filteredList;
	}

}
