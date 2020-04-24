package opgave_1;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Measurable[] m1 = new Measurable[3];

		m1[0] = new Chili(100000, "Reaper");
		m1[1] = new Chili(200, "Bleaper");
		m1[2] = new Chili(2000000, "Keeper");
		Filter f = null;
		System.out.println(Data.avgOver5000(m1, f));
		System.out.println(Data.max(m1));
	}

}
