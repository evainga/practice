package de.regex;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TxtReader {

	String filepath = "/guest-and-host.txt";

	public String txtToString(String filepath) throws IOException {
		this.filepath = filepath;
		String filename = TxtReader.class.getResource(filepath).getFile();
		return FileUtils.readFileToString(new File(filename), "UTF-8");
	}

	// public String getfilePath(){
	// return "/guest-and-host.txt";
	// }
}
