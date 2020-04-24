package opgave_1;

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
	 * Adds a car to this rental, and add a rental to this car.
	 * 
	 * @param car
	 */
	public void addCar(Car car) {
		if (!cars.contains(car)) {
			cars.add(car);
			car.addRental(this);
		}
	}

	/**
	 * Removes car from this rental, and remove rental from this car. pre: cars > -1
	 * 
	 * @param car
	 */
	public void removeCar(Car car) {
		if (cars.contains(car)) {
			cars.remove(car);
			car.removeRental(this);
		}
	}

	public ArrayList<Car> getCars() {
		return new ArrayList<>(cars);
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
		for (Car element : cars) {
			price += element.getPricePerDay() * days;
		}
		return price;
	}
}
