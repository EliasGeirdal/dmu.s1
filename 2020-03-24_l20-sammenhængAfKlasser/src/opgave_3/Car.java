package opgave_3;

public class Car {

	private String license = "";
	private Double pricePerDay;
	private int purchaseYear;

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
}
