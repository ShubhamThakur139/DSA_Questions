package TwoPointer;

// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
import java.util.Scanner;

public class MajorElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int major = arr[0];
        for (int i = 1; i < n; i++) {
            if (major == arr[i]) {
                count++;
            } else if (count == 0) {
                count++;
                major = arr[i];
            } else {
                count--;
            }
        }

        System.out.println(major);

        sc.close();
    }
}
