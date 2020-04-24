package opgave_5;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Indkøbsvogn i1 = new Indkøbsvogn();

		i1.addVare(new Spiritus(100, "Vodka", "Noget på russisk", 365, 37.5));
		i1.addVare(new Fødevare(5, "æble", "Keeps the doctor away", 365));
		i1.addVare(new Elartikle(1000, "Samsung", "Elektronisk elektronik", 10));

		System.out.println(i1.beregnTotal());

		System.out.println(i1.getVarer());

	}

}
