package Arrays;
//    0  1  2  3  4  5  6  7  8  9  10 11 12 13 14

// nums = {5, 6, 7, 8, 7, 6, 5, 4, 3, 4, 5, 6, 7, 6, 5}
// Optima indices are those where the value is either greater than (or) less than both its neighbours. At index 3 the value 8 and at index 12 the value 7 are both greater than their neighbours and at index 8 the value 3 is less than both its neighbours.

import java.util.ArrayList;
import java.util.List;

public class OptimaIndex {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        // int nums[] = { 5, 6, 7, 8, 7, 6, 5, 4, 3, 4, 5, 6, 7, 6, 5 };
        int nums[] = { 1, 1, 2 };
        List<Integer> ans = getOptimaIndices(nums);
        System.out.println(ans);
    }

    private static List<Integer> getOptimaIndices(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        getIndices(nums, 1);
        return list;
    }

    private static void getIndices(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            return;
        }

        if (nums[idx] > nums[idx - 1] && nums[idx] > nums[idx + 1]) {
            list.add(idx);
        }
        if (nums[idx] < nums[idx - 1] && nums[idx] < nums[idx + 1]) {
            list.add(idx);
        }

        getIndices(nums, idx + 1);
    }
}
