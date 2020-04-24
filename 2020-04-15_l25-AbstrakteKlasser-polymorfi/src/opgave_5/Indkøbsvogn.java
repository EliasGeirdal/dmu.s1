package opgave_5;

import java.util.ArrayList;

public class Indkøbsvogn {

	private ArrayList<Vare> varer;

	public Indkøbsvogn() {
		varer = new ArrayList<>();
	}

	public double beregnTotal() {
		double sum = 0;
		for (Vare vare : varer) {
			sum += vare.beregnSalgspris();
		}
		return sum;
	}

	public ArrayList<Vare> getVarer() {
		return new ArrayList<>(varer);
	}

	public void addVare(Vare vare) {
		if (!varer.contains(vare))
			varer.add(vare);
	}

	public void removeVare(Vare vare) {
		if (varer.contains(vare))
			varer.remove(vare);
	}
}
