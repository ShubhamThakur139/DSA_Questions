package TwoDArray;
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

import java.util.Arrays;

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
public class RotateImage {
    public static void main(String[] args) {
        // int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int matrix[][] = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix first
        for (int i = 0; i < n; i++) {
            int row = i + 1, col = i + 1;
            while (row < n && col < n) {
                int temp = matrix[i][col];
                matrix[i][col] = matrix[row][i];
                matrix[row][i] = temp;
                row++;
                col++;
            }
        }

        // reverse every row
        for (int i = 0; i < n; i++) {
            int j = 0, k = n - 1;
            while (j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }
}

// Approach First transpose the matrix then reverse every row
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]