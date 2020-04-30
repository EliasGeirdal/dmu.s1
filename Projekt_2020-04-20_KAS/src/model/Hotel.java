package model;

import java.util.ArrayList;

public class Hotel {
	// instance variables.
	private String navn, adresse, tlf, email;
	// link variables.
	private ArrayList<Tillæg> tillæg;
	private ArrayList<Værelse> værelser;
	// added

	public Hotel(String navn, String adresse, String tlf, String email) {
		super();
		this.navn = navn;
		this.adresse = adresse;
		this.tlf = tlf;
		this.email = email;
		tillæg = new ArrayList<>();
		værelser = new ArrayList<>();
	}

	// -----------------------Tillæg-------------------

	public Tillæg createTillæg(String navn, String beskrivelse, double pris) {
		Tillæg tillæg = new Tillæg(navn, beskrivelse, pris);
		this.tillæg.add(tillæg);
		return tillæg;
	}

	public ArrayList<Tillæg> getTillæg() {
		return new ArrayList<>(tillæg);
	}

	// --------------------værelser------------------------------------
	public Værelse createVærelse(String type, double pris, int sengepladser) {
		Værelse værelse = new Værelse(type, pris, sengepladser, this);
		værelser.add(værelse);
//		this.værelse = værelse;
		return værelse;
	}

	public ArrayList<Værelse> getVærelser() {
		return new ArrayList<>(værelser);
	}

	// --------------instance----------------------
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

	@Override
	public String toString() {
		return navn;
	}

}
