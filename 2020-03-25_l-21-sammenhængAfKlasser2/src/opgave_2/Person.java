package opgave_2;

import java.util.ArrayList;

public class Person {
	private String name = "";
	private int age;
	private ArrayList<Gift> gifts = new ArrayList<>();

	public Person(String name, int age) {
		this.name = name;
		this.setAge(age);
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "[" + name + ", " + age + "." + "]";
	}

	/**
	 * Adds a gift to the persons gift "collection". if it isn't connected. pre: The
	 * gift connected to the person.
	 * 
	 * @param gift
	 */
	public void addGift(Gift gift) {
		if (!gifts.contains(gift))
			gifts.add(gift);
	}

	/**
	 * Removes the gift from the person. if it is connected.
	 * 
	 * @param gift
	 */
	public void removeGift(Gift gift) {
		if (gifts.contains(gift))
			gifts.remove(gift);
	}

	public double totalGiftValue() {
		double sum = 0.00;
		for (Gift element : gifts) {
			sum += element.getPrice();
		}
		return sum;
	}

	public ArrayList<Person> getGiftGivers() {
		ArrayList<Person> givers = new ArrayList<>();
		for (Gift gift : gifts) {
			givers.add(gift.getGiver());
		}
		return givers;
	}

}
