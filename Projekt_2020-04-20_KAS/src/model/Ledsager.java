package model;

import java.util.ArrayList;

public class Ledsager {
	private String navn;
	// link attributter
	private Tilmelding tilmelding;
	private ArrayList<Udflugt> udflugter;

	public Ledsager(String navn, Tilmelding tilmelding) {
		super();
		this.navn = navn;
		this.tilmelding = tilmelding;
		udflugter = new ArrayList<>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Tilmelding getTilmelding() {
		return tilmelding;
	}

	public void setTilmelding(Tilmelding tilmelding) {
		this.tilmelding = tilmelding;
	}

}
