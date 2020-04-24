package opgave2Teater;

public class TheaterFloorApp {

	public static void main(String[] args) {
		TheaterFloor theater = new TheaterFloor();
		// TODO
		theater.printTheaterFloor();
		System.out.println("____________________________________");
		theater.run();
		theater.printTheaterFloor();
		System.out.println("____________________________________");
		theater.run();
		theater.printTheaterFloor();
		System.out.println("\nSelected seat costs: " + theater.buySeat(3, 6));
		System.out.println("\nSelected seat costs: " + theater.buySeat(3, 6));
		theater.buySeat(50);
		System.out.println("____________________________________");
		theater.printTheaterFloor();
	}
}
