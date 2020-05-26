package opgave3;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer c1 = new Customer("Anna", "Andersen", 18);
		Customer c2 = new Customer("Bent", "Bentsen", 19);
		Customer c3 = new Customer("Erik", "Erikson", 20);
		Customer c4 = new Customer("Frederik", "Frederikson", 21);
		ArrayList<Customer> customers = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));

		Customer c5 = new Customer("Anna", "Andersen", 18);
		Customer c6 = new Customer("Bent", "Bentsen", 19);
		Customer c7 = new Customer("Carl", "Carlson", 22);
//		Customer c8 = new Customer("Frederik", "Frederikson", 21);
//		Customer c9 = new Customer("Gudmund", "Gudmundson", 23);
//		Customer c10 = new Customer("Hans", "Hanson", 18);
		Customer[] badCustomers = { c5, c6, c7 };

		System.out.printf("Customers:      %s%n%n", customers);
		System.out.printf("Bad customers:  %s%n%n", Arrays.toString(badCustomers));
		System.out.printf("Good customers: %s%n", goodCustomers(customers, badCustomers));

	}

	/**
	 * Returnerer en sorteret ArrayList der indeholder alle customers fra l1 der
	 * ikke er i l2 Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
	 * indeholder ikke tomme pladser
	 */
	public static ArrayList<Customer> goodCustomers(ArrayList<Customer> l1, Customer[] l2) {
		ArrayList<Customer> result = new ArrayList<>();

		int i1 = 0;
		int i2 = 0;
		while (i1 < l1.size() && i2 < l2.length) {
			if (l1.get(i1).compareTo(l2[i2]) < 0) { // l1 comes first.
				result.add(l1.get(i1));
				i1++;
			} else if (l1.get(i1).compareTo(l2[i2]) > 0) { // l2 comes first.
				i2++;
			} else {
				i1++;
				i2++; // if they are duplicates
			}
		}
		// empty rest of l1.
		while (i1 < l1.size()) {
			result.add(l1.get(i1));
			i1++;
		}
		return result;
	}
}
