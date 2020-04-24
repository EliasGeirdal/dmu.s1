package opgave_2;

public class Værkfører extends Mekaniker {
	private int årForUdnævnelse;
	private double tillæg;

	public Værkfører(String navn, String adresse, int årForSvendeprøve, double timeLønssats, int årForUdnævnelse,
			double tillæg) {
		super(navn, adresse, årForSvendeprøve, timeLønssats);
		this.setÅrForUdnævnelse(årForUdnævnelse);
		this.setTillæg(tillæg);
	}

	@Override
	public double beregnLoen() {
		return super.beregnLoen() + tillæg;
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
}
