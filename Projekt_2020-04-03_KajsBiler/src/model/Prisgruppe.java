package model;

import java.util.ArrayList;

public class Prisgruppe {

	private final Gruppe prisGruppe;
	private int prisPrDag, prisPrUge, prisPrKm;
	private ArrayList<Bil> biler;

	public Prisgruppe(Gruppe prisGruppe, int prisPrDag, int prisPrUge, int prisPrKm) {
		this.prisGruppe = prisGruppe;
		this.prisPrDag = prisPrDag;
		this.prisPrUge = prisPrUge;
		this.prisPrKm = prisPrKm;
		biler = new ArrayList<>();
	}

	public ArrayList<Bil> getBiler() {
		return new ArrayList<>(biler);
	}

	public Bil createBil(String mærke, Prisgruppe prisgr, String regNr) {
		Bil bil = new Bil(mærke, prisgr, regNr);
		biler.add(bil);
		return bil;
	}

	public void addBil(Bil bil) {
		if (!biler.contains(bil)) {
			biler.add(bil);
			bil.setPrisgr(this);
		}
	}

	/**
	 * Bil må ikke være nullable
	 * 
	 * @param bil
	 */
	public void removeBil(Bil bil) {
		if (biler.contains(bil)) {
			biler.remove(bil);
			bil.setPrisgr(null);
		}
	}

	public int getPrisPrDag() {
		return prisPrDag;
	}

	public void setPrisPrDag(int prisPrDag) {
		this.prisPrDag = prisPrDag;
	}

	public int getPrisPrUge() {
		return prisPrUge;
	}

	public void setPrisPrUge(int prisPrUge) {
		this.prisPrUge = prisPrUge;
	}

	public int getPrisPrKm() {
		return prisPrKm;
	}

	public void setPrisPrKm(int prisPrKm) {
		this.prisPrKm = prisPrKm;
	}

	public Gruppe getPrisGruppe() {
		return prisGruppe;
	}

}
