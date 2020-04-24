package opgave_3;

import java.util.ArrayList;

public class Rental {

	private int number;
	private int days;
	private String date = "";
	private ArrayList<Car> cars = new ArrayList<>();

	public Rental(int number, String date, int days) {
		this.number = number;
		this.date = date;
		this.setDays(days);
	}

	/**
	 * Adds a car to this rental.
	 * 
	 * @param car
	 */
	public void addCar(Car car) {
		cars.add(car);
	}

	/**
	 * Removes car from this rental.
	 * 
	 * @param car
	 */
	public void removeCar(Car car) {
		cars.remove(car);
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * returns the price of the rental period.
	 * 
	 * @return price
	 */
	public double getPrice() {
		double price = 0;
		for (int i = 0; i < cars.size(); i++) {
			price += cars.get(i).getPricePerDay() * days;
		}
		return price;
	}
}
