package model;

import java.util.ArrayList;

public class Konto {

	private int nr = 0;
	private static int nrId = 0;
	private Kontotype kontotype;
	private ArrayList<Transaktion> transaktioner;

	public Konto(Kontotype kontotype) {
		nr = nrId;
		nrId++;
		this.setKontotype(kontotype);
		transaktioner = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Konto nummer: " + nr + "\nkontotype: " + kontotype + "\nSaldo: " + beregnSaldo();
	}

	/**
	 * Indsætter beløb ved at skabe et nyt transaktions objekt.
	 * 
	 * @param beløb
	 */
	public void indsætBelæb(int beløb) {
		Transaktion t = new Transaktion(beløb);
		transaktioner.add(t);
	}

	public void hævBeløb(int beløb) {
		Transaktion t = new Transaktion(beløb);
		transaktioner.add(t);
	}

	/**
	 * returnerer saldo.
	 */
	public int beregnSaldo() {
		int saldo = 0;
		for (Transaktion transaktion : transaktioner) {
			saldo += transaktion.getBeløb();
		}
		return saldo;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public Kontotype getKontotype() {
		return kontotype;
	}

	public void setKontotype(Kontotype kontotype) {
		this.kontotype = kontotype;
	}

	public ArrayList<Transaktion> getTransaktioner() {
		return transaktioner;
	}

}
