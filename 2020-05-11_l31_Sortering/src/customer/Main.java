package customer;

import java.util.Arrays;

import measure.SortMethods;

public class Main {

	public static void main(String[] args) {
		Customer c1 = new Customer(25, "Peter", "Jensen");
		Customer c2 = new Customer(25, "Poul", "Jensen");
		Customer c4 = new Customer(21, "Peter", "Jensen");
		Customer c3 = new Customer(25, "Peter", "Nielsen");

		Customer[] customers = { c1, c2, c3, c4 };
		Customer[] customers2 = Arrays.copyOf(customers, 2);

		for (Customer c : customers2)
			System.out.println(c);

		System.out.println(c1.compareTo(c2));
		System.out.println(c1.compareTo(c3));
		System.out.println(c1.compareTo(c4));
		System.out.println(c3.compareTo(c4));

		SortMethods.selectionSort(customers);
		System.out.println(Arrays.toString(customers));
	}
}
