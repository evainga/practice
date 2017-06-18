package de.regex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;

import java.io.IOException;

import org.testng.annotations.Test;

public class TxtReaderTest {
	private TxtReader fileReader = new TxtReader();

	@Test
	public void txtToString() throws IOException {
		assertThat(fileReader.txtToString(), startsWith("4. The Master ascended the high seat."));
		assertThat(fileReader.txtToString(),
				endsWith("Rinzai‘s (Linji) host and guest, ask the head monks of the two halls."));
	}
}
