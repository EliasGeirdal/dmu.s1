package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

public class Controller {

	// ----------------------forestilling------------------------
	public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
		Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
		Storage.addForestilling(forestilling);
		return forestilling;
	}

	public static ArrayList<Forestilling> getForestillinger() {
		return Storage.getForestillinger();
	}

	// --------------------kunde----------------------------

	public static Kunde createKunde(String navn, String mobil) {
		Kunde kunde = new Kunde(navn, mobil);
		Storage.addKunde(kunde);
		return kunde;
	}

	public static ArrayList<Kunde> getKunder() {
		return Storage.getKunder();
	}

	// ------------------misc-----------------------

	public static ArrayList<Plads> getPladserForDateAndKunde(LocalDate dato, Forestilling forestilling, Kunde kunde) {
		ArrayList<Plads> pladser = new ArrayList<>();
		for (Bestilling bestilling : forestilling.getBestillinger()) {
			for (Bestilling bestilling1 : kunde.getBestillinger()) {
				if (bestilling1.equals(bestilling)) {
					for (Plads plads : bestilling.getPladser()) {
						if (bestilling.getDato().isEqual(dato)) {
							pladser.add(plads);
						}
					}
				}
			}
		}
		return pladser;
	}

	public static void oversigtOverForestillinger(String filnavn) throws FileNotFoundException, IOException {
		try (PrintWriter pw = new PrintWriter(new File(filnavn))) {
			pw.println(Storage.getForestillinger());
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato,
			ArrayList<Plads> pladser) {
		try {

			// try something else than this.

			// Check if the date is correct.
			boolean correct = false;
			// amount of days between start and end of forestilling.
			long between = ChronoUnit.DAYS.between(forestilling.getStartDato(), forestilling.getSlutDato());
			// Run through all the days in the forestilling to see if it matches the desired
			// date.
			for (int i = 0; i < between; i++) {
				if (forestilling.getStartDato().plusDays(i).equals(dato)) {
					// date matches date in forestilling.
					correct = true;
				}
			}
			// if none of the dates matched, throw a runtime exception.
			if (!correct) {
				throw new RuntimeException("Forkert dato.");
			}
			// check if the seat is available, if it isnt throw a runtime exception.
			for (Plads plads : pladser) {
				if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)) {
					throw new RuntimeException("En af pladserne er optaget.");
				} else if (forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)) {
					return forestilling.createBestilling(forestilling, dato, kunde);
				}
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Fejl. Try again, fool.");
		}
		return null;
	}

	public static void initStorage() {
		Forestilling forestilling = createForestilling("Evita", LocalDate.of(2019, 01, 10), LocalDate.of(2019, 01, 20));
		createForestilling("Lykke Per", LocalDate.of(2019, 02, 01), LocalDate.of(2019, 02, 10));
		createForestilling("Chess", LocalDate.of(2019, 01, 21), LocalDate.of(2019, 01, 30));

		Kunde k = createKunde("Anders Hansen", "11223344");
		createKunde("Peter Jensen", "12345678");
		createKunde("Niels Madsen", "12341234");

		ArrayList<Plads> pladser = new ArrayList<>();
		pladser.add(new Plads(10, 10, 100));
		pladser.add(new Plads(10, 11, 100));

		Bestilling bestilling = opretBestillingMedPladser(forestilling, k, LocalDate.of(2019, 01, 11), pladser);

		for (Plads plads : pladser) {
			bestilling.addPlads(plads);
		}

		Bestilling bestilling1 = forestilling.createBestilling(forestilling, LocalDate.of(2020, 01, 10), k);
		bestilling1.addPlads(new Plads(20, 10, 200));
	}

}
