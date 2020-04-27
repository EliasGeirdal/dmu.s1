package model;

import java.util.ArrayList;

public class Deltager {

	// instance variables.
	private int id;
	private static int idcount = 1;
	private String fornavn, efternavn, tlf, adresse;

	// link variables.
	private Firma firma; // nullable.
	private ArrayList<Tilmelding> tilmeldinger; // tilmelding --- 1 * deltager.

	public Deltager(String fornavn, String efternavn, String tlf, String adresse) {
		super();
		this.id = idcount;
		idcount++;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.tlf = tlf;
		this.adresse = adresse;
		tilmeldinger = new ArrayList<>();
	}

	// -----------tilmelding metoder-----------------

	public void addTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding)) {
			tilmeldinger.add(tilmelding);
			tilmelding.setDeltager(this);
		}
	}

	public void removeTilmelding(Tilmelding tilmelding) {
		if (tilmeldinger.contains(tilmelding)) {
			tilmeldinger.remove(tilmelding);
			tilmelding.setDeltager(null);
		}
	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(tilmeldinger);
	}

	// -------firma metoder-------------------

	public Firma getFirma() {
		return firma;
	}

	/**
	 * 
	 * @param firma nullable parameter
	 */
	public void setFirma(Firma firma) {
		if (this.firma != firma)
			this.firma = firma;
	}

	// --------------- instance ---------------------
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
