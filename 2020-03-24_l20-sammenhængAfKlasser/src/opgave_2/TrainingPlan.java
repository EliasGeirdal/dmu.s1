package opgave_2;

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

	/**
	 * 
	 * @param swimmer
	 */
	public void addSwimmer(Swimmer swimmer) {
		swimmers.add(swimmer);
	}

	public void removeSwimmer(Swimmer swimmer) {
		swimmers.remove(swimmer);
	}

	/**
	 * returns a swimmer connected to the training plan.
	 * 
	 * @return
	 */
	public String getSwimmerInfo(Swimmer swimmer) {
		String swimmerName = swimmer.getName();
		return swimmerName;
	}

	/**
	 * return swimmers connected to the training plan.
	 * 
	 * @return
	 */
	public ArrayList<Swimmer> getSwimmers() {
		return new ArrayList<>(swimmers);
	}

}
