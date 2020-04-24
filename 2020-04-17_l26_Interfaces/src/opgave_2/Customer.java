package opgave_2;

import java.util.Arrays;

public class Customer implements Comparable<Customer> {

	private String fornavn, efternavn;
	private int alder;

	@Override
	public String toString() {
		return "Customer [fornavn=" + fornavn + ", efternavn=" + efternavn + ", alder=" + alder + "]";
	}

	public Customer() {
	}

	public Customer(String fornavn, String efternavn, int alder) {
		super();
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.alder = alder;
	}

	@Override
	public int compareTo(Customer otherCustomer) {
		// TODO Auto-generated method stub
		int comp = 0;
		if (this.efternavn.compareTo(otherCustomer.getEfternavn()) == 0) {
			if (this.fornavn.compareTo(otherCustomer.getFornavn()) == 0) {
				comp = this.getAlder() - otherCustomer.getAlder();
			} else {
				comp = this.getFornavn().compareTo(otherCustomer.getFornavn());
			}
		} else {
			comp = this.getEfternavn().compareTo(otherCustomer.getEfternavn());
		}
		return comp;
	}

	public static Customer lastCustomer(Customer[] customers) {
		Customer lastCustomer = customers[0];
		for (Customer customer : customers) {
			if (customer.compareTo(lastCustomer) > 0) {
				lastCustomer = customer;
			}
		}
		return lastCustomer;
	}

	public static Customer[] afterCustomer(Customer[] customers, Customer customer) {
		Customer[] c1 = new Customer[customers.length];
		int count = 0;
		for (int i = 0; i < customers.length; i++) {
			if (customer.compareTo(customers[i]) < 0) {
				c1[count] = customers[i];
				count++;
			}
		}
		return Arrays.copyOf(c1, count);
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

	public int getAlder() {
		return alder;
	}

	public void setAlder(int alder) {
		this.alder = alder;
	}

}
