package DP;

public class MaximumPathSum {
    public static void main(String[] args) {
        int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

        // int result = pathSum(grid, 0, 0);
        int result = minPathSum(grid);
        System.out.println(result);

    }

    private static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = col - 2; i >= 0; i--) {
            grid[row - 1][i] = grid[row - 1][i] + grid[row - 1][i + 1];
        }

        for (int i = row - 2; i >= 0; i--) {
            grid[i][col - 1] = grid[i][col - 1] + grid[i + 1][col - 1];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }

        return grid[0][0];
    }

    private static int pathSum(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i > grid.length - 1 || j > grid[0].length - 1) {
            return 0;
        }
        return grid[i][j] + Math.min(pathSum(grid, i + 1, j), pathSum(grid, i, j + 1));
    }
}
