package Model;

import Controller.Controller;

public class TilstandeTest {

	public static void main(String[] args) {

		KontoType kontotype = Controller.createKontoType("Ungdomskonto",
				"En kontotype til unge under 25, som for at beskytte du unge ikke tillader at der haeves paa en konto med saldo under 0");

		Konto k1 = Controller.createKonto(kontotype);

		Controller.haevEllerIndsaetBeloeb(k1, 100);
		Controller.haevEllerIndsaetBeloeb(k1, -100);

		Controller.lukKonto(k1);
		Controller.haevEllerIndsaetBeloeb(k1, 100);

		// tilfoej flere transaktioner og se hvad der sker

		System.out.println(k1);

	}
}
