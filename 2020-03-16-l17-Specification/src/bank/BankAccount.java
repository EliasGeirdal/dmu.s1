package bank;

/*
 * Modellerer en bank konto.
 */
public class BankAccount {
	private double balance;
	private static int nextId = 1000;
	private final int id;

	/**
	 * Initialisere en bank konto's startværdi.
	 * 
	 * @param initialBalance
	 */

	public BankAccount(double initialBalance) {
		balance = initialBalance;
		id = nextId++;
	}

	/**
	 * registrerer hvor meget der indsættes på kontoen. pre: 0 <= amount.
	 * 
	 * @param amount
	 */
	public void deposit(double amount) {
		balance += amount;
	}

	/**
	 * registrerer hvor meget der hæves. pre: balance >= amount
	 * 
	 * @param amount
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}

	/**
	 * Returnerer beløbet på kontoen.
	 * 
	 * @return beløb på konto.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * returnerer kontoens id.
	 * 
	 * @return id.
	 */
	public final int getId() {
		return id;
	}
}