package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
	private LocalDate dato;
	private Forestilling forestilling;
	private Kunde kunde;
	private ArrayList<Plads> pladser = new ArrayList<>();

	Bestilling(Forestilling forestilling, LocalDate dato, Kunde kunde) {
		this.forestilling = forestilling;
		this.kunde = kunde;
		this.dato = dato;
	}

	public int samletPris() {
		int samletPris = 0;
		for (Plads plads : pladser) {
			samletPris += plads.getPris();
		}
		return samletPris;
	}

	@Override
	public String toString() {
		return "Bestilling [dato=" + dato + ", pladser=" + pladser + "]";
	}

//	public Plads createPlads(int række, int nr, int pris) {
//		Plads plads = new Plads(række, nr, pris);
//		pladser.add(plads);
//		return plads;
//	}

	public void addPlads(Plads plads) {
		if (!pladser.contains(plads))
			pladser.add(plads);
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public Forestilling getForestilling() {
		return forestilling;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public ArrayList<Plads> getPladser() {
		return new ArrayList<>(pladser);
	}
}
