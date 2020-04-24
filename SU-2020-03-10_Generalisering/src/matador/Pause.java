package matador;

public class Pause extends Felt {

	private String bemærkning = " ";

	public Pause(int feltNummer, String navn, String bemærkning) {
		super(feltNummer, navn);
		// TODO Auto-generated constructor stub
		this.setBemærkning(bemærkning);
	}

	public String getBemærkning() {
		return bemærkning;
	}

	public void setBemærkning(String bemærkning) {
		this.bemærkning = bemærkning;
	}

}
