package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
	private LocalDateTime start;
	private LocalDateTime slut;
	private ArrayList<Plads> pladser;

	public Reservation(LocalDateTime start, LocalDateTime slut) {
		this.start = start;
		this.slut = slut;
		this.pladser = new ArrayList<>();
	}

	public void addPlads(Plads plads) {
		if (!pladser.contains(plads)) {
			pladser.add(plads);
			plads.addReservation(this);
		}
	}

	public void removePlads(Plads plads) {
		if (pladser.contains(plads)) {
			pladser.remove(plads);
			plads.removeReservation(this);
		}
	}

	public ArrayList<Plads> getPladser() {
		return new ArrayList<Plads>(pladser);
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getSlut() {
		return slut;
	}

}
