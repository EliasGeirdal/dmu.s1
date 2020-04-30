package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Deltager;
import model.Firma;
import model.Hotel;
import model.Konference;
import model.Ledsager;
import model.Tillæg;
import model.Tilmelding;
import model.Udflugt;
import model.Værelse;
import storage.Storage;

public class Controller {

	// -------------tilmelding--------------------------------

	public static Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder,
			Deltager deltager, Ledsager ledsager, Konference konference, Værelse værelse) {
		Tilmelding tilmelding = new Tilmelding(ankomstDato, afrejseDato, foredragsholder, deltager, ledsager,
				konference, værelse);
		konference.addTilmelding(tilmelding);
		deltager.addTilmelding(tilmelding);
		Storage.addTilmelding(tilmelding);
		return tilmelding;
	}

	public static Tilmelding getTilmeldingForKonference(Konference konference, Deltager deltager) {
		Tilmelding tilmelding = null;

		for (int i = 0; i < konference.getTilmeldinger().size(); i++) {
			for (int j = 0; j < deltager.getTilmeldinger().size(); j++) {
				if (konference.getTilmeldinger().get(i).equals(deltager.getTilmeldinger().get(j))) {
					return konference.getTilmeldinger().get(i);
				}
			}
		}
		return tilmelding;
	}

	public static void deleteTilmeldingFromKonference(Tilmelding tilmelding, Konference konference) {
		konference.removeTilmelding(tilmelding);
	}

	public static void deleteTilmelding(Tilmelding tilmelding) {
		Storage.removeTilmelding(tilmelding);
	}

	public static ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(Storage.getTilmeldinger());
	}

	public static void updateTilmelding(Tilmelding tilmelding, LocalDate ankomstDato, LocalDate afrejseDato) {
		tilmelding.setAfrejseDato(afrejseDato);
		tilmelding.setAnkomstDato(ankomstDato);
	}

	// -------------konference--------------------------
	public static Konference createKonference(String navn, String adresse, LocalDate startDato, LocalDate slutDato,
			double pris) {
		Konference konference = new Konference(navn, adresse, startDato, slutDato, pris);
		Storage.addKonference(konference);
		return konference;
	}

	/**
	 * deletes konference. pre: no tilmeldinger attached to konference.
	 * 
	 * @param konference konference.
	 */
	public static void deleteKonference(Konference konference) {
		Storage.removeKonference(konference);
	}

	public static ArrayList<Konference> getKonferencer() {
		return new ArrayList<>(Storage.getKonferencer());
	}

	public static void updateKonference(Konference konference, String navn, String adresse, LocalDate startDato,
			LocalDate slutDato, double pris) {
		konference.setAdresse(adresse);
		konference.setNavn(navn);
		konference.setSlutDato(slutDato);
		konference.setStartDato(startDato);
		konference.setDagspris(pris);
	}

	// -------------hotel--------------------------
	public static Hotel createHotel(String navn, String adresse, String tlf, String email) {
		Hotel hotel = new Hotel(navn, adresse, tlf, email);
		Storage.addHotel(hotel);
		return hotel;
	}

	public static void deleteHotel(Hotel hotel) {
		Storage.removeHotel(hotel);
	}

	public static ArrayList<Hotel> getHoteller() {
		return new ArrayList<>(Storage.getHoteller());
	}

	public static void addHotelToKonference(Hotel hotel, Konference konference) {
		konference.addHotel(hotel);
	}

	public static void removeHotelFromKonference(Hotel hotel, Konference konference) {
		konference.removeHotel(hotel);
	}

	// ---------------værelse-------------------
	public static Værelse createVærelse(Hotel hotel, String type, double pris, int sengepladser) {
		Værelse værelse = hotel.createVærelse(type, pris, sengepladser);
		return værelse;
	}

	// -------------------tillæg-----------------------
	public static Tillæg createTillæg(Hotel hotel, String navn, String beskrivelse, double pris) {
		Tillæg tillæg = hotel.createTillæg(navn, beskrivelse, pris);
		return tillæg;
	}

	public static void addTillægToTilmelding(Tillæg tillæg, Tilmelding tilmelding) {
		tilmelding.addTillæg(tillæg);
	}

	// -------------deltager-------------------
	public static Deltager createDeltager(String fornavn, String efternavn, String tlf, String adresse) {
		Deltager deltager = new Deltager(fornavn, efternavn, tlf, adresse);
		Storage.addDeltager(deltager);
		return deltager;
	}

	public static ArrayList<Deltager> getDeltagereForKonference(Konference konference) {
		ArrayList<Deltager> deltagere = new ArrayList<>();
		for (Tilmelding tilmelding : konference.getTilmeldinger()) {
			deltagere.add(tilmelding.getDeltager());
		}
		return deltagere;
	}

	public static void deleteDeltager(Deltager deltager) {
		Storage.removeDeltager(deltager);
	}

	public static ArrayList<Deltager> getDeltagere() {
		return new ArrayList<>(Storage.getDeltagere());
	}

	public static void updateDeltager(Deltager deltager, String fornavn, String efternavn, String tlf, String adresse,
			Firma firma) {
		deltager.setAdresse(adresse);
		deltager.setEfternavn(efternavn);
		deltager.setFirma(firma);
		deltager.setFornavn(fornavn);
		deltager.setTlf(tlf);
	}

	public static ArrayList<Deltager> getDeltagereFromSpecificHotel(Hotel hotel) {
		ArrayList<Deltager> deltagere = new ArrayList<>();

		// iterates over all possible deltagere.
		for (int i = 0; i < Storage.getDeltagere().size(); i++) {
			// iterates over all possible tilmeldinger of the specific deltager
			for (int j = 0; j < Storage.getDeltagere().get(i).getTilmeldinger().size(); j++) {
				// iterates over alle possible hotel rooms of explicit parameter.
				for (int j2 = 0; j2 < hotel.getVærelser().size(); j2++) {
					// checks if the room of the explicit hotel parameter is the same as the room of
					// the deltager in storage.
					if (hotel.getVærelser().get(j2)
							.equals(Storage.getDeltagere().get(i).getTilmeldinger().get(j).getVærelse())) {
						// adds the new found deltager to our array list of deltagere
						deltagere.add(Storage.getDeltagere().get(i));
					}
				}
			}
		}
		return deltagere;
	}

	// ----------------ledsager---------------------
	public static Ledsager createLedsager(String navn, Tilmelding tilmelding) {
		Ledsager ledsager = new Ledsager(navn);
		tilmelding.setLedsager(ledsager);
		Storage.addLedsager(ledsager);
		return ledsager;
	}

	public static void removeLedsagerFromTilmelding(Tilmelding tilmelding) {
		tilmelding.setLedsager(null);
	}

	public static void deleteLedsager(Ledsager ledsager) {
		Storage.removeLedsager(ledsager);
	}

	public static ArrayList<Ledsager> getLedsagere() {
		return new ArrayList<>(Storage.getLedsagere());
	}

	// ---------------udflugt---------------------

	public static Udflugt createUdflugt(String navn, String adresse, String beskrivelse, double pris,
			LocalDate startDato, LocalDate slutDato, Konference konference) {
		Udflugt udflugt = konference.createUdflugt(navn, adresse, beskrivelse, pris, startDato, slutDato);
		return udflugt;
	}

	public static void updateUdflugt(String navn, String adresse, String beskrivelse, double pris, LocalDate startDato,
			LocalDate slutDato, Konference konference, Udflugt udflugt) {
		udflugt.setNavn(navn);
		udflugt.setAdresse(adresse);
		udflugt.setBeskrivelse(beskrivelse);
		udflugt.setPris(pris);
		udflugt.setSlutDato(slutDato);
		udflugt.setStartDato(startDato);
	}

	public static void deleteUdflugtFromKonference(Konference konference, Udflugt udflugt) {
		konference.removeUdflugt(udflugt);
	}

	public static void addUdflugtToLedsager(Ledsager ledsager, Udflugt udflugt) {
		udflugt.addLedsager(ledsager);
	}

	// -----------------firma-------------------------
	public static Firma createFirma(Deltager deltager, String navn, String tlf, String adresse) {
		Firma firma = new Firma(navn, tlf, adresse);
		deltager.setFirma(firma);
		Storage.addFirma(firma);
		return firma;
	}

	public static void removeFirmaFromDeltager(Deltager deltager) {
		deltager.setFirma(null);
	}

	public static void deleteFirma(Firma firma) {
		Storage.removeFirma(firma);
	}

	public static ArrayList<Firma> getFirmaer() {
		return new ArrayList<>(Storage.getFirmaer());
	}

	// -------------------initstorage-----------------------
	public static void initStorage() {

		Hotel h1 = Controller.createHotel("Den Hvide Svane", "Adresse", "60 60 60 60", "hotel@hotel.dk");
		Hotel h2 = Controller.createHotel("Høtel Phønix", "Adresse", "60 60 60 60", "hotel@hotel.dk");
		Hotel h3 = Controller.createHotel("Pension Tusindfryd", "Adresse", "60 60 60 60", "hotel@hotel.dk");

		// start og slut dato for konferencen
		LocalDate start = LocalDate.of(2020, 5, 18);
		LocalDate slut = LocalDate.of(2020, 5, 20);

		// konference
		Konference k1 = Controller.createKonference("Hav og himmel", "Adresse", start, slut, 1500);
		Konference k2 = Controller.createKonference("TestKonference", "Adresse", start, slut, 1500);

		// Udflugter til konferencen.
		Udflugt byrundtur = Controller.createUdflugt("Byrundtur, Odense", "Adresse", "Beskrivelse", 125.00, start,
				start, k1);
		Udflugt egeskov = Controller.createUdflugt("Egeskov", "Adresse", "Beskrivelse", 75.00,
				LocalDate.of(2020, 5, 19), LocalDate.of(2020, 5, 19), k1);
		Udflugt trapholt = Controller.createUdflugt("Trapholt Museum, Kolding", "Adresse", "Beskrivelse", 200, slut,
				slut, k1);

		// Værelser
		// hotel 1
		Værelse svaneDobbelt = Controller.createVærelse(h1, "dobbelt", 1250.00, 2);
		Værelse svaneEnkelt = Controller.createVærelse(h1, "Enkelt", 1050.00, 1);
		// Hotel 2
		Værelse høtelDobbelt = Controller.createVærelse(h2, "dobbelt", 800, 2);
		Værelse høtelEnkelt = Controller.createVærelse(h2, "Enkelt", 700, 1);
		// Hotel 3
		Værelse pensionDobbelt = Controller.createVærelse(h3, "dobbelt", 600, 2);
		Værelse pensionEnkelt = Controller.createVærelse(h3, "Enkelt", 500, 1);

		// Tillæg
		// Hotel 1
		Tillæg svaneBad = Controller.createTillæg(h1, "Bad", "Beskrivelse", 0);
		Tillæg svaneMad = Controller.createTillæg(h1, "Mad", "Beskrivelse", 0);
		Tillæg svaneWifi = Controller.createTillæg(h1, "WIFI", "Beskrivelse", 50);
		// Hotel 2
		Tillæg høtelBad = Controller.createTillæg(h2, "Bad", "Beskrivelse", 200);
		Tillæg høtelMad = Controller.createTillæg(h2, "Mad", "Beskrivelse", 0);
		Tillæg høtelWifi = Controller.createTillæg(h2, "WIFI", "Beskrivelse", 75);
		// Hotel 3
		Tillæg pensionBad = Controller.createTillæg(h3, "Bad", "Beskrivelse", 0);
		Tillæg pensionMad = Controller.createTillæg(h3, "Mad", "Beskrivelse", 100);
		Tillæg pensionWifi = Controller.createTillæg(h3, "WIFI", "Beskrivelse", 0);

		// ----------------test tilmeldinger--------------------
		// deltagere
		Deltager finn = Controller.createDeltager("Finn", "Madsen", "Tlf Placeholder", "Adresse");
		Deltager niels = Controller.createDeltager("Niels", "Petersen", "Tlf Placeholder", "Adresse");
		Deltager peter = Controller.createDeltager("Peter", "Sommer", "Tlf Placeholder", "Adresse");
		Deltager lone = Controller.createDeltager("Lone", "Jensen", "Tlf Placeholder", "Adresse");

		// tilmeldinger
		Tilmelding t1 = Controller.createTilmelding(start, slut, false, finn, null, k1, null);
		Tilmelding t2 = Controller.createTilmelding(start, slut, false, niels, null, k1, svaneEnkelt);
		Tilmelding t3 = Controller.createTilmelding(start, slut, false, peter, null, k1, svaneDobbelt);
		Tilmelding t4 = Controller.createTilmelding(start, slut, true, lone, null, k1, svaneDobbelt);

		// ledsagere
		Ledsager mie = Controller.createLedsager("Mie Sommer", t3);
		Ledsager jan = Controller.createLedsager("Jan Madsen", t4);

		// tillæg - forbind til tilmeldinger
		Controller.addTillægToTilmelding(svaneWifi, t3);
		Controller.addTillægToTilmelding(svaneWifi, t4);

		// udflugter - forbind til ledsager
		Controller.addUdflugtToLedsager(mie, egeskov);
		Controller.addUdflugtToLedsager(mie, trapholt);
		Controller.addUdflugtToLedsager(jan, byrundtur);
		Controller.addUdflugtToLedsager(jan, egeskov);
	}

	public static void init() {
		initStorage();
	}
}
