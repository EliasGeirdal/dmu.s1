package opgave_1;

public class Chili implements Filter, Measurable {

	private int strength;
	private String name;

	public Chili(int strength, String name) {
		super();
		this.strength = strength;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Chili [strength=" + strength + ", name=" + name + "]";
	}

	@Override
	public double getMeasure() {
		// TODO Auto-generated method stub
		return strength;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean accept(Object o) {
		// TODO Auto-generated method stub
		boolean accept = false;
		if (getMeasure() > 5000) {
			accept = true;
		}
		return accept;
	}
}
