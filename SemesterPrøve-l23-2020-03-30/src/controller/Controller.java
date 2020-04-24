package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Arrangement;
import model.Område;
import model.Plads;
import model.Reservation;
import storage.Storage;

public class Controller {
	public static Arrangement createArrangement(String navn, boolean offentlig) {
		Arrangement arrangement = new Arrangement(navn, offentlig);
		Storage.addArrangement(arrangement);
		return arrangement;
	}

	public static void addReservationToArrangement(Arrangement arrangement, Reservation reservation) {
		arrangement.addReservation(reservation);
	}

	public static ArrayList<Arrangement> getArrangementer() {
		return Storage.getArrangementer();
	}

	// -------------------------------------------------------------

	public static Reservation createReservation(LocalDateTime start, LocalDateTime slut) {
		Reservation reservation = new Reservation(start, slut);
		Storage.addReservation(reservation);
		return reservation;
	}

	public static void addReservationToPlads(Plads plads, Reservation reservation) {
		plads.addReservation(reservation);
	}

	public static ArrayList<Reservation> getReservationer() {
		return Storage.getReservationer();
	}

	// -----------------------------------------------------------------
	public static Plads createPlads(int nr, Område område) {
		Plads plads = new Plads(nr, område);
		Storage.addPlads(plads);
		return plads;
	}

	public static void addPladsToReservation(Plads plads, Reservation reservation) {
		reservation.addPlads(plads);
	}

	public static ArrayList<Plads> getPladser() {
		return Storage.getPladser();
	}

	// --------------------------------------------------------------

	public static void initStorage() {

		Plads p1 = Controller.createPlads(1, Område.TURNERING);
		Plads p2 = Controller.createPlads(2, Område.TURNERING);
		Plads p3 = Controller.createPlads(3, Område.STANDARD);
		Plads p4 = Controller.createPlads(4, Område.STANDARD);
		Plads p5 = Controller.createPlads(5, Område.BØRNE);
		Plads p6 = Controller.createPlads(6, Område.VIP);

		Arrangement a1 = createArrangement("Dota 2 tournament", true);
		Arrangement a2 = createArrangement("CS GO tournament", false);

		Reservation r1 = createReservation(LocalDateTime.of(2019, 8, 12, 20, 00, 00),
				LocalDateTime.of(2019, 8, 12, 23, 00, 00));
		Reservation r2 = createReservation(LocalDateTime.of(2019, 8, 13, 19, 00, 00),
				LocalDateTime.of(2019, 8, 14, 06, 00, 00));
		Reservation r3 = createReservation(LocalDateTime.of(2019, 8, 14, 19, 00, 00),
				LocalDateTime.of(2019, 8, 15, 06, 00, 00));

		addPladsToReservation(p1, r1);
		addPladsToReservation(p2, r1);
		addPladsToReservation(p3, r2);
		addPladsToReservation(p4, r2);
		addPladsToReservation(p6, r3);

		addReservationToArrangement(a1, r1);
	}

	public static void init() {
		initStorage();
	}

}
