package opgave_2;

public class Mekaniker extends Person {
	private int årForSvendeprøve;
	private double timeLønssats;
	private int antalArbejdsUgeTimer = 37;

	public Mekaniker(String navn, String adresse, int årForSvendeprøve, double timeLønssats) {
		super(navn, adresse);
		this.setÅrForSvendeprøve(årForSvendeprøve);
		this.setTimeLønssats(timeLønssats);
	}

	public double beregnLoen() {
		return timeLønssats * antalArbejdsUgeTimer;
	}

	public double getTimeLønssats() {
		return timeLønssats;
	}

	public void setTimeLønssats(double timeLønssats) {
		this.timeLønssats = timeLønssats;
	}

	public int getÅrForSvendeprøve() {
		return årForSvendeprøve;
	}

	public void setÅrForSvendeprøve(int årForSvendeprøve) {
		this.årForSvendeprøve = årForSvendeprøve;
	}
}
