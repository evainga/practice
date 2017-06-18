package de.regex;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TxtReader {

	public String txtToString() throws IOException {

		Scanner in = new Scanner(new FileReader("guest-and-host.txt"));

		StringBuilder sb = new StringBuilder();
		while (in.hasNext()) {
			sb.append(in.next());
		}
		in.close();
		String txtString = sb.toString();
		return txtString;
	}

}
