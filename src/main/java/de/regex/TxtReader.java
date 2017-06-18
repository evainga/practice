package de.regex;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TxtReader {
	public String txtToString() throws IOException {
		String filename = TxtReader.class.getResource("/guest-and-host.txt").getFile();
		return FileUtils.readFileToString(new File(filename), "UTF-8");
	}
}
