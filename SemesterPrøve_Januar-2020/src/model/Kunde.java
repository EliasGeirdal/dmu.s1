package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
	private String navn, mobil;
	private ArrayList<Bestilling> bestillinger;

	public Kunde(String navn, String mobil) {
		super();
		this.navn = navn;
		this.mobil = mobil;
		bestillinger = new ArrayList<Bestilling>();
	}

	@Override
	public String toString() {
		return "Kunde [navn=" + navn + "]";
	}

	public ArrayList<Plads> bestiltePladserTilForestillingPådag(Forestilling forestilling, LocalDate dato) {
		ArrayList<Plads> pladser = new ArrayList<>();
		for (Bestilling bestilling : bestillinger) {
			if (bestilling.getForestilling() == forestilling && bestilling.getDato() == dato) {
				for (int i = 0; i < bestilling.getPladser().size(); i++) {
					pladser.add(bestilling.getPladser().get(i));
				}
			}
		}
		return pladser;
	}

	public void addBestilling(Bestilling bestilling) {
		bestillinger.add(bestilling);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public ArrayList<Bestilling> getBestillinger() {
		return bestillinger;
	}

}
