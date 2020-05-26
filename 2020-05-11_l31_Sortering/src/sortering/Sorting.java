package sortering;

public class Sorting {

	public static void selectionSort (int[] data) {
		int min;
		for (int index = 0; index < data.length - 1; index++) {
			min = index;
			for (int scan = index + 1; scan < data.length; scan++)
				if (data[scan] < data[min])
					min = scan;
			swap(data, min, index);
		}
	}
	
	private static void swap(int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	public static void insertionSort(int[] data) {
		for (int index = 1; index < data.length; index++) {
			int key = data[index];
			int position = index;
			while (position > 0 && data[position-1] > key) {
				data[position] = data[position-1];
				position--;
			}
			data[position] = key;
		}
	}
	
	public static void bubbleSort(int[] data) {
		int position, scan;
		for (position = data.length - 1; position >= 0; position--) {
			for (scan = 0; scan <= position - 1; scan++)
				if (data[scan] > data[scan + 1])
					swap(data, scan, scan + 1);
		}
	}

}
