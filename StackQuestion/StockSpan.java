package StackQuestion;

import java.util.Arrays;
import java.util.Stack;

// Prob stat: he stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
// The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
public class StockSpan {
    public static void main(String[] args) {
        // int price[] = { 100, 80, 60, 70, 60, 75, 85 };
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int result[] = stockSpan(price);
        System.out.println(Arrays.toString(result));
    }

    private static int[] stockSpan(int[] price) {
        int n = price.length;
        int result[] = new int[n];
        Stack<int[]> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && stk.peek()[0] <= price[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                result[i] = i - stk.peek()[1];
            } else {
                result[i] = i + 1;
            }
            stk.push(new int[] { price[i], i });
        }

        return result;
    }
}

// Time Complexity will be O(2n) because we can traverse array atmost twice
// Spcace Complexity will be O(n) because atmost we can store N elements in
// stack

// Input:
// N = 7, price[] = [100 80 60 70 60 75 85]
// Output:
// 1 1 1 2 1 4 6
// Explanation:
// Traversing the given input span for 100
// will be 1, 80 is smaller than 100 so the
// span is 1, 60 is smaller than 80 so the
// span is 1, 70 is greater than 60 so the
// span is 2 and so on. Hence the output will
// be 1 1 1 2 1 4 6.

// Input:
// N = 6, price[] = [10 4 5 90 120 80]
// Output:
// 1 1 2 4 5 1