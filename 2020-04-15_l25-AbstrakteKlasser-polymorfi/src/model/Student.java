package model;

public class Student extends Person {
	private String hovedfag;

	public Student(String navn, int foedselsår, String hovedfag) {
		super(navn, foedselsår);
		this.setHovedfag(hovedfag);
	}

	@Override
	public String toString() {
		return super.toString() + "Student [hovedfag=" + hovedfag + "]";
	}

	public String getHovedfag() {
		return hovedfag;
	}

	public void setHovedfag(String hovedfag) {
		this.hovedfag = hovedfag;
	}
}
