package opgave_3;

import java.util.ArrayList;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Ansat> ansatte = new ArrayList<>();
		Ansat m1 = new Mekaniker("Søren", "Gothåbsvej 58", 2005, 100);
		Ansat m2 = new Mekaniker("Supermand", "Gothåbsvej 58", 2005, 100);
		Ansat m3 = new Mekaniker("Morten", "Gothåbsvej 58", 2005, 100);
		Ansat v1 = new Værkfører("Peter", "Gothåbsvej 58", 2005, 100, 2008, 100);
		Ansat v2 = new Værkfører("Lars", "Gothåbsvej 58", 2005, 100, 2010, 100);
		Ansat s1 = new Synsmand("Lars", "Gothåbsvej 58", 2005, 100, 10);
		Ansat s2 = new Synsmand("Lars", "Gothåbsvej 58", 2005, 100, 10);
		Ansat a1 = new Arbejdsdreng("Lars", "Gothåbsvej 58", 100);
		Ansat a2 = new Arbejdsdreng("Lars", "Gothåbsvej 58", 100);

		ansatte.add(m1);
		ansatte.add(m2);
		ansatte.add(m3);
		ansatte.add(v1);
		ansatte.add(v2);
		ansatte.add(s1);
		ansatte.add(s2);
		ansatte.add(a1);
		ansatte.add(a2);

		System.out.println(samletLoen(ansatte));
		System.out.println(samletUgeløn(ansatte));
	}

	public static double samletUgeløn(ArrayList<Ansat> list) {
		double sum = 0;
		for (Ansat ansat : list) {
			sum += ansat.beregnLoen();
		}
		return sum;
	}

	/**
	 * Substitutions princippet bliver brugt i nedenstående metode, altså at
	 * mekaniker listen også kan indeholder subklasser til mekaniker samt er
	 * polymorfi blevet brugt, da beregnLoen metoden både eksisterer i mekaniker,
	 * værkfører og synsmand klassen. I nedenstående metode bliver beregnLoen
	 * metoden brugt afhængig af hvilken type klasse elementet i foreach løkken er.
	 * 
	 * @param ansatte
	 * @return
	 */
	public static double samletLoen(ArrayList<Ansat> ansatte) {
		double samletLoen = 0;
		// mekaniker listen kan indeholde subklasser, grundet substitutionsprincippet.
		for (Ansat ansat : ansatte) {
			// her bruges polymorfi til at berengLoen metoden bliver hentet fra den erklæret
			// klasse.
			samletLoen += ansat.beregnLoen();
		}
		return samletLoen;
	}

}
