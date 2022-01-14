package Arrays;

import java.util.ArrayList;
import java.util.List;

// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
public class FindDisappearedElement {
    public static void main(String[] args) {
        // int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
        int arr[] = { 1, 1 };
        List<Integer> list = findDisappearedNumbers(arr);
        System.out.println(list);
    }

    private static List<Integer> findDisappearedNumbers(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(arr[i]);
            if (arr[idx - 1] > 0) {
                arr[idx - 1] = -arr[idx - 1];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}

// nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]