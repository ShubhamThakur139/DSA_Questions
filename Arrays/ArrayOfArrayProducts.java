package Arrays;

import java.util.Arrays;

public class ArrayOfArrayProducts {
    public static void main(String[] args) {
        // int arr[] = { 8, 10, 2 };
        int arr[] = { 2, 7, 3, 4 };
        int n = arr.length;
        int res[] = new int[n];
        res[0] = arr[0];
        for (int i = 1; i < n; i++) {
            res[i] = arr[i] * res[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i > 0; i--) {
            res[i] = res[i - 1] * right;
            right *= arr[i];
        }
        res[0] = right;
        System.out.println(Arrays.toString(res));
    }
}
