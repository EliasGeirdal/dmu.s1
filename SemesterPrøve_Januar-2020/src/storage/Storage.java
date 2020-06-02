package storage;

import java.util.ArrayList;

import model.Forestilling;
import model.Kunde;

public class Storage {

	private static ArrayList<Forestilling> forestillinger = new ArrayList<>();
	private static ArrayList<Kunde> kunder = new ArrayList<>();

	// ---------------------forestilling----------------------------
	public static ArrayList<Forestilling> getForestillinger() {
		return new ArrayList<>(forestillinger);
	}

	public static void addForestilling(Forestilling forestilling) {
		forestillinger.add(forestilling);
	}

	// ---------------------kunde----------------------------
	public static ArrayList<Kunde> getKunder() {
		return new ArrayList<>(kunder);
	}

	public static void addKunde(Kunde kunde) {
		kunder.add(kunde);
	}

}
