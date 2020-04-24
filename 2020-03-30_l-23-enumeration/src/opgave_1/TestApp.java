package opgave_1;

import java.util.ArrayList;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hund h1 = new Hund(5000, Race.BOKSER);
		Hund h2 = new Hund(10000, Race.BOKSER);
		Hund h3 = new Hund(10000, Race.PUDDEL);
		Hund h4 = new Hund(10000, Race.PUDDEL);

	}

	public static int samletPris(ArrayList<Hund> hunde, Race race) {
		int sum = 0;
		for (Hund hund : hunde) {
			if (hund.getRace().ordinal() == race.ordinal()) {
				sum += hund.getPris();
			}
		}
		return sum;
	}

}
