package model;

public class Plads {
	private int række, nr, pris;

	public Plads(int række, int nr, int pris) {
		super();
		this.række = række;
		this.nr = nr;
		this.pris = pris;
	}

	@Override
	public String toString() {
		return "Plads [række=" + række + ", nr=" + nr + ", pris=" + pris + "]";
	}

	public int getRække() {
		return række;
	}

	public void setRække(int række) {
		this.række = række;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

}
