package Arrays;

import java.util.Scanner;

// Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.
public class GettingDifferentNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = getDifferentNumber(arr);
        System.out.println(ans);
        sc.close();
    }

    private static int getDifferentNumber(int[] arr) {
        int n = arr.length;
        // [4,5,3,2,1,0,2]

        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            while (temp < n && arr[temp] != temp) {
                swap(temp, arr[temp], arr, i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return n;
    }

    private static void swap(int temp, int i, int arr[], int idx) {
        arr[idx] = i;
        arr[temp] = temp;
    }
}
