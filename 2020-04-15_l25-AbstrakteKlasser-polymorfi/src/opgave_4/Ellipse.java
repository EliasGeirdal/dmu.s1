package opgave_4;

public class Ellipse extends FigurForm {
	private double w, h;

	/**
	 * Constructs an ellipse.
	 * 
	 * @param x upper left corner
	 * @param y upper left corner
	 * @param w the overall width
	 * @param h the overall width
	 */
	public Ellipse(double x, double y, double w, double h) {
		super(x, y);
		this.setW(w);
		this.setH(h);
	}

	/**
	 * Constructs a circle.
	 * 
	 * @param x        upper left corner
	 * @param y        upper left corner
	 * @param diameter diameter of circle.
	 */
	public Ellipse(double x, double y, double diameter) {
		super(x, y);
		this.w = diameter;
		this.h = diameter;

	}

	// pi * r1 * r2
	@Override
	public double getAreal() {
		// TODO Auto-generated method stub
		return Math.PI * (w / 2) * (h / 2);
	}

	@Override
	public String toString() {
		return "Ellipse [w=" + w + ", h=" + h + ", getAreal()=" + getAreal() + ", getX1()=" + getX1() + ", getY1()="
				+ getY1() + "]";
	}

	@Override
	public void parallelShiftX(double length) {
		// TODO Auto-generated method stub
		setX1(getX1() + length);
	}

	@Override
	public void parallelShiftY(double length) {
		// TODO Auto-generated method stub
		setY1(getY1() + length);
	}

	/**
	 * @param Xamount amount to shift x.
	 * @param Yamount amount to shift y.
	 */
	@Override
	public void shift(double Xamount, double Yamount) {
		// TODO Auto-generated method stub
		setX1(getX1() + Xamount);
		setY1(getY1() + Yamount);
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

}
