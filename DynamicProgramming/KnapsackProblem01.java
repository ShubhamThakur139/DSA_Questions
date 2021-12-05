package DynamicProgramming;

// Problem Statement: 1. You are given a number n, representing the count of items. 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items. 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
// Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
// again and again. As we can't use one item again and again this prob can be known as 0-1 Knapsack Problem

import java.util.*;

public class KnapsackProblem01 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val[] = new int[n];
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        int we[] = new int[n];
        for (int i = 0; i < n; i++)
            we[i] = sc.nextInt();
        int cap = sc.nextInt();
        int dp[][] = new int[n + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= we[i - 1]) {
                    if (val[i - 1] + dp[i - 1][j - we[i - 1]] > dp[i - 1][j]) {
                        dp[i][j] = val[i - 1] + dp[i - 1][j - we[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][cap]);

        sc.close();
    }
}
