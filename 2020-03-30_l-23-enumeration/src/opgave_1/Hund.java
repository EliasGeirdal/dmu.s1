package opgave_1;

public class Hund {
	private String navn;
	private boolean stamtavle;
	private int pris;
	private Race race;

	public Hund(int pris, Race race) {
		this.pris = pris;
		this.race = race;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
}
