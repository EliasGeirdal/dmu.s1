package opgave3;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> {
	private int alder;
	private String fornavn;
	private String efternavn;

	public Customer(String fornavn, String efternavn, int alder) {
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
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).compareTo(customer) >= 0)
				customers.add(i, customer);
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
