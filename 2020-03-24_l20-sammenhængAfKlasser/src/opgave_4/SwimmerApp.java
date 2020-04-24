package opgave_4;

import java.util.ArrayList;

public class SwimmerApp {

	public static void main(String[] args) {

		ArrayList<Double> lapTimes = new ArrayList<>();
		lapTimes.add(1.03);
		lapTimes.add(1.01);
		lapTimes.add(1.02);
		lapTimes.add(1.05);
		lapTimes.add(1.03);
		lapTimes.add(1.06);
		lapTimes.add(1.03);

		TrainingPlan t1 = new TrainingPlan('A', 16, 10);

		t1.createSwimmer("Jan", 1994, lapTimes, "AGF");
		t1.createSwimmer("Bo", 1995, lapTimes, "Lyseng");

		System.out.println("Name: " + t1.getSwimmers().get(0).getName());
		System.out.println("name: " + t1.getSwimmers().get(1).getName());

		t1.removeSwimmer(t1.getSwimmers().get(0));
		System.out.println("\nName: " + t1.getSwimmers().get(0).getName());

	}

}
