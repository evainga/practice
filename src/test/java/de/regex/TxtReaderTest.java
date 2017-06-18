package de.regex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.testng.annotations.Test;

public class TxtReaderTest {

	TxtReader filereader = new TxtReader();

	@Test
	public void txtToString() throws IOException {
		assertThat(filereader.txtToString(), is("mu"));
	}
}
