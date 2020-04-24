package model;

import java.util.ArrayList;

public class MethodsArrayList {

	/**
	 *
	 * @param list
	 * @return sums the mumbers in the list using a for loop
	 */
	public int sumListe(ArrayList<Integer> list) {
		int resultat = 0;
		for (int i = 0; i < list.size(); i++) {
			resultat = resultat + list.get(i);
		}
		return resultat;
	}

	/**
	 *
	 * @param list
	 * @return sums the mumbers in the list using a forEach loop
	 */
	public int sumListe2(ArrayList<Integer> list) {
		int resultat = 0;
		for (int tal : list) {
			resultat = resultat + tal;
		}
		return resultat;
	}

	/**
	 *
	 * @param list
	 * @return index at the first even number
	 */
	public int hasEvenAtIndex(ArrayList<Integer> list) {
		int index = -1;
		int i = 0;
		while (index == -1 && i < list.size()) {
			if (list.get(i) % 2 == 0) {
				index = i;
			}
			i++;
		}
		return index;
	}

	// metode der returnerer det mindste tal i listen.
	public int min(ArrayList<Integer> list) {
		int min = Integer.MAX_VALUE;
		for (int element : list) {
			if (element < min)
				min = element;
		}
		return min;
	}

	// Metode der returnerer gennemsnittet af tallenen i array listen.
	public double average(ArrayList<Integer> list) {
		double sum = 0;
		for (int element : list) {
			sum += element;
		}
		if (list.size() != 0)
			return sum / list.size();
		else
			return 0;
	}

	// metode der returnerer hvor ofte 0 indgår i listen.
	public int countZeros(ArrayList<Integer> list) {
		int zero = 0;
		for (int element : list) {
			if (element == 0)
				zero++;
		}
		return zero;
	}

	// Metode der erstatter alle lige til med nul.
	public void swapEvenWithZero(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0)
				list.set(i, 0);
		}
	}

	// metode der laver en ny liste med alle lige tal angivet liste.
	public ArrayList<Integer> aEvenList(ArrayList<Integer> list) {
		ArrayList<Integer> evenList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0)
				evenList.add(list.get(i));
		}
		return evenList;
	}
}
