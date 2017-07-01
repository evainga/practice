package de.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtReader {

	public List<String> findRegExMatchingStringsInText(String regEx, String text) {

		List<String> matchList = new ArrayList<>();
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			matchList.add(matcher.group());
		}
		return matchList;
	}

}
