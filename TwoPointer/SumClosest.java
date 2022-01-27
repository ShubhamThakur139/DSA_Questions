package TwoPointer;

import java.util.Arrays;

// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
// Return the sum of the three integers.
// You may assume that each input would have exactly one solution.
public class SumClosest {
    public static void main(String[] args) {
        int nums[] = { -1, 2, 1, -4 };
        int target = 1;

        int result = threeSumClosest(nums, target);
        System.out.println(result);
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = -1;
        int closest = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(sum - target);
                if (diff < closest) {
                    closest = diff;
                    ans = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return ans;
    }
}

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

// Input: nums = [0,0,0], target = 1
// Output: 0