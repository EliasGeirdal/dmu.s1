package model;

import java.util.ArrayList;

public class Plads {
	@Override
	public String toString() {
		return "Plads: " + nr + ", område: " + område;
	}

	private int nr;
	private Område område;
	private ArrayList<Reservation> reservationer;
	private static int standardTimePris = 50;

	public Plads(int nr, Område område) {
		this.nr = nr;
		this.område = område;
		this.reservationer = new ArrayList<>();
	}

	public double pris(int timer) {
		double pris = standardTimePris;
		if (this.område == Område.VIP) {
			pris = standardTimePris * 1.25;
		} else if (this.område == Område.BØRNE) {
			pris = standardTimePris * 0.80;
		} else if (this.område == Område.TURNERING) {
			pris = standardTimePris * 1.10;
		}
		return pris * timer;
	}

	public void addReservation(Reservation reservation) {
		if (!reservationer.contains(reservation)) {
			reservationer.add(reservation);
			reservation.addPlads(this);
		}
	}

	public void removeReservation(Reservation reservation) {
		if (reservationer.contains(reservation)) {
			reservationer.remove(reservation);
			reservation.removePlads(this);
		}
	}

	public ArrayList<Reservation> getReservationer() {
		return new ArrayList<Reservation>(reservationer);
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public Område getOmråde() {
		return område;
	}

	public static int getStandardTimePris() {
		return standardTimePris;
	}

	public static void setStandardTimePris(int standardTimePris) {
		Plads.standardTimePris = standardTimePris;
	}
}
