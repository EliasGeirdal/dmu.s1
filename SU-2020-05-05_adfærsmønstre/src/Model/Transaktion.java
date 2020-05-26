package Model;

import java.time.LocalDate;

public class Transaktion {

	private double beloeb;
	private LocalDate dato;

	public Transaktion(double beloeb) {
		this.beloeb = beloeb;
		this.dato = LocalDate.now();
	}

	public double getBeloeb() {
		return this.beloeb;
	}

	public LocalDate getDato() {
		return this.dato;
	}

}
