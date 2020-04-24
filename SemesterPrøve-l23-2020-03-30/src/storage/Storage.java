package storage;

import java.util.ArrayList;

import model.Arrangement;
import model.Plads;
import model.Reservation;

public class Storage {
	private static ArrayList<Arrangement> arrangementer = new ArrayList<>();
	private static ArrayList<Reservation> reservationer = new ArrayList<>();
	private static ArrayList<Plads> pladser = new ArrayList<>();

	// ----------------------------------------------------------------

	public static ArrayList<Arrangement> getArrangementer() {
		return new ArrayList<>(arrangementer);
	}

	public static void addArrangement(Arrangement arrangement) {
		arrangementer.add(arrangement);
	}

	public static void removeArrangement(Arrangement arrangement) {
		arrangementer.remove(arrangement);
	}
	// ---------------------------------------------------------------

	public static ArrayList<Reservation> getReservationer() {
		return new ArrayList<>(reservationer);
	}

	public static void addReservation(Reservation reservation) {
		reservationer.add(reservation);
	}

//	public static void removeReservation(Reservation reservation) {
//		reservationer.remove(reservation);
//	}

	// -----------------------------------------------------------
	public static ArrayList<Plads> getPladser() {
		return new ArrayList<Plads>(pladser);
	}

	public static void addPlads(Plads plads) {
		pladser.add(plads);
	}

//	public static void removePlads(Plads plads) {
//		pladser.remove(plads);
//	}
}
