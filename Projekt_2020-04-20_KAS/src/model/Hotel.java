package model;

import java.util.ArrayList;

public class Hotel {
	private String navn, adresse, tlf, email;
	// link attributter
	private ArrayList<Tilmelding> tilmeldinger;
	private ArrayList<Tillæg> tillæg;
	private ArrayList<Værelse> værelser;

	public Hotel(String navn, String adresse, String tlf, String email) {
		super();
		this.navn = navn;
		this.adresse = adresse;
		this.tlf = tlf;
		this.email = email;
		// link attributter
		tilmeldinger = new ArrayList<>();
		tillæg = new ArrayList<>();
		værelser = new ArrayList<>();
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

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
