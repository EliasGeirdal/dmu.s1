package measure;

import java.util.ArrayList;
import java.util.Collections;

public class SortTester {

	public static void main(String[] args) {

		int testSize = 25000;
		ArrayList<String> bigList = ListGenerator.generateString(testSize, 15);
		String[] bigArray1 = bigList.toArray(new String[0]);
		String[] bigArray2 = bigList.toArray(new String[0]);
		String[] bigArray3 = bigList.toArray(new String[0]);

		Measurer.start();
		Collections.sort(bigList);
		Measurer.stop();
		System.out.println(String.format("CollectionSort (%d) -- Total time in milliseconds: %d", testSize,
				Measurer.durationMilliSeconds()));

		// Bubble Sort Test
		Measurer.start();
		SortMethods.bubbleSort(bigArray1);
		Measurer.stop();
		System.out.println(String.format("BubbleSort (%d) -- Total time in milliseconds: %d", testSize,
				Measurer.durationMilliSeconds()));
//		String[] s = { "Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul",
//				"Torkild" };
//		SortMethods.bubbleSort(s);
//		System.out.println(Arrays.toString(s));

		// Insertion Sort Test
		Measurer.start();
		SortMethods.insertionSort(bigArray2);
		Measurer.stop();
		System.out.println(String.format("InsertionSort (%d) -- Total time in milliseconds: %d", testSize,
				Measurer.durationMilliSeconds()));

//		String[] s3 = { "Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul",
//				"Torkild" };
//		SortMethods.insertionSort(s3);
//		System.out.println(Arrays.toString(s3));

//		 Selection Sort Test
		Measurer.start();
		SortMethods.selectionSort(bigArray3);
		Measurer.stop();
		System.out.println(String.format("SelectionSort (%d) -- Total time in milliseconds: %d", testSize,
				Measurer.durationMilliSeconds()));

//		String[] s1 = { "Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul",
//				"Torkild" };
//		SortMethods.selectionSort(s1);
//		System.out.println(Arrays.toString(s1));
	}

}
