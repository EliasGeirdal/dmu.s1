package opgave_3;

import java.util.ArrayList;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
	private String name;
	private String club;
	private int yearGroup;
	private ArrayList<Double> lapTimes;
	// association --> 0..1
	private TrainingPlan trainingPlan; // nullable

	/**
	 * Initialize a new swimmer with name, club, yearGroup, and lap times.
	 */

	public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
		this.name = name;
		this.yearGroup = yearGroup;
		this.lapTimes = lapTimes;
		this.club = club;
	}

	/**
	 * set a training plan to a swimmer.
	 * 
	 * @param trainingPlan
	 */
	public void setTrainingPlan(TrainingPlan trainingPlan) {
		if (this.trainingPlan != trainingPlan) {
			TrainingPlan oldTrainingPlan = this.trainingPlan;
			if (oldTrainingPlan != null) {
				oldTrainingPlan.removeSwimmer(this);
			}
			this.trainingPlan = trainingPlan;
			if (this.trainingPlan != null) {
				trainingPlan.addSwimmer(this);
			}
		}
	}

	/**
	 * returns the training plan of the swimmer. note: nullable return value.
	 * 
	 * @return
	 */
	public TrainingPlan getTrainingPlan() {
		return trainingPlan;
	}

	/**
	 * Return the name of the swimmer
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the yearGroup of the swimmer
	 */
	public int getYearGroup() {
		return this.yearGroup;
	}

	/**
	 * Return the club of the swimmer
	 */
	public String getClub() {
		return this.club;
	}

	/**
	 * Register the club of the swimmer
	 * 
	 * @param club
	 */
	public void setClub(String club) {
		this.club = club;
	}

	/**
	 * Return the fastest lap time
	 */
	public double bestLapTime() {
		double best = Double.MAX_VALUE;
		for (double time : lapTimes) {
			if (best > time) {
				best = time;
			}
		}
		return best;
	}

	/**
	 * Return how many training hours the swimmer has each week.
	 */
	public int allTrainingHours() {
		return trainingPlan.getWeeklyStrengthHours() + trainingPlan.getWeeklyWaterHours();
	}

	public String toString() {
		return name + " " + trainingPlan.getLevel();
	}
}
