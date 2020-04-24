package opgave_4;

public abstract class FigurForm {

	private double x1, y1;

	public FigurForm(double x, double y) {
		this.x1 = x;
		this.y1 = y;
	}

	public double getX1() {
		return x1;
	}

	public double getY1() {
		return y1;
	}

	public void setX1(double length) {
		this.x1 = length;
	}

	public void setY1(double length) {
		this.y1 = length;
	}

	public abstract double getAreal();

	public abstract void shift(double Xamount, double Yamount);

	public abstract void parallelShiftX(double length);

	public abstract void parallelShiftY(double length);

}
