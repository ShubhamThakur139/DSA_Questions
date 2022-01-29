package StackQuestion;

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class NextSmallerElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Stack<Integer> stk = new Stack<>();
        int result[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() >= arr[i]) {
                stk.pop();
            }

            if (!stk.isEmpty()) {
                result[i] = stk.peek();
            } else {
                result[i] = -1;
            }
            stk.push(arr[i]);
        }

        System.out.println(Arrays.toString(result));

        scanner.close();
    }
}

// 1 4 5 2 1 4 7 8 5 4 1 25