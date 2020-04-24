package opgave4;

public class RadiatorStart {

	// Instance variables describing temperatures etc.
	private int temperature = 0;

	// Constructor: displays a radiator with the temperature of 0.
	public RadiatorStart(int temperature) {
		this.temperature = temperature;
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
