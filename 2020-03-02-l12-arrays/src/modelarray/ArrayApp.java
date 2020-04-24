package modelarray;

import java.util.Arrays;

public class ArrayApp {

	public static void main(String[] args) {
		ArrayMethods metode = new ArrayMethods();

		int[] tabel = metode.fyldArrayA();
		System.out.println("Forventet: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]");
		System.out.println("Aktuelt  : " + Arrays.toString(tabel));
		System.out.println();

		tabel = metode.fyldArrayB();
		System.out.println("Forventet: [2, 44, -23, 99, 8, -5, 7, 10, 20, 30]");
		System.out.println("Aktuelt  : " + Arrays.toString(tabel));
		System.out.println();

		tabel = metode.fyldArrayC();
		System.out.println("Forventet: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
		System.out.println("Aktuelt  : " + Arrays.toString(tabel));
		System.out.println();

		tabel = metode.fyldArrayD();
		System.out.println("Forventet: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]");
		System.out.println("Aktuelt  : " + Arrays.toString(tabel));
		System.out.println();

		tabel = metode.fyldArrayE();
		System.out.println("Forventet: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
		System.out.println("Aktuelt  : " + Arrays.toString(tabel));
		System.out.println();

		tabel = metode.fyldArrayF();
		System.out.println("Forventet: [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]");
		System.out.println("Aktuelt  : " + Arrays.toString(tabel));
		System.out.println();

		tabel = metode.fyldArrayG();
		System.out.println("Forventet: [0, 1, 2, 3 ,4 ,0 ,1 ,2 ,3 ,4]");
		System.out.println("Aktuelt  : " + Arrays.toString(tabel));
		System.out.println();

		System.out.println("__________________________________");
		int[] t = { 4, 6, 7, 2, 3 };
		metode.sum(t);
		System.out.println("summen af t er lig: " + metode.sum(t));

		double[] tt = { 2.5, 2.5, 2.5, 2.5 };
		System.out.println("summen af t er lig: " + metode.sum(tt));

		int a[] = { 2, 2, 2, 3, 5 };
		int b[] = { 2, 2, 2, 2 };
		int temp[] = metode.makeSum(a, b);
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		int[] test = { 2, 4, 4, 6, 8 };
		System.out.println("\n" + metode.hasUneven(test));
		int[] test1 = { 2, 3, 4, 6, 8 };
		System.out.println(metode.hasUneven(test1));
		// int[] tabel2 = { 78, 23, 1, 4, 65, 3, 87, 5, 12 };
		// metode.printArray(tabel2);
		//
		// System.out.println(metode.findMax(tabel2));

	}

}
