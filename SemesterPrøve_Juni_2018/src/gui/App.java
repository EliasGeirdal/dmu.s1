package gui;

import java.io.FileNotFoundException;
import java.time.LocalDate;

import controller.Controller;
import model.PraktikVirksomhed;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Controller.initStorage();
		PraktikVirksomhed p1 = Controller.getPraktikVirksomheder().get(0);
		p1.skrivTilFilKontrakter();
		System.out.println();
		System.out.println(p1.getPraktikKontrakter());
		p1.sorterKontrakter();
		System.out.println(p1.getPraktikKontrakter());
		System.out
				.println(p1.getTotalAntalUgentligeTimerIPeriode(LocalDate.of(2018, 6, 20), LocalDate.of(2020, 9, 20)));
		System.out.println(Controller.getEftertragtetSemesterVirksomhed(5));
	}

}
