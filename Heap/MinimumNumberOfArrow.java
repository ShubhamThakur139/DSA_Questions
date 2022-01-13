package Heap;

import java.util.Arrays;

public class MinimumNumberOfArrow {
    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int count = 1;
        int arrPtr = points[0][1];
        int n = points.length;
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= arrPtr) {
                continue;
            } else {
                arrPtr = points[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
