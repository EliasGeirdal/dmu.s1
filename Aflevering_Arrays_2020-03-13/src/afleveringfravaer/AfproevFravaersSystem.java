package afleveringfravaer;

public class AfproevFravaersSystem {

	public static void main(String[] args) {
		int[][] fravaer20V = { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
				{ 5, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0 } };

		FravaersSystem fraværsSystem = new FravaersSystem();

		// test udskrivFravaer.
		System.out.println("Fravaerliste: ");
		fraværsSystem.udskrivFravaer(fravaer20V);
		System.out.println();

		// test samletFravaer.
		System.out.printf("Total absence for selected student: " + "%5d\n", fraværsSystem.samletFravaer(fravaer20V, 5));
		System.out.printf("Total absence for selected student: " + "%5d\n", fraværsSystem.samletFravaer(fravaer20V, 2));
//		System.out.printf("Samlet fravær for valgt elev: " + "%5d", fraværsSystem.samletFravaer(fravaer20V, 8));
//		System.out.printf("Samlet fravær for valgt elev: " + "%5d", fraværsSystem.samletFravaer(fravaer20V, -1));

		// test af gennemsnit.
		System.out.printf("Average absence for selected student: " + "%6.2f\n",
				fraværsSystem.gennemsnit(fravaer20V, 1));
		System.out.printf("Average absence for selected student: " + "%6.2f\n",
				fraværsSystem.gennemsnit(fravaer20V, 2));
//		System.out.printf("Average absence for selected student: " + "%6.2f\n", fraværsSystem.gennemsnit(fravaer20V, 8));
//		System.out.printf("Average absence for selected student: " + "%6.2f\n", fraværsSystem.gennemsnit(fravaer20V, -1));

		// test af antalUdenFravaer.
		System.out.printf("Students with no absence: " + "%15d\n", fraværsSystem.antalUdenFravaer(fravaer20V));

		// test af mestFraever
		System.out.printf("Student with most absence: " + "%14d\n", fraværsSystem.mestFravaer(fravaer20V));

		// test af nulstil.
		fraværsSystem.nulstil(fravaer20V, 1);
		System.out.printf("Total absence for selected student: " + "%5d\n", fraværsSystem.samletFravaer(fravaer20V, 1));
//		fraværsSystem.nulstil(fravaer20V, -1);
		// when printing out of bounds index - total is set to 0.
//		System.out.printf("Total absence for selected student: " + "%5d\n",
//				fraværsSystem.samletFravaer(fravaer20V, -1));
//		fraværsSystem.nulstil(fravaer20V, 8);
//		fraværsSystem.nulstil(fravaer20V, 5);
		// tjek om tabellen er opdateret.
		fraværsSystem.udskrivFravaer(fravaer20V);

	}
}
