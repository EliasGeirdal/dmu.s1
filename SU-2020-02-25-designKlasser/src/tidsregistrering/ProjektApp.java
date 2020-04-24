package tidsregistrering;

import java.time.LocalDate;

public class ProjektApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Projekt p = new Projekt("Title1", LocalDate.now(), LocalDate.of(2020, 2, 27));
		System.out.println(p.getDeadline());
		p.setDeadline(LocalDate.of(2021, 02, 25));
		System.out.println(p.getDeadline());
		System.out.println(p.getDate());

//		p.LocalDate.((int) deadline)
		// Kode til Magnus

	}

}
