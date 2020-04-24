package model;

public class Tillæg {

	private String navn, beskrivelse;
	private double pris;

	public Tillæg(String navn, String beskrivelse, double pris) {
		super();
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.pris = pris;
	}

	// ---------------instance------------------------
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
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

}
