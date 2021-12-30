package DynamicProgramming;

import java.util.Scanner;

// Problem Statement : Given an array arr[] of integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

public class CountSumSubset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int sum = scanner.nextInt();

        int ans = perfectSum(n, nums, sum);

        System.out.println(ans);

        scanner.close();
    }

    private static int perfectSum(int n, int[] nums, int sum) {

        int dp[][] = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];

    }
}

// I/O
// Input: N = 6, arr[] = {2, 3, 5, 6, 8, 10}
// sum = 10
// Output: 3
// Explanation: {2, 3, 5}, {2, 8}, {10}

// Input: N = 5, arr[] = {1, 2, 3, 4, 5}
// sum = 10
// Output: 3
// Explanation: {1, 2, 3, 4}, {1, 4, 5},
// {2, 3, 5}