package DynamicProgramming;

// Prob Stat: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// How many possible unique paths are there?

public class UniquePath1 {
    static int path(int i, int j, int r, int c, int dp[][]) {
        if (i == r && j == c) {
            return 1;
        }
        if (i > r || j > c) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = path(i + 1, j, r, c, dp) + path(i, j + 1, r, c, dp);

        return dp[i][j];
    }

    static int uniquePaths(int m, int n) {
        return path(1, 1, m, n, new int[m + 1][n + 1]);
    }

    public static void main(String[] args) throws Exception {
        int ans = uniquePaths(3, 3);
        System.out.println(ans);
    }
}
