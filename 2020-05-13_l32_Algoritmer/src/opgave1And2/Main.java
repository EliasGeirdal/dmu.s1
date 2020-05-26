package opgave1And2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Customer c1 = new Customer(25, "A", "A");
		Customer c2 = new Customer(25, "B", "B");
		Customer c3 = new Customer(21, "D", "D");

		Customer c4 = new Customer(25, "C", "C");
		Customer c5 = new Customer(21, "E", "E");
		Customer c6 = new Customer(21, "0", "0");

//		ArrayList<Customer> liste = new ArrayList<>();
//		liste.add(c1);
//		liste.add(c2);
//		liste.add(c3);
//		liste.add(c4);
//		
//		Customer[] array = {c1, c2, c3, c5, null};
//
//		System.out.println(liste);
//
//		Customer.insertCustomer(liste, c5);
//		System.out.println(liste);
//		Customer.insertCustomer(liste, c6);
//		System.out.println(liste);

		Customer[] liste = { c1, c2, c3, null, null, null };
		System.out.println(Arrays.toString(liste));
		// test inserting a object inside the list.
		Customer.insertCustomer(liste, c4);
		System.out.println(Arrays.toString(liste));
		// test insert at the end of the array.
		Customer.insertCustomer(liste, c5);
		System.out.println(Arrays.toString(liste));
		// test insert in the beginning of the array.
		Customer.insertCustomer(liste, c6);
		System.out.println(Arrays.toString(liste));

	}
}
