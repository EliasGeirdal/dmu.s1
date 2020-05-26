package storage;

import java.util.ArrayList;

import model.Bil;
import model.Parkeringshus;

public class Storage {
	private static ArrayList<Parkeringshus> parkeringshuse = new ArrayList<>();
	private static ArrayList<Bil> biler = new ArrayList<>();

	// ----------------parkeringshuse---------------------------
	public static ArrayList<Parkeringshus> getParkeringshuse() {
		return new ArrayList<>(parkeringshuse);
	}

	public static void addParkeringshus(Parkeringshus parkeringshus) {
		parkeringshuse.add(parkeringshus);
	}

	// -------------------bil----------------------------------
	public static ArrayList<Bil> getBiler() {
		return new ArrayList<>(biler);
	}

	public static void addBil(Bil bil) {
		biler.add(bil);
	}

}
