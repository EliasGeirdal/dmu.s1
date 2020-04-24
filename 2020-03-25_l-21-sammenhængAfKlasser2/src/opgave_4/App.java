package opgave_4;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kollegie k1 = new Kollegie("Egmont", "Nørre Allé 75");

		Bolig b1 = k1.createBolig(25, "Odinsvej 27", 4500, k1);
		Bolig b2 = k1.createBolig(25, "Odinsvej 27", 4500, k1);

		LocalDate nextMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1);
		Lejeaftale lejeaftale1 = b1.createLejeaftale(b1, nextMonth);
		Lejeaftale lejeaftale2 = b1.createLejeaftale(b1, nextMonth);
		Lejeaftale lejeaftale3 = b1.createLejeaftale(b1, nextMonth);
		Lejeaftale lejeaftale4 = b2.createLejeaftale(b1, nextMonth);
		Lejeaftale lejeaftale5 = b2.createLejeaftale(b1, nextMonth);

		lejeaftale1.setTilDato(LocalDate.now().plusMonths(5));
		lejeaftale2.setTilDato(LocalDate.now().plusMonths(10));
		lejeaftale3.setTilDato(LocalDate.now().plusMonths(7));
		lejeaftale4.setTilDato(LocalDate.now().plusMonths(11));
		lejeaftale5.setTilDato(LocalDate.now().plusMonths(6));

		Lejer l1 = new Lejer("James", "HåndboldSpiller"), l2 = new Lejer("Elias", "BasketSpiller");

		lejeaftale1.addLejere(l1, l2);

		System.out.printf("%s%n%n", k1);
		System.out.printf("%s%n%n", b1);
		System.out.printf("%s%n%n", lejeaftale1);
		System.out.printf("%s%n%n", lejeaftale1.getLejere());

		System.out.println(k1.antalLejeAftaler());
		System.out.println(k1.gennemsnitligAntalDage());
	}

}
