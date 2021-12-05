package DynamicProgramming;

// Prob Stat A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// An obstacle and space is marked as 1 and 0 respectively in the grid.

public class UniquePath2 {
    public static int path(int i, int j, int[][] obstacleGrid, int dp[][]) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = path(i + 1, j, obstacleGrid, dp) + path(i, j + 1, obstacleGrid, dp);

        return dp[i][j];

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        return path(0, 0, obstacleGrid, new int[obstacleGrid.length][obstacleGrid[0].length]);
    }

    public static void main(String args[]) {
        int obstacleGrid[][] = {
                { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }
        };

        int ans = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);
    }
}
