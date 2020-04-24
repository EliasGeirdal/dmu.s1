package model;

public class Person {
	private String navn;
	private int foedselsår;

	public Person(String navn, int foedselsår) {
		this.setFoedselsår(foedselsår);
		this.setNavn(navn);
	}

	@Override
	public String toString() {
		return "\nPerson [navn=" + navn + ", foedselsår=" + foedselsår + "] ";
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getFoedselsår() {
		return foedselsår;
	}

	public void setFoedselsår(int foedselsår) {
		this.foedselsår = foedselsår;
	}
}
