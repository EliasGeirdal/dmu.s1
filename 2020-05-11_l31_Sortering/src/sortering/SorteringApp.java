package sortering;

import java.util.Arrays;

public class SorteringApp {

    public static void main(String[] args) {
        final int[] tabelInit = { 3, 9, 6, 1, 2 };

        System.out.println("bubbleSort");
        int[] tabel = Arrays.copyOf(tabelInit, tabelInit.length);
        System.out.println(Arrays.toString(tabel));
        Sorting.bubbleSort(tabel);
        System.out.println(Arrays.toString(tabel));
        System.out.println("--------------------------------");

        System.out.println("selectionSort");
        tabel = Arrays.copyOf(tabelInit, tabelInit.length);
        System.out.println(Arrays.toString(tabel));
        Sorting.selectionSort(tabel);
        System.out.println(Arrays.toString(tabel));
        System.out.println("--------------------------------");

        System.out.println("insertionSort:");
        tabel = Arrays.copyOf(tabelInit, tabelInit.length);
        System.out.println(Arrays.toString(tabel));
        Sorting.insertionSort(tabel);
        System.out.println(Arrays.toString(tabel));
}

}
