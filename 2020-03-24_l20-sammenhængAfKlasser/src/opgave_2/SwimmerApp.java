package opgave_2;

import java.util.ArrayList;

public class SwimmerApp {

	public static void main(String[] args) {

		ArrayList<Double> lapTimes = new ArrayList<>();
		Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");
		Swimmer s2 = new Swimmer("Bo", 2000, lapTimes, "FCK");
		TrainingPlan t1 = new TrainingPlan('A', 16, 10);
		t1.addSwimmer(s1);
		t1.addSwimmer(s2);

		System.out.println("Name: " + t1.getSwimmerInfo(s1) + "\nLevel: " + t1.getLevel() + "\nStrength Hours: "
				+ t1.getWeeklyStrengthHours() + "\nWater hours: " + t1.getWeeklyWaterHours());
		System.out.println("\nName: " + t1.getSwimmerInfo(s2) + "\nLevel: " + t1.getLevel() + "\nStrength Hours: "
				+ t1.getWeeklyStrengthHours() + "\nWater hours: " + t1.getWeeklyWaterHours());

	}

}
