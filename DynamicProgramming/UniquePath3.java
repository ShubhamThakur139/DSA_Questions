package DynamicProgramming;

// Prob Stat: You are given an m x n integer array grid where grid[i][j] could be:
// 1 representing the starting square. There is exactly one starting square.
// 2 representing the ending square. There is exactly one ending square.
// 0 representing empty squares we can walk over.
// -1 representing obstacles that we cannot walk over.
// Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

public class UniquePath3 {
    static boolean isTrue(boolean[][] isVisited, int grid[][]) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isVisited[i][j] == false && grid[i][j] != 2 && grid[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }

    static int path(int i, int j, int m, int n, int[][] grid, boolean isVisited[][]) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == -1
                || isVisited[i][j] == true) {
            return 0;
        }

        if (grid[i][j] == 2) {
            if (isTrue(isVisited, grid)) {
                return 1;
            }
            return 0;
        }
        isVisited[i][j] = true;
        int ans = path(i, j + 1, m, n, grid, isVisited) + path(i + 1, j, m, n, grid, isVisited)
                + path(i - 1, j, m, n, grid, isVisited) + path(i, j - 1, m, n, grid, isVisited);
        isVisited[i][j] = false;
        return ans;
    }

    public static int uniquePathsIII(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = path(i, j, i, j, grid, new boolean[grid.length][grid[0].length]);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int[][] grid = {
                { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 }
        };
        int ans = uniquePathsIII(grid);
        System.out.println(ans);
    }
}
