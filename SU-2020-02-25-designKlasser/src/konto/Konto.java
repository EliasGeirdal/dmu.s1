package konto;

public class Konto {

	private int nr = 0;
	private int saldo = 0;
	private String kontoType;
	private String status = "åben";

	public Konto(String kontoType, int nr) {
		this.kontoType = kontoType;
		this.nr = nr;
	}

	public int getNr() {
		return nr;
	}

	public int getSaldoBalance() {
		return saldo;
	}

	public void setKontoType(String kontoType) {
		this.kontoType = kontoType;
	}

	public String getKontoType() {
		return kontoType;
	}

	public void indsætBeløb(int beløb) {
		if (status.equalsIgnoreCase("åben"))
			saldo += beløb;
		else
			System.out.println("fejl: Konto er lukket.");
	}

	public void hævBeløb(int beløb) {
		if (status.equalsIgnoreCase("lukket"))
			saldo -= beløb;
		else
			System.out.println("fejl: Konto er lukket.");
	}

	public void lukKonto() {
		if (status.equalsIgnoreCase("åben"))
			status = "lukket";
		else
			status = "åben";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Konto k = new Konto("budget", 2);
		System.out.println(k.getKontoType());
		k.indsætBeløb(500);
		System.out.println(k.getSaldoBalance());
		k.lukKonto();
		k.hævBeløb(200);

	}

}
