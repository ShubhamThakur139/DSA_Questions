package SortingAlgo;

import java.util.Arrays;

// In bubbleSort we swap the adjacent elements if they are in wrong order

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 3, 2, 7, 8, 8, 9 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
}
