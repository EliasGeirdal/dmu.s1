package model;

public class Person {
	
	// Instance variables describing the person
	
	private String name;
	private String address;
	private double monthlySalary;
	private double yearlySalary;
	private double holidayPay;
	private String previousFirms;
	
	/** Constructor: when describing the person, we need to know persons name, address, monthly salary etc.
	 * @param name persons name.
	 * @param address persons address.
	 * @param monthlySalary persons salary on a monthly basis.
	 * @param yearlySalary persons salary on a yearly basis.
	 * @param holidayPay persons holiday pay calculated from 2.5 percent of yearly salary.
	*/
	
	public Person(String name, String address, double monthlySalary) {
		this.name = name;
		this.address = address;
		this.monthlySalary = monthlySalary;
		this.yearlySalary = monthlySalary * 12;
	    this.holidayPay = (yearlySalary * 1.025) - yearlySalary;
	}
	
	// The persons previous firms is set by SetPreviousFirms method.
	// The persons previous firms is called by getPreviousFirms method.
	
	public void setPreviousFirms(String previousFirms) {
		this.previousFirms = previousFirms;
	}
	
	public String getPreviousFirms() {
		return previousFirms;
	}
	
	
	// The persons yearly salary is set by setYearlySalary method.
	// The persons yearly salary is called by getYearlySalary method.
	
	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = monthlySalary * 12;
	}
	
	public double getYearlySalary() {
		return yearlySalary;
	}
	
	// The persons holiday pay is set by setHolidayPay method.
	// The persons holiday pay is called by getHolidayPay method.
	
	public void setHolidayPay(double holidayPay) {
		this.holidayPay = (yearlySalary * 1.025) - yearlySalary;
	}
	
	public double getHolidayPay() {
		return holidayPay;
	}

	// Personens navn kaldes ved setName metoden.
	// Personens navn hentes ved getName metoden.
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	// Personens addresse kaldes ved setAddress metoden.
	// Personens addresse hentes ved getAddress metoden.
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	// The persons monthly salary is set by the setMonthlySalary method.
	// The persons monthly salary is called by the getMonthlySalary method.
	
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	public double getMonthlySalary() {
		return monthlySalary;
	}
	
	String underscore = "****************************************************************************";
	
	public void printPerson() {
		System.out.println("PERSON");
		System.out.println(underscore);
		System.out.println("name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Salary: " + monthlySalary);
		System.out.println("Yearly salary: " + yearlySalary);
		System.out.println("holiday pay " + holidayPay);
		System.out.println("Previous companies: " + previousFirms);
		System.out.println(underscore);
	}

}
