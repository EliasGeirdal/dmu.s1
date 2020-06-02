package model;

import java.util.ArrayList;

public class Parkeringshus {
	// instance variables
	private String adresse;

	// link attributes
	private ArrayList<Parkeringsplads> parkeringspladser = new ArrayList<>();

	/**
	 * Constructs parkeringshus with an address.
	 * 
	 * @param adresse address of parkeringshus.
	 */
	public Parkeringshus(String adresse) {
		super();
		this.adresse = adresse;
	}

	public ArrayList<Parkeringsplads> optagnePladser() {
		ArrayList<Parkeringsplads> optagnePladser = new ArrayList<>();
		for (Parkeringsplads parkeringsplads : parkeringspladser) {
			if (parkeringsplads.getBil() != null) {
				optagnePladser.add(parkeringsplads);
			}
		}
		return new ArrayList<>(optagnePladser);
	}

	/**
	 * Returns the amount of cars with specific bilmærke.
	 * 
	 * @param bilmærke
	 * @return count of cars with specific bilmærke.
	 */
	public int findAntalBiler(Bilmærke bilmærke) {
		int count = 0;
		for (Parkeringsplads parkeringsplads : parkeringspladser) {
			if (parkeringsplads.getBil() != null && parkeringsplads.getBil().getBilmærke().equals(bilmærke)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Finds parkeringsplads containing a specific car.
	 * 
	 * @param regNummer The licence plate of the car.
	 * @return pladsnummer.
	 */
	public int findPladsMedBil(String regNummer) {
		int i = 0;
		while (i < parkeringspladser.size()) {
			Parkeringsplads p = parkeringspladser.get(i);
			if (p.getBil() != null && p.getBil().getRegNr().equals(regNummer)) { // tilføjet p.getbil()
				return parkeringspladser.get(i).getNummer();
			}
			i++;
		}
//  	Ville nedenstående ikke være lige så hurtigt?

//		for (Parkeringsplads parkeringsplads : parkeringspladser) {
//			if (parkeringsplads.getBil().getRegNr().equals(regNummer)) {
//				return parkeringsplads.getNummer();
//			}
//		}
		return -1;
	}

	/**
	 * Counts the amount of available parkeringspladser.
	 */
	public int antalLedigePladser() {
		int count = 0;
		for (Parkeringsplads parkeringsplads : parkeringspladser) {
			if (parkeringsplads.getBil().equals(null)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Creates parkeringsplads associated with parkeringshus.
	 * 
	 * @param nummer pladsnummer.
	 * @return parkeringsplads
	 */
	public Parkeringsplads createParkeringsplads(int nummer) {
		Parkeringsplads parkeringsplads = new Parkeringsplads(nummer);
		parkeringspladser.add(parkeringsplads);
		// TODO
		return parkeringsplads;
	}

	/**
	 * Creates specification of parkerings i.e. Invalideplads with an additionl
	 * attribute: Area.
	 * 
	 * @param nummer pladsnummer
	 * @param area   areal.
	 * @return invalideplads.
	 */
	public Invalideplads createInvalideplads(int nummer, double area) {
		Invalideplads invPlads = new Invalideplads(nummer, area);
		parkeringspladser.add(invPlads);
		return invPlads;

	}

	/**
	 * Remove parkeringsplads from parkeringshus
	 * 
	 */
	public void removeParkeringsplads(Parkeringsplads parkeringsplads) {
		if (parkeringspladser.contains(parkeringsplads)) {
			parkeringspladser.remove(parkeringsplads);
			parkeringsplads.removeParkeringshus(this);
		}
	}

	public ArrayList<Parkeringsplads> getParkeringspladser() {
		return new ArrayList<>(parkeringspladser);
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return adresse + "";
	}

}
