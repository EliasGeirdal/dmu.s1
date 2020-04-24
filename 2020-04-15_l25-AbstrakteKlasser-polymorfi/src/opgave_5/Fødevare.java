package opgave_5;

public class Fødevare extends Vare {
	private int holdbarhedsperiode;

	public Fødevare(int pris, String navn, String beskrivelse, int holdbarhedsperiode) {
		super(pris, navn, beskrivelse);
		this.holdbarhedsperiode = holdbarhedsperiode;
	}

	@Override
	public double beregnSalgspris() {
		return getPris() * 1.05;
	}

	public int getHoldbarhedsperiode() {
		return holdbarhedsperiode;
	}

	public void setHoldbarhedsperiode(int holdbarhedsperiode) {
		this.holdbarhedsperiode = holdbarhedsperiode;
	}
}
