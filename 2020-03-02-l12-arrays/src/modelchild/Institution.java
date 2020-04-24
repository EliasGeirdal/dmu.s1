package modelchild;

public class Institution {

	private String name;
	private String address;
	private Child[] children;
	private int numberOfChildren;
	private static int MAX_NUMBER_OF_CHILDREN = 100;

	public Institution(String name, String address) {
		this.name = name;
		this.address = address;
		numberOfChildren = 0;
		children = new Child[MAX_NUMBER_OF_CHILDREN];
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void addChild(Child child) {
		children[numberOfChildren] = child;
		numberOfChildren++;
	}

	public double averageAge() {
		double sum = 0;
		for (int i = 0; i < numberOfChildren; i++) {
			sum += children[i].getAge();
		}
		double average = sum / numberOfChildren;
		return average;
	}

	public int numberOfGirls() {
		int girls = 0;
		for (int i = 0; i < numberOfChildren; i++) {
			if (!children[i].isBoy()) {
			}
		}
		return girls;
	}

	public int numberOfBoys() {
		int boys = 0;
		for (int i = 0; i < numberOfChildren; i++) {
			if (children[i].isBoy()) {
				boys++;
			}
		}
		return boys;
	}
}
