package model;

public class Værelse {

	private String type;
	private double dagspris;
	private int sengepladser;

	public Værelse(String type, double pris, int sengepladser) {
		super();
		this.type = type;
		this.dagspris = pris;
		this.sengepladser = sengepladser;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPris() {
		return dagspris;
	}

	public void setPris(double pris) {
		this.dagspris = pris;
	}

	public int getSengepladser() {
		return sengepladser;
	}

	public void setSengepladser(int sengepladser) {
		this.sengepladser = sengepladser;
	}

}
