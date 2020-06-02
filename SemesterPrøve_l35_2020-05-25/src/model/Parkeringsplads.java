package model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Parkeringsplads {
	// instance variables
	private int nummer;
	private LocalTime ankomst;
	private double saldo;
	private final double PRIS_PR_10_MIN = 6;
	// link attributes
	private Parkeringshus parkeringshus;
	private Bil bil; // nullable

	// Initialise parking spot with arrival set to null. (will be set when car is
	// assigned)
	/**
	 * Constructs parkeringsplads with arrival set to null (will be set when car is
	 * assigned).
	 * 
	 * @param nummer pladsnummer.
	 */
	public Parkeringsplads(int nummer) { //
		super();
		this.nummer = nummer;
		this.ankomst = null;
	}

	/**
	 * Removes car from parkingsplads and updates saldo.
	 * 
	 * @param afgangstidspunkt
	 */
	public void hentBil(LocalTime afgangstidspunkt) {
		if (!bil.equals(null)) {
			saldo += beregnPris(afgangstidspunkt);
			bil = null;
		}
	}

	/**
	 * Calculates price of parking.
	 * 
	 * @param afgangstidspunkt Time of departure.
	 * @return price.
	 */
	public double beregnPris(LocalTime afgangstidspunkt) {
		double pris = -1;
		if (!bil.equals(null)) {
			long minutesBetween = ChronoUnit.MINUTES.between(ankomst, afgangstidspunkt);
			pris = (minutesBetween / 10) * PRIS_PR_10_MIN;
		}
		return pris;
	}

	public Bil getBil() {
		return bil;
	}

	public void setBil(Bil bil) {
		if (this.bil != bil) {
			this.bil = bil;
			ankomst = LocalTime.now();
		}
	}

	/**
	 * Sets parkeringshus and updates both sides of aggregation.
	 * 
	 * @param parkeringshus cannot be null
	 */
	public void setParkeringshus(Parkeringshus parkeringshus) {
		if (this.parkeringshus != parkeringshus) {
			// TODO
			Parkeringshus oldPhus = this.parkeringshus;
			if (oldPhus != null) {
				oldPhus.removeParkeringsplads(this);
			}
			this.parkeringshus = parkeringshus;
		}
	}

	/**
	 * Removes parkeringshus.
	 */
	public void removeParkeringshus(Parkeringshus parkeringshus) {
		if (this.parkeringshus.equals(parkeringshus)) {
			this.parkeringshus = null;
			parkeringshus.removeParkeringsplads(this);
		}
	}

	public Parkeringshus getParkeringshus() {
		return parkeringshus;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public LocalTime getAnkomst() {
		return ankomst;
	}

	public void setAnkomst(LocalTime ankomst) {
		this.ankomst = ankomst;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Plads " + nummer + ": " + bil;
	}

}
