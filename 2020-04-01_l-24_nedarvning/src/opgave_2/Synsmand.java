package opgave_2;

public class Synsmand extends Mekaniker {
	private int antalSynPrUge;
	private final double TILLÆG = 29;

	public Synsmand(String navn, String adresse, int årForSvendeprøve, double timeLønssats, int antalSynPrUge) {
		super(navn, adresse, årForSvendeprøve, timeLønssats);
		this.antalSynPrUge = antalSynPrUge;
		// TODO Auto-generated constructor stub
	}

	public void addSyn() {
		antalSynPrUge++;
	}

	public int getAntalSynPrUge() {
		return antalSynPrUge;
	}

	public void setAntalSynPrUge(int antalSynPrUge) {
		this.antalSynPrUge = antalSynPrUge;
	}

	@Override

	public double beregnLoen() {
		return super.beregnLoen() + (antalSynPrUge * TILLÆG);
	}

}
