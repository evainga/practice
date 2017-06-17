package de.smallStuff;

public class PrimzahlCheck {

	public boolean primzahlCheck(int zahl) {
		if (zahl < 2) {
			validNumber(zahl);
			return false;
		} else
			return primzahlCheck(zahl, zahl - 1);
	}

	public String validNumber(int zahl) {
		return "Please insert a natural number higher than 1";
	}

	public boolean primzahlCheck(int zahl, int hilfsZahl) {
		if (hilfsZahl == 1)
			return true;
		if (zahl % hilfsZahl == 0)
			return false;
		else {
			return primzahlCheck(zahl, hilfsZahl - 1);
		}
	}
}
