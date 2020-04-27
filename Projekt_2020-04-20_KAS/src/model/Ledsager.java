package model;

import java.util.ArrayList;

public class Ledsager {
	// instance variable
	private String navn;
	// instance variables.
	private ArrayList<Udflugt> udflugter;

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

}
