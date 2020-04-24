package eksempelStud;

public class EksempelArray {

	public int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	public int max(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public int maxAlder(Person[] array) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (max < array[i].getAlder())
				max = array[i].getAlder();
		}
		return max;
	}
}
