package opgavee316;

public class BugApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bug bug1 = new Bug(0);
		bug1.move();
		bug1.move();

		System.out.print(bug1.getPosition());
	}
}
