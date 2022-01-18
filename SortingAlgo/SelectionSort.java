package SortingAlgo;

// In selection sort we take minimum element from unsorted array and placed it into sorted array 

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 3, 2, 7, 8, 8, 9 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            if (arr[min_idx] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
            }

        }
    }
}
