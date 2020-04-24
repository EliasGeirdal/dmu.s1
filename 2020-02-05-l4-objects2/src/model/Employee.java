package model;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String name;
	private boolean trainee;
	private int age;
	private String lastname;

	/**
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved oprettelse
	 * er den ansatte en trainee
	 * @param name skal indeholde string med fornavn
	 * @param lastname skal indeholde...
	 */
	public Employee(String inputName, String lastname, int age) {
		name = inputName;
		this.lastname = lastname;
		this.age = age;
		trainee = true;
	}

	// den ansattes navn kaldes ved et setLastname metoden


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}

	// den ansattes nye alder efter fødselsdag kaldes ved getBirthday metoden.

	public void birthday() {
		age = age + 1;
	}

	// den ansattes alder kan ændres ved kald af setAge metoden

	public void setAge(int age) {
		this.age = age;
	}

	// den ansattes navn kan hentes ved getAge metoden
	public int getAge() {
		return age;
	}

	// Den ansattes navn kan ændres ved kald af setName metoden

	public void setName(String inputName) {
		name = inputName;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getName() {
		return name;
	}

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	public void printEmployee() {

		System.out.println("*******************");
		System.out.println("First name: " + name);
		System.out.println("Last name: " + lastname);
		System.out.println("Trainee " + trainee);
		System.out.println(age);

	}
}
