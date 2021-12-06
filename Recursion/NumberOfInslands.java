package Recursion;

// prob stat : Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

public class NumberOfInslands {

    static void path(char arr[][], int i, int j) {
        if (i < 0 || j < 0 || i > arr.length - 1 || j > arr[0].length - 1 || arr[i][j] == '0') {
            return;
        }
        arr[i][j] = '0';
        path(arr, i, j + 1);
        path(arr, i + 1, j);
        path(arr, i - 1, j);
        path(arr, i, j - 1);
    }

    public static int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    path(grid, i, j);
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {

        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        int ans = numIslands(grid);
        System.out.println(ans);
    }
}
