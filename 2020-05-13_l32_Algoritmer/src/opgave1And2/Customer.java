package opgave1And2;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> {
	private int alder;
	private String fornavn;
	private String efternavn;

	public Customer(int alder, String fornavn, String efternavn) {
		super();
		this.alder = alder;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
	}

	public int getAlder() {
		return alder;
	}

	public void setAlder(int alder) {
		this.alder = alder;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEfternavn() {
		return efternavn;
	}

	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}

	/**
	 * Indsætter kunde i kunder. Listen kunder er sorteret Krav: kunder er sorteret
	 *
	 */
	public static void insertCustomer(ArrayList<Customer> customers, Customer customer) {
		int i = 0;
		boolean insertIndexFound = false;
		while (!insertIndexFound && i <= customers.size()) {
			if (customers.get(i).compareTo(customer) > 0) {
				customers.add(i, customer);
				insertIndexFound = true;
			} else if (i == customers.size() - 1) {
				customers.add(customer);
				insertIndexFound = true;
			}
			i++;
		}
	}

	/**
	 * Indsætter kunde i kunder. Listen kunder er sorteret Krav: kunder er sorteret
	 *
	 */
	public static void insertCustomer(Customer[] customers, Customer customer) {
		int i = 0;
		boolean insertIndexFound = false;
		while (!insertIndexFound && i <= customers.length - 1) {
			if (customers[i] == null || customers[i].compareTo(customer) > 0) {
				add(customers, customer, i);
				insertIndexFound = true;
			}
			i++;
		}
	}

	private static void add(Customer[] list, Customer customer, int index) {
		if (index == list.length - 1) {
			list[index] = customer;
		} else {
			for (int i = list.length - 1; i > index; i--) {
				list[i] = list[i - 1];
			}
			list[index] = customer;
		}
	}

	@Override
	public int compareTo(Customer customer) {
		int compare = efternavn.compareTo(customer.efternavn);
		if (compare == 0) {
			compare = fornavn.compareTo(customer.fornavn);
			if (compare == 0) {
				compare = alder - customer.alder;
			}
		}
		return compare;
	}

	@Override
	public String toString() {
		return efternavn + " " + fornavn + " " + alder;
	}

}
