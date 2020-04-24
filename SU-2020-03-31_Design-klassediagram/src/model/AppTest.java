package model;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kontotype kt1 = new Kontotype("Pension", "Pension konto", "betingelser");
		Konto k1 = new Konto(kt1);
		Konto k2 = new Konto(kt1);

		k1.indsætBelæb(500);
		System.out.println(k1.toString());

		k1.indsætBelæb(-500);

		System.out.println(k2.toString());
		System.out.println(k1.beregnSaldo());

		System.out.println(k1.getTransaktioner().get(0).getDato());

	}

}
