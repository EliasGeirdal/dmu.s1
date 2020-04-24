package opgave_1;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car("An 85 871", 2006);
		Car c2 = new Car("YC 31 188", 2000);
		Car c3 = new Car("BI 10 101", 2010);

		Rental r1 = new Rental(1, "24-03-2020", 14);
		Rental r2 = new Rental(2, "24-03-2020", 10);

		// test add car.
//		c1.addRental(r1);
		r1.addCar(c1);
		c2.addRental(r1);
		System.out.println(r1.getCars().get(0).getLicense());
		// test remove rental.
		c1.removeRental(r1);
		System.out.println(r1.getCars().get(0).getLicense());

		// test add car.
		r1.addCar(c3);
		r2.addCar(c3);
		System.out.println("\n" + c3.getRentals().get(0).getDays());
		// test remove car.
		r1.removeCar(c3);
		System.out.println(c3.getRentals().get(0).getDays());

		// test maxRentalPeriod.
		r1.addCar(c3);
		System.out.println("\n" + c3.maxRentalPeriod());
	}

}
