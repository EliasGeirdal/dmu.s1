package opgave_1;

import java.util.ArrayList;

public class Car {

	private String license = "";
	private Double pricePerDay;
	private int purchaseYear;
	private ArrayList<Rental> rentals = new ArrayList<>();

	public Car(String license, int year) {
		this.license = license;
		this.purchaseYear = year;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getLicense() {
		return license;
	}

	public int getPurchaseYear() {
		return purchaseYear;
	}

	/**
	 * add a rental to the car, and add a car to the rental.
	 * 
	 * @param rental
	 */
	public void addRental(Rental rental) {
		if (!rentals.contains(rental)) {
			rentals.add(rental);
			rental.addCar(this);
		}
	}

	/**
	 * remove rental from car, and remove car from rental. pre: rentals > -1
	 * 
	 * @param rental
	 */
	public void removeRental(Rental rental) {
		if (rentals.contains(rental)) {
			rentals.remove(rental);
			rental.removeCar(this);
		}
	}

	public ArrayList<Rental> getRentals() {
		return new ArrayList<>(rentals);
	}

	/**
	 * returns the longest period the cars have been rented.
	 * 
	 * @param rental
	 * @return
	 */
	public int maxRentalPeriod() {
		int period = Integer.MIN_VALUE;
		for (Rental element : rentals) {
			if (period < element.getDays())
				period = element.getDays();
		}
		return period;
	}

}
