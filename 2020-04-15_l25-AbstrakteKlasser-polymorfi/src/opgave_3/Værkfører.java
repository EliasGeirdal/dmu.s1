package opgave_3;

public class Værkfører extends Ansat {

	private int årForSvendeprøve;
	private int årForUdnævnelse;
	private double tillæg;

	public Værkfører(String navn, String adresse, int årForSvendeprøve, double timeLønssats, int årForUdnævnelse,
			double tillæg) {
		super(navn, adresse, timeLønssats);
		this.setÅrForSvendeprøve(årForSvendeprøve);
		this.setÅrForUdnævnelse(årForUdnævnelse);
		this.setTillæg(tillæg);
	}

	@Override
	public double beregnLoen() {
		return (getTimeLønssats() * 37) + tillæg;
	}

	public int getÅrForUdnævnelse() {
		return årForUdnævnelse;
	}

	public void setÅrForUdnævnelse(int årForUdnævnelse) {
		this.årForUdnævnelse = årForUdnævnelse;
	}

	public double getTillæg() {
		return tillæg;
	}

	public void setTillæg(double tillæg) {
		this.tillæg = tillæg;
	}

	public int getÅrForSvendeprøve() {
		return årForSvendeprøve;
	}

	public void setÅrForSvendeprøve(int årForSvendeprøve) {
		this.årForSvendeprøve = årForSvendeprøve;
	}
}
