package DynamicProgramming;

// Problem Statement: 1. You are given a number n, representing the count of items. 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items. 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
//Each item can be taken any number of times. You are allowed to put the same item again and again. 
// As we can use one item again and again this prob can be known as unbounded Knapsack Problem

import java.util.Scanner;

public class UnboundedKnapsProb {
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

        int dp[] = new int[cap + 1];
        for (int bagc = 1; bagc < dp.length; bagc++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (we[j] <= bagc) {
                    // remaining bag capacity
                    int rbagc = bagc - we[j];
                    // remaining bag value
                    int rbagv = dp[rbagc];
                    int total_val = rbagv + val[j];
                    if (total_val > max) {
                        max = total_val;
                    }
                } else {
                    continue;
                }
            }
            dp[bagc] = max;
        }

        System.out.println(dp[cap]);
        sc.close();

    }
}
