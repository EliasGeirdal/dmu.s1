package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konference {

	private String navn, adresse;
	private LocalDateTime startDato, slutDato;
	private double pris;
	// link attributer
	private ArrayList<Tilmelding> tilmeldinger; // association --- 0..* tilmeldinger.
	private ArrayList<Hotel> hoteller; // association --> * hoteller.
	private ArrayList<Udflugt> udflugter; // composition --> * Udflugt.

	public Konference(String navn, String adresse, LocalDateTime startDato, LocalDateTime slutDato, double pris) {
		super();
		this.navn = navn;
		this.adresse = adresse;
		this.startDato = startDato;
		this.slutDato = slutDato;
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
	public Udflugt createUdflugt(String navn, String adresse, String beskrivelse, double pris, LocalDateTime startDato,
			LocalDateTime slutDato) {
		Udflugt udflugt = new Udflugt(navn, adresse, beskrivelse, pris, startDato, slutDato);
		udflugter.add(udflugt);
		return udflugt;
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}

	// ----------alm.attributter-----------------------------------------------
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

	public LocalDateTime getStartDato() {
		return startDato;
	}

	public void setStartDato(LocalDateTime startDato) {
		this.startDato = startDato;
	}

	public LocalDateTime getSlutDato() {
		return slutDato;
	}

	public void setSlutDato(LocalDateTime slutDato) {
		this.slutDato = slutDato;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

}
