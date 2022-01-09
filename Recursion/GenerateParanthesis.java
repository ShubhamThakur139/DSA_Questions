package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Prob stat: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
public class GenerateParanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> list1 = generateParenthesis(n);
        System.out.println(list1);
        sc.close();
    }

    static List<String> list = new ArrayList<>();

    static void genAllParan(int n, String asf, int open, int close) {
        if (open == 0 && close == 0) {
            list.add(asf);
        }

        if (open < 0 || close < 0) {
            return;
        }

        genAllParan(n, asf + "(", open - 1, close);
        if (open < close) {
            genAllParan(n, asf + ")", open, close - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        genAllParan(n, "(", n - 1, n);
        return list;
    }
}
