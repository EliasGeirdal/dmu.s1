package afleveringfravaer;

public class FravaersSystem {

	/**
	 * Fraværstallene udskrives på skærmen
	 *
	 * @param fravaer
	 */

	public void udskrivFravaer(int[][] fravaer) {
		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[i].length; j++) {
				System.out.printf("%3s", (fravaer[i][j] + " "));
			}
			System.out.println();
		}
	}

	/**
	 * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
	 * elevnr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public int samletFravaer(int[][] fravaer, int elevNr) {
		// TODO
		int sum = 0;
		if (elevNr > -1 && elevNr <= fravaer.length) {
			for (int i = 0; i < fravaer[elevNr - 1].length; i++) {
				sum += fravaer[elevNr - 1][i];
			}
		} else
			System.out.println("\nChoose existing student number.");
		return sum;
	}

	/**
	 * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
	 * elevNr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public double gennemsnit(int[][] fravaer, int elevNr) {
		// TODO
		double sum = this.samletFravaer(fravaer, elevNr);
		return sum / 12;
	}

	/**
	 * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
	 *
	 * @param fravaer
	 * @return
	 */
	public int antalUdenFravaer(int[][] fravaer) {
		// TODO
		int count = 0;
		for (int i = 1; i <= fravaer.length; i++) {
			if (this.samletFravaer(fravaer, i) == 0) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
	 * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer for
	 * en af disse.
	 *
	 * @param fravaer
	 * @return
	 */
	public int mestFravaer(int[][] fravaer) {
		int max = -1;
		int index = -1;
		for (int i = 1; i <= fravaer.length; i++) {
			if (this.samletFravaer(fravaer, i) > max) {
				max = this.samletFravaer(fravaer, i);
				index = i;
			}
		}
		return index;
	}

	/**
	 * Registrerer at eleven med elevNr ikke har haft fravær i nogen af de 12
	 * måneder.
	 *
	 * @param fravaer
	 * @param elevNr
	 */
	public void nulstil(int[][] fravaer, int elevNr) {
		if (elevNr > -1 && elevNr <= fravaer.length) {
			for (int i = 0; i < fravaer[elevNr - 1].length; i++) {
				fravaer[elevNr - 1][i] = 0;
			}
		} else
			System.out.println("\nChoose existing student number.");
	}
}
