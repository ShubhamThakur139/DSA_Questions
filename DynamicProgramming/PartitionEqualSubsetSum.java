package DynamicProgramming;

import java.util.Scanner;

//Problem Statement: Given a non-empty array nums containing only positive integers,find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

// Explanation line no 58

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        boolean result = canPartition(nums, n);

        System.out.println(result);

        scanner.close();
    }

    private static boolean canPartition(int[] nums, int n) {
        long sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = (int) sum / 2;
        return isSubsetSum(nums, target, n);
    }

    private static boolean isSubsetSum(int[] nums, int target, int n) {
        boolean t[][] = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][target];
    }
}

// if you closely observe the question you noticed some points:
// 1. if sum of all array elements is odd it can't be divide into two parts so
// if sum of all elements is odd then return false
// 2. once you divide the sum into half so this problem becames isSubsetSum
// after half the sum became a target if the target found as subset in array
// then we know the rest of the subset sum is also equal to half of the array

// I/O
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.