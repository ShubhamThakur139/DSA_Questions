package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int n = s1.length();
        int m = s2.length();

        t = new int[n + 1][m + 1];

        for (int row[] : t) {
            Arrays.fill(row, -1);
        }

        int length = longestCommonSubsequence(s1, s2, n, m);
        System.out.println(length);
        sc.close();
    }

    static int[][] t = new int[1001][1001];

    private static int longestCommonSubsequence(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (t[n][m] != -1) {
            return t[n][m];
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return t[n][m] = 1 + longestCommonSubsequence(s1, s2, n - 1, m - 1);
        } else {
            return t[n][m] = Math.max(longestCommonSubsequence(s1, s2, n - 1, m),
                    longestCommonSubsequence(s1, s2, n, m - 1));
        }
    }
}

// Input: text1 = "abcde", text2 = "ace"
// Output: 3
// Explanation: The longest common subsequence is "ace" and its length is 3.