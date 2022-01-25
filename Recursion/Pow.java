package Recursion;

import java.util.Scanner;

// Pb stat: Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
public class Pow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        double pow = myPow(x, n);
        System.out.println(pow);
        sc.close();
    }

    private static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

// Example 1:

// Input: x = 2.00000, n = 10
// Output: 1024.00000
// Example 2:

// Input: x = 2.10000, n = 3
// Output: 9.26100
// Example 3:

// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25
