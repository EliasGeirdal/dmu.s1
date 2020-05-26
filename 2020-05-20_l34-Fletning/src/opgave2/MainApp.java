package opgave2;

import java.util.Arrays;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l1 = { 2, 4, 6, 8, 10, 12, 14 };
		int[] l2 = { 1, 2, 4, 5, 6, 9, 12, 17 };
		System.out.println(Arrays.toString(fællesTal(l1, l2)));

	}

	/**
	 * Returnerer et sorteret array der indeholder alle elementer l1 og l2 har til
	 * fælles Krav: l1 og l2 er sorterede, indeholder ikke dubletter og indeholder
	 * ikke tomme pladser
	 */
	public static int[] fællesTal(int[] l1, int[] l2) {
		int[] result = new int[l1.length + l2.length];

		int i1 = 0;
		int i2 = 0;
		int j = 0;
		// flet så længe der er noget i begge lister.
		while (i1 < l1.length && i2 < l2.length) {
			if (l1[i1] < l2[i2]) { // l1's første tal er mindst.
				result[j] = l1[i1];
				i1++;
				j++;
			} else { // l2's første tal er mindst.
				result[j] = l2[i2];
				i2++;
				j++;
			}
		} // tøm den liste der ikke er tom.
		while (i1 < l1.length) {
			result[j] = l1[i1];
			i1++;
			j++;
		}
		while (i2 < l2.length) {
			result[j] = l2[i2];
			i2++;
			j++;
		}
		return result;
	}

}
