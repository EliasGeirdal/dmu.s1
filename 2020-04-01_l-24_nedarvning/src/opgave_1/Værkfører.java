package opgave_1;

public class Værkfører extends Mekaniker {
	private int årForUdnævnelse;
	private double tillæg;

	public Værkfører(String navn, String adresse, int årForSvendeprøve, double timeLønssats, int årForUdnævnelse,
			double tillæg) {
		super(navn, adresse, årForSvendeprøve, timeLønssats);
		this.årForUdnævnelse = årForUdnævnelse;
		this.tillæg = tillæg;
	}
}
