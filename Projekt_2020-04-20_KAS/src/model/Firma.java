package model;

import java.util.ArrayList;

public class Firma {

	private String navn, tlf;
	// link attributter
	private ArrayList<Deltager> deltagere;

	public Firma(String navn, String tlf) {
		super();
		this.navn = navn;
		this.tlf = tlf;
		// link attributter
		deltagere = new ArrayList<>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

}
