package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

// Problem Statement: 1. You are given a number n, representing the count of items. 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items. 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
//Each item can be taken any number of times. You are allowed to put the same item again and again. 
// As we can use one item again and again this prob can be known as unbounded Knapsack Problem

public class UnboundedKnapA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int value[] = new int[n];
        for (int i = 0; i < n; i++)
            value[i] = sc.nextInt();
        int weight[] = new int[n];
        for (int i = 0; i < n; i++)
            weight[i] = sc.nextInt();
        int capacity = sc.nextInt();

        int result = unboundedKnapsack(weight, value, capacity, n);

        dp = new int[n + 1][capacity + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int result1 = unboundedRecursion(weight, value, capacity, n);

        System.out.println(result);
        System.out.println(result1);
        sc.close();
    }

    static int dp[][] = new int[1001][1001];

    private static int unboundedRecursion(int[] weight, int[] value, int capacity, int n) {
        if (capacity == 0 || n == 0) {
            return 0;
        }

        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        if (weight[n - 1] <= capacity) {
            return dp[n][capacity] = Math.max(
                    value[n - 1] + unboundedRecursion(weight, value, capacity - weight[n - 1], n),
                    unboundedRecursion(weight, value, capacity, n - 1));
        }

        else if (weight[n - 1] > capacity) {
            return dp[n][capacity] = unboundedRecursion(weight, value, capacity, n - 1);
        }
        return 0;
    }

    private static int unboundedKnapsack(int[] weight, int[] value, int capacity, int n) {

        int t[][] = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] <= j) {
                    t[i][j] = Math.max(t[i - 1][j], value[i - 1] + t[i][j - weight[i - 1]]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][capacity];
    }

}
// 5
// 15 14 10 45 30
// 2 5 1 3 4
// 7
// ans 100