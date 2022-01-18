package SortingAlgo;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 3, 2, 7, 8, 8, 9 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

    }
}
