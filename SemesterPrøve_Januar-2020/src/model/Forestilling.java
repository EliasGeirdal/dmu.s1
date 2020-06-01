package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
	private String navn;
	private LocalDate startDato, slutDato;
	// link
	private ArrayList<Bestilling> bestillinger;

	public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
		super();
		this.navn = navn;
		this.startDato = startDato;
		this.slutDato = slutDato;
		bestillinger = new ArrayList<>();
	}

	public boolean erPladsLedig(int række, int nummer, LocalDate dato) {
		int i = 0;
		while (i < bestillinger.size()) {
			for (Bestilling bestilling : bestillinger) {
				if (bestilling.getDato() == dato) {
					for (Plads plads : bestilling.getPladser()) {
						if (plads.getRække() == række && plads.getNr() == nummer) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Forestilling [navn=" + navn + ", startDato=" + startDato + ", slutDato=" + slutDato + "]";
	}

	public LocalDate succesDato() {
		try {
			LocalDate date = bestillinger.get(0).getDato();
			int max = 0;
			for (Bestilling bestilling : bestillinger) {
				if (antalBestiltePladserPåDag(bestilling.getDato()) >= max) {
					date = bestilling.getDato();
				}
			}
			return date;
		} catch (RuntimeException e) {
			throw new RuntimeException("Error. Check amount of bestilligner");
		}
	}

	public int antalBestiltePladserPåDag(LocalDate dag) {
		int antal = 0;
		for (Bestilling bestilling : bestillinger) {
			if (bestilling.getDato().equals(dag)) {
				antal++;
			}
			// If .equals doesnt work use this.
//			if (bestilling.getDato() == dag) {
//				antal++;
//			}
		}
		return antal;
	}

	public Bestilling createBestilling(Forestilling forestilling, LocalDate dato, Kunde kunde) {
		Bestilling bestilling = new Bestilling(this, dato, kunde);
		bestillinger.add(bestilling);
		kunde.addBestilling(bestilling);
		return bestilling;

	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public LocalDate getStartDato() {
		return startDato;
	}

	public void setStartDato(LocalDate startDato) {
		this.startDato = startDato;
	}

	public LocalDate getSlutDato() {
		return slutDato;
	}

	public void setSlutDato(LocalDate slutDato) {
		this.slutDato = slutDato;
	}

	public ArrayList<Bestilling> getBestillinger() {
		return bestillinger;
	}
}
