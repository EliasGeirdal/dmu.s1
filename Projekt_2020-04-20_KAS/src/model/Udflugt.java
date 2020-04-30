package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
	// instance variable
	private String navn, adresse, beskrivelse;
	private double pris;
	private LocalDate startDato, slutDato;
	// link instance variables
	private ArrayList<Ledsager> ledsagere;

	public Udflugt(String navn, String adresse, String beskrivelse, double pris, LocalDate startDato,
			LocalDate slutDato) {
		super();
		this.navn = navn;
		this.adresse = adresse;
		this.beskrivelse = beskrivelse;
		this.pris = pris;
		this.startDato = startDato;
		this.slutDato = slutDato;
		ledsagere = new ArrayList<Ledsager>();
	}

	// ----------------ledsager metoder-----------------------
	public ArrayList<Ledsager> getLedsagere() {
		return new ArrayList<>(ledsagere);
	}

	public void addLedsager(Ledsager ledsager) {
		if (!ledsagere.contains(ledsager)) {
			ledsagere.add(ledsager);
			ledsager.addUdflugt(this);
		}
	}

	public void removeLedsager(Ledsager ledsager) {
		if (ledsagere.contains(ledsager)) {
			ledsagere.add(ledsager);
			ledsager.removeUdflugt(this);
		}
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

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
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

	@Override
	public String toString() {
		return navn + "(" + ledsagere + ")";
	}
}
