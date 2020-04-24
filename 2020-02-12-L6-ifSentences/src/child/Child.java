package child;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	// Constructor:

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String getGender() {
		String gender = "";
		if (boy == true) {
			gender = "boy";
		} else {
			gender = "girl";
		}
		return gender;
	}

	public String institution() {
		// TODO: implement!
		String result = "";
		if (age < 1) {
			result = "Home";
		} else if (age < 2) {
			result = "Nursery";
		} else if (age < 5) {
			result = "Kindergarten";
		} else if (age < 16) {
			result = "School";
		} else if (age >= 17) {
			result = "Out of school";
		}
		return result;
	}

	public String team() {
		if (age < 8 && !boy)
			return "tumbling girls";
		else if (age >= 8 && !boy)
			return "springy girls";
		else if (age < 8 && boy)
			return "young cubs";
		else if (age >= 8 && boy)
			return "Cool boys";
		else
			return "Error: not applicable";
	}

}
