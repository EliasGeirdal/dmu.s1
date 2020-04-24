package opgave_5;

public class Elartikle extends Vare {

	private double energiForbrug;

	public Elartikle(double pris, String navn, String beskrivelse, double energiForbrug) {
		super(pris, navn, beskrivelse);
		this.setEnergiForbrug(energiForbrug);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double beregnSalgspris() {
		double result = getPris() + 3;
		if ((getPris() * 1.3) - getPris() > 3) {
			result = getPris() * 1.3;
		}
		return result;
	}

	public double getEnergiForbrug() {
		return energiForbrug;
	}

	public void setEnergiForbrug(double energiForbrug) {
		this.energiForbrug = energiForbrug;
	}

}
