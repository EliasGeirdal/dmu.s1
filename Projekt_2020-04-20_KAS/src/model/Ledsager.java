package model;

import java.util.ArrayList;

public class Ledsager {
	// instance variable
	private String navn;
	// link variables
	private Tilmelding tilmelding;
	private ArrayList<Udflugt> udflugter;

	public Ledsager(String navn, Tilmelding tilmelding) {
		super();
		// instance
		this.navn = navn;
		// link
		this.tilmelding = tilmelding;
		udflugter = new ArrayList<>();
	}

	/**
	 * returns the price of accumulated udflugt prices.
	 * 
	 * @return sum of udflugt prices.
	 */
	public double beregnPrisForUdflugter() {
		double sum = 0;
		for (Udflugt udflugt : udflugter) {
			sum += udflugt.getPris();
		}
		return sum;
	}

	// ---------------udflugt-----------------------

	public void addUdflugt(Udflugt udflugt) {
		if (!udflugter.contains(udflugt)) {
			udflugter.add(udflugt);
			udflugt.addLedsager(this);
		}
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}

	// -----------tilmelding------------------
	public Tilmelding getTilmelding() {
		return tilmelding;
	}

	public void setTilmelding(Tilmelding tilmelding) {
		this.tilmelding = tilmelding;
	}

	// ----------------instance--------------------
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

}
