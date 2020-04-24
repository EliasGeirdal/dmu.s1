package opgave_4;

public class Rektangel extends FigurForm {

	private double x2, y2;

	/**
	 * constructs a rektangel.
	 * 
	 * @param x1 initial position on the horizontal line.
	 * @param y1 initial position on the vertical line.
	 * @param x2 second podouble on x axe.
	 * @param y2 second podouble on y axe.
	 */
	public Rektangel(double x1, double y1, double x2, double y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * Constructs a square.
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 */
	public Rektangel(double x1, double y1, double x2) {
		this(x1, y1, x2, y1 + (x2 - x1));
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getAreal() {
		// TODO Auto-generated method stub
		return (x2 - getX1()) * (y2 - getY1());
	}

	public double getX2() {
		return x2;
	}

	public double getY2() {
		return y2;
	}

	@Override
	public void parallelShiftX(double length) {
		// TODO Auto-generated method stub
		setX1(getX1() + length);
		this.x2 += length;
	}

	@Override
	public void parallelShiftY(double length) {
		// TODO Auto-generated method stub
		setY1(getY1() + length);
		this.y2 += length;
	}

	@Override
	public void shift(double Xamount, double Yamount) {
		// TODO Auto-generated method stub
		setX1(getX1() + Xamount);
		this.x2 += Xamount;
		setY1(getY1() + Yamount);
		this.y2 += Yamount;
	}
}
