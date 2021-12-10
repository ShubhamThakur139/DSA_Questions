package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String args[]) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };

        // We have to find triplets whose sum is equal to 0
        int n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> l_list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            int tar = -nums[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == tar) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    if (!set.contains(list)) {
                        set.add(list);
                        l_list.add(list);
                    }
                    start++;
                    end--;
                } else if (sum < tar) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(l_list);

    }
}
