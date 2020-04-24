package opgave_4;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FigurForm ellipse = new Ellipse(5, 7, 20, 20);
		System.out.println(ellipse.getAreal());

		// cirkel
		FigurForm cirkel = new Ellipse(5, 7, 20);
		System.out.println(cirkel.getAreal());

		FigurForm r1 = new Rektangel(2, 2, 4, 4);
		System.out.println(r1.getAreal());

		// kvadrat
		FigurForm r2 = new Rektangel(2, 2, 4);
		System.out.println(r2.getAreal());

		ellipse.parallelShiftX(10);
		ellipse.parallelShiftY(10);
		ellipse.shift(10, 10);

		System.out.println(ellipse);
	}
}
