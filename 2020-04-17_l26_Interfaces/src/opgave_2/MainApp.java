package opgave_2;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer[] list = new Customer[4];

		// Check last name.
		list[0] = new Customer("A", "A", 20);
		list[1] = new Customer("B", "B", 20);
		list[2] = new Customer("C", "C", 20);
		list[3] = new Customer("D", "D", 20);

		// check first name
		list[0] = new Customer("A", "A", 20);
		list[1] = new Customer("B", "A", 20);
		list[2] = new Customer("C", "A", 20);
		list[3] = new Customer("D", "A", 20);

		// Check age.
		list[0] = new Customer("A", "A", 20);
		list[1] = new Customer("A", "A", 21);
		list[2] = new Customer("A", "A", 22);
		list[3] = new Customer("A", "A", 23);

		// test afterCustomer
		list[0] = new Customer("A", "A", 20);
		list[1] = new Customer("A", "B", 21);
		list[2] = new Customer("A", "C", 22);
		list[3] = new Customer("A", "D", 23);

		Customer test = new Customer("A", "B", 19);

//		System.out.println(Customer.lastCustomer(list));

		Customer[] testList = Customer.afterCustomer(list, test);

		for (Customer customer : testList) {
			System.out.println(customer);
		}
	}

}
