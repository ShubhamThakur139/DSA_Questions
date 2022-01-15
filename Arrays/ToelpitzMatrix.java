package Arrays;

// Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
// A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
public class ToelpitzMatrix {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
        boolean ans = isToeplitzMatrix(matrix);
        System.out.println(ans);
    }

    private static boolean isToeplitzMatrix(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        for (int r = 0; r < nRows - 1; r++) {
            for (int c = 0; c < nCols; c++) {

                if (r + 1 < nRows && c + 1 < nCols) {
                    if (matrix[r][c] != matrix[r + 1][c + 1]) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
