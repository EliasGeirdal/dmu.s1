package model;

import java.util.ArrayList;

public class Ledsager {
	// instance variable
	private String navn;
	// instance variables.
	private ArrayList<Udflugt> udflugter;
	private Tilmelding tilmelding;

	public Ledsager(String navn) {
		// instance
		this.navn = navn;
		// link
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

	public void removeUdflugt(Udflugt udflugt) {
		if (udflugter.contains(udflugt)) {
			udflugter.add(udflugt);
			udflugt.removeLedsager(this);
		}
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}

	// ----------------instance--------------------
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Tilmelding getTilmelding() {
		return tilmelding;
	}

	public void setTilmelding(Tilmelding tilmelding) {
		if (tilmelding != null) {
			if (this.tilmelding != tilmelding) {
				this.tilmelding = tilmelding;
				tilmelding.setLedsager(this);
			}
		}
	}

	@Override
	public String toString() {
		return navn + "(" + tilmelding.getDeltager() + ")";
	}
}
