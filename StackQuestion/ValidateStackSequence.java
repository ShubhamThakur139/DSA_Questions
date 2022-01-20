package StackQuestion;

import java.util.Stack;

// Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
public class ValidateStackSequence {
    public static void main(String[] args) {
        int pushed[] = { 1, 2, 3, 4, 5 };
        int popped[] = { 4, 5, 3, 2, 1 };
        boolean ans = validateStackSequences(pushed, popped);
        System.out.println(ans ? "Valid" : "Invalid");
    }

    private static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int n = popped.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            stk.push(pushed[i]);
            while (j < n && !stk.isEmpty() && stk.peek() == popped[j]) {
                stk.pop();
                j++;
            }
        }
        return stk.isEmpty();
    }
}

// pushed = [1,2,3,4,5]
// popped = [4,5,3,2,1]
// o/p: true

// Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
// Output: false