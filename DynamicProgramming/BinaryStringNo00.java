package DynamicProgramming;

// Prob Stat:- In this prob statement we have to print the number of binary strings of length n with no consecutive 0's.
// approach in this either we include the number or not include the number
import java.util.Scanner;

public class BinaryStringNo00 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dp0[] = new int[n + 1];
        int dp1[] = new int[n + 1];

        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp0[i] = dp1[i - 1];
            dp1[i] = dp1[i - 1] + dp0[i - 1];
        }

        System.out.println(dp0[n] + dp1[n]);
        sc.close();
    }
}
