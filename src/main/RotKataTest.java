package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RotKataTest {

	RotKata rotKata = new RotKata();

	@Test
	public void grossschreibung() {
		assertThat(rotKata.grossschreibung("abcDßäüöä"), is("ABCDSSAEUEOEAE"));
	}

	@DataProvider(name = "charSwitcher")
	public Object[][] createData2() {
		return new Object[][] {
				{ 'A', 3, 'D' },
				{ 'D', 3, 'G' },
				{ 'Z', 26, 'Z' },
				{ 'Z', 27, 'A' },
				{ 'Z', 28, 'B' },
				{ 'C', 140, 'M' },
				{ 'H', 13, 'U' }
		};
	}

	@Test(dataProvider = "charSwitcher")
	public void charSwitcher(char initialCharacter, int versatz, char newCharacter) {
		assertThat(rotKata.charSwitcher(initialCharacter, versatz),
				is(newCharacter));
	}

	@Test
	public void rotKataService() {
		assertThat(rotKata.rotKataService("HelloWorld", 13),
				is("URYYBJBEYQ"));
		assertThat(rotKata.rotKataService("Hello World", 13), is("URYYB JBEYQ"));
	}

	// @DataProvider(name = "toASCII")
	// public Object[][] createData1() {
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
