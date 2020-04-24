package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konference {

	private String navn, adresse;
	private LocalDateTime startDato, slutDato;
	// link attributer
	private ArrayList<Tilmelding> tilmeldinger;
	private ArrayList<Hotel> hoteller;

	public Konference(String navn, String adresse, LocalDateTime startDato, LocalDateTime slutDato) {
		super();
		this.navn = navn;
		this.adresse = adresse;
		this.startDato = startDato;
		this.slutDato = slutDato;
		// link attributter
		tilmeldinger = new ArrayList<>();
		hoteller = new ArrayList<>();
	}

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

}
