package Arrays;

import java.util.Scanner;

// Probl Statement : Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.

class ArrayIndexAndEquality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = indexEqualsValueSearch(arr);
        System.out.println(result);
        sc.close();

    }

    private static int indexEqualsValueSearch(int[] arr) {
        int len = arr.length;
        if (len == 0) { // No element in array
            return -1;
        }
        if (len == 1) { // One element in array
            if (arr[0] == 0) {
                return 0;
            } else {
                return -1;
            }
        }
        // If all elements are negative in array
        if (arr[len - 1] < 0) {
            return -1;
        }

        int lo = 0, hi = len - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == mid) {
                ans = mid;
                hi = mid - 1;
            } else if (arr[mid] > mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}

// input: arr = [-8,0,2,5]
// output: 2 # since arr[2] == 2

// input: arr = [-1,0,3,6]
// output: -1 # since no index in arr satisfies arr[i] == i.