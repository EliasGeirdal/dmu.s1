package chooseEgg;

public class WhichEgg {

	public WhichEgg() {

	}

	public void chooseEgg() {

		int rolls = (int) (Math.random() * 3);
		if (rolls == 1)
			System.out.println("Scrambled eggs!");
		else if (rolls == 2)
			System.out.println("Fried eggs");
		else
			System.out.println("boiled eggs.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhichEgg e = new WhichEgg();
		e.chooseEgg();
		System.out.println(6 % 6);
	}

}
