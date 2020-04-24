package matador;

public class FeltMedPris extends Felt {

	private int købsPris = 0;

	public FeltMedPris(int feltNummer, String navn, int købsPris) {
		super(feltNummer, navn);
		// TODO Auto-generated constructor stub
		this.setKøbsPris(købsPris);
	}

	public int getKøbsPris() {
		return købsPris;
	}

	public void setKøbsPris(int købsPris) {
		this.købsPris = købsPris;
	}

	@Override
	public void udskrivFelt() {
		super.udskrivFelt();
		System.out.println("Købspris: " + købsPris);
	}
}
