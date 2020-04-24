package opgave_3;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
	private char level;
	private int weeklyWaterHours;
	private int weeklyStrengthHours;
	private final ArrayList<Swimmer> swimmers = new ArrayList<>();

	public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
		this.level = level;
		this.weeklyWaterHours = weeklyWaterHours;
		this.weeklyStrengthHours = weeklyStrengthHours;
	}

	/**
	 * Add a swimmer to the training plan, and add the training plan to the
	 * connected swimmer.
	 * 
	 * @param swimmer
	 */
	public void addSwimmer(Swimmer swimmer) {
		if (!swimmers.contains(swimmer)) {
			swimmers.add(swimmer);
			swimmer.setTrainingPlan(this);
		}
	}

	/**
	 * removes a swimmer from the training plan, and sets the plan to null.
	 * 
	 * @param swimmer
	 */
	public void removeSwimmer(Swimmer swimmer) {
		if (swimmers.contains(swimmer)) {
			swimmers.remove(swimmer);
			swimmer.setTrainingPlan(null);
		}
	}

	public ArrayList<Swimmer> getSwimmers() {
		return new ArrayList<>(swimmers);
	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char niveau) {
		this.level = niveau;
	}

	public int getWeeklyStrengthHours() {
		return weeklyStrengthHours;
	}

	public void setWeeklyStrengthHours(int weeklyStrengthHours) {
		this.weeklyStrengthHours = weeklyStrengthHours;
	}

	public int getWeeklyWaterHours() {
		return weeklyWaterHours;
	}

	public void setWeeklyWaterHours(int weeklyWaterHours) {
		this.weeklyWaterHours = weeklyWaterHours;
	}

}
