package storage;

import java.util.ArrayList;

import model.Bil;
import model.Prisgruppe;

public class Storage {
	private static ArrayList<Bil> biler = new ArrayList<>();
	private static ArrayList<Prisgruppe> prisgrupper = new ArrayList<>();

	// -----------------------------------------------------------------------------------------

	public static ArrayList<Bil> getBil() {
		return new ArrayList<>(biler);
	}

	public static void addBil(Bil bil) {
		biler.add(bil);
	}

	public static void removeBil(Bil bil) {
		biler.remove(bil);
	}

	// ------------------------------------------------------------------------------------------

	public static ArrayList<Prisgruppe> getPrisgruppe() {
		return new ArrayList<>(prisgrupper);
	}

	public static void addPrisgruppe(Prisgruppe prisgruppe) {
		prisgrupper.add(prisgruppe);
	}

	public static void removePrisgruppe(Prisgruppe prisgruppe) {
		prisgrupper.remove(prisgruppe);
	}

}
