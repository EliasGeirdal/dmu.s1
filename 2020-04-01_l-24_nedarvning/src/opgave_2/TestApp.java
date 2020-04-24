package opgave_2;

import java.util.ArrayList;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Mekaniker> mekaniker = new ArrayList<>();
		Mekaniker m1 = new Mekaniker("Søren", "Gothåbsvej 58", 2005, 100);
		Mekaniker m2 = new Mekaniker("Supermand", "Gothåbsvej 58", 2005, 100);
		Mekaniker m3 = new Mekaniker("Morten", "Gothåbsvej 58", 2005, 100);
		Værkfører v1 = new Værkfører("Peter", "Gothåbsvej 58", 2005, 100, 2008, 100);
		Værkfører v2 = new Værkfører("Lars", "Gothåbsvej 58", 2005, 100, 2010, 100);
		Synsmand s1 = new Synsmand("Lars", "Gothåbsvej 58", 2005, 100, 10);
		Synsmand s2 = new Synsmand("Lars", "Gothåbsvej 58", 2005, 100, 10);

		mekaniker.add(m1);
		mekaniker.add(m2);
		mekaniker.add(m3);
		mekaniker.add(v1);
		mekaniker.add(v2);
		mekaniker.add(s1);
		mekaniker.add(s2);

		System.out.println(samletLoen(mekaniker));
	}

	/**
	 * Substitutions princippet bliver brugt i nedenstående metode, altså at
	 * mekaniker listen også kan indeholder subklasser til mekaniker samt er
	 * polymorfi blevet brugt, da beregnLoen metoden både eksisterer i mekaniker,
	 * værkfører og synsmand klassen. I nedenstående metode bliver beregnLoen
	 * metoden brugt afhængig af hvilken type klasse elementet i foreach løkken er.
	 * 
	 * @param list
	 * @return
	 */
	public static double samletLoen(ArrayList<Mekaniker> list) {
		double samletLoen = 0;
		// mekaniker listen kan indeholde subklasser, grundet substitutionsprincippet.
		for (Mekaniker mekaniker : list) {
			// her bruges polymorfi til at berengLoen metoden bliver hentet fra den erklæret
			// klasse.
			samletLoen += mekaniker.beregnLoen();
		}
		return samletLoen;
	}
}
