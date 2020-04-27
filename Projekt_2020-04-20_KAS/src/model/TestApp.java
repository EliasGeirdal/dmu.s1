package model;

import java.time.LocalDateTime;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Hoteller
		Hotel h1 = new Hotel("Den Hvide Svane", "Adresse", "60 60 60 60", "hotel@hotel.dk");
		Hotel h2 = new Hotel("Høtel Phønix", "Adresse", "60 60 60 60", "hotel@hotel.dk");
		Hotel h3 = new Hotel("Pension Tusindfryd", "Adresse", "60 60 60 60", "hotel@hotel.dk");

		// start og slut dato for konferencen
		LocalDateTime start = LocalDateTime.of(2020, 5, 18, 12, 00);
		LocalDateTime slut = LocalDateTime.of(2020, 5, 20, 12, 00);

		// konference
		Konference k1 = new Konference("Hav og himmel", "Adresse", start, slut, 1500);

		// Udflugter til konferencen.
		Udflugt byrundtur = k1.createUdflugt("Byrundtur, Odense", "Adresse", "Beskrivelse", 125.00, start, start);
		Udflugt egeskov = k1.createUdflugt("Egeskov", "Adresse", "Beskrivelse", 75.00,
				LocalDateTime.of(2020, 5, 19, 12, 00), LocalDateTime.of(2020, 5, 19, 12, 00));
		Udflugt trapholt = k1.createUdflugt("Trapholt Museum, Kolding", "Adresse", "Beskrivelse", 200, slut, slut);

		// Værelser
		// hotel 1
		Værelse svaneDobbelt = h1.createVærelse("dobbelt", 1250.00, 2);
		Værelse svaneEnkelt = h1.createVærelse("Enkelt", 1050.00, 1);
		// Hotel 2
		Værelse høtelDobbelt = h2.createVærelse("dobbelt", 800, 2);
		Værelse høtelEnkelt = h2.createVærelse("Enkelt", 700, 1);
		// Hotel 3
		Værelse pensionDobbelt = h3.createVærelse("dobbelt", 600, 2);
		Værelse pensionEnkelt = h3.createVærelse("Enkelt", 500, 1);

		// Tillæg
		// Hotel 1
		Tillæg svaneBad = h1.createTillæg("Bad", "Beskrivelse", 0);
		Tillæg svaneMad = h1.createTillæg("Mad", "Beskrivelse", 0);
		Tillæg svaneWifi = h1.createTillæg("WIFI", "Beskrivelse", 50);
		// Hotel 2
		Tillæg høtelBad = h1.createTillæg("Bad", "Beskrivelse", 200);
		Tillæg høtelMad = h1.createTillæg("Mad", "Beskrivelse", 0);
		Tillæg høtelWifi = h1.createTillæg("WIFI", "Beskrivelse", 75);
		// Hotel 3
		Tillæg pensionBad = h1.createTillæg("Bad", "Beskrivelse", 0);
		Tillæg pensionMad = h1.createTillæg("Mad", "Beskrivelse", 100);
		Tillæg pensionWifi = h1.createTillæg("WIFI", "Beskrivelse", 0);

		// ----------------test tilmeldinger--------------------
		// deltagere
		Deltager finn = new Deltager("Finn", "Madsen", "Tlf Placeholder", "Adresse");
		Deltager niels = new Deltager("Niels", "Petersen", "Tlf Placeholder", "Adresse");
		Deltager peter = new Deltager("Peter", "Sommer", "Tlf Placeholder", "Adresse");
		Deltager lone = new Deltager("Lone", "Jensen", "Tlf Placeholder", "Adresse");

		// ledsagere
		Ledsager mie = new Ledsager("Mie Sommer");
		Ledsager jan = new Ledsager("Jan Madsen");

		// tilmeldinger
		Tilmelding t1 = new Tilmelding(start, slut, false, finn, null, k1, null);
		Tilmelding t2 = new Tilmelding(start, slut, false, niels, null, k1, svaneEnkelt);
		Tilmelding t3 = new Tilmelding(start, slut, false, peter, mie, k1, svaneDobbelt);
		Tilmelding t4 = new Tilmelding(start, slut, true, lone, jan, k1, svaneDobbelt);

		// tillæg - forbind til tilmeldinger
		t3.addTillæg(svaneWifi);
		t4.addTillæg(svaneWifi);

		// udflugter - forbind til ledsager
		mie.addUdflugt(egeskov);
		mie.addUdflugt(trapholt);
		jan.addUdflugt(byrundtur);
		jan.addUdflugt(egeskov);

		System.out.println(t1.beregnPris());
		System.out.println(t2.beregnPris());
		System.out.println(t3.beregnTillægspris());
		System.out.println(t3.beregnPris());
		System.out.println(t4.beregnPris());

	}

}
