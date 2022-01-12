package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int ans = findKthSmallest(arr, k);
        System.out.println(ans);
        sc.close();
    }

    private static int findKthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}

// 4 5 21 2 34 3
// 3