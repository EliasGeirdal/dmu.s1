package matador;

public class Grund extends FeltMedPris {

	private int lejePris;

	public Grund(int feltNummer, String navn, int købsPris, int lejePris) {
		super(feltNummer, navn, købsPris);
		// TODO Auto-generated constructor stub
		this.setLejePris(lejePris);
	}

	public int getLejePris() {
		return lejePris;
	}

	public void setLejePris(int lejePris) {
		this.lejePris = lejePris;
	}

}
