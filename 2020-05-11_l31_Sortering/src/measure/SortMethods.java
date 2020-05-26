package measure;

public class SortMethods {

	public static void bubbleSort(Comparable[] data) {
		// TODO
		int position, scan;
		for (position = data.length - 1; position >= 0; position--) {
			for (scan = 0; scan <= position - 1; scan++) {
				if (data[scan].compareTo(data[scan + 1]) > 0) {
					swap(data, scan, scan + 1);
				}
			}
		}
	}

	public static void insertionSort(Comparable[] data) {
		// TODO
		for (int index = 1; index < data.length; index++) {
			Comparable key = data[index];
			int position = index;
			while (position > 0 && data[position - 1].compareTo(key) > 0) {
				data[position] = data[position - 1];
				position--;
			}
			data[position] = key;
		}
	}

	public static void selectionSort(Comparable[] data) {
		// TODO
		int min;
		for (int index = 0; index < data.length - 1; index++) {
			min = index;
			for (int scan = index + 1; scan < data.length; scan++)
				if (data[scan].compareTo(data[min]) < 0)
					min = scan;
			swap(data, min, index);
		}
	}

	@SuppressWarnings("unused")
	private static void swap(Comparable[] data, int index1, int index2) {
		Comparable temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
}
