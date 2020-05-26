package opgave1;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		ArrayList<Customer> l1 = new ArrayList<>();
		ArrayList<Customer> l2 = new ArrayList<>();
		Customer c1 = new Customer(20, "Jens", "Jensen");
		Customer c2 = new Customer(20, "Amadeo", "Jensen");
		Customer c3 = new Customer(20, "Arielle", "Jensen");
		Customer c4 = new Customer(20, "Olivia", "Jensen");
		Customer c5 = new Customer(20, "Isla", "Jensen");
		Customer c6 = new Customer(20, "Ava", "Jensen");
		Customer c7 = new Customer(20, "Liam", "Jensen");
		l1.add(c1);
		l1.add(c2);
		l1.add(c3);
		l2.add(c4);
		l2.add(c5);
		l2.add(c6);
		l2.add(c7);
		Collections.sort(l1);
		Collections.sort(l2);
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(fletAlleKunder(l1, l2));
	}

	/**
	 * Returnerer en sorteret ArrayList der indeholder alle kunder fra både l1 og l2
	 * Krav: l1 og l2 er sorterede
	 */
	public static ArrayList<Customer> fletAlleKunder(ArrayList<Customer> l1, ArrayList<Customer> l2) {
		ArrayList<Customer> result = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		while (i1 < l1.size() && i2 < l2.size()) {
			if (l1.get(i1).compareTo(l2.get(i2)) <= 0) {
				result.add(l1.get(i1));
				i1++;
			} else {
				result.add(l2.get(i2));
				i2++;
			}
		}
		while (i1 < l1.size()) {
			result.add(l1.get(i1));
			i1++;
		}
		while (i2 < l2.size()) {
			result.add(l2.get(i2));
			i2++;
		}
		return result;
	}
}
