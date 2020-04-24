package bank;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount b1 = new BankAccount(2000);
		BankAccount b2 = new BankAccount(10000);
		BankAccount b3 = new BankAccount(50000);

		System.out.println(b1.getBalance());
		System.out.println(b1.getId());
		System.out.println(b2.getId());
		System.out.println(b3.getId());
	}

}
