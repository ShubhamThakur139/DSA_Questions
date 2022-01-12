package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortKSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sortNearlyK(arr, n, k);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }

    private static void sortNearlyK(int[] arr, int n, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                arr[count++] = minHeap.poll();
            }
        }

        while (minHeap.size() > 0) {
            arr[count++] = minHeap.poll();
        }

    }
}

// Given an array of n elements, where each element is at most k away from its
// target position, devise an algorithm that sorts in O(n log k) time. For
// example, let us consider k is 2, an element at index 7 in the sorted array,
// can be at indexes 5, 6, 7, 8, 9 in the given array.
// Input:arr[]={6,5,3,2,8,10,9}k=3 Output:arr[]={2,3,5,6,8,9,10}

// Input:arr[]={10,9,8,7,4,70,60,50}k=4 Output:arr[]={4,7,8,9,10,50,60,70}