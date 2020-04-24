package opgave_3;

import java.util.ArrayList;

public class SwimmerApp {

	public static void main(String[] args) {

		ArrayList<Double> lapTimes = new ArrayList<>();
		lapTimes.add(1.02);
		lapTimes.add(1.01);
		lapTimes.add(0.99);
		lapTimes.add(0.98);
		lapTimes.add(1.02);
		lapTimes.add(1.04);
		lapTimes.add(0.99);
		Swimmer jan = new Swimmer("Jan", 1994, lapTimes, "AGF");
		Swimmer bo = new Swimmer("Bo", 1995, lapTimes, "Lyseng");
		Swimmer mikkel = new Swimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");
		Swimmer jens = new Swimmer("Jens", 1993, lapTimes, "AIA-Tranbjerg");
		Swimmer ole = new Swimmer("Ole", 1993, lapTimes, "AIA-Tranbjerg");

		lapTimes = new ArrayList<>();
		lapTimes.add(1.05);
		lapTimes.add(1.01);
		lapTimes.add(1.04);
		lapTimes.add(1.06);
		lapTimes.add(1.08);
		lapTimes.add(1.04);
		lapTimes.add(1.02);

		lapTimes = new ArrayList<>();
		lapTimes.add(1.03);
		lapTimes.add(1.01);
		lapTimes.add(1.02);
		lapTimes.add(1.05);
		lapTimes.add(1.03);
		lapTimes.add(1.06);
		lapTimes.add(1.03);

		ArrayList<Swimmer> swimmers = new ArrayList<>();
		swimmers.add(jan);
		swimmers.add(bo);
		swimmers.add(mikkel);

		for (Swimmer s : swimmers) {
			System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
		}

		System.out.println("________________________________________________\n");

		TrainingPlan t1 = new TrainingPlan('A', 16, 10);
		TrainingPlan t2 = new TrainingPlan('B', 10, 6);

		// set training plan for the three swimmers.
		jan.setTrainingPlan(t1);
		bo.setTrainingPlan(t1);
		mikkel.setTrainingPlan(t2);
		// test both plans
		System.out.println("Test");
		printSwimmers(t1);
		printSwimmers(t2);
		bo.setTrainingPlan(t2);
		// test: change (bo is set from plan 1 to plan 2).
		System.out.println("Test");
		printSwimmers(t2);
		// test: add new swimmers to plan 1 and plan 2.
		System.out.println("Test");
		t1.addSwimmer(jens);
		t2.addSwimmer(ole);
		printSwimmers(t1);
		printSwimmers(t2);
		// test: remove jens and bo from plan 1 and 2.
		System.out.println("Test");
		t1.removeSwimmer(jens);
		t2.removeSwimmer(ole);
		printSwimmers(t1);
		printSwimmers(t2);
	}

	public static void printSwimmers(TrainingPlan trainingPlan) {
		for (Swimmer swimmer : trainingPlan.getSwimmers())
			System.out.println(swimmer);
		System.out.println("--------------");
	}
}
