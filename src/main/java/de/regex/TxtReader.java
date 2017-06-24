package de.regex;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class TxtReader {

	public String txtToString(String filePath) throws IOException {
		String filename = TxtReader.class.getResource(filePath).getFile();
		return FileUtils.readFileToString(new File(filename), "UTF-8");
	}

	public List<String> findRegExMatchingStringsInText(String regEx, String filePath) throws IOException {

		List<String> matchList = new ArrayList<>();
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(txtToString(filePath));

		while (matcher.find()) {
			matchList.add(matcher.group());
		}
		return matchList;
	}

}
