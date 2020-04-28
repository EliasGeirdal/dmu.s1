package storage;

import java.util.ArrayList;

import model.Deltager;
import model.Firma;
import model.Hotel;
import model.Konference;
import model.Ledsager;
import model.Tilmelding;

public class Storage {
	private static ArrayList<Tilmelding> tilmeldinger;
	private static ArrayList<Konference> konferencer;
	private static ArrayList<Hotel> hoteller;
	private static ArrayList<Deltager> deltagere;
	private static ArrayList<Ledsager> ledsagere;
	private static ArrayList<Firma> firmaer;

	// test

	// -----------------------tilmelding-----------------
	public static ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(tilmeldinger);
	}

	public static void addTilmelding(Tilmelding tilmelding) {
		tilmeldinger.add(tilmelding);
	}

	public static void removeTilmelding(Tilmelding tilmelding) {
		tilmeldinger.remove(tilmelding);
	}

	// ---------------------konference-------------------------
	public static ArrayList<Konference> getKonferencer() {
		return new ArrayList<>(konferencer);
	}

	public static void addKonference(Konference konference) {
		konferencer.add(konference);
	}

	public static void removeKonference(Konference konference) {
		konferencer.remove(konference);
	}

	// -------------------hoteller-----------------------
	public static ArrayList<Hotel> getHoteller() {
		return new ArrayList<>(hoteller);
	}

	public static void addHotel(Hotel hotel) {
		hoteller.add(hotel);
	}

	public static void removeHotel(Hotel hotel) {
		hoteller.remove(hotel);
	}

	// -----------------deltagere---------------------
	public static ArrayList<Deltager> getDeltagere() {
		return new ArrayList<>(deltagere);
	}

	public static void addDeltager(Deltager deltager) {
		deltagere.add(deltager);
	}

	public static void removeDeltager(Deltager deltager) {
		deltagere.remove(deltager);
	}

	// -------------ledsager-------------------------
	public static ArrayList<Ledsager> getLedsagere() {
		return new ArrayList<>(ledsagere);
	}

	public static void addLedsager(Ledsager ledsager) {
		ledsagere.add(ledsager);
	}

	public static void removeLedsager(Ledsager ledsager) {
		ledsagere.remove(ledsager);
	}

	// ----------------firma--------------------------
	public static ArrayList<Firma> getFirma() {
		return new ArrayList<>(firmaer);
	}

	public static void addFirma(Firma firma) {
		firmaer.add(firma);
	}

	public static void removeFirma(Firma firma) {
		firmaer.remove(firma);
	}
}
