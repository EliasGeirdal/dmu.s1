package opgave_3;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCarlolol = new Car("An 85 871", 2006);
		Car c2 = new Car("YC 31 188", 2000);
		Car c3 = new Car("BI 10 101", 2010);
		Car c4 = new Car("OB 43 245", 1999);
		Car c5 = new Car("AB 12 345", 1980);

		Rental r1 = new Rental(1, "24-03-2020", 14);
		Rental r2 = new Rental(2, "24-03-2020", 7);

		// add all the cars.
		r1.addCar(myCarlolol);
		r1.addCar(c2);
		r2.addCar(c3);
		r2.addCar(c4);
		r2.addCar(c5);

		// Set price per day for all the cars..
		myCarlolol.setPricePerDay(100.00);
		c2.setPricePerDay(58.00);
		c3.setPricePerDay(120.00);
		c4.setPricePerDay(80.00);
		c5.setPricePerDay(99.99);

		System.out.println("Total price for rental: " + r1.getPrice());
		System.out.println("Total price for rental: " + r2.getPrice());
	}

}
