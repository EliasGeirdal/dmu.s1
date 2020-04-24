package opgavee316;

public class Bug {
	// Instance variables: We need the initial position of the bug and the direction
	// it is heading.
	private int initialPosition;
	private int direction = 1;

	// Constructor: the constructor constructs the elements to create the object:
	// Bug.
	public Bug(int initialPosition) {
		this.initialPosition = initialPosition;
	}

	// The direction is changed by the method: turn().
	public void turn() {
		this.direction = direction * (-1);
	}

	// The bug is moved by its initial position + the direction it is in. and the
	// method: move().
	public void move() {
		this.initialPosition += direction;
	}

	// get the position of the bunny by the method: getPosition.
	public int getPosition() {
		return initialPosition;
	}
}
