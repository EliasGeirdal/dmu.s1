package stars;

public class Stars {
	final int MAX_ROWS = 10;

	public void starPicture() {
		for (int row = 1; row <= MAX_ROWS; row++) {
			for (int star = 1; star <= row; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void starPictureA() {
		// TODO
		String star = "**********";
		for (int i = star.length(); i >= 0; i--) {
			System.out.println(star.substring(0, i));
		}

	}

	public void starPictureB() {
		// TODO
		String star = "**********";
		String space = "         ";
		int j = 9;
		for (int i = 1; i <= 10; i++) {
			System.out.println(space.substring(0, j) + star.substring(0, i));
			j--;
		}
	}

	public void starPictureC() {
		// TODO
		String star = "**********";
		String space = "         ";
		int j = 0;
		for (int i = 9; i >= 0; i--) {
			System.out.println(space.substring(0, j) + star.substring(0, i));
			j++;
		}
	}

	public void starPictureD() {
		// TODO

	}

}
