package model;

public class CopierApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Copier c1 = new Copier(0);
		c1.insertPaper(132);
		System.out.println("There is: " + c1.getPaper() + " Papers left.");
		// System.out.println(c1.getPaper());
		c1.makeCopy(2);
		System.out.println("There is: " + c1.getPaper() + " Papers left.");
		c1.makePaperJam();
		c1.makeCopy(2);
		c1.fixJam();
		c1.makeCopy(2);
		System.out.println("There is: " + c1.getPaper() + " Papers left.");

	}

}
