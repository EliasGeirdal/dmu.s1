package model;

import java.util.ArrayList;

public class ArrayListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> navn = new ArrayList<>();
		navn.add("Hans");
		navn.add("Viggo");
		navn.add("Jens");
		navn.add("Børge");
		navn.add("Bent");

		for (String s : navn) {
			System.out.println(s);
		}
		System.out.println("-------------------------------------------");

		navn.add(2, "Jane");
		for (String s : navn) {
			System.out.println(s);
		}

		navn.remove(1);
		navn.add(0, "Pia");
		navn.add("Ib");
		System.out.println("der er: " + navn.size() + " elementer i listen.");

		navn.set(2, "Hansi");
		System.out.println("der er: " + navn.size() + " elementer i listen.");
		// udskriver alle navne gennem en forEach løkke.
		for (String s : navn) {
			System.out.println(s);
		}
		// udskriver alle længder af alle navne gennem en for-løkke.
		for (int i = 0; i < navn.size(); i++) {
			System.out.println(navn.get(i).length());
		}
		System.out.println("---------------------------");
		// Udskriver alle længder af alle navne gennem en forEach-løkke.
		for (String s : navn) {
			System.out.println(s.length());
		}
	}
}
