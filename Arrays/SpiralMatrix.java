package Arrays;

import java.util.Arrays;

// Given a 2D array (matrix) inputMatrix of integers, create a function spiralCopy that copies inputMatrix’s values into a 1D array in a spiral order, clockwise. Your function then should return that array. Analyze the time and space complexities of your solution.
public class SpiralMatrix {
    public static void main(String[] args) {
        int inputMatrix[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };

        int result[] = spiralCopy(inputMatrix);
        System.out.println(Arrays.toString(result));
    }

    private static int[] spiralCopy(int[][] inputMatrix) {
        int n = inputMatrix.length;
        int m = inputMatrix[0].length;
        int result[] = new int[n * m];
        int dir = 0;
        int row = 0, nRow = n - 1, col = 0, nCol = m - 1;
        int idx = 0;
        while (row <= nRow && col <= nCol) {
            if (dir % 4 == 0) {
                for (int i = col; i <= nCol; i++) {
                    result[idx++] = inputMatrix[row][i];
                }
                row++;
            } else if (dir % 4 == 1) {
                for (int i = row; i <= nRow; i++) {
                    result[idx++] = inputMatrix[i][nCol];
                }
                nCol--;
            } else if (dir % 4 == 2) {
                for (int i = nCol; i >= col; i--) {
                    result[idx++] = inputMatrix[nRow][i];
                }
                nRow--;
            } else if (dir % 4 == 3) {
                for (int i = nRow; i >= row; i--) {
                    result[idx++] = inputMatrix[i][col];
                }
                col++;
            }
            dir++;
        }

        return result;
    }
}
