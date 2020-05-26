package Controller;

import Model.Konto;
import Model.KontoType;
import Storage.Storage;

public class Controller {

	public static KontoType createKontoType(String navn, String beskrivelse) {

		KontoType kontoType = new KontoType(navn, beskrivelse);
		Storage.addKontoType(kontoType);
		return kontoType;
	}

	public static Konto createKonto(KontoType kontoType) {
		Konto konto = null;

		konto = new Konto(kontoType);

		return konto;
	}

	public static void lukKonto(Konto konto) {
		konto.lukKonto();
	}

	public static void haevEllerIndsaetBeloeb(Konto konto, int beloeb) {
		try {
			konto.haevEllerIndsaetBeloeb(beloeb);
		} catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}

}
