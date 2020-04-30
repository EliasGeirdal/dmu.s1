package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
	@Override
	public String toString() {
		return navn;
	}

	// Instance variables.
	private String navn;
	private String adresse;
	private LocalDate startDato, slutDato;
	private double dagsPris;
	// link instance variables.
	private ArrayList<Tilmelding> tilmeldinger; // association --- 0..* tilmeldinger.
	private ArrayList<Hotel> hoteller; // association --> * hoteller.
	private ArrayList<Udflugt> udflugter; // composition --> * Udflugt.

	public Konference(String navn, String adresse, LocalDate startDato, LocalDate slutDato, double pris) {
		super();
		this.navn = navn;
		this.adresse = adresse;
		this.startDato = startDato;
		this.slutDato = slutDato;
		this.dagsPris = pris;
		// link attributter
		tilmeldinger = new ArrayList<>();
		hoteller = new ArrayList<>();
		udflugter = new ArrayList<>();
	}

	// ----------------tilmelding metoder--------------------------------
	public void addTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding)) {
			tilmeldinger.add(tilmelding);
			tilmelding.setKonference(this);
		}
	}

	public void removeTilmelding(Tilmelding tilmelding) {
		if (tilmeldinger.contains(tilmelding)) {
			tilmeldinger.remove(tilmelding);
			tilmelding.setKonference(null);
		}
	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(tilmeldinger);
	}

	// ---------------------hotel metoder ------------------------
	public void addHotel(Hotel hotel) {
		if (!hoteller.contains(hotel))
			hoteller.add(hotel);
	}

	public void removeHotel(Hotel hotel) {
		if (hoteller.contains(hotel))
			hoteller.remove(hotel);
	}

	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<>(hoteller);
	}

	// ---------------udflugt metoder----------------------
	public Udflugt createUdflugt(String navn, String adresse, String beskrivelse, double pris, LocalDate startDato,
			LocalDate slutDato) {
		Udflugt udflugt = new Udflugt(navn, adresse, beskrivelse, pris, startDato, slutDato);
		udflugter.add(udflugt);
		return udflugt;
	}

	public void removeUdflugt(Udflugt udflugt) {
		if (udflugter.contains(udflugt)) {
			udflugter.remove(udflugt);
		}
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}

	// ----------instance-----------------------------------------------
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public double getDagspris() {
		return dagsPris;
	}

	public void setDagspris(double pris) {
		this.dagsPris = pris;
	}

}
