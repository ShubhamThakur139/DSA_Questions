package SortingAlgo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 3, 2, 7, 8, 8, 9 };
        int len = arr.length;
        mergeSort(arr, 0, len - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            // Sort the first and second half
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            // merge the sorted halves

            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + i + 1];
        }

        // set pointers to left and right array
        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k++] = left[i++];
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k++] = right[j++];
        }

    }
}
