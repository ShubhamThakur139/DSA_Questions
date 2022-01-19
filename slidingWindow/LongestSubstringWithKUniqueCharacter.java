package slidingWindow;

import java.util.HashMap;
import java.util.Map;

// Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
public class LongestSubstringWithKUniqueCharacter {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        int ans = longestkSubstr(s, k);
        System.out.println(ans);
    }

    private static int longestkSubstr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() < k) {
            return -1;
        }
        int n = s.length();
        int longest = -1;
        int i = 0, j = 0;
        while (j < n) {
            char cc = s.charAt(j);
            map.put(cc, map.getOrDefault(cc, 0) + 1);
            while (map.size() > k) {
                char pc = s.charAt(i);
                map.put(pc, map.get(pc) - 1);
                if (map.get(pc) == 0) {
                    map.remove(pc);
                }
                i++;
            }
            if (map.size() == k) {
                longest = Math.max(longest, j - i + 1);
            }
            j++;
        }
        return longest;
    }
}

// Input:
// S = "aabacbebebe", K = 3
// Output: 7
// Explanation: "cbebebe" is the longest
// substring with K distinct characters.

// Input:
// S = "aaaa", K = 2
// Output: -1
// Explanation: There's no substring with K
// distinct characters.