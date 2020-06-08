package storage;

import java.util.ArrayList;

import model.PraktikKontrakt;
import model.PraktikVirksomhed;

public class Storage {
	private static ArrayList<PraktikVirksomhed> praktikVirksomheder = new ArrayList<>();
	private static ArrayList<PraktikKontrakt> praktikKontrakter = new ArrayList<>();

	// -------------------praktikVirksomhed----------------------------------
	public static ArrayList<PraktikVirksomhed> getPraktikVirksomheder() {
		return new ArrayList<>(praktikVirksomheder);
	}

	public static void addPraktikVirksomhed(PraktikVirksomhed praktikVirksomhed) {
		praktikVirksomheder.add(praktikVirksomhed);
	}

	// -------------------praktikKontrakt----------------------------------
	public static ArrayList<PraktikKontrakt> getPraktikKontrakter() {
		return new ArrayList<>(praktikKontrakter);
	}

	public static void addPraktikKontrakt(PraktikKontrakt praktikKontrakt) {
		praktikKontrakter.add(praktikKontrakt);
	}
}
