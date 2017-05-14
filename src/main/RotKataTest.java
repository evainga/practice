package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RotKataTest {

	RotKata rotKata = new RotKata();

	@Test
	public void upperCaseAndFormat() {
		assertThat(rotKata.upperCaseAndFormat("abcDßäüöä"), is("ABCDSSAEUEOEAE"));
	}

	@DataProvider(name = "charSwitcher")
	public Object[][] createData1() {
		return new Object[][] {
				{ 'A', 3, 'D' },
				{ 'D', 3, 'G' },
				{ 'Z', 26, 'Z' },
				{ 'Z', 27, 'A' },
				{ 'Z', 28, 'B' },
				{ 'C', 140, 'M' },
				{ 'H', 13, 'U' },
				{ 'V', 13, 'I' },
				{ '.', 13, '.' }
		};
	}

	@Test(dataProvider = "charSwitcher")
	public void charSwitcher(char oldChar, int shiftNumber, char newChar) {
		assertThat(rotKata.charSwitcher(oldChar, shiftNumber),
				is(newChar));
	}

	@DataProvider(name = "encrypter")
	public Object[][] createData2() {
		return new Object[][] {
				{ "HelloWorld", 13, "URYYBJBEYQ" },
				{ "Hello World", 13, "URYYB JBEYQ" },
				{ "Hello, World!", 13, "URYYB, JBEYQ!" },
				{ "übungs ding!&", 27, "VFCVOHT EJOH!&" },

		};
	}

	@Test(dataProvider = "encrypter")
	public void encrypter(String oldWord, int shiftNumber, String newWord) {
		assertThat(rotKata.encrypter(oldWord, shiftNumber),
				is(newWord));

	}

	// @DataProvider(name = "toASCII")
	// public Object[][] createData3() {
	// return new Object[][] {
	// { 'A', 65 },
	// { 'B', 66 },
	// { 'Z', 90 },
	// { 'Ä', 196 },
	// { 'Ü', 220 },
	// { 'Ö', 214 },
	// { 'ß', 223 }
	// };
	// }

	// @Test(dataProvider = "toASCII")
	// public void toASCII(char character, int ascii) {
	// assertThat(rotKata.toASCII(character), is(ascii));
	// }

}
