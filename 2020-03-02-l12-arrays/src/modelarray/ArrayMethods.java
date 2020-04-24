package modelarray;

public class ArrayMethods {
	public void printArray(int[] tabel) {
		System.out.print("{");
		for (int i = 0; i < tabel.length; i++) {
			if (i == 0) {
				System.out.print(tabel[i]);
			} else {
				System.out.print(", " + tabel[i]);
			}
		}
		System.out.println("}  ");
	}

	/**
	 *
	 * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
	 */
	public int[] fyldArrayA() {
		int[] result = new int[10];
		// TODO
		return result;
	}

	/**
	 *
	 * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
	 */
	public int[] fyldArrayB() {
//    	  int[] result = new int[10];
		int[] result = { 2, 44, -23, 99, 8, -5, 7, 10, 20, 30 };
		return result;
	}

	/**
	 *
	 * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
	 */
	public int[] fyldArrayC() {
		int[] result = new int[10];
		// TODO
		int counter = 0;
		for (int i = 0; i < result.length; i++) {
			result[i] = counter;
			counter++;
		}
		return result;
	}

	/**
	 *
	 * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
	 */
	public int[] fyldArrayD() {
		int[] result = new int[10];
		// TODO
		int counter = 0;
		for (int i = 0; i < result.length; i++) {
			result[i] = counter + 2;
			counter += 2;
		}
		return result;
	}

	/**
	 *
	 * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
	 */
	public int[] fyldArrayE() {
		int[] result = new int[10];
		// TODO
		for (int i = 1; i <= result.length; i++) {
			result[i - 1] = i * i;
		}
		return result;
	}

	/**
	 *
	 * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
	 */
	public int[] fyldArrayF() {
		int[] result = new int[10];
		// TODO
		for (int i = 1; i <= result.length; i++) {
			result[i - 1] = (i + 1) % 2;
		}
		return result;
	}

	/**
	 *
	 * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
	 */
	public int[] fyldArrayG() {
		int[] result = new int[10];
		for (int i = 0; i < result.length; i++) {
			result[i] = i % 5;

		}
		return result;
	}

	public int findMax(int[] tabel) {
		int max = -1;
		for (int i = 0; i < tabel.length; i++) {
			if (tabel[i] > max) {
				max = tabel[i];
			}
		}
		return max;
	}

	// returnerer summen af array t, som integer.
	public int sum(int[] t) {
		int sum = 0;
		for (int i = 0; i < t.length; i++) {
			sum += t[i];
		}
		return sum;
	}

	// returnerer summen af array t, som double..
	public double sum(double[] t) {
		double sum = 0;
		for (int i = 0; i < t.length; i++) {
			sum += t[i];
		}
		return sum;
	}

	public int[] makeSum(int[] a, int[] b) {
		int length = 0;
		if (a.length > b.length)
			length = a.length;
		else
			length = b.length;
		int[] sum = new int[length];
		for (int i = 0; i < length; i++) {
			if (a.length > length && b.length > length)
				sum[i] = a[i] + b[i];
			else if (b.length < a.length)
				sum[i] = a[i];
			else
				sum[i] = b[i];
		}
		return sum;
	}

	public boolean hasUneven(int[] t) {
		boolean uneven = false;
		for (int i = 0; i < t.length; i++) {
			if (t[i] % 2 != 0) {
				uneven = true;
			}
		}
		return uneven;
	}
}
