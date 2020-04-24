public class Teacher extends Person {

	private int salary = 0;
	private String fag;

	public Teacher(String name, String address, String qualification, int salary) {
		super(name, address, qualification);
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public void udskrivPerson() {
		super.udskrivPerson();
		System.out.println("Salary: " + salary);
	}

	public double yearSalary() {
		return (salary * 1.125) * 12;
	}

	public String getFag() {
		return fag;
	}

}
