package SortingAlgo;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 3, 2, 7, 8, 8, 9 };
        int len = arr.length;
        quickSort(arr, 0, len - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int s = lo;
        int e = hi;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];
        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        quickSort(arr, lo, e);
        quickSort(arr, s, hi);
    }
}
