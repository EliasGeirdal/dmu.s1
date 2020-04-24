package opgave_5;

public class Spiritus extends Fødevare {

	private double alkoholProcent;

	public Spiritus(int pris, String navn, String beskrivelse, int holdbarhedsperiode, double alkoholProcent) {
		super(pris, navn, beskrivelse, holdbarhedsperiode);
		this.setAlkoholProcent(alkoholProcent);
		// TODO Auto-generated constructor stub
	}

	/**
	 * beregn udfra moms.
	 */
	@Override
	public double beregnSalgspris() {
		double result = 0;
		if (getPris() <= 90)
			result = getPris() * 1.80;
		else if (getPris() > 90)
			result = getPris() * 2.20;
		return result;
	}

	public double getAlkoholProcent() {
		return alkoholProcent;
	}

	public void setAlkoholProcent(double alkoholProcent) {
		this.alkoholProcent = alkoholProcent;
	}

}
