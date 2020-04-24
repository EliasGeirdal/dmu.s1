package opgave_3;

public abstract class Ansat extends Person {

	private double timeLønssats;

	public Ansat(String navn, String adresse, double timeLønssats) {
		super(navn, adresse);
		this.setTimeLønssats(timeLønssats);
		// TODO Auto-generated constructor stub
	}

	public abstract double beregnLoen();

	public double getTimeLønssats() {
		return timeLønssats;
	}

	public void setTimeLønssats(double timeLønssats) {
		this.timeLønssats = timeLønssats;
	}
}
