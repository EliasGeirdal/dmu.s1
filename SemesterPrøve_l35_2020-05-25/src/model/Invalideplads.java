package model;

import java.time.LocalTime;

public class Invalideplads extends Parkeringsplads {
	private double area;

	public Invalideplads(int nummer, double area) {
		super(nummer);
		this.area = area;
	}

	/**
	 * Price of invalideplads is 0.
	 */
	@Override
	public double beregnPris(LocalTime slutTidspunkt) {
		return 0;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
}
