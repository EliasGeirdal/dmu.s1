package opgave_3;

public class Mekaniker extends Ansat {

	private int årForSvendeprøve;

	public Mekaniker(String navn, String adresse, int årForSvendeprøve, double timeLønssats) {
		super(navn, adresse, timeLønssats);
		this.årForSvendeprøve = årForSvendeprøve;
	}

	@Override
	public double beregnLoen() {
		return getTimeLønssats() * 37;
	}
}
