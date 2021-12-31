package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Problem Statement Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference
public class MinimumSumPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int range = 0;
        for (Integer el : arr) {
            range += el;
        }

        List<Integer> subsets = subsetSum(arr, range);
        int min = Integer.MAX_VALUE;
        for (Integer s1 : subsets) {
            int diff = range - 2 * s1;
            min = Math.min(min, diff);
        }

        System.out.println(min);
        sc.close();
    }

    private static List<Integer> subsetSum(int[] arr, int range) {

        int n = arr.length;
        boolean t[][] = new boolean[n + 1][range + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= range / 2; i++) {
            if (t[n][i]) {
                list.add(i);
            }
        }

        return list;
    }
}

// I/O:
// Input: N = 4, arr[] = {1, 6, 11, 5}
// Output: 1
// Explanation:
// Subset1 = {1, 5, 6}, sum of Subset1 = 12
// Subset2 = {11}, sum of Subset2 = 11

// Input: N = 2, arr[] = {1, 4}
// Output: 3
// Explanation:
// Subset1 = {1}, sum of Subset1 = 1
// Subset2 = {4}, sum of Subset2 = 4