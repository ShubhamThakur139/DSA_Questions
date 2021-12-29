package DynamicProgramming;

import java.util.Scanner;

// Given an array of non-negative integers,and a value sum,
// determine if there is a subset of the given set with sum equal to given sum.
public class SubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = sc.nextInt();

        if (isSubsetSum(n, arr, sum)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        sc.close();
    }

    private static Boolean isSubsetSum(int n, int[] arr, int sum) {
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}

// Input / Output
// Input:
// N = 6
// arr[] = {3, 34, 4, 12, 5, 2}
// sum = 9
// Output: 1
// Explanation: Here there exists a subset with
// sum = 9, 4+3+2 = 9.