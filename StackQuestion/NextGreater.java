package StackQuestion;

// Given an array of N elements, find the next greater element for each element in the array, print -1 if it does not exits.
import java.util.Scanner;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Stack<Integer> stk = new Stack<>();
        int res[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                res[i] = stk.peek();
            } else {
                res[i] = -1;
            }
            stk.push(arr[i]);
        }

        for (Integer el : res) {
            System.out.print(el + " ");
        }
        System.out.println();
        scanner.close();
    }
}