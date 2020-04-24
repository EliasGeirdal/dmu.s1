package model;

import java.util.ArrayList;

public class Deltager {

	private int id;
	private static int idcount = 1;
	private String fornavn, efternavn, tlf, adresse;
	// link attributter ---- to do
	private Firma firma; // nullable
	private ArrayList<Ledsager> ledsagere;
	private ArrayList<Tilmelding> tilmeldinger;

	public Deltager(int id, String fornavn, String efternavn, String tlf, String adresse, Firma firma) {
		super();
		this.id = idcount;
		idcount++;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.tlf = tlf;
		this.adresse = adresse;
		// link attributter
		this.firma = firma;
		ledsagere = new ArrayList<>();
		tilmeldinger = new ArrayList<>();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEfternavn() {
		return efternavn;
	}

	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
