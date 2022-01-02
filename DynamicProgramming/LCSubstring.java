package DynamicProgramming;
// Given two strings. The task is to find the length of the longest common substring.

import java.util.Scanner;

public class LCSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int n = s1.length();
        int m = s2.length();

        int res = longestCommonSubstr(s1, s2, n, m);
        System.out.println(res);
        sc.close();
    }

    private static int longestCommonSubstr(String s1, String s2, int n, int m) {
        int t[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = 0;
                }
            }
        }

        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                maxLen = Math.max(maxLen, t[i][j]);
            }
        }

        return maxLen;

    }
}

// Input: S1 = "ABCDGH", S2 = "ACDGHR"
// Output: 4
// Explanation: The longest common substring
// is "CDGH" which has length 4.