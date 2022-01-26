package Recursion;

// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
// Given an integer n, return true if n is an ugly number.
public class UglyNumber {
    public static void main(String[] args) {
        int n = 9;
        boolean ans = isUgly(n);
        System.out.println(ans);
    }

    private static boolean isUgly(int n) {
        if (n == 1)
            return true;
        if (n <= 0)
            return false;
        boolean ans = false;
        if (n % 2 == 0) {
            ans = isUgly(n / 2);
        } else if (n % 3 == 0) {
            ans = isUgly(n / 3);
        } else if (n % 5 == 0) {
            ans = isUgly(n / 5);
        }
        return ans;
    }
}
