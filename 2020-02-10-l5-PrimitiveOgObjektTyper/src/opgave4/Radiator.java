package opgave4;

public class Radiator {
	
	// Instance variables describing temperatures etc.
	private int temperature = 0;
	
	/* Constructor: displays a radiator with temperature of 20 degrees.
	 */
	public Radiator() {
		this.temperature = temperature + 20;
	}
	
	// The temperature of the radiator is called by getTemperature() metoden.
	public int getTemperature() {
		return temperature;
	}
	
	// The temperature is turned up by turnUp(int degrees) method.
	// The temperature is turned down by turnDown(int degrees) method.
	public void turnUp(int degrees) {
		this.temperature = temperature + degrees;
	}
	public void turnDown(int degrees) {
		this.temperature = temperature - degrees;
	}
	
}
