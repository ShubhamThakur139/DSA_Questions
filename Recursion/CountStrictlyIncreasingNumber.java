package Recursion;

import java.util.Scanner;

public class CountStrictlyIncreasingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printIncreasing(0, "", n);
        sc.close();
    }

    private static void printIncreasing(int next, String s, int n) {
        if (s.length() == n) {
            System.out.println(s);
            return;
        }

        for (int i = next + 1; i <= 9; i++) {
            printIncreasing(i, s + "" + i, n);
        }

    }
}
