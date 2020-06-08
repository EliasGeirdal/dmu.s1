package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.PraktikKontrakt;
import model.PraktikOpgave;
import model.PraktikVirksomhed;
import storage.Storage;

public class Controller {

	// -----------------------------PraktikVirksomhed-------------------------------------
	public static PraktikVirksomhed createPraktikVirksomhed(String navn, String feedback, String kontaktperson) {
		PraktikVirksomhed praktikVirksomhed = new PraktikVirksomhed(navn, feedback, kontaktperson);
		Storage.addPraktikVirksomhed(praktikVirksomhed);
		return praktikVirksomhed;
	}

	public static ArrayList<PraktikVirksomhed> getPraktikVirksomheder() {
		return Storage.getPraktikVirksomheder();
	}

	public static void updatePraktikVirksomhed(PraktikVirksomhed praktikVirksomhed, String navn, String feedback,
			String kontaktperson) {
		praktikVirksomhed.setFeedback(feedback);
		praktikVirksomhed.setKontaktperson(kontaktperson);
		praktikVirksomhed.setNavn(navn);
	}

	public static void addVirksomhedToKontrakt(PraktikVirksomhed virksomhed, PraktikKontrakt kontrakt) {
		kontrakt.setPraktikVirksomhed(virksomhed);
	}

	public static String getEftertragtetSemesterVirksomhed(int semester) {
		String navn = "";
		int max = Integer.MIN_VALUE;
		for (PraktikVirksomhed virksomhed : Storage.getPraktikVirksomheder()) {
			int count = 0;
			for (PraktikOpgave opgave : virksomhed.getPraktikOpgaver()) {
				if (opgave.getSemester() == semester) {
					count++;
				}
			}
			if (count > max) {
				max = count;
				navn = virksomhed.getNavn();
			}
		}
		return navn;
	}

	// -----------------------------PraktikKontrakt------------------------------
	public static PraktikKontrakt createPraktikKontrakt(String opgavebeskrivelse, int timerPerUge,
			LocalDate periodeStart, LocalDate periodeSlut) {
		PraktikKontrakt praktikKontrakt = new PraktikKontrakt(opgavebeskrivelse, timerPerUge, periodeStart,
				periodeSlut);
		Storage.addPraktikKontrakt(praktikKontrakt);
		return praktikKontrakt;
	}

	public static ArrayList<PraktikKontrakt> getPraktikKontrakter() {
		return Storage.getPraktikKontrakter();
	}

	// ----------------------------PraktikOpgave-----------------------------------
	public static PraktikOpgave createPraktikOpgave(String navn, int semester, PraktikVirksomhed praktikVirksomhed) {
		PraktikOpgave praktikOpgave = praktikVirksomhed.createPraktikOpgave(navn, semester);
		return praktikOpgave;
	}

	// -----------------------------------------------------------------------------------
	public static void initStorage() {
		PraktikVirksomhed p1 = Controller.createPraktikVirksomhed("Vestas", "Godt miljø", "Peter Justesen");
		PraktikVirksomhed p2 = Controller.createPraktikVirksomhed("Nilfisk", "Udfordrende", "Peter Justesen");
		PraktikVirksomhed p3 = Controller.createPraktikVirksomhed("POWER", "Energisk", "Margrethe Dybdahl");

		// PraktikKontrakt 1 : Vestas.
		PraktikKontrakt pk1 = Controller.createPraktikKontrakt("Tester", 37, LocalDate.of(2018, 7, 1),
				LocalDate.of(2018, 9, 16));
		Controller.addVirksomhedToKontrakt(p1, pk1);
		// PraktikKontrakt 2 : Nilfisk.
		PraktikKontrakt pk2 = Controller.createPraktikKontrakt("Udvikler", 27, LocalDate.of(2018, 3, 14),
				LocalDate.of(2018, 5, 6));
		Controller.addVirksomhedToKontrakt(p2, pk2);
		// PraktikKontrakt 3 : Vestas.
		PraktikKontrakt pk3 = Controller.createPraktikKontrakt("Programmør", 15, LocalDate.of(2018, 2, 14),
				LocalDate.of(2018, 6, 6));
		Controller.addVirksomhedToKontrakt(p1, pk3);
		// PraktikKontrakt 4 : Vestas.
		PraktikKontrakt pk4 = Controller.createPraktikKontrakt("Analytiker", 12, LocalDate.of(2018, 2, 14),
				LocalDate.of(2018, 4, 6));
		Controller.addVirksomhedToKontrakt(p1, pk4);

		PraktikOpgave po1 = p1.createTekniskOpgave("Flowoptimering", 5, "Java");
		PraktikOpgave po2 = p1.createTekniskOpgave("Test i felten", 5, "c#");
		PraktikOpgave po3 = p2.createAnalyseOpgave("Risikoanalyse", 3, "MUST");
		PraktikOpgave po4 = p3.createTekniskOpgave("Simulering", 5, "Python");
	}

}
