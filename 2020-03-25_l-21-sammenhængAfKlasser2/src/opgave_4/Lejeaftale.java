package opgave_4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lejeaftale {

	private LocalDate fraDato = null;
	private LocalDate tilDato = null;
	private Bolig bolig;
	private final int MAX_LEJERE = 2;
	private ArrayList<Lejer> lejere = new ArrayList<>(); // nullable

	public Lejeaftale(Bolig bolig, LocalDate fraDato) {
		if (bolig != null) {
			this.setFraDato(fraDato);
			this.bolig = bolig;
		}
	}

	@Override
	public String toString() {
		return "Lejeaftale [fraDato=" + fraDato + ", tilDato=" + tilDato + ", bolig=" + bolig + ", lejere=" + lejere
				+ "]";
	}

	public void addLejere(Lejer lejer1, Lejer lejer2) {
		if (!this.lejere.contains(lejer1)) {
			if (this.lejere.size() < MAX_LEJERE) {
				this.lejere.add(lejer1);
			}
		}
		if (!this.lejere.contains(lejer2)) {
			if (this.lejere.size() < MAX_LEJERE) {
				this.lejere.add(lejer2);
			}
		}
	}

	public void removeLejer(Lejer lejer) {
		if (this.lejere.contains(lejer)) {
			this.lejere.remove(lejer);
		}
	}

	/**
	 * return lejere on the lejeaftale. pre: must be at least one connected lejer.
	 * 
	 * @return
	 */
	public ArrayList<Lejer> getLejere() {
		return new ArrayList<>(lejere);
	}

	/**
	 * returns the bolig associated with the lejeaftale.
	 * 
	 * @return
	 */
	public Bolig getBolig() {
		return bolig;
	}

	public LocalDate getFraDato() {
		return fraDato;
	}

	public void setFraDato(LocalDate fraDato) {
		this.fraDato = fraDato;
	}

	public LocalDate getTilDato() {
		return tilDato;
	}

	public void setTilDato(LocalDate tilDato) {
		this.tilDato = tilDato;
	}

}
