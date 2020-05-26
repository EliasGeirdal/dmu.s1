package model;

public class Bil {
	private String regNr;
	private Bilmærke bilmærke;

	/**
	 * Initialize a car with registreringsnummer.
	 * 
	 * @param regNr
	 */
	public Bil(String regNr) {
		super();
		this.regNr = regNr;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public Bilmærke getBilmærke() {
		return bilmærke;
	}

	public void setBilmærke(Bilmærke bilmærke) {
		this.bilmærke = bilmærke;
	}

	@Override
	public String toString() {
		return regNr + ", " + bilmærke;
	}

}
