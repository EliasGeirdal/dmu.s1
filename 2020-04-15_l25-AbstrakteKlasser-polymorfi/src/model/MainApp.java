package model;

import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> personer = new ArrayList<>();

		personer.add(new Student("Jens", 1995, "IT"));
		personer.add(new Instructor("Ole", 1885, 20000));

		System.out.print(personer);
	}

}
