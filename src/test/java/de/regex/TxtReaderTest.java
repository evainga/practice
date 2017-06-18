package de.regex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import java.io.IOException;

import org.testng.annotations.Test;

public class TxtReaderTest {

	private TxtReader filereader = new TxtReader();

	@Test
	public void txtToString() throws IOException {
		assertThat(filereader.txtToString(), startsWith("4. The Master ascenden the high seat."));
	}
}
