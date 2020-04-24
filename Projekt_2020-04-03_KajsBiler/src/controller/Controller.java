package controller;

import java.util.ArrayList;

import model.Bil;
import model.Gruppe;
import model.Prisgruppe;
import storage.Storage;

public class Controller {

	public static Bil createBil(String maerke, Prisgruppe prisgr, String regNr) {
		Bil bil = prisgr.createBil(maerke, prisgr, regNr);
		Storage.addBil(bil);
		return bil;
	}

	public static void addBilToPrisgruppe(Prisgruppe prisgruppe, Bil bil) {
		prisgruppe.addBil(bil);
	}

	public static ArrayList<Bil> getBiler() {
		return Storage.getBil();
	}

	// --------------------------------------------------------------------------------------

	public static Prisgruppe createPrisgruppe(Gruppe prisGruppe, int prisPrDag, int prisPrUge, int prisPrKm) {
		Prisgruppe prisgr = new Prisgruppe(prisGruppe, prisPrDag, prisPrUge, prisPrKm);
		Storage.addPrisgruppe(prisgr);
		return prisgr;
	}

	public static void addPrisgruppeToBil(Prisgruppe prisgruppe, Bil bil) {
		bil.setPrisgr(prisgruppe);
	}

	public static ArrayList<Prisgruppe> getPrisgrupper() {
		return Storage.getPrisgruppe();
	}

	public static void initStorage() {
		Prisgruppe a = new Prisgruppe(Gruppe.A, 100, 500, 5);
		Prisgruppe b = new Prisgruppe(Gruppe.B, 200, 1000, 10);
		Prisgruppe c = new Prisgruppe(Gruppe.C, 400, 2000, 20);
		Prisgruppe d = new Prisgruppe(Gruppe.D, 800, 4000, 40);

		Controller.createBil("Honda", a, "YC 31 188");
		Controller.createBil("Volkswagen", b, "TA 12 999");
		Controller.createBil("Ford", c, "AB 12 345");
		Controller.createBil("Mazda", d, "ZX 11 999");
	}

	public static void init() {
		initStorage();
	}
}
