package opgave1dobbelArray;

public class Opgave1DobbelArray {

	public static void main(String[] args) {
		final int ROW = 8;
		final int COL = 8;
		int[][] values = new int[ROW][COL];
		DobbelArray da = new DobbelArray();

		// Udskriv values på tabel form
		da.udskrivArray(values);

		// TODO Opgave 1.1 lav ændringer i values så der står 5 på alle pladser

		System.out.println();
		System.out.println("Nedenfor skulle der stå 5 på alle pladser");
		System.out.println();
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				values[i][j] = 5;
			}
		}
		da.udskrivArray(values);

		// TODO Opgave 1.2 lav ændringer i values så der står 2 i lige rækker og 3 i
		// ulige

		System.out.println();
		System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden række");
		System.out.println();
		for (int i = 0; i < values.length; i++) {
			for (int j = 1; j <= values[i].length; j++) {
				if (j % 2 == 0)
					values[i][j - 1] = 3;
				else
					values[i][j - 1] = 2;
			}
		}
		da.udskrivArray(values);

		// TODO Opgave 1.3 lav ændringer i values så der står 2 i lige søjler og 3 i
		// ulige

		System.out.println();
		System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden søjle");
		System.out.println();
		for (int i = 0; i < values.length; i++) {
			for (int j = 1; j <= values[i].length; j++) {
				if (j % 2 == 0)
					values[i][j - 1] = 2;
				else
					values[i][j - 1] = 3;
			}
		}
		da.udskrivArray(values);

		// TODO Opgave 1.4 lav ændringer i values så den har skiftende 0'er og 1'er som
		// på et
		// skakbræt

		System.out.println();
		System.out.println("Nedenfor skulle der stå 0 og 1 på alle pladser som på skakbræt");
		System.out.println();
//		int companion = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 1; j <= values[i].length; j++) {
				if ((i + (j - 1)) % 2 == 0)
					values[i][j - 1] = 1;
				else
					values[i][j - 1] = 0;
			}
		}
		da.udskrivArray(values);

		// TODO Opgave 1.5 lav ændringer så alle elementer i nederste og øverste række
		// samt første
		// og sidste søjle er 5 og resten skal være 2.

		System.out.println();
		System.out.println("Nedenfor skulle der stå 5 i kanten og 2 ellers");
		System.out.println();
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				values[i][j] = 2;
				values[0][j] = 5;
				values[values.length - 1][j] = 5;
			}
			values[i][0] = 5;
			values[i][values[0].length - 1] = 5;
		}
		da.udskrivArray(values);

		// TODO Opgave 1.6 beregn summen af alle tallene i values og udskriv denne.
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				sum += values[i][j];
			}
		}
		System.out.println(sum);
	}

}
