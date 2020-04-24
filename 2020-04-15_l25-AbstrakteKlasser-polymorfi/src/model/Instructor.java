package model;

public class Instructor extends Person {

	private int monthlySalary;

	public Instructor(String navn, int foedselsår, int salary) {
		super(navn, foedselsår);
		this.setSalary(salary);
	}

	@Override
	public String toString() {
		return super.toString() + "Instructor [salary=" + monthlySalary + "]";
	}

	public int getSalary() {
		return monthlySalary;
	}

	public void setSalary(int salary) {
		this.monthlySalary = salary;
	}
}
