package opgave4;

public class RadiatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Radiator 1 _________________________________________");

		Radiator radiator1 = new Radiator();
		System.out.println(radiator1.getTemperature());
		radiator1.turnDown(10);
		System.out.println(radiator1.getTemperature());
		radiator1.turnUp(15);
		System.out.println(radiator1.getTemperature());

		System.out.println("Radiator 2 _________________________________________");

		RadiatorStart radiator2 = new RadiatorStart(22);
		System.out.println(radiator2.getTemperature());
		radiator2.turnUp(5);
		System.out.println(radiator2.getTemperature());
		radiator2.turnDown(10);
		System.out.println(radiator2.getTemperature());
	}
}
