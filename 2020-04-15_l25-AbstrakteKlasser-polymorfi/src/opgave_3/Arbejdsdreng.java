package opgave_3;

public class Arbejdsdreng extends Ansat {

	public Arbejdsdreng(String navn, String adresse, double timeLønssats) {
		super(navn, adresse, timeLønssats);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double beregnLoen() {
		return getTimeLønssats() * 25;
	};

}
