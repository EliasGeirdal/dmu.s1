package opgave_5;

public abstract class Vare {
	private double pris;
	private String navn, beskrivelse;

	public Vare(double pris, String navn, String beskrivelse) {
		this.pris = pris;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
	}

	@Override
	public String toString() {
		return "\nVare [navn=" + navn + ", pris=" + pris + "]\n";
	}

	public double beregnSalgspris() {
		return pris * 1.25;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
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
}
