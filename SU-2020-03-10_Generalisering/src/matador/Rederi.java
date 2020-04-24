package matador;

public class Rederi extends FeltMedPris {

	private int basisLejePris;

	public Rederi(int feltNummer, String navn, int købsPris, int basisLejePris) {
		super(feltNummer, navn, købsPris);
		// TODO Auto-generated constructor stub
		this.setBasisLejePris(basisLejePris);
	}

	public int getBasisLejePris() {
		return basisLejePris;
	}

	public void setBasisLejePris(int basisLejePris) {
		this.basisLejePris = basisLejePris;
	}

}
