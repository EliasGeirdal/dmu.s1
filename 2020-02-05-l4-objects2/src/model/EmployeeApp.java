package model;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans Jensen ", "Peterson", 27);
		e1.birthday();
		e1.printEmployee();
		e1.setName("Viggo ");
		e1.setLastname("olesen");
		e1.setAge(32);
		e1.birthday();
		e1.printEmployee();
	}

}
