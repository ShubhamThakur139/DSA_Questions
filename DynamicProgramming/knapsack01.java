package DynamicProgramming;

import java.util.Arrays;
// Problem Statement: 1. You are given a number n, representing the count of items. 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items. 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
// Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
// again and again. 
// As we can't use one item again and again this prob can be known as 0-1 Knapsack Problem
import java.util.Scanner;

public class knapsack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // total number of items
        int val[] = new int[n]; // value corresponding to weight
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        int wt[] = new int[n]; // weight
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();
        int capacity = sc.nextInt(); // capacity of bag to hold weight

        dp = new int[n + 1][capacity + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int maxProfit = knapsack(wt, val, capacity, n);

        System.out.println(maxProfit);

        sc.close();
    }

    static int dp[][] = new int[1001][1001];

    static int knapsack(int wt[], int val[], int capacity, int n) {
        if (capacity == 0 || n == 0) {
            return 0;
        }

        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        if (wt[n - 1] <= capacity) {
            return dp[n][capacity] = Math.max(val[n - 1] + knapsack(wt, val, capacity - wt[n - 1], n - 1),
                    knapsack(wt, val, capacity, n - 1));
        }

        else if (wt[n - 1] > capacity) {
            return dp[n][capacity] = knapsack(wt, val, capacity, n - 1);
        }
        return 0;
    }

}

// Sample I/O:
// 5
// 15 14 10 45 30
// 2 5 1 3 4
// 7