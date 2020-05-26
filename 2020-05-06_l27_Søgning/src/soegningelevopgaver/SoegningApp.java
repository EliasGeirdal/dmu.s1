package soegningelevopgaver;

import java.util.ArrayList;

public class SoegningApp {

	public static void main(String[] args) {
		Soegning s = new Soegning();

		// Kode til afprøvning af opgave 1
		int[] talArray = { 2, 4, 8, 2 };
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));

		// Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7
		// opgave 2
		int[] talArray2 = { 2, 9, 8, 16 };
		System.out.println("Højeste tal i intervallet [10, 15]: " + s.findMaxInterval(talArray2));
		talArray2[2] = 15;
		System.out.println("Højeste tal i intervallet [10, 15]: " + s.findMaxInterval(talArray2));

		// opgave 3
		int[] talArray3 = { 7, 9, 13, 7, 9, 13 };
		System.out.println("Is there adjacent numbers? " + s.findAdjacentNum(talArray3));
		talArray3[1] = 13;
		System.out.println("Is there adjacent numbers? " + s.findAdjacentNum(talArray3));

		System.out.println("Opgave 5");
		System.out.println(s.findMaxSqrtLinear(0));
		System.out.println("Opgave 5.1");
		System.out.println(s.findMaxSqrtBinary(0));

		// opgave 6
		System.out.println("Opgave 6");
		ArrayList<Integer> talArray6 = new ArrayList<Integer>();
		talArray6.add(7);
		talArray6.add(9);
		talArray6.add(13);
		talArray6.add(7);
		talArray6.add(9);
		talArray6.add(13);
		System.out.println(talArray6);
		System.out.println(s.find(talArray6, 13));
		System.out.println(talArray6);
	}

}
