package model;

public class Kontotype {

	private String navn;
	private String beskrivelse;
	private String betingelser;

	public Kontotype(String navn, String beskrivelse, String betingelse) {
		this.setBeskrivelse(beskrivelse);
		this.setNavn(navn);
		this.setBetingelser(betingelse);
	}

	@Override
	public String toString() {
		return "\nNavn: " + navn + "\nBeskrivelse: " + beskrivelse + "\nBetingelser: " + betingelser;
	}

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

	public String getBetingelser() {
		return betingelser;
	}

	public void setBetingelser(String betingelser) {
		this.betingelser = betingelser;
	}
}
