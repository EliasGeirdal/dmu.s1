package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.Bil;
import model.Bilmærke;
import model.Invalideplads;
import model.Parkeringshus;
import model.Parkeringsplads;
import storage.Storage;

public class Controller {
	// ---------------------parkeringshus------------------------------
	public static Parkeringshus createParkeringshus(String adresse) {
		Parkeringshus p = new Parkeringshus(adresse);
		Storage.addParkeringshus(p);
		return p;
	}

	public static ArrayList<Parkeringshus> getParkeringshuse() {
		return Storage.getParkeringshuse();
	}

	// ----------------parkeringsplads----------------------------------
	public static Parkeringsplads createParkeringsplads(int nummer, Parkeringshus parkeringshus) {
		Parkeringsplads pPlads = parkeringshus.createParkeringsplads(nummer);
		return pPlads;
	}

	public static Parkeringsplads getLedigPlads(Parkeringshus parkeringshus) {
		for (Parkeringsplads parkeringsplads : parkeringshus.getParkeringspladser()) {
			if (parkeringsplads.getBil() == null) {
				return parkeringsplads;
			}
		}
		return null;
	}

	// -------------------Invalideplads--------------------------------------
	public static Invalideplads createInvalideplads(int nummer, double area, Parkeringshus parkeringshus) {
		Invalideplads iPlads = parkeringshus.createInvalideplads(nummer, area);
		return iPlads;
	}

	// -----------------------bil---------------------------------------------
	public static Bil createBil(String regNr) {
		Bil bil = new Bil(regNr);
		Storage.addBil(bil);
		return bil;
	}

	public static ArrayList<Bil> getBiler() {
		return Storage.getBiler();
	}

	public static void addBilToPlads(Parkeringsplads parkeringsplads, Bil bil) {
		parkeringsplads.setBil(bil);
	}

	/**
	 * Print list of optagne pladser into filenavn document.
	 * 
	 * @param hus     parkeringshus.
	 * @param filnavn name of file.
	 * @throws FileNotFoundException
	 */
	public static void writeOptagnePladser(Parkeringshus hus, String filnavn) throws IOException {
		File file = new File(filnavn);
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(hus.optagnePladser());
		}
	}

	/**
	 * Initial content.
	 */
	public static void createSomeObjects() {
		Bil b1 = createBil("AB 11 222");
		Bil b2 = createBil("EF 33 444");
		Bil b3 = createBil("BD 55 666");

		b1.setBilmærke(Bilmærke.BMW);
		b2.setBilmærke(Bilmærke.FORD);
		b3.setBilmærke(Bilmærke.VOLKSWAGEN);

		Parkeringshus parkeringshus1 = Controller.createParkeringshus("Havnegade 12, 8000 Arhus");
		Parkeringshus parkeringshus2 = Controller.createParkeringshus("DOKK1 Parkering, 8000 Arhus");

		for (int i = 1; i <= 110; i++) {
			if (i <= 100)
				parkeringshus1.createParkeringsplads(i);
			else
				parkeringshus1.createInvalideplads(i, 18);
		}

		for (int i = 0; i < 10; i++) {
			parkeringshus2.createParkeringsplads(i);
		}

		Controller.addBilToPlads(parkeringshus1.getParkeringspladser().get(10), b1);
		Controller.addBilToPlads(parkeringshus1.getParkeringspladser().get(20), b2);
		Controller.addBilToPlads(parkeringshus1.getParkeringspladser().get(30), b3);
	}

}
