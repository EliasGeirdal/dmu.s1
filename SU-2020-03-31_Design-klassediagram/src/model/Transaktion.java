package model;

import java.time.LocalDate;

public class Transaktion {
	@Override
	public String toString() {
		return "\nBeløb: " + beløb + "\nDato: " + dato;
	}

	private int beløb;
	private LocalDate dato;

	public Transaktion(int beløb) {
		this.beløb = beløb;
		setDato(LocalDate.now());
	}

	public int getBeløb() {
		return beløb;
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}
}
