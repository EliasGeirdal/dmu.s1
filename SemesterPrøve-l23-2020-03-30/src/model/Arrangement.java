package model;

import java.util.ArrayList;

public class Arrangement {

	private String navn;
	private boolean offentlig;
	private ArrayList<Reservation> reservationer;

	public Arrangement(String navn, boolean offentlig) {
		this.navn = navn;
		this.offentlig = offentlig;
		this.reservationer = new ArrayList<>();
	}

	public int antalReserveredePladser() {
		int antal = 0;
		for (Reservation reservationer : reservationer) {
			antal += reservationer.getPladser().size();
		}
		return antal;
	}

	public void addReservation(Reservation reservation) {
		if (!reservationer.contains(reservation))
			reservationer.add(reservation);
	}

	public void removeReservation(Reservation reservation) {
		if (reservationer.contains(reservation))
			reservationer.remove(reservation);
	}

	public ArrayList<Reservation> getReservationer() {
		return new ArrayList<Reservation>(reservationer);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public boolean isOffentlig() {
		return offentlig;
	}

	public void setOffentlig(boolean offentlig) {
		this.offentlig = offentlig;
	}
}
