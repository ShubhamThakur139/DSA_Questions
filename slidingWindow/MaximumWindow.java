package slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// Prob Stat:You are given an array of integers nums,there is a sliding window of size k which is moving from the very left of the array to the very right.You can only see the k numbers in the window.Each time the sliding window moves right by one position.Return the max sliding window.
public class MaximumWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int res[] = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(res));
        sc.close();
    }

    static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        Deque<Integer> pq = new LinkedList<>();
        int i=0,j=0;
        while(j<n){
            if(!pq.isEmpty()){
                while(!pq.isEmpty() && pq.peekLast()<nums[j]){
                    pq.pollLast();
                }
                pq.addLast(nums[j]);
            }else{
                pq.add(nums[j]);
            }
            if(j-i+1<k){               
            }else if(j-i+1==k){
                res[i]=pq.peekFirst();
                if(nums[i]==pq.peekFirst()){
                     pq.pollFirst();
                }
                i++;
            }
            j++;
        }
        return res;
}

// O/P : Input: nums = [1,3,
// -1,-3,5,3,6,7],k=3
// Output: [3,3,5,5,6,7]
// Explanation:
// Window position Max
// --------------- -----
// [1 3 -1] -3 5 3 6 7 3
// 1 [3 -1 -3] 5 3 6 7 3
// 1 3 [-1 -3 5] 3 6 7 5
// 1 3 -1 [-3 5 3] 6 7 5
// 1 3 -1 -3 [5 3 6] 7 6
// 1 3 -1 -3 5 [3 6 7] 7