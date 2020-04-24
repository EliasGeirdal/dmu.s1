package matador;

public class Felt {

	private int feltNummer;
	private String navn;

	public Felt(int feltNummer, String navn) {
		this.setFeltNummer(feltNummer);
		this.setNavn(navn);
	}

	public int getFeltNummer() {
		return feltNummer;
	}

	public void setFeltNummer(int feltNummer) {
		this.feltNummer = feltNummer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void udskrivFelt() {
		System.out.println("Nummer: " + feltNummer + "\nNavn: " + navn);
	}

}
