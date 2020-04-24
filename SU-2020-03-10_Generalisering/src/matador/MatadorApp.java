package matador;

public class MatadorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Felt felt = new Felt(2, "Fasanvej 11");
		FeltMedPris fasanvej = new FeltMedPris(2, "Fasanvej 11", 850000);
		Grund PizzaNord = new Grund(2, "Fasanvej 11", 850000, 30000);

		fasanvej.udskrivFelt();
	}

}
