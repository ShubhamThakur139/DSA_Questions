package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwapsInCircularArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() < 2)
                continue;
            int first = list.get(0);
            int second = list.get(1);
            int secondLast = list.get(list.size() - 2);
            int last = list.get(list.size() - 1);

            ans = Math.min(ans, first + second - 1);
            ans = Math.min(ans, n - secondLast + n - last + 1);
            if (first == 0) {
                ans = Math.min(ans, n - last + 1);
            } else {
                ans = Math.min(ans, first - 1 + n - last);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

        sc.close();
    }
}
