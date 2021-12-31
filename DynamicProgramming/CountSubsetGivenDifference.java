package DynamicProgramming;

import java.util.Scanner;

// problem stat: Given an array and diff you have to return count the number of subset with given difference

// Explanation : Let say sum of subset1 is s1 and subset2 is s2
// s1 - s2  = diff (Given)
// s1 + s2 = sum(arr) (Logical)
// Therefore adding both we get 
// 2s1= diff + sum of array
// s1= (diff + sum of array)/2;
// Problem reduces to find no of subsets with given sum**
public class CountSubsetGivenDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int diff = sc.nextInt();
        int sumOfArray = 0;
        for (Integer num : arr) {
            sumOfArray += num;
        }

        int s1 = (diff + sumOfArray) / 2;
        int ans = countSubsetSum(arr, s1);
        System.out.println(ans);
        sc.close();

    }

    private static int countSubsetSum(int[] arr, int s1) {
        int n = arr.length;
        int t[][] = new int[n + 1][s1 + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][s1];
    }
}

// Input / Output
// Input:
// N = 4
// arr[] = {1,1,2,3}
// diff = 1
// Output: 3
